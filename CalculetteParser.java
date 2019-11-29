// Generated from Calculette.g4 by ANTLR 4.7.2



	import java.util.HashMap;
	import java.util.Scanner;  // Import the Scanner class
	
	
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_decl = 2, RULE_instruction = 3, 
		RULE_entrSorti = 4, RULE_expr = 5, RULE_exprFloat = 6, RULE_exprBoolean = 7, 
		RULE_assignation = 8, RULE_bloc = 9, RULE_blocFonction = 10, RULE_condition = 11, 
		RULE_fonction = 12, RULE_params = 13, RULE_args = 14, RULE_finInstruction = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "decl", "instruction", "entrSorti", "expr", "exprFloat", 
			"exprBoolean", "assignation", "bloc", "blocFonction", "condition", "fonction", 
			"params", "args", "finInstruction"
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

	@Override
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 

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
	   

	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public String code;
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			calcul();
			setState(33);
			match(EOF);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 
			
			// On initialise _localctx.code, pour ensuite l'utiliser comme accumulateur 
				((CalculContext)_localctx).code =  new String();  
				((CalculContext)_localctx).code =  "\n";

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 int entry = nextLabel(); _localctx.code += "JUMP " + entry + "\n"; 
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					match(NEWLINE);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					((CalculContext)_localctx).fonction = fonction();
					 _localctx.code += ((CalculContext)_localctx).fonction.code; 
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(58);
				match(NEWLINE);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "\n LABEL " + entry + "\n"; 
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ENTIER) | (1L << REELLE) | (1L << TYPE) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(65);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "\nHALT\n"; 
			}
			_ctx.stop = _input.LT(-1);

					System.out.println( sp );
					System.out.println(_localctx.code);
					

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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			((DeclContext)_localctx).TYPE = match(TYPE);
			setState(76);
			((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(77);
			finInstruction();

						//je regarde d'abord si cette variable existe deja    
						//Si une variable qui a le 	même nom et le même type, on interrompt la déclaration 
						//*********************************** */
						// je pense que je dois ajouter ici verifierType(String valeur, String type)
						if( (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("int") ){
							
							tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
							//******************* joutee */
							tablesSymboles.ajouteNBVariable();
						    ((DeclContext)_localctx).code =  "PUSHI 0\n";
			            
							
						}else if( (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("float") ){
							
							tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
							// probleme : quand la variable existe on va comme meme afficher pushi 0
				          	tablesSymboles.ajouteNBVariable();
				            ((DeclContext)_localctx).code =  "PUSHF 0.0\n";
							
						}else if( (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("bool") ){
							
							tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
							// probleme : quand la variable existe on va comme meme afficher pushi 0
				          	tablesSymboles.ajouteNBVariable();
				            ((DeclContext)_localctx).code =  "PUSHI 0\n";
							
						}else{
							
							System.err.println("Erreur type non reconnue"); 
							
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExprContext expr;
		public ExprFloatContext exprFloat;
		public AssignationContext assignation;
		public EntrSortiContext entrSorti;
		public Token TYPE;
		public Token IDENTIFIANT;
		public Token BOOLEAN;
		public ConditionContext condition;
		public InstructionContext instruction;
		public BlocContext bloc;
		public BlocContext bloc_if;
		public BlocContext bloc_else;
		public AssignationContext a1;
		public AssignationContext a2;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExprFloatContext exprFloat() {
			return getRuleContext(ExprFloatContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public EntrSortiContext entrSorti() {
			return getRuleContext(EntrSortiContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode BOOLEAN() { return getToken(CalculetteParser.BOOLEAN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<BlocContext> bloc() {
			return getRuleContexts(BlocContext.class);
		}
		public BlocContext bloc(int i) {
			return getRuleContext(BlocContext.class,i);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		int _la;
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				((InstructionContext)_localctx).expr = expr(0);
				setState(81);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((InstructionContext)_localctx).exprFloat = exprFloat(0);
				setState(85);
				finInstruction();
				 
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).exprFloat.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				((InstructionContext)_localctx).assignation = assignation();
				setState(89);
				finInstruction();
				 
				            
				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				((InstructionContext)_localctx).entrSorti = entrSorti();
				setState(93);
				finInstruction();

				    		((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).entrSorti.code ;
				       
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				((InstructionContext)_localctx).TYPE = match(TYPE);
				setState(97);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(98);
				match(T__0);
				setState(99);
				((InstructionContext)_localctx).BOOLEAN = match(BOOLEAN);
				setState(100);
				finInstruction();


				  		if( (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null).equals("bool") || (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null).equals("int") ){
				        		
				        	tablesSymboles.putVar((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null), (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null));
				  			/****************ajoutee */
				  			tablesSymboles.ajouteNBVariable();
				  			AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
				  			((InstructionContext)_localctx).code =   "PUSHI 0\n" + "PUSHI " +  (((InstructionContext)_localctx).BOOLEAN!=null?((InstructionContext)_localctx).BOOLEAN.getText():null) + "\nSTOREG " + at.adresse + "\n";
				        	
				        	}else{
				        		
				        		System.err.println("erreur de type ");
				        		System.exit(0);
				        		
				        	}
				  	 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				((InstructionContext)_localctx).TYPE = match(TYPE);
				setState(104);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(105);
				match(T__0);
				setState(106);
				((InstructionContext)_localctx).expr = expr(0);
				setState(107);
				finInstruction();


						if( (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null).equals("int") ){
				        		
				        	tablesSymboles.putVar((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null), (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null));
					  		/************ajoutee */
					  		tablesSymboles.ajouteNBVariable();
					  		AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
					  		 
					  		
					  		
					  		((InstructionContext)_localctx).code =   "PUSHI 0\n" + ((InstructionContext)_localctx).expr.code + "STOREG " + at.adresse + "\n";
				        
				        
				        	}else{
				        		
				        		System.err.println("erreur de type ");
				        		System.exit(0);
				        		
				        	}
				  	 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				((InstructionContext)_localctx).TYPE = match(TYPE);
				setState(111);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(112);
				match(T__0);
				setState(113);
				((InstructionContext)_localctx).exprFloat = exprFloat(0);
				setState(114);
				finInstruction();


				  		if( (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null).equals("float") ){
				        		
				        	tablesSymboles.putVar((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null), (((InstructionContext)_localctx).TYPE!=null?((InstructionContext)_localctx).TYPE.getText():null));
				  			/****************ajoutee */
				  			tablesSymboles.ajouteNBVariable();
				  			AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
				  			((InstructionContext)_localctx).code =   "PUSHI 0\n" + ((InstructionContext)_localctx).exprFloat.code + "STOREG " + at.adresse + "\n";
				        	sp++; 
				        	sp--; 
				        	
				        	}else{
				        		
				        		System.err.println("erreur de type ");
				        		System.exit(0);
				        		
				        	}
				  	 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(117);
				match(T__1);
				setState(118);
				match(T__2);
				setState(119);
				((InstructionContext)_localctx).condition = condition(0);
				setState(120);
				match(T__3);
				setState(121);
				((InstructionContext)_localctx).instruction = instruction();

				  	 		((InstructionContext)_localctx).code =  "";
				  	 		
				  	 		int label1 = nextLabel();
				  	 		int label2 = nextLabel();
				  	 		
				  	 		_localctx.code += "\n LABEL " + label1 + "\n";
				  	 		_localctx.code += ((InstructionContext)_localctx).condition.code ;
				  	 		_localctx.code += "JUMPF " + label2 + "\n";
				        	sp--; 
				  	 		_localctx.code += ((InstructionContext)_localctx).instruction.code ;
				  	 		_localctx.code += "JUMP " + label1 + "\n";
							_localctx.code += "\n LABEL " + label2 + "\n";
				  	 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(124);
				match(T__1);
				setState(125);
				match(T__2);
				setState(126);
				((InstructionContext)_localctx).condition = condition(0);
				setState(127);
				match(T__3);
				setState(128);
				((InstructionContext)_localctx).bloc = bloc();

				  	 		((InstructionContext)_localctx).code =  "";
				  	 		
				  	 		int label1 = nextLabel();
				  	 		int label2 = nextLabel();
				  	 		
				  	 		_localctx.code += "\n LABEL " + label1 + "\n";
				  	 		_localctx.code += ((InstructionContext)_localctx).condition.code ;
				  	 		_localctx.code += "JUMPF " + label2 + "\n";
				        	sp--; 
				  	 		_localctx.code += ((InstructionContext)_localctx).bloc.code ;
				  	 		_localctx.code += "JUMP " + label1 + "\n";
				  	 		_localctx.code += "\n LABEL " + label2 + "\n";
				  	  
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(131);
				match(T__4);
				setState(132);
				match(T__2);
				setState(133);
				((InstructionContext)_localctx).condition = condition(0);
				setState(134);
				match(T__3);
				setState(135);
				((InstructionContext)_localctx).bloc_if = bloc();

				  			((InstructionContext)_localctx).code =  "";
				  			_localctx.code += ((InstructionContext)_localctx).condition.code ;
				  			
				  			int label_fin_if  = nextLabel();
				 			
				 			_localctx.code += "JUMPF " + label_fin_if + "\n";
				        	sp--; 
				 			_localctx.code += ((InstructionContext)_localctx).bloc_if.code;
				 			
				 			int label_rest_code  = nextLabel();
				 			
				 			_localctx.code += "JUMP " + label_rest_code + "\n";
				 			_localctx.code += _localctx.code += "\n LABEL " + label_fin_if + "\n";
				  		
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(137);
					match(T__5);
					setState(138);
					((InstructionContext)_localctx).bloc_else = bloc();
					 
					  				_localctx.code +=  ((InstructionContext)_localctx).bloc_else.code ; 	
					  			
					}
				}

				   _localctx.code += "\n LABEL " + label_rest_code  + "\n";
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(145);
				match(T__6);
				setState(146);
				match(T__2);
				setState(147);
				((InstructionContext)_localctx).a1 = assignation();
				setState(148);
				match(T__7);
				setState(149);
				((InstructionContext)_localctx).condition = condition(0);
				setState(150);
				match(T__7);
				setState(151);
				((InstructionContext)_localctx).a2 = assignation();
				setState(152);
				match(T__3);
				setState(153);
				((InstructionContext)_localctx).instruction = instruction();

				       		((InstructionContext)_localctx).code =  "";
				       		_localctx.code +=  ((InstructionContext)_localctx).a1.code ;
				       		
				       		int label_for  = nextLabel();
				       		
				       		_localctx.code += "\n LABEL " + label_for + "\n";
				       		_localctx.code += ((InstructionContext)_localctx).condition.code ;
				       	
				       		int label_fin_for = nextLabel();
				       	
				       		_localctx.code += "JUMPF " + label_fin_for + "\n";
				        	sp--; 
				       		_localctx.code += ((InstructionContext)_localctx).a2.code ;
				       		_localctx.code += ((InstructionContext)_localctx).instruction.code ;
				       		_localctx.code += "JUMP " + label_for + "\n";
				       		_localctx.code += "\n LABEL " + label_fin_for + "\n";
				       
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(156);
				match(T__6);
				setState(157);
				match(T__2);
				setState(158);
				((InstructionContext)_localctx).a1 = assignation();
				setState(159);
				match(T__7);
				setState(160);
				((InstructionContext)_localctx).condition = condition(0);
				setState(161);
				match(T__7);
				setState(162);
				((InstructionContext)_localctx).a2 = assignation();
				setState(163);
				match(T__3);
				setState(164);
				((InstructionContext)_localctx).bloc = bloc();

					       		((InstructionContext)_localctx).code =  "";
					       		_localctx.code +=  ((InstructionContext)_localctx).a1.code ;
					       		
					       		int label_for  = nextLabel();
					       		
					       		_localctx.code += "\n LABEL " + label_for + "\n";
					       		_localctx.code += ((InstructionContext)_localctx).condition.code ;
					       	
					       		int label_fin_for = nextLabel();
					       	
					       		_localctx.code += "JUMPF " + label_fin_for + "\n";
					       		
				        		sp--; 
					       		_localctx.code += ((InstructionContext)_localctx).a2.code ;
					       		_localctx.code += ((InstructionContext)_localctx).bloc.code ;
					       		_localctx.code += "JUMP " + label_for + "\n";
					       		_localctx.code += "\n LABEL " + label_fin_for + "\n";
					       
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(167);
				match(T__8);
				setState(168);
				((InstructionContext)_localctx).instruction = instruction();
				setState(169);
				match(T__9);
				setState(170);
				match(T__2);
				setState(171);
				((InstructionContext)_localctx).condition = condition(0);
				setState(172);
				match(T__3);

					  	 ((InstructionContext)_localctx).code =  "";
					  	 
					  	 int label_repeat  = nextLabel();
					  	 int label_fin_repeat  = nextLabel();
					  	 
					  	 _localctx.code += "\n LABEL " + label_repeat + "\n";
					  	 _localctx.code += ((InstructionContext)_localctx).instruction.code;
					  	 _localctx.code += ((InstructionContext)_localctx).condition.code ;
					  	 _localctx.code += "JUMPF " + label_fin_repeat + "\n";
					  	
				         sp--; 
					  	 _localctx.code += "JUMP " + label_repeat + "\n";
					  	 _localctx.code += "\n LABEL " + label_fin_repeat + "\n";
					  
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(175);
				match(T__8);
				setState(176);
				((InstructionContext)_localctx).bloc = bloc();
				setState(177);
				match(T__9);
				setState(178);
				match(T__2);
				setState(179);
				((InstructionContext)_localctx).condition = condition(0);
				setState(180);
				match(T__3);

					  	 ((InstructionContext)_localctx).code =  "";
					  	 
					  	 int label_repeat  = nextLabel();
					  	 int label_fin_repeat  = nextLabel();
					  	 
					  	 _localctx.code += "\n LABEL " + label_repeat + "\n";
					  	 _localctx.code += ((InstructionContext)_localctx).bloc.code;
					  	 _localctx.code += ((InstructionContext)_localctx).condition.code ;
					  	 _localctx.code += "JUMPF " + label_fin_repeat + "\n";
					  	 
				         sp--; 
					  	 _localctx.code += "JUMP " + label_repeat + "\n";
					  	 _localctx.code += "\n LABEL " + label_fin_repeat + "\n";
					  
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(183);
				finInstruction();

				            ((InstructionContext)_localctx).code =  "\n";
				        
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

	public static class EntrSortiContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public EntrSortiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entrSorti; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterEntrSorti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitEntrSorti(this);
		}
	}

	public final EntrSortiContext entrSorti() throws RecognitionException {
		EntrSortiContext _localctx = new EntrSortiContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entrSorti);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(T__10);
				setState(189);
				((EntrSortiContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(190);
				match(T__3);
				    		
							AdresseType at = tablesSymboles.getAdresseType((((EntrSortiContext)_localctx).IDENTIFIANT!=null?((EntrSortiContext)_localctx).IDENTIFIANT.getText():null));
							
							 
							if( at.type.equals("int")){
								
								((EntrSortiContext)_localctx).code =  "READ \n" +  "STOREG " + at.adresse +"\n";
							
							}else if( at.type.equals("float") ){
						
								((EntrSortiContext)_localctx).code =  "READF \n" +  "STOREG " + at.adresse + "\n";
							
							}else {
								
								System.err.println("Erreur type non reconnue");
							}
				        
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(T__11);
				setState(193);
				((EntrSortiContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(194);
				match(T__3);

							AdresseType at = tablesSymboles.getAdresseType((((EntrSortiContext)_localctx).IDENTIFIANT!=null?((EntrSortiContext)_localctx).IDENTIFIANT.getText():null));
							if( at.type.equals("int")){
								
								((EntrSortiContext)_localctx).code =  "PUSHG " + at.adresse + "\n" + "WRITE\n";		
								
							}else if( at.type.equals("float") ){
						
								((EntrSortiContext)_localctx).code =  "PUSHG " + at.adresse + "\n" + "WRITEF\n";	
							
							}else {
								
								System.err.println("Erreur type non reconnue");
							}
				        
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

	public static class ExprContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExprContext a;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public ExprContext b;
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(199);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				 ((ExprContext)_localctx).code =  "PUSHI " + (((ExprContext)_localctx).ENTIER!=null?Integer.valueOf(((ExprContext)_localctx).ENTIER.getText()):0)  + "\n"; 
				}
				break;
			case 2:
				{
				setState(201);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				    					
				    					
									 AdresseType at = tablesSymboles.getAdresseType((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null));
									 if( at.paramFonc == 1 ){
									 	
									 	 ((ExprContext)_localctx).code =  "PUSHL " + at.adresse + "\n";
									 	
									 } 
									 else{
									 	((ExprContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
									 }
				    					
				    				
				}
				break;
			case 3:
				{
				setState(203);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(204);
				match(T__2);
				setState(205);
				((ExprContext)_localctx).args = args();
				setState(206);
				match(T__3);
				  
				       		
				       		
				       		//a finir*****
				       		// on reserve de la place pour la valeur de retour 
				    	   	// ÇA DEPEND DE TYPE 
				       		((ExprContext)_localctx).code =  "";
				       		 
				       		AdresseType at = tablesSymboles.getFonction((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null) );
				       		//((ExprContext)_localctx).type =  at.type; je ne sais pas si je le fais ou pas 
				       		
				       		if( at.type.equals("int") ){
				            
					            ((ExprContext)_localctx).code =  "PUSHI 0\n";
								sp++;
								
							}else if( at.type.equals("float") ){
								
					            ((ExprContext)_localctx).code =  "PUSHF 0.0\n";
								
							}else {
								
								System.err.println("Erreur type non reconnue"); 	
							} 
				                 	
				   			// empiler les args
				   			_localctx.code += ((ExprContext)_localctx).args.code ; 
				   		
				   			_localctx.code += "CALL " + at.adresse + "\n" ;
				   			
				   			for( int i = 0; i < ((ExprContext)_localctx).args.size ; i++){		
				   				_localctx.code += "POP \n";
				   				
				   			}
				        
				        
				}
				break;
			case 4:
				{
				setState(209);
				match(T__2);
				setState(210);
				expr(0);
				setState(211);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(235);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(216);
						match(T__12);
						setState(217);
						((ExprContext)_localctx).b = expr(9);
						 ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code  + "\n" + ((ExprContext)_localctx).b.code  + "MUL" + "\n"; sp--;
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(221);
						match(T__13);
						setState(222);
						((ExprContext)_localctx).b = expr(8);
						 ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code  + "\n" + ((ExprContext)_localctx).b.code  + "DIV" + "\n"; sp--;
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(226);
						match(T__14);
						setState(227);
						((ExprContext)_localctx).b = expr(7);
						 ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code  + "\n" + ((ExprContext)_localctx).b.code  + "ADD" + "\n"; sp--; 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(231);
						match(T__15);
						setState(232);
						((ExprContext)_localctx).b = expr(6);
						 ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code  + "\n" + ((ExprContext)_localctx).b.code  + "SUB" + "\n"; sp--; 
						}
						break;
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ExprFloatContext extends ParserRuleContext {
		public String code;
		public ExprFloatContext a;
		public Token REELLE;
		public Token IDENTIFIANT;
		public ExprFloatContext b;
		public TerminalNode REELLE() { return getToken(CalculetteParser.REELLE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public List<ExprFloatContext> exprFloat() {
			return getRuleContexts(ExprFloatContext.class);
		}
		public ExprFloatContext exprFloat(int i) {
			return getRuleContext(ExprFloatContext.class,i);
		}
		public ExprFloatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprFloat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExprFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExprFloat(this);
		}
	}

	public final ExprFloatContext exprFloat() throws RecognitionException {
		return exprFloat(0);
	}

	private ExprFloatContext exprFloat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprFloatContext _localctx = new ExprFloatContext(_ctx, _parentState);
		ExprFloatContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exprFloat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REELLE:
				{
				setState(241);
				((ExprFloatContext)_localctx).REELLE = match(REELLE);
				 ((ExprFloatContext)_localctx).code =  "PUSHF " + (((ExprFloatContext)_localctx).REELLE!=null?((ExprFloatContext)_localctx).REELLE.getText():null)  + "\n"; 
				}
				break;
			case IDENTIFIANT:
				{
				setState(243);
				((ExprFloatContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
										AdresseType at = tablesSymboles.getAdresseType((((ExprFloatContext)_localctx).IDENTIFIANT!=null?((ExprFloatContext)_localctx).IDENTIFIANT.getText():null));
										((ExprFloatContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
				    					sp++; 
				    				
				}
				break;
			case T__2:
				{
				setState(245);
				match(T__2);
				setState(246);
				exprFloat(0);
				setState(247);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(271);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprFloatContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprFloat);
						setState(251);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(252);
						match(T__12);
						setState(253);
						((ExprFloatContext)_localctx).b = exprFloat(8);
						 ((ExprFloatContext)_localctx).code =  ((ExprFloatContext)_localctx).a.code  + "\n" + ((ExprFloatContext)_localctx).b.code  + "FMUL" + "\n"; sp--; sp--;
						}
						break;
					case 2:
						{
						_localctx = new ExprFloatContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprFloat);
						setState(256);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(257);
						match(T__13);
						setState(258);
						((ExprFloatContext)_localctx).b = exprFloat(7);
						 ((ExprFloatContext)_localctx).code =  ((ExprFloatContext)_localctx).a.code  + "\n" + ((ExprFloatContext)_localctx).b.code  + "FDIV" + "\n"; sp--; sp--; 
						}
						break;
					case 3:
						{
						_localctx = new ExprFloatContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprFloat);
						setState(261);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(262);
						match(T__14);
						setState(263);
						((ExprFloatContext)_localctx).b = exprFloat(6);
						 ((ExprFloatContext)_localctx).code =  ((ExprFloatContext)_localctx).a.code  + "\n" + ((ExprFloatContext)_localctx).b.code  + "FADD" + "\n"; sp--; sp--; 
						}
						break;
					case 4:
						{
						_localctx = new ExprFloatContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exprFloat);
						setState(266);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(267);
						match(T__15);
						setState(268);
						((ExprFloatContext)_localctx).b = exprFloat(5);
						 ((ExprFloatContext)_localctx).code =  ((ExprFloatContext)_localctx).a.code  + "\n" + ((ExprFloatContext)_localctx).b.code  + "FSUB" + "\n"; sp--; sp--; 
						}
						break;
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class ExprBooleanContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token BOOLEAN;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode BOOLEAN() { return getToken(CalculetteParser.BOOLEAN, 0); }
		public ExprBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExprBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExprBoolean(this);
		}
	}

	public final ExprBooleanContext exprBoolean() throws RecognitionException {
		ExprBooleanContext _localctx = new ExprBooleanContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprBoolean);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				((ExprBooleanContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 					
								
								AdresseType at = tablesSymboles.getAdresseType((((ExprBooleanContext)_localctx).IDENTIFIANT!=null?((ExprBooleanContext)_localctx).IDENTIFIANT.getText():null));
								
								if( at.type.equals("bool")){
									
												
									 if( at.paramFonc == 1 ){
									 	
									 	 ((ExprBooleanContext)_localctx).code =  "PUSHL " + at.adresse + "\n";
									 	
									 } 
									 else{
									 	((ExprBooleanContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
									 } 
									
								}else{
									System.out.println("erreur de type ce n est pas un boolean'");	
								}
					
				    					
				    		 
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				((ExprBooleanContext)_localctx).BOOLEAN = match(BOOLEAN);

				    	
				    	((ExprBooleanContext)_localctx).code =  "PUSHI " + (((ExprBooleanContext)_localctx).BOOLEAN!=null?((ExprBooleanContext)_localctx).BOOLEAN.getText():null)  + "\n";
				    
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public ExprFloatContext exprFloat;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprFloatContext exprFloat() {
			return getRuleContext(ExprFloatContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignation);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(283);
				match(T__0);
				setState(284);
				((AssignationContext)_localctx).expr = expr(0);
				  		
				     	  	AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        	if( at.type.equals("int") ){
				     
				        	// je dois voir aussi si le type match ou pas
				        	// sinon erreur ???        	
				        	((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expr.code +  "STOREG " + at.adresse + "\n";
				        	sp--; 
				        	
				        	}else{
				        		
				        		System.err.println("Erreur de type ");
				        		System.exit(0);
				        		
				        	}
				        	
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(288);
				match(T__0);
				setState(289);
				((AssignationContext)_localctx).exprFloat = exprFloat(0);
				  		
				        	AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				        	if( at.type.equals("float") ){
				        
				        	((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).exprFloat.code +  "STOREG " + at.adresse + "\n";
				        	sp--; 
				        	}else{
				        		
				        		System.err.println("Erreur de type ");
				        		System.exit(0);	
				        	}	
				        
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bloc);
		 	((BlocContext)_localctx).code =  "";  

				TableSymboles _tableLocale =  tablesSymboles.newTableLocale();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__16);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ENTIER) | (1L << REELLE) | (1L << TYPE) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(295);
				((BlocContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlocContext)_localctx).instruction.code; 
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			match(T__17);
			 
			        	System.out.println( _tableLocale.toString() );
			        	tablesSymboles.dropTableLocale() ;
			        	System.out.println( _tableLocale.toString() );
			        
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

	public static class BlocFonctionContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public ExprContext expr;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlocFonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocFonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBlocFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBlocFonction(this);
		}
	}

	public final BlocFonctionContext blocFonction() throws RecognitionException {
		BlocFonctionContext _localctx = new BlocFonctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blocFonction);
		 	

			((BlocFonctionContext)_localctx).code =  ""; 
			
			TableSymboles _tableLocale =  tablesSymboles.newTableLocale();


		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(T__16);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ENTIER) | (1L << REELLE) | (1L << TYPE) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(307);
				((BlocFonctionContext)_localctx).instruction = instruction();
				 _localctx.code += ((BlocFonctionContext)_localctx).instruction.code;  
				}
				}
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(315);
				match(T__18);
				setState(316);
				((BlocFonctionContext)_localctx).expr = expr(0);
				setState(317);
				match(T__7);
				}
			}

					
			    			
			    			
			    			_localctx.code += ((BlocFonctionContext)_localctx).expr.code ;
				    		_localctx.code += "STOREL " +   (-3 - tablesSymboles.nbVarFonction() ) + "\n" ;  // pas fini 
				       		_localctx.code += "RETURN\n";
				       	
			    		
			setState(322);
			match(T__17);
			 
			        		
			       		
			        	System.out.println( _tableLocale.toString() );
			        	tablesSymboles.dropTableLocale() ;
			        	System.out.println( _tableLocale.toString() );
			       
			         
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

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext c1;
		public ExprContext a;
		public ExprContext b;
		public ExprBooleanContext exprBoolean;
		public ConditionContext condition;
		public ExprFloatContext a1;
		public ExprFloatContext b1;
		public ConditionContext c2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBooleanContext exprBoolean() {
			return getRuleContext(ExprBooleanContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<ExprFloatContext> exprFloat() {
			return getRuleContexts(ExprFloatContext.class);
		}
		public ExprFloatContext exprFloat(int i) {
			return getRuleContext(ExprFloatContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(326);
				((ConditionContext)_localctx).a = expr(0);
				setState(327);
				match(T__19);
				setState(328);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "INF\n";sp--; 
				}
				break;
			case 2:
				{
				setState(331);
				((ConditionContext)_localctx).a = expr(0);
				setState(332);
				match(T__20);
				setState(333);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "SUP\n"; sp--; 
				}
				break;
			case 3:
				{
				setState(336);
				((ConditionContext)_localctx).a = expr(0);
				setState(337);
				match(T__21);
				setState(338);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "INFEQ\n"; sp--; 
				}
				break;
			case 4:
				{
				setState(341);
				((ConditionContext)_localctx).a = expr(0);
				setState(342);
				match(T__22);
				setState(343);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "SUPEQ\n"; sp--; 
				}
				break;
			case 5:
				{
				setState(346);
				((ConditionContext)_localctx).a = expr(0);
				setState(347);
				match(T__23);
				setState(348);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "EQUAL\n"; sp--; 
				}
				break;
			case 6:
				{
				setState(351);
				((ConditionContext)_localctx).a = expr(0);
				setState(352);
				match(T__24);
				setState(353);
				((ConditionContext)_localctx).b = expr(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + "NEQ\n"; sp--; 
				}
				break;
			case 7:
				{
				setState(356);
				((ConditionContext)_localctx).exprBoolean = exprBoolean();
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).exprBoolean.code ;
				}
				break;
			case 8:
				{
				setState(359);
				match(T__27);
				setState(360);
				match(T__2);
				setState(361);
				((ConditionContext)_localctx).condition = condition(0);
				setState(362);
				match(T__3);

				  	  	((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + "PUSHI 1\n" + "SUB\n" + "PUSHI -1\n" + "MUL\n";      	
				      
				}
				break;
			case 9:
				{
				setState(365);
				match(T__2);
				setState(366);
				((ConditionContext)_localctx).condition = condition(0);
				setState(367);
				match(T__3);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code ; 
				}
				break;
			case 10:
				{
				setState(370);
				match(T__28);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n"; sp++; 
				}
				break;
			case 11:
				{
				setState(372);
				match(T__29);
				 ((ConditionContext)_localctx).code =  "PUSHI 0\n"; sp++; 
				}
				break;
			case 12:
				{
				setState(374);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(375);
				match(T__19);
				setState(376);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FINF\n"; sp--; sp--; 
				}
				break;
			case 13:
				{
				setState(379);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(380);
				match(T__20);
				setState(381);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FSUP\n"; sp--; sp--; 
				}
				break;
			case 14:
				{
				setState(384);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(385);
				match(T__21);
				setState(386);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FINFEQ\n"; sp--; sp--; 
				}
				break;
			case 15:
				{
				setState(389);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(390);
				match(T__22);
				setState(391);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FSUPEQ\n"; sp--; sp--; 
				}
				break;
			case 16:
				{
				setState(394);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(395);
				match(T__23);
				setState(396);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FEQUAL\n"; sp--; sp--; 
				}
				break;
			case 17:
				{
				setState(399);
				((ConditionContext)_localctx).a1 = exprFloat(0);
				setState(400);
				match(T__24);
				setState(401);
				((ConditionContext)_localctx).b1 = exprFloat(0);
				 ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a1.code + ((ConditionContext)_localctx).b1.code + "FNEQ\n"; sp--; sp--; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(416);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(406);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(407);
						match(T__25);
						setState(408);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(13);

						            	  	((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "MUL\n" + "PUSHI 0\n" + "SUP\n" ;
						                
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(411);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(412);
						match(T__26);
						setState(413);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(12);

						            	  	System.out.println("sara");
						            	  	((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "ADD\n" + "PUSHI 0\n" + "SUP\n" ;
						                
						}
						break;
					}
					} 
				}
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public BlocFonctionContext blocFonction;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public BlocFonctionContext blocFonction() {
			return getRuleContext(BlocFonctionContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fonction);
		 


			  
		//	  TableSymboles _tableLocaleFonction =  tablesSymboles.newTableLocaleFonction();
			  // je peux ici saufgarder quel fonction on est en traine de trvailler

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			((FonctionContext)_localctx).TYPE = match(TYPE);
			setState(422);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 
			     		// code java gérer la déclaration de "la variable" de retour de la fonction
			            int labelDebut = nextLabel();
			            ((FonctionContext)_localctx).code =  "";
			            _localctx.code += "\n LABEL " + labelDebut + "\n";        
			      		tablesSymboles.nouvelleFonction( (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), labelDebut , (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));      		 
			        	// je saufgarde ici dans quelle fonction on travaille
			       		TableSymboles _tableLocaleFonction =  tablesSymboles.newTableLocaleFonction();
			        
			setState(424);
			match(T__2);
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(425);
				params();
				}
			}

			setState(428);
			match(T__3);
			setState(429);
			((FonctionContext)_localctx).blocFonction = blocFonction();

			            
			            // corps de la fonction
			            _localctx.code += ((FonctionContext)_localctx).blocFonction.code; 
			             
			        	
			            tablesSymboles.dropTableFonction() ;
			        
			}
			_ctx.stop = _input.LT(-1);
			 


				
				
			    


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

	public static class ParamsContext extends ParserRuleContext {
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(433);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			 
			            
			            // code java gérant  une variable locale (argi)
			      		if( (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null).equals("int") ){
							
							 
							 
							
							tablesSymboles.putVarFonction((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
							//******************* joutee */
							//tablesSymboles.ajouteNBVariable();
							
							
						}else if( (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null).equals("float") ){
							
							tablesSymboles.putVarFonction((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
							// probleme : quand la variable existe on va comme meme afficher pushi 0
				          	//tablesSymboles.ajouteNBVariable();
				           
						}else {
							
							System.err.println("Erreur type non reconnue"); 
							
						}
			      
			      
			        
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(435);
				match(T__30);
				setState(436);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(437);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				 
				           
					            // code java gérant  une variable locale (argi)
					      		if( (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null).equals("int") ){
									
									tablesSymboles.putVarFonction((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
									//******************* joutee */
									//tablesSymboles.ajouteNBVariable();
									
									// probleme : quand la variable existe on va comme meme afficher pushi 0
						           
									
								}else if( (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null).equals("float") ){
									
									tablesSymboles.putVarFonction((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
									// probleme : quand la variable existe on va comme meme afficher pushi 0
						           //tablesSymboles.ajouteNBVariable();
						           
								}else {
									
									System.err.println("Erreur type non reconnue"); 
									
								}
					            
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 
			    	 
			    		
			    		// METTRE À JOUR LES ADRESSE
			    		
			    		tablesSymboles.majVarFonc() ;
			   
			    	
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(446);
				((ArgsContext)_localctx).expr = expr(0);
				 
				        // code java pour première expression pour arg1
				    	((ArgsContext)_localctx).code =  ((ArgsContext)_localctx).expr.code;
				    	_localctx.size++; 
				    	
				    
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__30) {
					{
					{
					setState(448);
					match(T__30);
					setState(449);
					((ArgsContext)_localctx).expr = expr(0);
					 
					        // code java pour expression suivante pour argi
					   		_localctx.code += ((ArgsContext)_localctx).expr.code ;
					  		_localctx.size++;
					    
					}
					}
					setState(456);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FinInstructionContext extends ParserRuleContext {
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_finInstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(T__7);
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
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 6:
			return exprFloat_sempred((ExprFloatContext)_localctx, predIndex);
		case 11:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean exprFloat_sempred(ExprFloatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 12);
		case 9:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u01d0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\7\3>\n\3\f\3\16\3A\13\3"+
		"\3\3\3\3\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0090\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5\u00bd\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c7\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d8\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00ee\n\7\f\7\16\7\u00f1\13\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00fc\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0112\n\b\f\b\16\b\u0115\13\b"+
		"\3\t\3\t\3\t\3\t\5\t\u011b\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0127\n\n\3\13\3\13\3\13\3\13\7\13\u012d\n\13\f\13\16\13\u0130\13"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0139\n\f\f\f\16\f\u013c\13\f\3"+
		"\f\3\f\3\f\3\f\5\f\u0142\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0197\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u01a3"+
		"\n\r\f\r\16\r\u01a6\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u01ad\n\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01ba\n\17\f\17"+
		"\16\17\u01bd\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u01c7"+
		"\n\20\f\20\16\20\u01ca\13\20\5\20\u01cc\n\20\3\21\3\21\3\21\2\5\f\16\30"+
		"\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u01fc\2\"\3\2\2\2\4"+
		"*\3\2\2\2\6M\3\2\2\2\b\u00bc\3\2\2\2\n\u00c6\3\2\2\2\f\u00d7\3\2\2\2\16"+
		"\u00fb\3\2\2\2\20\u011a\3\2\2\2\22\u0126\3\2\2\2\24\u0128\3\2\2\2\26\u0134"+
		"\3\2\2\2\30\u0196\3\2\2\2\32\u01a7\3\2\2\2\34\u01b2\3\2\2\2\36\u01cb\3"+
		"\2\2\2 \u01cd\3\2\2\2\"#\5\4\3\2#$\7\2\2\3$\3\3\2\2\2%&\5\6\4\2&\'\b\3"+
		"\1\2\')\3\2\2\2(%\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3"+
		"\2\2\2-\61\b\3\1\2.\60\7\"\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\629\3\2\2\2\63\61\3\2\2\2\64\65\5\32\16\2\65\66\b\3\1\2\66"+
		"8\3\2\2\2\67\64\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:?\3\2\2\2;9\3"+
		"\2\2\2<>\7\"\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3"+
		"\2\2\2BH\b\3\1\2CD\5\b\5\2DE\b\3\1\2EG\3\2\2\2FC\3\2\2\2GJ\3\2\2\2HF\3"+
		"\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\b\3\1\2L\5\3\2\2\2MN\7\'\2\2NO"+
		"\7)\2\2OP\5 \21\2PQ\b\4\1\2Q\7\3\2\2\2RS\5\f\7\2ST\5 \21\2TU\b\5\1\2U"+
		"\u00bd\3\2\2\2VW\5\16\b\2WX\5 \21\2XY\b\5\1\2Y\u00bd\3\2\2\2Z[\5\22\n"+
		"\2[\\\5 \21\2\\]\b\5\1\2]\u00bd\3\2\2\2^_\5\n\6\2_`\5 \21\2`a\b\5\1\2"+
		"a\u00bd\3\2\2\2bc\7\'\2\2cd\7)\2\2de\7\3\2\2ef\7$\2\2fg\5 \21\2gh\b\5"+
		"\1\2h\u00bd\3\2\2\2ij\7\'\2\2jk\7)\2\2kl\7\3\2\2lm\5\f\7\2mn\5 \21\2n"+
		"o\b\5\1\2o\u00bd\3\2\2\2pq\7\'\2\2qr\7)\2\2rs\7\3\2\2st\5\16\b\2tu\5 "+
		"\21\2uv\b\5\1\2v\u00bd\3\2\2\2wx\7\4\2\2xy\7\5\2\2yz\5\30\r\2z{\7\6\2"+
		"\2{|\5\b\5\2|}\b\5\1\2}\u00bd\3\2\2\2~\177\7\4\2\2\177\u0080\7\5\2\2\u0080"+
		"\u0081\5\30\r\2\u0081\u0082\7\6\2\2\u0082\u0083\5\24\13\2\u0083\u0084"+
		"\b\5\1\2\u0084\u00bd\3\2\2\2\u0085\u0086\7\7\2\2\u0086\u0087\7\5\2\2\u0087"+
		"\u0088\5\30\r\2\u0088\u0089\7\6\2\2\u0089\u008a\5\24\13\2\u008a\u008f"+
		"\b\5\1\2\u008b\u008c\7\b\2\2\u008c\u008d\5\24\13\2\u008d\u008e\b\5\1\2"+
		"\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0092\b\5\1\2\u0092\u00bd\3\2\2\2\u0093\u0094\7\t\2\2\u0094"+
		"\u0095\7\5\2\2\u0095\u0096\5\22\n\2\u0096\u0097\7\n\2\2\u0097\u0098\5"+
		"\30\r\2\u0098\u0099\7\n\2\2\u0099\u009a\5\22\n\2\u009a\u009b\7\6\2\2\u009b"+
		"\u009c\5\b\5\2\u009c\u009d\b\5\1\2\u009d\u00bd\3\2\2\2\u009e\u009f\7\t"+
		"\2\2\u009f\u00a0\7\5\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\7\n\2\2\u00a2"+
		"\u00a3\5\30\r\2\u00a3\u00a4\7\n\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\7"+
		"\6\2\2\u00a6\u00a7\5\24\13\2\u00a7\u00a8\b\5\1\2\u00a8\u00bd\3\2\2\2\u00a9"+
		"\u00aa\7\13\2\2\u00aa\u00ab\5\b\5\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\7"+
		"\5\2\2\u00ad\u00ae\5\30\r\2\u00ae\u00af\7\6\2\2\u00af\u00b0\b\5\1\2\u00b0"+
		"\u00bd\3\2\2\2\u00b1\u00b2\7\13\2\2\u00b2\u00b3\5\24\13\2\u00b3\u00b4"+
		"\7\f\2\2\u00b4\u00b5\7\5\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7\6\2\2"+
		"\u00b7\u00b8\b\5\1\2\u00b8\u00bd\3\2\2\2\u00b9\u00ba\5 \21\2\u00ba\u00bb"+
		"\b\5\1\2\u00bb\u00bd\3\2\2\2\u00bcR\3\2\2\2\u00bcV\3\2\2\2\u00bcZ\3\2"+
		"\2\2\u00bc^\3\2\2\2\u00bcb\3\2\2\2\u00bci\3\2\2\2\u00bcp\3\2\2\2\u00bc"+
		"w\3\2\2\2\u00bc~\3\2\2\2\u00bc\u0085\3\2\2\2\u00bc\u0093\3\2\2\2\u00bc"+
		"\u009e\3\2\2\2\u00bc\u00a9\3\2\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00b9\3\2"+
		"\2\2\u00bd\t\3\2\2\2\u00be\u00bf\7\r\2\2\u00bf\u00c0\7)\2\2\u00c0\u00c1"+
		"\7\6\2\2\u00c1\u00c7\b\6\1\2\u00c2\u00c3\7\16\2\2\u00c3\u00c4\7)\2\2\u00c4"+
		"\u00c5\7\6\2\2\u00c5\u00c7\b\6\1\2\u00c6\u00be\3\2\2\2\u00c6\u00c2\3\2"+
		"\2\2\u00c7\13\3\2\2\2\u00c8\u00c9\b\7\1\2\u00c9\u00ca\7%\2\2\u00ca\u00d8"+
		"\b\7\1\2\u00cb\u00cc\7)\2\2\u00cc\u00d8\b\7\1\2\u00cd\u00ce\7)\2\2\u00ce"+
		"\u00cf\7\5\2\2\u00cf\u00d0\5\36\20\2\u00d0\u00d1\7\6\2\2\u00d1\u00d2\b"+
		"\7\1\2\u00d2\u00d8\3\2\2\2\u00d3\u00d4\7\5\2\2\u00d4\u00d5\5\f\7\2\u00d5"+
		"\u00d6\7\6\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00c8\3\2\2\2\u00d7\u00cb\3\2"+
		"\2\2\u00d7\u00cd\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\u00ef\3\2\2\2\u00d9"+
		"\u00da\f\n\2\2\u00da\u00db\7\17\2\2\u00db\u00dc\5\f\7\13\u00dc\u00dd\b"+
		"\7\1\2\u00dd\u00ee\3\2\2\2\u00de\u00df\f\t\2\2\u00df\u00e0\7\20\2\2\u00e0"+
		"\u00e1\5\f\7\n\u00e1\u00e2\b\7\1\2\u00e2\u00ee\3\2\2\2\u00e3\u00e4\f\b"+
		"\2\2\u00e4\u00e5\7\21\2\2\u00e5\u00e6\5\f\7\t\u00e6\u00e7\b\7\1\2\u00e7"+
		"\u00ee\3\2\2\2\u00e8\u00e9\f\7\2\2\u00e9\u00ea\7\22\2\2\u00ea\u00eb\5"+
		"\f\7\b\u00eb\u00ec\b\7\1\2\u00ec\u00ee\3\2\2\2\u00ed\u00d9\3\2\2\2\u00ed"+
		"\u00de\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ee\u00f1\3\2"+
		"\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\r\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f2\u00f3\b\b\1\2\u00f3\u00f4\7&\2\2\u00f4\u00fc\b\b\1\2\u00f5"+
		"\u00f6\7)\2\2\u00f6\u00fc\b\b\1\2\u00f7\u00f8\7\5\2\2\u00f8\u00f9\5\16"+
		"\b\2\u00f9\u00fa\7\6\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fb"+
		"\u00f5\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fc\u0113\3\2\2\2\u00fd\u00fe\f\t"+
		"\2\2\u00fe\u00ff\7\17\2\2\u00ff\u0100\5\16\b\n\u0100\u0101\b\b\1\2\u0101"+
		"\u0112\3\2\2\2\u0102\u0103\f\b\2\2\u0103\u0104\7\20\2\2\u0104\u0105\5"+
		"\16\b\t\u0105\u0106\b\b\1\2\u0106\u0112\3\2\2\2\u0107\u0108\f\7\2\2\u0108"+
		"\u0109\7\21\2\2\u0109\u010a\5\16\b\b\u010a\u010b\b\b\1\2\u010b\u0112\3"+
		"\2\2\2\u010c\u010d\f\6\2\2\u010d\u010e\7\22\2\2\u010e\u010f\5\16\b\7\u010f"+
		"\u0110\b\b\1\2\u0110\u0112\3\2\2\2\u0111\u00fd\3\2\2\2\u0111\u0102\3\2"+
		"\2\2\u0111\u0107\3\2\2\2\u0111\u010c\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\17\3\2\2\2\u0115\u0113\3\2\2"+
		"\2\u0116\u0117\7)\2\2\u0117\u011b\b\t\1\2\u0118\u0119\7$\2\2\u0119\u011b"+
		"\b\t\1\2\u011a\u0116\3\2\2\2\u011a\u0118\3\2\2\2\u011b\21\3\2\2\2\u011c"+
		"\u011d\7)\2\2\u011d\u011e\7\3\2\2\u011e\u011f\5\f\7\2\u011f\u0120\b\n"+
		"\1\2\u0120\u0127\3\2\2\2\u0121\u0122\7)\2\2\u0122\u0123\7\3\2\2\u0123"+
		"\u0124\5\16\b\2\u0124\u0125\b\n\1\2\u0125\u0127\3\2\2\2\u0126\u011c\3"+
		"\2\2\2\u0126\u0121\3\2\2\2\u0127\23\3\2\2\2\u0128\u012e\7\23\2\2\u0129"+
		"\u012a\5\b\5\2\u012a\u012b\b\13\1\2\u012b\u012d\3\2\2\2\u012c\u0129\3"+
		"\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7\24\2\2\u0132\u0133\b"+
		"\13\1\2\u0133\25\3\2\2\2\u0134\u013a\7\23\2\2\u0135\u0136\5\b\5\2\u0136"+
		"\u0137\b\f\1\2\u0137\u0139\3\2\2\2\u0138\u0135\3\2\2\2\u0139\u013c\3\2"+
		"\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0141\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u013e\7\25\2\2\u013e\u013f\5\f\7\2\u013f\u0140\7"+
		"\n\2\2\u0140\u0142\3\2\2\2\u0141\u013d\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\b\f\1\2\u0144\u0145\7\24\2\2\u0145\u0146\b"+
		"\f\1\2\u0146\27\3\2\2\2\u0147\u0148\b\r\1\2\u0148\u0149\5\f\7\2\u0149"+
		"\u014a\7\26\2\2\u014a\u014b\5\f\7\2\u014b\u014c\b\r\1\2\u014c\u0197\3"+
		"\2\2\2\u014d\u014e\5\f\7\2\u014e\u014f\7\27\2\2\u014f\u0150\5\f\7\2\u0150"+
		"\u0151\b\r\1\2\u0151\u0197\3\2\2\2\u0152\u0153\5\f\7\2\u0153\u0154\7\30"+
		"\2\2\u0154\u0155\5\f\7\2\u0155\u0156\b\r\1\2\u0156\u0197\3\2\2\2\u0157"+
		"\u0158\5\f\7\2\u0158\u0159\7\31\2\2\u0159\u015a\5\f\7\2\u015a\u015b\b"+
		"\r\1\2\u015b\u0197\3\2\2\2\u015c\u015d\5\f\7\2\u015d\u015e\7\32\2\2\u015e"+
		"\u015f\5\f\7\2\u015f\u0160\b\r\1\2\u0160\u0197\3\2\2\2\u0161\u0162\5\f"+
		"\7\2\u0162\u0163\7\33\2\2\u0163\u0164\5\f\7\2\u0164\u0165\b\r\1\2\u0165"+
		"\u0197\3\2\2\2\u0166\u0167\5\20\t\2\u0167\u0168\b\r\1\2\u0168\u0197\3"+
		"\2\2\2\u0169\u016a\7\36\2\2\u016a\u016b\7\5\2\2\u016b\u016c\5\30\r\2\u016c"+
		"\u016d\7\6\2\2\u016d\u016e\b\r\1\2\u016e\u0197\3\2\2\2\u016f\u0170\7\5"+
		"\2\2\u0170\u0171\5\30\r\2\u0171\u0172\7\6\2\2\u0172\u0173\b\r\1\2\u0173"+
		"\u0197\3\2\2\2\u0174\u0175\7\37\2\2\u0175\u0197\b\r\1\2\u0176\u0177\7"+
		" \2\2\u0177\u0197\b\r\1\2\u0178\u0179\5\16\b\2\u0179\u017a\7\26\2\2\u017a"+
		"\u017b\5\16\b\2\u017b\u017c\b\r\1\2\u017c\u0197\3\2\2\2\u017d\u017e\5"+
		"\16\b\2\u017e\u017f\7\27\2\2\u017f\u0180\5\16\b\2\u0180\u0181\b\r\1\2"+
		"\u0181\u0197\3\2\2\2\u0182\u0183\5\16\b\2\u0183\u0184\7\30\2\2\u0184\u0185"+
		"\5\16\b\2\u0185\u0186\b\r\1\2\u0186\u0197\3\2\2\2\u0187\u0188\5\16\b\2"+
		"\u0188\u0189\7\31\2\2\u0189\u018a\5\16\b\2\u018a\u018b\b\r\1\2\u018b\u0197"+
		"\3\2\2\2\u018c\u018d\5\16\b\2\u018d\u018e\7\32\2\2\u018e\u018f\5\16\b"+
		"\2\u018f\u0190\b\r\1\2\u0190\u0197\3\2\2\2\u0191\u0192\5\16\b\2\u0192"+
		"\u0193\7\33\2\2\u0193\u0194\5\16\b\2\u0194\u0195\b\r\1\2\u0195\u0197\3"+
		"\2\2\2\u0196\u0147\3\2\2\2\u0196\u014d\3\2\2\2\u0196\u0152\3\2\2\2\u0196"+
		"\u0157\3\2\2\2\u0196\u015c\3\2\2\2\u0196\u0161\3\2\2\2\u0196\u0166\3\2"+
		"\2\2\u0196\u0169\3\2\2\2\u0196\u016f\3\2\2\2\u0196\u0174\3\2\2\2\u0196"+
		"\u0176\3\2\2\2\u0196\u0178\3\2\2\2\u0196\u017d\3\2\2\2\u0196\u0182\3\2"+
		"\2\2\u0196\u0187\3\2\2\2\u0196\u018c\3\2\2\2\u0196\u0191\3\2\2\2\u0197"+
		"\u01a4\3\2\2\2\u0198\u0199\f\16\2\2\u0199\u019a\7\34\2\2\u019a\u019b\5"+
		"\30\r\17\u019b\u019c\b\r\1\2\u019c\u01a3\3\2\2\2\u019d\u019e\f\r\2\2\u019e"+
		"\u019f\7\35\2\2\u019f\u01a0\5\30\r\16\u01a0\u01a1\b\r\1\2\u01a1\u01a3"+
		"\3\2\2\2\u01a2\u0198\3\2\2\2\u01a2\u019d\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4"+
		"\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\31\3\2\2\2\u01a6\u01a4\3\2\2"+
		"\2\u01a7\u01a8\7\'\2\2\u01a8\u01a9\7)\2\2\u01a9\u01aa\b\16\1\2\u01aa\u01ac"+
		"\7\5\2\2\u01ab\u01ad\5\34\17\2\u01ac\u01ab\3\2\2\2\u01ac\u01ad\3\2\2\2"+
		"\u01ad\u01ae\3\2\2\2\u01ae\u01af\7\6\2\2\u01af\u01b0\5\26\f\2\u01b0\u01b1"+
		"\b\16\1\2\u01b1\33\3\2\2\2\u01b2\u01b3\7\'\2\2\u01b3\u01b4\7)\2\2\u01b4"+
		"\u01bb\b\17\1\2\u01b5\u01b6\7!\2\2\u01b6\u01b7\7\'\2\2\u01b7\u01b8\7)"+
		"\2\2\u01b8\u01ba\b\17\1\2\u01b9\u01b5\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bb\3\2"+
		"\2\2\u01be\u01bf\b\17\1\2\u01bf\35\3\2\2\2\u01c0\u01c1\5\f\7\2\u01c1\u01c8"+
		"\b\20\1\2\u01c2\u01c3\7!\2\2\u01c3\u01c4\5\f\7\2\u01c4\u01c5\b\20\1\2"+
		"\u01c5\u01c7\3\2\2\2\u01c6\u01c2\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6"+
		"\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u01c0\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\37\3\2\2\2\u01cd\u01ce\7\n\2"+
		"\2\u01ce!\3\2\2\2\34*\619?H\u008f\u00bc\u00c6\u00d7\u00ed\u00ef\u00fb"+
		"\u0111\u0113\u011a\u0126\u012e\u013a\u0141\u0196\u01a2\u01a4\u01ac\u01bb"+
		"\u01c8\u01cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}