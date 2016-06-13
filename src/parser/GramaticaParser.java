// Generated from /home/jorge/Desktop/TP-VF/grammar/Gramatica.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, NOME=24, ID=25, 
		DATA=26, INT=27, WS=28;
	public static final int
		RULE_programa = 0, RULE_preC = 1, RULE_posC = 2, RULE_instrs = 3, RULE_instr = 4, 
		RULE_ifInstruction = 5, RULE_elseCondition = 6, RULE_whileInstruction = 7, 
		RULE_forInstruction = 8, RULE_inv = 9, RULE_atr = 10, RULE_exp = 11, RULE_termo = 12, 
		RULE_fator = 13, RULE_cond = 14, RULE_comp = 15, RULE_op = 16;
	public static final String[] ruleNames = {
		"programa", "preC", "posC", "instrs", "instr", "ifInstruction", "elseCondition", 
		"whileInstruction", "forInstruction", "inv", "atr", "exp", "termo", "fator", 
		"cond", "comp", "op"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'while'", "'for'", 
		"';'", "'['", "']'", "'='", "'+'", "'-'", "'*'", "'/'", "'true'", "'false'", 
		"'&&'", "'||'", "'>'", "'<'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NOME", "ID", "DATA", "INT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public PreCContext preC() {
			return getRuleContext(PreCContext.class,0);
		}
		public InstrsContext instrs() {
			return getRuleContext(InstrsContext.class,0);
		}
		public PosCContext posC() {
			return getRuleContext(PosCContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			preC();
			setState(35);
			instrs();
			setState(36);
			posC();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreCContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public PreCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preC; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPreC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreCContext preC() throws RecognitionException {
		PreCContext _localctx = new PreCContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_preC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			cond(0);
			setState(40);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PosCContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public PosCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_posC; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitPosC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosCContext posC() throws RecognitionException {
		PosCContext _localctx = new PosCContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_posC);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			cond(0);
			setState(44);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrsContext extends ParserRuleContext {
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public InstrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrsContext instrs() throws RecognitionException {
		InstrsContext _localctx = new InstrsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			instr();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__6) | (1L << T__7) | (1L << ID))) != 0)) {
				{
				{
				setState(47);
				instr();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrContext extends ParserRuleContext {
		public IfInstructionContext ifInstruction() {
			return getRuleContext(IfInstructionContext.class,0);
		}
		public WhileInstructionContext whileInstruction() {
			return getRuleContext(WhileInstructionContext.class,0);
		}
		public ForInstructionContext forInstruction() {
			return getRuleContext(ForInstructionContext.class,0);
		}
		public AtrContext atr() {
			return getRuleContext(AtrContext.class,0);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instr);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				ifInstruction();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				whileInstruction();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				forInstruction();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				atr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfInstructionContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public InstrsContext instrs() {
			return getRuleContext(InstrsContext.class,0);
		}
		public ElseConditionContext elseCondition() {
			return getRuleContext(ElseConditionContext.class,0);
		}
		public IfInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifInstruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitIfInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfInstructionContext ifInstruction() throws RecognitionException {
		IfInstructionContext _localctx = new IfInstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifInstruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__2);
			setState(60);
			match(T__3);
			setState(61);
			cond(0);
			setState(62);
			match(T__4);
			setState(63);
			match(T__0);
			setState(64);
			instrs();
			setState(65);
			match(T__1);
			setState(67);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(66);
				elseCondition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseConditionContext extends ParserRuleContext {
		public InstrsContext instrs() {
			return getRuleContext(InstrsContext.class,0);
		}
		public ElseConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitElseCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseConditionContext elseCondition() throws RecognitionException {
		ElseConditionContext _localctx = new ElseConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__5);
			setState(70);
			match(T__0);
			setState(71);
			instrs();
			setState(72);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileInstructionContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public InvContext inv() {
			return getRuleContext(InvContext.class,0);
		}
		public InstrsContext instrs() {
			return getRuleContext(InstrsContext.class,0);
		}
		public WhileInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileInstruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitWhileInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileInstructionContext whileInstruction() throws RecognitionException {
		WhileInstructionContext _localctx = new WhileInstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__6);
			setState(75);
			match(T__3);
			setState(76);
			cond(0);
			setState(77);
			match(T__4);
			setState(78);
			inv();
			setState(79);
			match(T__0);
			setState(80);
			instrs();
			setState(81);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInstructionContext extends ParserRuleContext {
		public List<AtrContext> atr() {
			return getRuleContexts(AtrContext.class);
		}
		public AtrContext atr(int i) {
			return getRuleContext(AtrContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public InvContext inv() {
			return getRuleContext(InvContext.class,0);
		}
		public InstrsContext instrs() {
			return getRuleContext(InstrsContext.class,0);
		}
		public ForInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInstruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitForInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInstructionContext forInstruction() throws RecognitionException {
		ForInstructionContext _localctx = new ForInstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_forInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__7);
			setState(84);
			match(T__3);
			setState(85);
			atr();
			setState(86);
			match(T__8);
			setState(87);
			cond(0);
			setState(88);
			match(T__8);
			setState(89);
			atr();
			setState(90);
			match(T__4);
			setState(91);
			inv();
			setState(92);
			match(T__0);
			setState(93);
			instrs();
			setState(94);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public InvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inv; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvContext inv() throws RecognitionException {
		InvContext _localctx = new InvContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__9);
			setState(97);
			cond(0);
			setState(98);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AtrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtrContext atr() throws RecognitionException {
		AtrContext _localctx = new AtrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
			setState(101);
			match(T__11);
			setState(102);
			exp(0);
			setState(103);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public Token opA;
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(106);
			termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(108);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(109);
					((ExpContext)_localctx).opA = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__12 || _la==T__13) ) {
						((ExpContext)_localctx).opA = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(110);
					termo(0);
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public Token opM;
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		return termo(0);
	}

	private TermoContext termo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoContext _localctx = new TermoContext(_ctx, _parentState);
		TermoContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_termo, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(117);
			fator();
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termo);
					setState(119);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(120);
					((TermoContext)_localctx).opM = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
						((TermoContext)_localctx).opM = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(121);
					fator();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GramaticaParser.ID, 0); }
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << ID) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public Token opL;
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			switch (_input.LA(1)) {
			case T__16:
			case T__17:
			case ID:
			case INT:
				{
				setState(130);
				comp();
				}
				break;
			case T__3:
				{
				setState(131);
				match(T__3);
				setState(132);
				cond(0);
				setState(133);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cond);
					setState(137);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(138);
					((CondContext)_localctx).opL = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__18 || _la==T__19) ) {
						((CondContext)_localctx).opL = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(139);
					cond(2);
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			exp(0);
			setState(146);
			op();
			setState(147);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_op);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(T__20);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__21);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(T__21);
				setState(152);
				match(T__11);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(T__20);
				setState(154);
				match(T__11);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				match(T__11);
				setState(156);
				match(T__11);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				match(T__22);
				setState(158);
				match(T__11);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(159);
				match(T__11);
				setState(160);
				match(T__20);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(161);
				match(T__21);
				setState(162);
				match(T__11);
				setState(163);
				match(T__20);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 12:
			return termo_sempred((TermoContext)_localctx, predIndex);
		case 14:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5\63\n\5\f"+
		"\5\16\5\66\13\5\3\6\3\6\3\6\3\6\5\6<\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\rr\n\r\f\r\16\ru\13\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\7\16}\n\16\f\16\16\16\u0080\13\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u008a\n\20\3\20\3\20\3\20\7\20"+
		"\u008f\n\20\f\20\16\20\u0092\13\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00a7"+
		"\n\22\3\22\2\5\30\32\36\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2"+
		"\6\3\2\17\20\3\2\21\22\5\2\23\24\33\33\35\35\3\2\25\26\u00a7\2$\3\2\2"+
		"\2\4(\3\2\2\2\6,\3\2\2\2\b\60\3\2\2\2\n;\3\2\2\2\f=\3\2\2\2\16G\3\2\2"+
		"\2\20L\3\2\2\2\22U\3\2\2\2\24b\3\2\2\2\26f\3\2\2\2\30k\3\2\2\2\32v\3\2"+
		"\2\2\34\u0081\3\2\2\2\36\u0089\3\2\2\2 \u0093\3\2\2\2\"\u00a6\3\2\2\2"+
		"$%\5\4\3\2%&\5\b\5\2&\'\5\6\4\2\'\3\3\2\2\2()\7\3\2\2)*\5\36\20\2*+\7"+
		"\4\2\2+\5\3\2\2\2,-\7\3\2\2-.\5\36\20\2./\7\4\2\2/\7\3\2\2\2\60\64\5\n"+
		"\6\2\61\63\5\n\6\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2"+
		"\2\2\65\t\3\2\2\2\66\64\3\2\2\2\67<\5\f\7\28<\5\20\t\29<\5\22\n\2:<\5"+
		"\26\f\2;\67\3\2\2\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\13\3\2\2\2=>\7\5\2"+
		"\2>?\7\6\2\2?@\5\36\20\2@A\7\7\2\2AB\7\3\2\2BC\5\b\5\2CE\7\4\2\2DF\5\16"+
		"\b\2ED\3\2\2\2EF\3\2\2\2F\r\3\2\2\2GH\7\b\2\2HI\7\3\2\2IJ\5\b\5\2JK\7"+
		"\4\2\2K\17\3\2\2\2LM\7\t\2\2MN\7\6\2\2NO\5\36\20\2OP\7\7\2\2PQ\5\24\13"+
		"\2QR\7\3\2\2RS\5\b\5\2ST\7\4\2\2T\21\3\2\2\2UV\7\n\2\2VW\7\6\2\2WX\5\26"+
		"\f\2XY\7\13\2\2YZ\5\36\20\2Z[\7\13\2\2[\\\5\26\f\2\\]\7\7\2\2]^\5\24\13"+
		"\2^_\7\3\2\2_`\5\b\5\2`a\7\4\2\2a\23\3\2\2\2bc\7\f\2\2cd\5\36\20\2de\7"+
		"\r\2\2e\25\3\2\2\2fg\7\33\2\2gh\7\16\2\2hi\5\30\r\2ij\7\13\2\2j\27\3\2"+
		"\2\2kl\b\r\1\2lm\5\32\16\2ms\3\2\2\2no\f\3\2\2op\t\2\2\2pr\5\32\16\2q"+
		"n\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\31\3\2\2\2us\3\2\2\2vw\b\16\1"+
		"\2wx\5\34\17\2x~\3\2\2\2yz\f\3\2\2z{\t\3\2\2{}\5\34\17\2|y\3\2\2\2}\u0080"+
		"\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\33\3\2\2\2\u0080~\3\2\2\2\u0081\u0082"+
		"\t\4\2\2\u0082\35\3\2\2\2\u0083\u0084\b\20\1\2\u0084\u008a\5 \21\2\u0085"+
		"\u0086\7\6\2\2\u0086\u0087\5\36\20\2\u0087\u0088\7\7\2\2\u0088\u008a\3"+
		"\2\2\2\u0089\u0083\3\2\2\2\u0089\u0085\3\2\2\2\u008a\u0090\3\2\2\2\u008b"+
		"\u008c\f\3\2\2\u008c\u008d\t\5\2\2\u008d\u008f\5\36\20\4\u008e\u008b\3"+
		"\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\37\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\5\30\r\2\u0094\u0095\5\"\22"+
		"\2\u0095\u0096\5\30\r\2\u0096!\3\2\2\2\u0097\u00a7\7\27\2\2\u0098\u00a7"+
		"\7\30\2\2\u0099\u009a\7\30\2\2\u009a\u00a7\7\16\2\2\u009b\u009c\7\27\2"+
		"\2\u009c\u00a7\7\16\2\2\u009d\u009e\7\16\2\2\u009e\u00a7\7\16\2\2\u009f"+
		"\u00a0\7\31\2\2\u00a0\u00a7\7\16\2\2\u00a1\u00a2\7\16\2\2\u00a2\u00a7"+
		"\7\27\2\2\u00a3\u00a4\7\30\2\2\u00a4\u00a5\7\16\2\2\u00a5\u00a7\7\27\2"+
		"\2\u00a6\u0097\3\2\2\2\u00a6\u0098\3\2\2\2\u00a6\u0099\3\2\2\2\u00a6\u009b"+
		"\3\2\2\2\u00a6\u009d\3\2\2\2\u00a6\u009f\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a7#\3\2\2\2\n\64;Es~\u0089\u0090\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}