// Generated from Calculette.g4 by ANTLR 4.7.2



	import java.util.HashMap;
	import java.util.Scanner;  // Import the Scanner class
	
	
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		NEWLINE=32, WS=33, BOOLEAN=34, ENTIER=35, REELLE=36, TYPE=37, MOTCLE=38, 
		IDENTIFIANT=39, READLN=40, PRINTLN=41, COMMENTAIRE=42, UNMATCH=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "NEWLINE", "WS", 
			"BOOLEAN", "ENTIER", "REELLE", "TYPE", "MOTCLE", "IDENTIFIANT", "READLN", 
			"PRINTLN", "COMMENTAIRE", "UNMATCH"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'while'", "'('", "')'", "'if'", "'else'", "'for'", "';'", 
			"'repeat'", "'until'", "'readln('", "'println('", "'*'", "'/'", "'+'", 
			"'-'", "'{'", "'}'", "'return'", "'<'", "'>'", "'<='", "'>='", "'=='", 
			"'!='", "'and'", "'or'", "'not'", "'true'", "'false'", "','", null, null, 
			null, null, null, null, null, null, "'readln'", "'println'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NEWLINE", "WS", "BOOLEAN", 
			"ENTIER", "REELLE", "TYPE", "MOTCLE", "IDENTIFIANT", "READLN", "PRINTLN", 
			"COMMENTAIRE", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	 

		private TablesSymboles tablesSymboles = new TablesSymboles();
		private int sp = 0;	

		private int evalexpr (int x, String op, int y) {
	        if ( op.equals("*") ){
	            return x*y;
	        } else if ( op.equals("+") ){
	            return x+y;
	        } else {
	           System.err.println("Opérateur arithmétique inconnu : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique inconnu : '"+op+"'");
	        }
	    }
	    
	    private int _label = 0;
	    /** générateur de nom d'étiquettes */
	    private int nextLabel() { return _label++; }
	    
		public boolean isReal(String string) {
		    boolean delimiterMatched = false;
		    char delimiter = '.';
		    for (int i = 0; i < string.length(); i++) {
		        char c = string.charAt(i);
		        if (!(c >= '0' && c <= '9' || c == delimiter)) {
		            // contains not number
		            return false;
		        }
		        if (c == delimiter) {
		            // delimiter matched twice
		            if (delimiterMatched) {
		                return false;
		            }
		            delimiterMatched = true;
		        }
		    }
		    // if matched delimiter once return true
		    return delimiterMatched;
		}
	   


	public CalculetteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0164\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\5!\u00ce\n!\3!\3!\3!\3!\3\"\6"+
		"\"\u00d5\n\"\r\"\16\"\u00d6\3\"\3\"\3#\3#\3$\5$\u00de\n$\3$\6$\u00e1\n"+
		"$\r$\16$\u00e2\3%\5%\u00e6\n%\3%\6%\u00e9\n%\r%\16%\u00ea\3%\3%\6%\u00ef"+
		"\n%\r%\16%\u00f0\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u00ff\n&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u012f\n\'\3(\6(\u0132\n(\r"+
		"(\16(\u0133\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\7"+
		"+\u0149\n+\f+\16+\u014c\13+\3+\3+\3+\3+\6+\u0152\n+\r+\16+\u0153\7+\u0156"+
		"\n+\f+\16+\u0159\13+\3+\3+\5+\u015d\n+\3+\3+\3,\3,\3,\3,\2\2-\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-\3\2\7\4\2\13\13\"\"\4\2C\\c|\3\2\f\f\3\2,,\3\2"+
		"\61\61\2\u0179\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7a\3\2\2\2\t"+
		"c\3\2\2\2\13e\3\2\2\2\rh\3\2\2\2\17m\3\2\2\2\21q\3\2\2\2\23s\3\2\2\2\25"+
		"z\3\2\2\2\27\u0080\3\2\2\2\31\u0088\3\2\2\2\33\u0091\3\2\2\2\35\u0093"+
		"\3\2\2\2\37\u0095\3\2\2\2!\u0097\3\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2"+
		"\'\u009d\3\2\2\2)\u00a4\3\2\2\2+\u00a6\3\2\2\2-\u00a8\3\2\2\2/\u00ab\3"+
		"\2\2\2\61\u00ae\3\2\2\2\63\u00b1\3\2\2\2\65\u00b4\3\2\2\2\67\u00b8\3\2"+
		"\2\29\u00bb\3\2\2\2;\u00bf\3\2\2\2=\u00c4\3\2\2\2?\u00ca\3\2\2\2A\u00cd"+
		"\3\2\2\2C\u00d4\3\2\2\2E\u00da\3\2\2\2G\u00dd\3\2\2\2I\u00e5\3\2\2\2K"+
		"\u00fe\3\2\2\2M\u012e\3\2\2\2O\u0131\3\2\2\2Q\u0135\3\2\2\2S\u013c\3\2"+
		"\2\2U\u015c\3\2\2\2W\u0160\3\2\2\2YZ\7?\2\2Z\4\3\2\2\2[\\\7y\2\2\\]\7"+
		"j\2\2]^\7k\2\2^_\7n\2\2_`\7g\2\2`\6\3\2\2\2ab\7*\2\2b\b\3\2\2\2cd\7+\2"+
		"\2d\n\3\2\2\2ef\7k\2\2fg\7h\2\2g\f\3\2\2\2hi\7g\2\2ij\7n\2\2jk\7u\2\2"+
		"kl\7g\2\2l\16\3\2\2\2mn\7h\2\2no\7q\2\2op\7t\2\2p\20\3\2\2\2qr\7=\2\2"+
		"r\22\3\2\2\2st\7t\2\2tu\7g\2\2uv\7r\2\2vw\7g\2\2wx\7c\2\2xy\7v\2\2y\24"+
		"\3\2\2\2z{\7w\2\2{|\7p\2\2|}\7v\2\2}~\7k\2\2~\177\7n\2\2\177\26\3\2\2"+
		"\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7f\2\2\u0084\u0085\7n\2\2\u0085\u0086\7p\2\2\u0086\u0087\7*\2\2\u0087"+
		"\30\3\2\2\2\u0088\u0089\7r\2\2\u0089\u008a\7t\2\2\u008a\u008b\7k\2\2\u008b"+
		"\u008c\7p\2\2\u008c\u008d\7v\2\2\u008d\u008e\7n\2\2\u008e\u008f\7p\2\2"+
		"\u008f\u0090\7*\2\2\u0090\32\3\2\2\2\u0091\u0092\7,\2\2\u0092\34\3\2\2"+
		"\2\u0093\u0094\7\61\2\2\u0094\36\3\2\2\2\u0095\u0096\7-\2\2\u0096 \3\2"+
		"\2\2\u0097\u0098\7/\2\2\u0098\"\3\2\2\2\u0099\u009a\7}\2\2\u009a$\3\2"+
		"\2\2\u009b\u009c\7\177\2\2\u009c&\3\2\2\2\u009d\u009e\7t\2\2\u009e\u009f"+
		"\7g\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7t\2\2\u00a2"+
		"\u00a3\7p\2\2\u00a3(\3\2\2\2\u00a4\u00a5\7>\2\2\u00a5*\3\2\2\2\u00a6\u00a7"+
		"\7@\2\2\u00a7,\3\2\2\2\u00a8\u00a9\7>\2\2\u00a9\u00aa\7?\2\2\u00aa.\3"+
		"\2\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7?\2\2\u00ad\60\3\2\2\2\u00ae\u00af"+
		"\7?\2\2\u00af\u00b0\7?\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7#\2\2\u00b2\u00b3"+
		"\7?\2\2\u00b3\64\3\2\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7"+
		"\7f\2\2\u00b7\66\3\2\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7t\2\2\u00ba8"+
		"\3\2\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7v\2\2\u00be"+
		":\3\2\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7w\2\2\u00c2"+
		"\u00c3\7g\2\2\u00c3<\3\2\2\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7g\2\2\u00c9>\3\2\2\2\u00ca"+
		"\u00cb\7.\2\2\u00cb@\3\2\2\2\u00cc\u00ce\7\17\2\2\u00cd\u00cc\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\b!\2\2\u00d2B\3\2\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\b\"\2\2\u00d9D\3\2\2\2\u00da\u00db\4\62\63"+
		"\2\u00dbF\3\2\2\2\u00dc\u00de\7/\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\4\62;\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3H\3\2\2\2"+
		"\u00e4\u00e6\7/\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e9\4\62;\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\7\60"+
		"\2\2\u00ed\u00ef\4\62;\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1J\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3"+
		"\u00f4\7p\2\2\u00f4\u00ff\7v\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7n\2\2"+
		"\u00f7\u00f8\7q\2\2\u00f8\u00f9\7c\2\2\u00f9\u00ff\7v\2\2\u00fa\u00fb"+
		"\7d\2\2\u00fb\u00fc\7q\2\2\u00fc\u00fd\7q\2\2\u00fd\u00ff\7n\2\2\u00fe"+
		"\u00f2\3\2\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ffL\3\2\2\2"+
		"\u0100\u0101\7d\2\2\u0101\u0102\7t\2\2\u0102\u0103\7g\2\2\u0103\u0104"+
		"\7c\2\2\u0104\u012f\7m\2\2\u0105\u0106\7e\2\2\u0106\u0107\7n\2\2\u0107"+
		"\u0108\7c\2\2\u0108\u0109\7u\2\2\u0109\u012f\7u\2\2\u010a\u010b\7f\2\2"+
		"\u010b\u010c\7q\2\2\u010c\u010d\7w\2\2\u010d\u010e\7d\2\2\u010e\u010f"+
		"\7n\2\2\u010f\u012f\7g\2\2\u0110\u0111\7g\2\2\u0111\u0112\7n\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u012f\7g\2\2\u0114\u0115\7k\2\2\u0115\u012f\7h\2\2"+
		"\u0116\u0117\7k\2\2\u0117\u0118\7o\2\2\u0118\u0119\7r\2\2\u0119\u011a"+
		"\7q\2\2\u011a\u011b\7t\2\2\u011b\u012f\7v\2\2\u011c\u011d\7r\2\2\u011d"+
		"\u011e\7w\2\2\u011e\u011f\7d\2\2\u011f\u0120\7n\2\2\u0120\u0121\7k\2\2"+
		"\u0121\u012f\7e\2\2\u0122\u0123\7u\2\2\u0123\u0124\7v\2\2\u0124\u0125"+
		"\7c\2\2\u0125\u0126\7v\2\2\u0126\u0127\7k\2\2\u0127\u012f\7e\2\2\u0128"+
		"\u0129\7v\2\2\u0129\u012a\7j\2\2\u012a\u012b\7t\2\2\u012b\u012c\7q\2\2"+
		"\u012c\u012d\7y\2\2\u012d\u012f\7u\2\2\u012e\u0100\3\2\2\2\u012e\u0105"+
		"\3\2\2\2\u012e\u010a\3\2\2\2\u012e\u0110\3\2\2\2\u012e\u0114\3\2\2\2\u012e"+
		"\u0116\3\2\2\2\u012e\u011c\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u0128\3\2"+
		"\2\2\u012fN\3\2\2\2\u0130\u0132\t\3\2\2\u0131\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134P\3\2\2\2\u0135"+
		"\u0136\7t\2\2\u0136\u0137\7g\2\2\u0137\u0138\7c\2\2\u0138\u0139\7f\2\2"+
		"\u0139\u013a\7n\2\2\u013a\u013b\7p\2\2\u013bR\3\2\2\2\u013c\u013d\7r\2"+
		"\2\u013d\u013e\7t\2\2\u013e\u013f\7k\2\2\u013f\u0140\7p\2\2\u0140\u0141"+
		"\7v\2\2\u0141\u0142\7n\2\2\u0142\u0143\7p\2\2\u0143T\3\2\2\2\u0144\u0145"+
		"\7\61\2\2\u0145\u0146\7\61\2\2\u0146\u014a\3\2\2\2\u0147\u0149\n\4\2\2"+
		"\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014b\u015d\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\7\61\2\2"+
		"\u014e\u0157\7,\2\2\u014f\u0151\n\5\2\2\u0150\u0152\n\6\2\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0156\3\2\2\2\u0155\u014f\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u015b\7,\2\2\u015b\u015d\7\61\2\2\u015c\u0144\3\2\2\2\u015c\u014d\3\2"+
		"\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b+\2\2\u015fV\3\2\2\2\u0160\u0161"+
		"\13\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\b,\2\2\u0163X\3\2\2\2\21\2\u00cd"+
		"\u00d6\u00dd\u00e2\u00e5\u00ea\u00f0\u00fe\u012e\u0133\u014a\u0153\u0157"+
		"\u015c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}