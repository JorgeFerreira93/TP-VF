package visitor;

/**
 * Construção do objeto Programa
 *
 * @author jorge
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
            Instrucao aux = (Instrucao) visitInstr(i).getValue();
            if(aux instanceof ForInstruction){
                instrucoes.add(((ForInstruction) aux).getAtr());
                instrucoes.add(new WhileInstruction(((ForInstruction) aux).getCond(), ((ForInstruction) aux).getInv(), ((ForInstruction) aux).getInstrucoes()));
            }
            else{
                instrucoes.add((Instrucao) visitInstr(i).getValue());
            }
        }

        Exp pos = (Exp) visitPosC(ctx.posC()).getValue();
        return new Value(new Programa(pre, instrucoes, pos));
    }

    @Override
    public Value visitInstr(GramaticaParser.InstrContext ctx) {
        if(ctx.atr() != null){
            return visitAtr(ctx.atr());
        }
        else if(ctx.whileInstruction() != null){
            return visitWhileInstruction(ctx.whileInstruction());
        }
        else if(ctx.ifInstruction() != null){
            return visitIfInstruction(ctx.ifInstruction());
        }
        else if(ctx.forInstruction() != null){
            return visitForInstruction(ctx.forInstruction());
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
    public Value visitIfInstruction(GramaticaParser.IfInstructionContext ctx) {
        Exp cond = (Exp) visitCond(ctx.cond()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        if(ctx.elseCondition() != null){
            ArrayList<Instrucao> instrucoesElse = (ArrayList<Instrucao>) visitElseCondition(ctx.elseCondition()).getValue();
            return new Value(new IfInstruction(cond, instrucoes, instrucoesElse));
        }

        return new Value(new IfInstruction(cond, instrucoes));
    }

    @Override
    public Value visitElseCondition(GramaticaParser.ElseConditionContext ctx) {
        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        return new Value(instrucoes);
    }

    @Override
    public Value visitWhileInstruction(GramaticaParser.WhileInstructionContext ctx) {
        Exp cond = (Exp) visitCond(ctx.cond()).getValue();
        Exp invariante = (Exp) visitCond(ctx.inv().cond()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        return new Value(new WhileInstruction(cond, invariante, instrucoes));
    }

    @Override
    public Value visitForInstruction(GramaticaParser.ForInstructionContext ctx) {
        Instrucao atr = (Instrucao) visitAtr(ctx.atr(0)).getValue();
        Exp cond = (Exp) visitCond(ctx.cond()).getValue();
        Exp invariante = (Exp) visitCond(ctx.inv().cond()).getValue();

        ArrayList<Instrucao> instrucoes = new ArrayList<>();

        for(GramaticaParser.InstrContext i : ctx.instrs().instr()){
            instrucoes.add((Instrucao) visitInstr(i).getValue());
        }

        instrucoes.add((Instrucao) visitAtr(ctx.atr(1)).getValue());

        return new Value(new ForInstruction(atr, cond, invariante, instrucoes));
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
