package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Classe que representa uma instrução for.
 *
 * @author jorge
 */
public class ForInstruction implements Instrucao {
    private Instrucao atr;
    private Exp cond;
    private Exp inv;
    private ArrayList<Instrucao> instrucoes;

    public ForInstruction(Instrucao atr, Exp cond, Exp inv, ArrayList<Instrucao> instrucoes){
        this.atr = atr;
        this.cond = cond;
        this.inv = inv;
        this.instrucoes = instrucoes;
    }

    public Instrucao getAtr() {
        return atr;
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
        return atr + " " + cond + "   " + inv + "   " + instrucoes.toString();
    }
}
