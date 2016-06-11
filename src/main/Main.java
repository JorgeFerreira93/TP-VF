package main;

import instrs.Atrib;
import instrs.Instrucao;
import instrs.WhileCondition;
import operator.Exp;
import operator.Operador;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import parser.*;
import visitor.Visitor;
import instrs.Programa;

public class Main {

    public static void main(String[] args) throws IOException {
        ANTLRInputStream in = new ANTLRInputStream(new FileInputStream(new File("C:\\Users\\Jorge\\Documents\\MIEI\\4Âº Ano\\MFES\\VF\\TPVF\\src\\fich.txt")));
        GramaticaLexer lexer  = new GramaticaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaParser parser = new GramaticaParser(tokens);

        ParseTree tree = parser.programa();

        new Visitor().visit(tree);

        Programa p =(Programa)(new Visitor().visit(tree)).getValue();

        vcg(p);
    }

    private static void vcg(Programa p){
        ArrayList<Exp> expressoes = wp(p.getInstrucoes(), p.getPos());

        for(Exp e : expressoes){
            Operador o = new Operador("=>", p.getPre(), e);
            System.out.println(o);
        }

        expressoes = vcAux(p.getInstrucoes(), p.getPos());

        for(Exp e : expressoes){
            System.out.println(e);
        }
    }

    private static ArrayList<Exp> wp(ArrayList<Instrucao> instrucoes, Exp pos){

        ArrayList<Exp> condicoes = new ArrayList<>();

        for(Instrucao i: instrucoes){
            Exp e = null;
            if(i instanceof Atrib){
                e = wpAtrib((Atrib) i, pos);
            }
            else if(i instanceof WhileCondition){
                e = wpWhile((WhileCondition) i, pos);
            }

            condicoes.add(e);
        }

        return condicoes;
    }

    private static Exp wpAtrib(Atrib a, Exp pos){

        pos.replace(a.getId(), a.getAtrib());

        return pos;
    }

    private static Exp wpWhile(WhileCondition w, Exp pos){
        return w.getInv();
    }

    private static ArrayList<Exp> vcAux(ArrayList<Instrucao> instrucoes, Exp pos){

        ArrayList<Exp> condicoes = new ArrayList<>();

        for(Instrucao i: instrucoes){
            ArrayList<Exp> exps = new ArrayList<>();
            if(i instanceof Atrib){
            }
            else if(i instanceof WhileCondition){
                exps = vcWhile((WhileCondition) i, pos);
            }

            for(Exp e : exps){
                condicoes.add(e);
            }
        }

        return condicoes;
    }

    private static ArrayList<Exp> vcWhile(WhileCondition w, Exp pos){

        ArrayList<Exp> expressoesWP = wp(w.getInstrucoes(), (Exp) w.getInv().clone());
        ArrayList<Exp> expressoes = new ArrayList<>();

        for(Exp e : expressoesWP){
            Operador o1 = new Operador("&&", w.getInv(), w.getCond());
            Operador o2 = new Operador("=>", o1, e);
            expressoes.add(o2);
        }

        Operador not = new Operador("!", null, w.getCond());
        Operador o1 = new Operador("&&", w.getInv(), not);
        Operador o2 = new Operador("=>", o1, pos);

        expressoes.add(o2);

        ArrayList<Exp> expressoesVC = vcAux(w.getInstrucoes(), pos);

        for(Exp e : expressoesVC){
            expressoes.add(e);
        }

        return expressoes;
    }

}
