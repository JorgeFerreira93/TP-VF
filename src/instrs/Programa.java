package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Created by Jorge on 10-06-2016.
 */
public class Programa {
    Exp pre;
    ArrayList<Instrucao> instrucoes;
    Exp pos;

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
