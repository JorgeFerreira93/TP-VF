package generator;

import instrs.*;
import operator.Exp;
import operator.Operador;

import java.util.ArrayList;

/**
 * Classe que gera as condições de verificação de um programa.
 *
 * @author jorge
 */
public class VCGen {

    public VCGen(){}

    /**
     * Método que recebe um objeto da class Programa e gera as suas condições de verificação através da seguinte
     * fórmula: VCG({P}C{Q}) = {[P->wp(C,Q)]} U VCaux(C,Q)
     *
     * @param p Programa a ser analisado
     * @return O conjunto das condições de verificaão
     * */
    public ArrayList<Exp> vcg(Programa p){

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

    /**
     * Aplica a regra wp a um conjunto de instruções
     *
     * @param instrucoes Conjunto de instruções
     * @param pos Pós-condição
     * @return Condição
     * */
    private Exp wp(ArrayList<Instrucao> instrucoes, Exp pos){

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
            else if(i instanceof WhileInstruction){
                e = wpWhile((WhileInstruction) i, pos);
            }
            else if(i instanceof IfInstruction){
                e = wpIf((IfInstruction) i, pos);
            }
            return e;
        }
    }

    /**
     * Aplica a regra wp(atrib) a uma atribuição
     *
     * @param a Atribuição
     * @param pos Pós-condição
     * @return Condição
     * */
    private Exp wpAtrib(Atrib a, Exp pos){
        pos.replace(a.getId(), a.getAtrib());

        return pos;
    }

    /**
     * Aplica a regra wp(while) a uma instrução while
     *
     * @param w Instrução while
     * @param pos Pós-condição
     * @return Condição
     * */
    private Exp wpWhile(WhileInstruction w, Exp pos){
        return w.getInv();
    }

    /**
     * Aplica a regra wp(if) a uma instrução if
     *
     * @param i Instrução if
     * @param pos Pós-condição
     * @return Condição
     * */
    private Exp wpIf(IfInstruction i, Exp pos) {
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

    /**
     * Aplica a regra VCaux a um conjunto de instruções
     *
     * @param instrucoes Conjunto de instruções
     * @param pos Pós-condição
     * @return Condição
     * */
    private ArrayList<Exp> vcAux(ArrayList<Instrucao> instrucoes, Exp pos){

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
            else if(i instanceof WhileInstruction){
                exps = vcWhile((WhileInstruction) i, pos);
            }
            else if(i instanceof IfInstruction){
                exps = vcIf((IfInstruction) i, pos);
            }
            return exps;
        }
    }

    /**
     * Aplica a regra VCaux(while) a uma instrução while
     *
     * @param w Instrução while
     * @param pos Pós-condição
     * @return Condição
     * */
    private ArrayList<Exp> vcWhile(WhileInstruction w, Exp pos){

        Exp expressaoWP = wp(w.getInstrucoes(), (Exp) w.getInv().clone());
        ArrayList<Exp> expressoes = new ArrayList<>();

        /* (I && b) -> wp(C, I) */
        Operador o1 = new Operador("&&", w.getInv(), w.getCond());
        Operador o2 = new Operador("=>", o1, expressaoWP);
        expressoes.add(o2);

        /* (I && !b) -> Q */
        Operador not = new Operador("!", null, w.getCond());
        o1 = new Operador("&&", w.getInv(), not);
        o2 = new Operador("=>", o1, pos);

        expressoes.add(o2);

        /* VCaux(C, I) */
        ArrayList<Exp> expressoesVC = vcAux(w.getInstrucoes(), pos);

        for(Exp e : expressoesVC){
            expressoes.add(e);
        }

        return expressoes;
    }

    /**
     * Aplica a regra VCaux(if) a uma intrução if
     *
     * @param i Instrução if
     * @param pos Pós-condição
     * @return Condição
     * */
    private ArrayList<Exp> vcIf(IfInstruction i, Exp pos){

        ArrayList<Exp> expressoesVC = vcAux(i.getInstrucoesIf(), pos);
        ArrayList<Exp> expressoes = new ArrayList<>();

        for(Exp e : expressoesVC){
            expressoes.add(e);
        }

        return expressoes;
    }
}
