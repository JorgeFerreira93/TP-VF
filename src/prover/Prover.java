package prover;

import com.microsoft.z3.*;
import operator.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jorge on 6/11/16.
 */
public class Prover {

    ArrayList<Exp> condicoes;

    public Prover(ArrayList<Exp> condicoes){
        this.condicoes = condicoes;
    }

    public ArrayList<Result> parse(){

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        cfg.put("proof", "true");
        Context ctx = new Context(cfg);

        ArrayList<Result> results = new ArrayList<>();

        for(Exp e : this.condicoes){

            BoolExpr b = (BoolExpr) resExp(e, ctx);
            Solver solver = ctx.mkSolver();

            solver.add(ctx.mkNot(b));

            Status q = solver.check();

            switch (q){
                case SATISFIABLE:
                    results.add(new Result(q, e, b, solver.getModel().toString()));
                    break;

                case UNSATISFIABLE:
                    results.add(new Result(q, e, b, solver.getProof().toString()));
                    break;
            }
        }

        return results;
    }

    private Expr resExp(Exp e, Context ctx){

        Operador expressao = (Operador) e;

        Expr left = null;
        Expr right = null;

        if(expressao.getLeft() != null){
            if(expressao.getLeft() instanceof Int){
                left = ctx.mkNumeral(((Int) expressao.getLeft()).getN(), ctx.getIntSort());
            }
            else if(expressao.getLeft() instanceof Id){
                left = ctx.mkIntConst(((Id) expressao.getLeft()).getName());
            }
            else{
                left = resExp(expressao.getLeft(), ctx);
            }
        }

        if(expressao.getRight() instanceof Int){
            right = ctx.mkNumeral(((Int) expressao.getRight()).getN(), ctx.getIntSort());
        }
        else if(expressao.getRight() instanceof Id){
            right = ctx.mkIntConst(((Id) expressao.getRight()).getName());
        }
        else{
            right = resExp(expressao.getRight(), ctx);
        }

        Expr b = null;

        switch (expressao.getOp()){

            case "+":
                b = ctx.mkAdd((ArithExpr) left, (ArithExpr) right);
                return b;

            case "-":
                b = ctx.mkSub((ArithExpr) left, (ArithExpr) right);
                return b;

            case "*":
                b = ctx.mkMul((ArithExpr) left, (ArithExpr) right);
                return b;

            case "/":
                b = ctx.mkDiv((ArithExpr) left, (ArithExpr) right);
                return b;

            case ">":
                b = ctx.mkGt((ArithExpr) left, (ArithExpr) right);
                return b;

            case ">=":
                b = ctx.mkGe((ArithExpr) left, (ArithExpr) right);
                return b;

            case "<":
                b = ctx.mkLt((ArithExpr) left, (ArithExpr) right);
                return b;

            case "<=":
                b = ctx.mkLe((ArithExpr) left, (ArithExpr) right);
                return b;

            case "&&":
                b = ctx.mkAnd((BoolExpr) left, (BoolExpr) right);
                return b;

            case "||":
                b = ctx.mkOr((BoolExpr) left, (BoolExpr) right);
                return b;

            case "=>":
                b = ctx.mkImplies((BoolExpr) left, (BoolExpr) right);
                return b;

            case "!":
                b = ctx.mkNot((BoolExpr) right);
                return b;

            case "==":
                b = ctx.mkEq(left, right);
                return b;

            case "<=>":
                b = ctx.mkEq((BoolExpr) left, (BoolExpr) right);
                return b;
        }

        return null;
    }
}
