package prover;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Status;
import operator.Exp;

/**
 * Classe que representa o resultado da prova de uma condição de verificação.
 *
 * @author jorge
 */
public class Result {

    private Status stat;
    private Exp condicao;
    private BoolExpr z3;
    private String prova;

    public Result(Status stat, Exp condicao, BoolExpr z3, String prova){
        this.stat = stat;
        this.condicao = condicao;
        this.z3 = z3;
        this.prova = prova;
    }

    public Exp getCondicao() {
        return condicao;
    }

    public Status getStat() {
        return stat;
    }

    public String getZ3() {
        return z3.toString();
    }

    public String getProva() {
        return prova;
    }
}
