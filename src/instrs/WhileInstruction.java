package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Created by Jorge on 10-06-2016.
 */
public class WhileInstruction implements Instrucao {
    Exp cond;
    Exp inv;
    ArrayList<Instrucao> instrucoes;

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
