package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Classe que representa um programa.
 *
 * @author jorge
 */
public class Programa {
    private Exp pre;
    private ArrayList<Instrucao> instrucoes;
    private Exp pos;

    public Programa(Exp pre, ArrayList<Instrucao> instrucoes, Exp pos){
        this.pre = pre;
        this.instrucoes = instrucoes;
        this.pos = pos;
    }

    public Exp getPre() {
        return pre;
    }

    public Exp getPos() {
        return pos;
    }

    public ArrayList<Instrucao> getInstrucoes() {
        return instrucoes;
    }

    @Override
    public String toString() {
        return pre.toString() + instrucoes + pos.toString();
    }
}
