// Generated from /home/jorge/Desktop/TP-VF/grammar/Gramatica.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(GramaticaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#preC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreC(GramaticaParser.PreCContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#posC}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosC(GramaticaParser.PosCContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#instrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrs(GramaticaParser.InstrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstr(GramaticaParser.InstrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#ifCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCondition(GramaticaParser.IfConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#elseCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseCondition(GramaticaParser.ElseConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(GramaticaParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#inv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInv(GramaticaParser.InvContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#atr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtr(GramaticaParser.AtrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(GramaticaParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(GramaticaParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(GramaticaParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(GramaticaParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(GramaticaParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(GramaticaParser.OpContext ctx);
}