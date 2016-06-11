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

    public void parse(){
        for(Exp e : this.condicoes){
            System.out.println(e + "    : " + verifica(e));
        }
    }

    private Status verifica(Exp e){

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);

        BoolExpr b = (BoolExpr) resExp(e, ctx);

        Solver solver = ctx.mkSolver();
        solver.add(b);

        return solver.check();
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
                b = ctx.mkGe((ArithExpr) left, (ArithExpr) right);
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
        }

        return null;
    }

    public void teste(){

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        Context ctx = new Context(cfg);

        System.out.println("PushPopExample1");

        /* create a big number */
        IntSort int_type = ctx.getIntSort();

        IntExpr hundred = (IntExpr) ctx.mkNumeral("100", int_type);
        IntExpr thousand = (IntExpr) ctx.mkNumeral("1000", int_type);

        /* create x */
        IntExpr x = ctx.mkIntConst("x");

        BoolExpr b1 = ctx.mkLe(x, thousand);
        BoolExpr b2 = ctx.mkLt(x, hundred);
        Expr b0 = ctx.mkAdd(x, thousand);
        Expr b3 = (BoolExpr) ctx.mkAnd(b1, b2);
        BoolExpr b4 = ctx.mkGt(x, thousand);
        BoolExpr b5 = ctx.mkImplies((BoolExpr) b3, b4);

        Solver solver = ctx.mkSolver();

        System.out.println("(assert (=> (> x 100) (and (< 100 x) (<= x 1000))))");
        solver.add(b5);

        System.out.println(solver.check());
    }
}
