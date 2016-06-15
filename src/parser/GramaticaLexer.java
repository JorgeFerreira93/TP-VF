// Generated from /home/jorge/Desktop/VF/TP-VF/grammar/Gramatica.g4 by ANTLR 4.5.3
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NOME=22, ID=23, DATA=24, INT=25, 
		WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "NOME", "ID", "DATA", "INT", "WS", 
		"STRING", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "HEX_DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "';'", "'if'", "'('", "')'", "'else'", "'while'", 
		"'for'", "'['", "']'", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
		"'>'", "'<'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "NOME", "ID", 
		"DATA", "INT", "WS"
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


	public GramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00b3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\7\30|\n\30\f\30\16"+
		"\30\177\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\6\32\u0088\n\32\r\32"+
		"\16\32\u0089\3\33\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0093\n\34\f\34\16"+
		"\34\u0096\13\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u009e\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00a9\n\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\29\2;\2=\2?\2\3\2\b\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13"+
		"\f\17\17\"\"\3\2$$\n\2$$))^^ddhhppttvv\5\2\62;CHch\u00b5\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2"+
		"\13J\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21S\3\2\2\2\23Y\3\2\2\2\25]\3\2\2"+
		"\2\27_\3\2\2\2\31a\3\2\2\2\33c\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!i\3\2\2"+
		"\2#k\3\2\2\2%n\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+u\3\2\2\2-w\3\2\2\2/y\3\2"+
		"\2\2\61\u0080\3\2\2\2\63\u0087\3\2\2\2\65\u008b\3\2\2\2\67\u008f\3\2\2"+
		"\29\u009d\3\2\2\2;\u00a8\3\2\2\2=\u00aa\3\2\2\2?\u00b1\3\2\2\2AB\7}\2"+
		"\2B\4\3\2\2\2CD\7\177\2\2D\6\3\2\2\2EF\7=\2\2F\b\3\2\2\2GH\7k\2\2HI\7"+
		"h\2\2I\n\3\2\2\2JK\7*\2\2K\f\3\2\2\2LM\7+\2\2M\16\3\2\2\2NO\7g\2\2OP\7"+
		"n\2\2PQ\7u\2\2QR\7g\2\2R\20\3\2\2\2ST\7y\2\2TU\7j\2\2UV\7k\2\2VW\7n\2"+
		"\2WX\7g\2\2X\22\3\2\2\2YZ\7h\2\2Z[\7q\2\2[\\\7t\2\2\\\24\3\2\2\2]^\7]"+
		"\2\2^\26\3\2\2\2_`\7_\2\2`\30\3\2\2\2ab\7?\2\2b\32\3\2\2\2cd\7-\2\2d\34"+
		"\3\2\2\2ef\7/\2\2f\36\3\2\2\2gh\7,\2\2h \3\2\2\2ij\7\61\2\2j\"\3\2\2\2"+
		"kl\7(\2\2lm\7(\2\2m$\3\2\2\2no\7~\2\2op\7~\2\2p&\3\2\2\2qr\7@\2\2r(\3"+
		"\2\2\2st\7>\2\2t*\3\2\2\2uv\7#\2\2v,\3\2\2\2wx\5\67\34\2x.\3\2\2\2y}\t"+
		"\2\2\2z|\t\3\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\60\3\2\2"+
		"\2\177}\3\2\2\2\u0080\u0081\5\63\32\2\u0081\u0082\7/\2\2\u0082\u0083\5"+
		"\63\32\2\u0083\u0084\7/\2\2\u0084\u0085\5\63\32\2\u0085\62\3\2\2\2\u0086"+
		"\u0088\4\62;\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\64\3\2\2\2\u008b\u008c\t\4\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008e\b\33\2\2\u008e\66\3\2\2\2\u008f\u0094\7$\2\2\u0090"+
		"\u0093\59\35\2\u0091\u0093\n\5\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7$\2\2\u00988\3\2\2\2\u0099"+
		"\u009a\7^\2\2\u009a\u009e\t\6\2\2\u009b\u009e\5=\37\2\u009c\u009e\5;\36"+
		"\2\u009d\u0099\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e:"+
		"\3\2\2\2\u009f\u00a0\7^\2\2\u00a0\u00a1\4\62\65\2\u00a1\u00a2\4\629\2"+
		"\u00a2\u00a9\4\629\2\u00a3\u00a4\7^\2\2\u00a4\u00a5\4\629\2\u00a5\u00a9"+
		"\4\629\2\u00a6\u00a7\7^\2\2\u00a7\u00a9\4\629\2\u00a8\u009f\3\2\2\2\u00a8"+
		"\u00a3\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9<\3\2\2\2\u00aa\u00ab\7^\2\2\u00ab"+
		"\u00ac\7w\2\2\u00ac\u00ad\5? \2\u00ad\u00ae\5? \2\u00ae\u00af\5? \2\u00af"+
		"\u00b0\5? \2\u00b0>\3\2\2\2\u00b1\u00b2\t\7\2\2\u00b2@\3\2\2\2\t\2}\u0089"+
		"\u0092\u0094\u009d\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}