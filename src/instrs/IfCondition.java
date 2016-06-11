package instrs;

import operator.Exp;

import java.util.ArrayList;

/**
 * Created by Jorge on 10-06-2016.
 */
public class IfCondition implements Instrucao {
    Exp cond;
    ArrayList<Instrucao> instrucoesIf;
    ArrayList<Instrucao> instrucoesElse;

    public IfCondition(Exp cond, ArrayList<Instrucao> instrucoesIf, ArrayList<Instrucao> instrucoesElse){
        this.cond = cond;
        this.instrucoesIf = instrucoesIf;
        this.instrucoesElse = instrucoesElse;
    }

    public IfCondition(Exp cond, ArrayList<Instrucao> instrucoesIf){
        this.cond = cond;
        this.instrucoesIf = instrucoesIf;
        this.instrucoesElse = null;
    }

}
