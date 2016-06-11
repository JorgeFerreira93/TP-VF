package main;

import instrs.*;
import operator.Exp;
import operator.Operador;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import parser.*;
import prover.Prover;
import visitor.Visitor;

public class Main {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream in = new ANTLRInputStream(new FileInputStream(new File("/home/jorge/Desktop/TP-VF/src/fich.txt")));
        GramaticaLexer lexer  = new GramaticaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaParser parser = new GramaticaParser(tokens);

        ParseTree tree = parser.programa();

        Programa p =(Programa)(new Visitor().visit(tree)).getValue();

        ArrayList<Exp> condicoes = vcg(p);

        for(Exp e : condicoes){
            System.out.println(e);
        }

        Prover prover = new Prover(condicoes);

        prover.parse();
    }

    private static ArrayList<Exp> vcg(Programa p){

        ArrayList<Exp> res = new ArrayList<>();


        Exp expressao = wp((ArrayList<Instrucao>) p.getInstrucoes().clone(), p.getPos());

        Operador o = new Operador("=>", p.getPre(), expressao);
        res.add(o);

        ArrayList<Exp> expressoes = vcAux(p.getInstrucoes(), p.getPos());

        for(Exp e : expressoes){
            res.add(e);
        }

        return res;
    }

    private static Exp wp(ArrayList<Instrucao> instrucoes, Exp pos){

        ArrayList<Exp> condicoes = new ArrayList<>();

        if(instrucoes.size() > 1){
            Instrucao i = instrucoes.remove(0);
            Exp res = wp(instrucoes, pos);
            ArrayList<Instrucao> cond = new ArrayList<>();
            cond.add(i);
            return wp(cond, res);
        }
        else{
            Instrucao i = instrucoes.get(0);
            Exp e = null;
            if(i instanceof Atrib){
                e = wpAtrib((Atrib) i, pos);
            }
            else if(i instanceof WhileCondition){
                e = wpWhile((WhileCondition) i, pos);
            }
            else if(i instanceof IfCondition){
                e = wpIf((IfCondition) i, pos);
            }
            return e;
        }
    }

    private static Exp wpAtrib(Atrib a, Exp pos){
        pos.replace(a.getId(), a.getAtrib());

        return pos;
    }

    private static Exp wpWhile(WhileCondition w, Exp pos){
        return w.getInv();
    }

    private static Exp wpIf(IfCondition i, Exp pos) {
        Exp posIf = wp(i.getInstrucoesIf(), (Exp) pos.clone());

        if(i.getInstrucoesElse() != null){
            Exp posElse = wp(i.getInstrucoesElse(), (Exp) pos.clone());
            Operador o1 = new Operador("=>", i.getCond(), posIf);
            Operador not = new Operador("!", null, i.getCond());
            Operador o2 = new Operador("=>", not, posElse);
            Operador res = new Operador("&&", o1, o2);
            return res;
        }
        else{
            Operador o = new Operador("=>", i.getCond(), posIf);
            return o;
        }
    }

    private static ArrayList<Exp> vcAux(ArrayList<Instrucao> instrucoes, Exp pos){

        ArrayList<Exp> condicoes = new ArrayList<>();

        if(instrucoes.size() > 1){

            Instrucao i = instrucoes.remove(0);

            ArrayList<Instrucao> instrs = new ArrayList<>();
            instrs.add(i);

            Exp posQ = wp((ArrayList<Instrucao>) instrucoes.clone(), (Exp) pos.clone());

            ArrayList<Exp> a = vcAux(instrs, posQ);
            ArrayList<Exp> b = vcAux(instrucoes, pos);

            ArrayList<Exp> res = new ArrayList<>();

            for(Exp e : a){
                res.add(e);
            }

            for(Exp e : b){
                res.add(e);
            }

            return res;
        }
        else{

            Instrucao i = instrucoes.get(0);
            ArrayList<Exp> exps = new ArrayList<>();
            if(i instanceof Atrib){
            }
            else if(i instanceof WhileCondition){
                exps = vcWhile((WhileCondition) i, pos);
            }
            else if(i instanceof IfCondition){
                exps = vcIf((IfCondition) i, pos);
            }
            return exps;
        }
    }

    private static ArrayList<Exp> vcWhile(WhileCondition w, Exp pos){

        Exp expressaoWP = wp(w.getInstrucoes(), (Exp) w.getInv().clone());
        ArrayList<Exp> expressoes = new ArrayList<>();
        Operador o1 = new Operador("&&", w.getInv(), w.getCond());
        Operador o2 = new Operador("=>", o1, expressaoWP);
        expressoes.add(o2);

        Operador not = new Operador("!", null, w.getCond());
        o1 = new Operador("&&", w.getInv(), not);
        o2 = new Operador("=>", o1, pos);

        expressoes.add(o2);

        ArrayList<Exp> expressoesVC = vcAux(w.getInstrucoes(), pos);

        for(Exp e : expressoesVC){
            expressoes.add(e);
        }

        return expressoes;
    }

    private static ArrayList<Exp> vcIf(IfCondition i, Exp pos){

        ArrayList<Exp> expressoesVC = vcAux(i.getInstrucoesIf(), pos);
        ArrayList<Exp> expressoes = new ArrayList<>();

        for(Exp e : expressoesVC){
            expressoes.add(e);
        }

        return expressoes;
    }

}
