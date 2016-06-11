package visitor;

/**
 * Created by Jorge on 06-06-2016.
 */

import instrs.*;
import parser.*;
import operator.*;

import java.util.ArrayList;

public class Visitor extends GramaticaBaseVisitor<Value> {

    @Override
    public Value visitPrograma(GramaticaParser.ProgramaContext ctx) {

        Exp pre = (Exp) visitPreC(ctx.preC()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        Exp pos = (Exp) visitPosC(ctx.posC()).getValue();

        return new Value(new Programa(pre, instrucoes, pos));
    }

    @Override
    public Value visitInstr(GramaticaParser.InstrContext ctx) {
        if(ctx.atr() != null){
            return visitAtr(ctx.atr());
        }
        else if(ctx.whileCondition() != null){
            return visitWhileCondition(ctx.whileCondition());
        }
        else if(ctx.ifCondition() != null){
            return visitIfCondition(ctx.ifCondition());
        }
        return null;
    }

    @Override
    public Value visitAtr(GramaticaParser.AtrContext ctx) {
        Exp left = (Exp) new Id(ctx.ID().getText());
        Exp right = (Exp) visitExp(ctx.exp()).getValue();

        return new Value(new Atrib(left, right));
    }

    @Override
    public Value visitIfCondition(GramaticaParser.IfConditionContext ctx) {
        Exp cond = (Exp) visitCond(ctx.cond()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        return new Value(new IfCondition(cond, instrucoes));
    }

    @Override
    public Value visitWhileCondition(GramaticaParser.WhileConditionContext ctx) {
        Exp cond = (Exp) visitCond(ctx.cond()).getValue();
        Exp invariante = (Exp) visitCond(ctx.inv().cond()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        return new Value(new WhileCondition(cond, invariante, instrucoes));
    }

    @Override
    public Value visitPreC(GramaticaParser.PreCContext ctx) {
        return visitCond(ctx.cond());
    }

    @Override
    public Value visitPosC(GramaticaParser.PosCContext ctx) {
        return visitCond(ctx.cond());
    }

    @Override
    public Value visitCond(GramaticaParser.CondContext ctx) {
        if(ctx.opL == null){
            return visitComp(ctx.comp());
        }
        else{
            Exp left = (Exp) visitCond(ctx.cond(0)).getValue();
            Exp right = (Exp) visitCond(ctx.cond(1)).getValue();

            Exp op = (Exp) new Operador(ctx.opL.getText(), left, right);

            return new Value(op);

        }
    }

    @Override
    public Value visitComp(GramaticaParser.CompContext ctx) {
        /*String id = (String) visitExp(ctx.exp(0)).getValue();
        String op = (String) visitOp(ctx.op()).getValue();
        String n = (String) visitExp(ctx.exp(1)).getValue();
        return new Value(new Comp(id, op, n));*/

        Exp left = (Exp) visitExp(ctx.exp(0)).getValue();
        Exp right = (Exp) visitExp(ctx.exp(1)).getValue();

        Exp op = (Exp) new Operador(ctx.op().getText(), left, right);

        return new Value(op);
    }

    @Override
    public Value visitExp(GramaticaParser.ExpContext ctx) {
        if(ctx.opA == null){
            return visitTermo(ctx.termo());
        }
        else{
            Exp left = (Exp) visitExp(ctx.exp()).getValue();
            Exp right = (Exp) visitTermo(ctx.termo()).getValue();

            return new Value(new Operador(ctx.opA.getText(), left, right));
        }
    }

    @Override
    public Value visitOp(GramaticaParser.OpContext ctx) {
        return new Value(ctx.getText());
    }

    @Override
    public Value visitTermo(GramaticaParser.TermoContext ctx) {
        if(ctx.opM == null){
            return visitFator(ctx.fator());
        }
        else{
            Exp left = (Exp) visitTermo(ctx.termo()).getValue();
            Exp right = (Exp) visitFator(ctx.fator()).getValue();

            return new Value(new Operador(ctx.opM.getText(), left, right));
        }
    }

    @Override
    public Value visitFator(GramaticaParser.FatorContext ctx) {
        if(ctx.ID() != null){
            return new Value(new Id(ctx.getText()));
        }
        else if(ctx.INT() != null){
            return new Value(new Int(Integer.parseInt(ctx.getText())));
        }

        return null;
    }
}
