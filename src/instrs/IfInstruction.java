package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Classe que representa uma instrução if.
 *
 * @author jorge
 */
public class IfInstruction implements Instrucao {
    private Exp cond;
    private ArrayList<Instrucao> instrucoesIf;
    private ArrayList<Instrucao> instrucoesElse;

    public IfInstruction(Exp cond, ArrayList<Instrucao> instrucoesIf, ArrayList<Instrucao> instrucoesElse){
        this.cond = cond;
        this.instrucoesIf = instrucoesIf;
        this.instrucoesElse = instrucoesElse;
    }

    public IfInstruction(Exp cond, ArrayList<Instrucao> instrucoesIf){
        this.cond = cond;
        this.instrucoesIf = instrucoesIf;
        this.instrucoesElse = null;
    }

    public ArrayList<Instrucao> getInstrucoesElse() {
        return instrucoesElse;
    }

    public ArrayList<Instrucao> getInstrucoesIf() {
        return instrucoesIf;
    }

    public Exp getCond() {
        return cond;
    }
}
