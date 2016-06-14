package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Classe que representa uma instrução while.
 *
 * @author jorge
 */
public class WhileInstruction implements Instrucao {
    private Exp cond;
    private Exp inv;
    private ArrayList<Instrucao> instrucoes;

    public WhileInstruction(Exp cond, Exp inv, ArrayList<Instrucao> instrucoes){
        this.cond = cond;
        this.inv = inv;
        this.instrucoes = instrucoes;
    }

    public Exp getCond() {
        return cond;
    }

    public ArrayList<Instrucao> getInstrucoes() {
        return instrucoes;
    }

    public Exp getInv() {
        return inv;
    }

    @Override
    public String toString() {
        return cond + "   " + inv + "   " + instrucoes.toString();
    }
}
