// Generated from CGrammar.g4 by ANTLR 4.13.0
package com.compiler.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VOID=1, INT=2, CHAR=3, FLOAT=4, DOUBLE=5, RETURN=6, IF=7, ELSE=8, WHILE=9, 
		DO=10, FOR=11, SWITCH=12, CASE=13, DEFAULT=14, BREAK=15, CONTINUE=16, 
		PRINTF=17, SCANF=18, SIZEOF=19, IDENTIFIER=20, NUMBER=21, CHAR_LITERAL=22, 
		FLOAT_LITERAL=23, STRING_LITERAL=24, PLUS=25, MINUS=26, MUL=27, DIV=28, 
		MOD=29, INCREMENT=30, DECREMENT=31, ASSIGN=32, PLUS_ASSIGN=33, MINUS_ASSIGN=34, 
		MUL_ASSIGN=35, DIV_ASSIGN=36, MOD_ASSIGN=37, AND=38, OR=39, LOGICAL_AND=40, 
		LOGICAL_OR=41, LOGICAL_NOT=42, LT=43, LE=44, GT=45, GE=46, EQ=47, NEQ=48, 
		SEMI=49, COLON=50, COMMA=51, LPAREN=52, RPAREN=53, LBRACE=54, RBRACE=55, 
		LBRACKET=56, RBRACKET=57, WS=58, COMMENT=59, BLOCK_COMMENT=60, DOC_COMMENT=61;
	public static final int
		RULE_type = 0, RULE_baseType = 1, RULE_program = 2, RULE_functionDecl = 3, 
		RULE_paramList = 4, RULE_param = 5, RULE_varDecl = 6, RULE_arrayInitializer = 7, 
		RULE_block = 8, RULE_statement = 9, RULE_exprStatement = 10, RULE_ifStatement = 11, 
		RULE_whileStatement = 12, RULE_doWhileStatement = 13, RULE_forStatement = 14, 
		RULE_returnStatement = 15, RULE_breakStatement = 16, RULE_continueStatement = 17, 
		RULE_switchStatement = 18, RULE_caseStatement = 19, RULE_defaultStatement = 20, 
		RULE_printfStatement = 21, RULE_scanfStatement = 22, RULE_expression = 23, 
		RULE_logicalOrExpression = 24, RULE_logicalAndExpression = 25, RULE_equalityExpression = 26, 
		RULE_relationalExpression = 27, RULE_additiveExpression = 28, RULE_multiplicativeExpression = 29, 
		RULE_prefixExpression = 30, RULE_postfixExpression = 31, RULE_expressionList = 32, 
		RULE_primaryExpression = 33, RULE_literal = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"type", "baseType", "program", "functionDecl", "paramList", "param", 
			"varDecl", "arrayInitializer", "block", "statement", "exprStatement", 
			"ifStatement", "whileStatement", "doWhileStatement", "forStatement", 
			"returnStatement", "breakStatement", "continueStatement", "switchStatement", 
			"caseStatement", "defaultStatement", "printfStatement", "scanfStatement", 
			"expression", "logicalOrExpression", "logicalAndExpression", "equalityExpression", 
			"relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"prefixExpression", "postfixExpression", "expressionList", "primaryExpression", 
			"literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'void'", "'int'", "'char'", "'float'", "'double'", "'return'", 
			"'if'", "'else'", "'while'", "'do'", "'for'", "'switch'", "'case'", "'default'", 
			"'break'", "'continue'", "'printf'", "'scanf'", "'sizeof'", null, null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", 
			"'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'&'", "'|'", "'&&'", 
			"'||'", "'!'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "';'", "':'", 
			"','", "'('", "')'", "'{'", "'}'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VOID", "INT", "CHAR", "FLOAT", "DOUBLE", "RETURN", "IF", "ELSE", 
			"WHILE", "DO", "FOR", "SWITCH", "CASE", "DEFAULT", "BREAK", "CONTINUE", 
			"PRINTF", "SCANF", "SIZEOF", "IDENTIFIER", "NUMBER", "CHAR_LITERAL", 
			"FLOAT_LITERAL", "STRING_LITERAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"INCREMENT", "DECREMENT", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "MUL_ASSIGN", 
			"DIV_ASSIGN", "MOD_ASSIGN", "AND", "OR", "LOGICAL_AND", "LOGICAL_OR", 
			"LOGICAL_NOT", "LT", "LE", "GT", "GE", "EQ", "NEQ", "SEMI", "COLON", 
			"COMMA", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"WS", "COMMENT", "BLOCK_COMMENT", "DOC_COMMENT"
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
	public String getGrammarFileName() { return "CGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(CGrammarParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(CGrammarParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(CGrammarParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(CGrammarParser.RBRACKET, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			baseType();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(71);
				match(LBRACKET);
				setState(72);
				match(RBRACKET);
				}
				}
				setState(77);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CGrammarParser.VOID, 0); }
		public TerminalNode INT() { return getToken(CGrammarParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(CGrammarParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(CGrammarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CGrammarParser.DOUBLE, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CGrammarParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(82);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(80);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(81);
					varDecl();
					}
					break;
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0) );
			setState(86);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CGrammarParser.VOID, 0); }
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			type();
			setState(89);
			match(IDENTIFIER);
			setState(90);
			match(LPAREN);
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(91);
				paramList();
				}
				break;
			case 2:
				{
				setState(92);
				match(VOID);
				}
				break;
			}
			setState(95);
			match(RPAREN);
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(96);
				block();
				}
				break;
			case SEMI:
				{
				setState(97);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(CGrammarParser.VOID, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CGrammarParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramList);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(VOID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(101);
				param();
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(102);
					match(COMMA);
					setState(103);
					param();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CGrammarParser.IDENTIFIER, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			type();
			setState(112);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(CGrammarParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public List<TerminalNode> LBRACKET() { return getTokens(CGrammarParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(CGrammarParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(CGrammarParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(CGrammarParser.RBRACKET, i);
		}
		public TerminalNode ASSIGN() { return getToken(CGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CGrammarParser.NUMBER, i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			type();
			setState(115);
			match(IDENTIFIER);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(116);
				match(LBRACKET);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(117);
					match(NUMBER);
					}
				}

				setState(120);
				match(RBRACKET);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(126);
				match(ASSIGN);
				setState(129);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SIZEOF:
				case IDENTIFIER:
				case NUMBER:
				case CHAR_LITERAL:
				case FLOAT_LITERAL:
				case STRING_LITERAL:
				case MUL:
				case INCREMENT:
				case DECREMENT:
				case AND:
				case LOGICAL_NOT:
				case LPAREN:
					{
					setState(127);
					expression();
					}
					break;
				case LBRACE:
					{
					setState(128);
					arrayInitializer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(133);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(CGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CGrammarParser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CGrammarParser.COMMA, i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(LBRACE);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4508275940261888L) != 0)) {
				{
				setState(136);
				expression();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					expression();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(CGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CGrammarParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(LBRACE);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22522674450243326L) != 0)) {
				{
				{
				setState(149);
				statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public PrintfStatementContext printfStatement() {
			return getRuleContext(PrintfStatementContext.class,0);
		}
		public ScanfStatementContext scanfStatement() {
			return getRuleContext(ScanfStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
			case CHAR:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				varDecl();
				}
				break;
			case SIZEOF:
			case IDENTIFIER:
			case NUMBER:
			case CHAR_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case MUL:
			case INCREMENT:
			case DECREMENT:
			case AND:
			case LOGICAL_NOT:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				exprStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				ifStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				whileStatement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				doWhileStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				forStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				returnStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				switchStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 9);
				{
				setState(165);
				breakStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 10);
				{
				setState(166);
				continueStatement();
				}
				break;
			case PRINTF:
				enterOuterAlt(_localctx, 11);
				{
				setState(167);
				printfStatement();
				}
				break;
			case SCANF:
				enterOuterAlt(_localctx, 12);
				{
				setState(168);
				scanfStatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 13);
				{
				setState(169);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			expression();
			setState(173);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CGrammarParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(IF);
			setState(176);
			match(LPAREN);
			setState(177);
			expression();
			setState(178);
			match(RPAREN);
			setState(179);
			statement();
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(180);
				match(ELSE);
				setState(181);
				statement();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CGrammarParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(WHILE);
			setState(185);
			match(LPAREN);
			setState(186);
			expression();
			setState(187);
			match(RPAREN);
			setState(188);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(CGrammarParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(CGrammarParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(DO);
			setState(191);
			statement();
			setState(192);
			match(WHILE);
			setState(193);
			match(LPAREN);
			setState(194);
			expression();
			setState(195);
			match(RPAREN);
			setState(196);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(CGrammarParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FOR);
			setState(199);
			match(LPAREN);
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
			case INT:
			case CHAR:
			case FLOAT:
			case DOUBLE:
				{
				setState(200);
				varDecl();
				}
				break;
			case SIZEOF:
			case IDENTIFIER:
			case NUMBER:
			case CHAR_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case MUL:
			case INCREMENT:
			case DECREMENT:
			case AND:
			case LOGICAL_NOT:
			case LPAREN:
				{
				setState(201);
				exprStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4508275940261888L) != 0)) {
				{
				setState(204);
				expression();
				}
			}

			setState(207);
			match(SEMI);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4508275940261888L) != 0)) {
				{
				setState(208);
				expression();
				}
			}

			setState(211);
			match(RPAREN);
			setState(212);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CGrammarParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(RETURN);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4508275940261888L) != 0)) {
				{
				setState(215);
				expression();
				}
			}

			setState(218);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(CGrammarParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(BREAK);
			setState(221);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(CGrammarParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(CONTINUE);
			setState(224);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(CGrammarParser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(CGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CGrammarParser.RBRACE, 0); }
		public List<CaseStatementContext> caseStatement() {
			return getRuleContexts(CaseStatementContext.class);
		}
		public CaseStatementContext caseStatement(int i) {
			return getRuleContext(CaseStatementContext.class,i);
		}
		public DefaultStatementContext defaultStatement() {
			return getRuleContext(DefaultStatementContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(SWITCH);
			setState(227);
			match(LPAREN);
			setState(228);
			expression();
			setState(229);
			match(RPAREN);
			setState(230);
			match(LBRACE);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(231);
				caseStatement();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(237);
				defaultStatement();
				}
			}

			setState(240);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaseStatementContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(CGrammarParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CGrammarParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitCaseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStatementContext caseStatement() throws RecognitionException {
		CaseStatementContext _localctx = new CaseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_caseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(CASE);
			setState(243);
			expression();
			setState(244);
			match(COLON);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22522674450243326L) != 0)) {
				{
				{
				setState(245);
				statement();
				}
				}
				setState(250);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultStatementContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(CGrammarParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(CGrammarParser.COLON, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitDefaultStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStatementContext defaultStatement() throws RecognitionException {
		DefaultStatementContext _localctx = new DefaultStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_defaultStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(DEFAULT);
			setState(252);
			match(COLON);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22522674450243326L) != 0)) {
				{
				{
				setState(253);
				statement();
				}
				}
				setState(258);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintfStatementContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(CGrammarParser.PRINTF, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CGrammarParser.STRING_LITERAL, 0); }
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CGrammarParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrintfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printfStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitPrintfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintfStatementContext printfStatement() throws RecognitionException {
		PrintfStatementContext _localctx = new PrintfStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_printfStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(PRINTF);
			setState(260);
			match(LPAREN);
			setState(261);
			match(STRING_LITERAL);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(262);
				match(COMMA);
				setState(263);
				expression();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			match(RPAREN);
			setState(270);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScanfStatementContext extends ParserRuleContext {
		public TerminalNode SCANF() { return getToken(CGrammarParser.SCANF, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CGrammarParser.STRING_LITERAL, 0); }
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(CGrammarParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CGrammarParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ScanfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanfStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitScanfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanfStatementContext scanfStatement() throws RecognitionException {
		ScanfStatementContext _localctx = new ScanfStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_scanfStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(SCANF);
			setState(273);
			match(LPAREN);
			setState(274);
			match(STRING_LITERAL);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(275);
				match(COMMA);
				setState(276);
				expression();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(RPAREN);
			setState(283);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			logicalOrExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_OR() { return getTokens(CGrammarParser.LOGICAL_OR); }
		public TerminalNode LOGICAL_OR(int i) {
			return getToken(CGrammarParser.LOGICAL_OR, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logicalOrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			logicalAndExpression();
			setState(292);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(288);
					match(LOGICAL_OR);
					setState(289);
					logicalAndExpression();
					}
					} 
				}
				setState(294);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> LOGICAL_AND() { return getTokens(CGrammarParser.LOGICAL_AND); }
		public TerminalNode LOGICAL_AND(int i) {
			return getToken(CGrammarParser.LOGICAL_AND, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_logicalAndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			equalityExpression();
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(296);
					match(LOGICAL_AND);
					setState(297);
					equalityExpression();
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(CGrammarParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(CGrammarParser.EQ, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(CGrammarParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(CGrammarParser.NEQ, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_equalityExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			relationalExpression();
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(304);
					_la = _input.LA(1);
					if ( !(_la==EQ || _la==NEQ) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(305);
					relationalExpression();
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(CGrammarParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(CGrammarParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(CGrammarParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(CGrammarParser.GT, i);
		}
		public List<TerminalNode> LE() { return getTokens(CGrammarParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(CGrammarParser.LE, i);
		}
		public List<TerminalNode> GE() { return getTokens(CGrammarParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(CGrammarParser.GE, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_relationalExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			additiveExpression();
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(312);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131941395333120L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(313);
					additiveExpression();
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CGrammarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CGrammarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CGrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CGrammarParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			multiplicativeExpression();
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(321);
					multiplicativeExpression();
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<PrefixExpressionContext> prefixExpression() {
			return getRuleContexts(PrefixExpressionContext.class);
		}
		public PrefixExpressionContext prefixExpression(int i) {
			return getRuleContext(PrefixExpressionContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(CGrammarParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(CGrammarParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(CGrammarParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CGrammarParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(CGrammarParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(CGrammarParser.MOD, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			prefixExpression();
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(328);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(329);
					prefixExpression();
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixExpressionContext extends ParserRuleContext {
		public PrefixExpressionContext prefixExpression() {
			return getRuleContext(PrefixExpressionContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(CGrammarParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(CGrammarParser.DECREMENT, 0); }
		public TerminalNode LOGICAL_NOT() { return getToken(CGrammarParser.LOGICAL_NOT, 0); }
		public TerminalNode AND() { return getToken(CGrammarParser.AND, 0); }
		public TerminalNode MUL() { return getToken(CGrammarParser.MUL, 0); }
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public PrefixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExpressionContext prefixExpression() throws RecognitionException {
		PrefixExpressionContext _localctx = new PrefixExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_prefixExpression);
		int _la;
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MUL:
			case INCREMENT:
			case DECREMENT:
			case AND:
			case LOGICAL_NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4676279861248L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(336);
				prefixExpression();
				}
				break;
			case SIZEOF:
			case IDENTIFIER:
			case NUMBER:
			case CHAR_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				postfixExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(CGrammarParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(CGrammarParser.LBRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(CGrammarParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(CGrammarParser.RBRACKET, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(CGrammarParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(CGrammarParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(CGrammarParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(CGrammarParser.RPAREN, i);
		}
		public List<TerminalNode> INCREMENT() { return getTokens(CGrammarParser.INCREMENT); }
		public TerminalNode INCREMENT(int i) {
			return getToken(CGrammarParser.INCREMENT, i);
		}
		public List<TerminalNode> DECREMENT() { return getTokens(CGrammarParser.DECREMENT); }
		public TerminalNode DECREMENT(int i) {
			return getToken(CGrammarParser.DECREMENT, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			primaryExpression();
			setState(354);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(352);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACKET:
						{
						setState(341);
						match(LBRACKET);
						setState(342);
						expression();
						setState(343);
						match(RBRACKET);
						}
						break;
					case LPAREN:
						{
						setState(345);
						match(LPAREN);
						setState(347);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(346);
							expressionList();
							}
							break;
						}
						setState(349);
						match(RPAREN);
						}
						break;
					case INCREMENT:
						{
						setState(350);
						match(INCREMENT);
						}
						break;
					case DECREMENT:
						{
						setState(351);
						match(DECREMENT);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(356);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CGrammarParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4508275940261888L) != 0)) {
				{
				setState(357);
				expression();
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(358);
					match(COMMA);
					setState(359);
					expression();
					}
					}
					setState(364);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends PrimaryExpressionContext {
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends PrimaryExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(CGrammarParser.IDENTIFIER, 0); }
		public IdentifierExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExpressionContext extends PrimaryExpressionContext {
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public ParenExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExpressionContext extends PrimaryExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SizeofExpressionContext extends PrimaryExpressionContext {
		public TerminalNode SIZEOF() { return getToken(CGrammarParser.SIZEOF, 0); }
		public TerminalNode LPAREN() { return getToken(CGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CGrammarParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SizeofExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitSizeofExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_primaryExpression);
		try {
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new IdentifierExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new LiteralExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				literal();
				}
				break;
			case 3:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(369);
				match(LPAREN);
				setState(370);
				expression();
				setState(371);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SizeofExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(373);
				match(SIZEOF);
				setState(374);
				match(LPAREN);
				setState(377);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VOID:
				case INT:
				case CHAR:
				case FLOAT:
				case DOUBLE:
					{
					setState(375);
					type();
					}
					break;
				case SIZEOF:
				case IDENTIFIER:
				case NUMBER:
				case CHAR_LITERAL:
				case FLOAT_LITERAL:
				case STRING_LITERAL:
				case MUL:
				case INCREMENT:
				case DECREMENT:
				case AND:
				case LOGICAL_NOT:
				case LPAREN:
					{
					setState(376);
					expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(379);
				match(RPAREN);
				}
				break;
			case 5:
				_localctx = new CastExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(381);
				match(LPAREN);
				setState(382);
				type();
				setState(383);
				match(RPAREN);
				setState(384);
				expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CGrammarParser.NUMBER, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(CGrammarParser.CHAR_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(CGrammarParser.FLOAT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CGrammarParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CGrammarVisitor ) return ((CGrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static final String _serializedATN =
		"\u0004\u0001=\u0187\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000J\b\u0000\n\u0000\f\u0000M\t"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0004\u0002S\b"+
		"\u0002\u000b\u0002\f\u0002T\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003^\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004i\b\u0004\n\u0004\f\u0004l\t"+
		"\u0004\u0003\u0004n\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006w\b\u0006\u0001"+
		"\u0006\u0005\u0006z\b\u0006\n\u0006\f\u0006}\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0082\b\u0006\u0003\u0006\u0084\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u008c\b\u0007\n\u0007\f\u0007\u008f\t\u0007\u0003\u0007\u0091"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u0097\b\b\n\b"+
		"\f\b\u009a\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00ab\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b7\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00cb\b\u000e\u0001\u000e\u0003\u000e\u00ce"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00d2\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00d9\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00e9\b\u0012\n\u0012\f\u0012\u00ec"+
		"\t\u0012\u0001\u0012\u0003\u0012\u00ef\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00f7\b\u0013"+
		"\n\u0013\f\u0013\u00fa\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u00ff\b\u0014\n\u0014\f\u0014\u0102\t\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0109\b\u0015\n\u0015"+
		"\f\u0015\u010c\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0116\b\u0016"+
		"\n\u0016\f\u0016\u0119\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0123"+
		"\b\u0018\n\u0018\f\u0018\u0126\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u012b\b\u0019\n\u0019\f\u0019\u012e\t\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u0133\b\u001a\n\u001a\f\u001a\u0136\t\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u013b\b\u001b\n\u001b"+
		"\f\u001b\u013e\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c"+
		"\u0143\b\u001c\n\u001c\f\u001c\u0146\t\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0005\u001d\u014b\b\u001d\n\u001d\f\u001d\u014e\t\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0003\u001e\u0153\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u015c\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0161\b"+
		"\u001f\n\u001f\f\u001f\u0164\t\u001f\u0001 \u0001 \u0001 \u0005 \u0169"+
		"\b \n \f \u016c\t \u0003 \u016e\b \u0001!\u0001!\u0001!\u0001!\u0001!"+
		"\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u017a\b!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0003!\u0183\b!\u0001\"\u0001\"\u0001\""+
		"\u0000\u0000#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0007\u0001\u0000\u0001"+
		"\u0005\u0001\u0000/0\u0001\u0000+.\u0001\u0000\u0019\u001a\u0001\u0000"+
		"\u001b\u001d\u0004\u0000\u001b\u001b\u001e\u001f&&**\u0001\u0000\u0015"+
		"\u0018\u019c\u0000F\u0001\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000"+
		"\u0004R\u0001\u0000\u0000\u0000\u0006X\u0001\u0000\u0000\u0000\bm\u0001"+
		"\u0000\u0000\u0000\no\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000\u0000"+
		"\u000e\u0087\u0001\u0000\u0000\u0000\u0010\u0094\u0001\u0000\u0000\u0000"+
		"\u0012\u00aa\u0001\u0000\u0000\u0000\u0014\u00ac\u0001\u0000\u0000\u0000"+
		"\u0016\u00af\u0001\u0000\u0000\u0000\u0018\u00b8\u0001\u0000\u0000\u0000"+
		"\u001a\u00be\u0001\u0000\u0000\u0000\u001c\u00c6\u0001\u0000\u0000\u0000"+
		"\u001e\u00d6\u0001\u0000\u0000\u0000 \u00dc\u0001\u0000\u0000\u0000\""+
		"\u00df\u0001\u0000\u0000\u0000$\u00e2\u0001\u0000\u0000\u0000&\u00f2\u0001"+
		"\u0000\u0000\u0000(\u00fb\u0001\u0000\u0000\u0000*\u0103\u0001\u0000\u0000"+
		"\u0000,\u0110\u0001\u0000\u0000\u0000.\u011d\u0001\u0000\u0000\u00000"+
		"\u011f\u0001\u0000\u0000\u00002\u0127\u0001\u0000\u0000\u00004\u012f\u0001"+
		"\u0000\u0000\u00006\u0137\u0001\u0000\u0000\u00008\u013f\u0001\u0000\u0000"+
		"\u0000:\u0147\u0001\u0000\u0000\u0000<\u0152\u0001\u0000\u0000\u0000>"+
		"\u0154\u0001\u0000\u0000\u0000@\u016d\u0001\u0000\u0000\u0000B\u0182\u0001"+
		"\u0000\u0000\u0000D\u0184\u0001\u0000\u0000\u0000FK\u0003\u0002\u0001"+
		"\u0000GH\u00058\u0000\u0000HJ\u00059\u0000\u0000IG\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000L\u0001\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u0007"+
		"\u0000\u0000\u0000O\u0003\u0001\u0000\u0000\u0000PS\u0003\u0006\u0003"+
		"\u0000QS\u0003\f\u0006\u0000RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005\u0000\u0000\u0001W\u0005"+
		"\u0001\u0000\u0000\u0000XY\u0003\u0000\u0000\u0000YZ\u0005\u0014\u0000"+
		"\u0000Z]\u00054\u0000\u0000[^\u0003\b\u0004\u0000\\^\u0005\u0001\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_b\u00055\u0000\u0000`c\u0003\u0010"+
		"\b\u0000ac\u00051\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000"+
		"\u0000\u0000c\u0007\u0001\u0000\u0000\u0000dn\u0005\u0001\u0000\u0000"+
		"ej\u0003\n\u0005\u0000fg\u00053\u0000\u0000gi\u0003\n\u0005\u0000hf\u0001"+
		"\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000md\u0001\u0000\u0000\u0000me\u0001\u0000\u0000\u0000n\t\u0001\u0000"+
		"\u0000\u0000op\u0003\u0000\u0000\u0000pq\u0005\u0014\u0000\u0000q\u000b"+
		"\u0001\u0000\u0000\u0000rs\u0003\u0000\u0000\u0000s{\u0005\u0014\u0000"+
		"\u0000tv\u00058\u0000\u0000uw\u0005\u0015\u0000\u0000vu\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u00059\u0000"+
		"\u0000yt\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0083\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0081\u0005 \u0000\u0000\u007f\u0082\u0003"+
		".\u0017\u0000\u0080\u0082\u0003\u000e\u0007\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000"+
		"\u0000\u0000\u0083~\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u00051\u0000\u0000"+
		"\u0086\r\u0001\u0000\u0000\u0000\u0087\u0090\u00056\u0000\u0000\u0088"+
		"\u008d\u0003.\u0017\u0000\u0089\u008a\u00053\u0000\u0000\u008a\u008c\u0003"+
		".\u0017\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u00057\u0000"+
		"\u0000\u0093\u000f\u0001\u0000\u0000\u0000\u0094\u0098\u00056\u0000\u0000"+
		"\u0095\u0097\u0003\u0012\t\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u00057\u0000\u0000\u009c\u0011"+
		"\u0001\u0000\u0000\u0000\u009d\u00ab\u0003\f\u0006\u0000\u009e\u00ab\u0003"+
		"\u0014\n\u0000\u009f\u00ab\u0003\u0016\u000b\u0000\u00a0\u00ab\u0003\u0018"+
		"\f\u0000\u00a1\u00ab\u0003\u001a\r\u0000\u00a2\u00ab\u0003\u001c\u000e"+
		"\u0000\u00a3\u00ab\u0003\u001e\u000f\u0000\u00a4\u00ab\u0003$\u0012\u0000"+
		"\u00a5\u00ab\u0003 \u0010\u0000\u00a6\u00ab\u0003\"\u0011\u0000\u00a7"+
		"\u00ab\u0003*\u0015\u0000\u00a8\u00ab\u0003,\u0016\u0000\u00a9\u00ab\u0003"+
		"\u0010\b\u0000\u00aa\u009d\u0001\u0000\u0000\u0000\u00aa\u009e\u0001\u0000"+
		"\u0000\u0000\u00aa\u009f\u0001\u0000\u0000\u0000\u00aa\u00a0\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a1\u0001\u0000\u0000\u0000\u00aa\u00a2\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a3\u0001\u0000\u0000\u0000\u00aa\u00a4\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a5\u0001\u0000\u0000\u0000\u00aa\u00a6\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a7\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u0013\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0003.\u0017\u0000\u00ad\u00ae\u00051\u0000\u0000"+
		"\u00ae\u0015\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0007\u0000\u0000"+
		"\u00b0\u00b1\u00054\u0000\u0000\u00b1\u00b2\u0003.\u0017\u0000\u00b2\u00b3"+
		"\u00055\u0000\u0000\u00b3\u00b6\u0003\u0012\t\u0000\u00b4\u00b5\u0005"+
		"\b\u0000\u0000\u00b5\u00b7\u0003\u0012\t\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u0017\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\t\u0000\u0000\u00b9\u00ba\u00054\u0000"+
		"\u0000\u00ba\u00bb\u0003.\u0017\u0000\u00bb\u00bc\u00055\u0000\u0000\u00bc"+
		"\u00bd\u0003\u0012\t\u0000\u00bd\u0019\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0005\n\u0000\u0000\u00bf\u00c0\u0003\u0012\t\u0000\u00c0\u00c1\u0005"+
		"\t\u0000\u0000\u00c1\u00c2\u00054\u0000\u0000\u00c2\u00c3\u0003.\u0017"+
		"\u0000\u00c3\u00c4\u00055\u0000\u0000\u00c4\u00c5\u00051\u0000\u0000\u00c5"+
		"\u001b\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u000b\u0000\u0000\u00c7"+
		"\u00ca\u00054\u0000\u0000\u00c8\u00cb\u0003\f\u0006\u0000\u00c9\u00cb"+
		"\u0003\u0014\n\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003"+
		".\u0017\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u00051\u0000"+
		"\u0000\u00d0\u00d2\u0003.\u0017\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u00055\u0000\u0000\u00d4\u00d5\u0003\u0012\t\u0000\u00d5"+
		"\u001d\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005\u0006\u0000\u0000\u00d7"+
		"\u00d9\u0003.\u0017\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u00051\u0000\u0000\u00db\u001f\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\u000f\u0000\u0000\u00dd\u00de\u00051\u0000\u0000\u00de!\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\u0010\u0000\u0000\u00e0\u00e1\u00051\u0000\u0000"+
		"\u00e1#\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\f\u0000\u0000\u00e3"+
		"\u00e4\u00054\u0000\u0000\u00e4\u00e5\u0003.\u0017\u0000\u00e5\u00e6\u0005"+
		"5\u0000\u0000\u00e6\u00ea\u00056\u0000\u0000\u00e7\u00e9\u0003&\u0013"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ef\u0003(\u0014\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u00057\u0000\u0000\u00f1%\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005\r\u0000\u0000\u00f3\u00f4\u0003.\u0017\u0000\u00f4\u00f8\u0005"+
		"2\u0000\u0000\u00f5\u00f7\u0003\u0012\t\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\'\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u000e\u0000"+
		"\u0000\u00fc\u0100\u00052\u0000\u0000\u00fd\u00ff\u0003\u0012\t\u0000"+
		"\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102\u0001\u0000\u0000\u0000"+
		"\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000"+
		"\u0101)\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0005\u0011\u0000\u0000\u0104\u0105\u00054\u0000\u0000\u0105\u010a"+
		"\u0005\u0018\u0000\u0000\u0106\u0107\u00053\u0000\u0000\u0107\u0109\u0003"+
		".\u0017\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u00055\u0000\u0000\u010e\u010f\u00051\u0000\u0000"+
		"\u010f+\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0012\u0000\u0000\u0111"+
		"\u0112\u00054\u0000\u0000\u0112\u0117\u0005\u0018\u0000\u0000\u0113\u0114"+
		"\u00053\u0000\u0000\u0114\u0116\u0003.\u0017\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u011a\u0001\u0000"+
		"\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u00055\u0000"+
		"\u0000\u011b\u011c\u00051\u0000\u0000\u011c-\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u00030\u0018\u0000\u011e/\u0001\u0000\u0000\u0000\u011f\u0124\u0003"+
		"2\u0019\u0000\u0120\u0121\u0005)\u0000\u0000\u0121\u0123\u00032\u0019"+
		"\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000"+
		"\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000"+
		"\u0000\u01251\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u0127\u012c\u00034\u001a\u0000\u0128\u0129\u0005(\u0000\u0000\u0129\u012b"+
		"\u00034\u001a\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012e\u0001"+
		"\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001"+
		"\u0000\u0000\u0000\u012d3\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000"+
		"\u0000\u0000\u012f\u0134\u00036\u001b\u0000\u0130\u0131\u0007\u0001\u0000"+
		"\u0000\u0131\u0133\u00036\u001b\u0000\u0132\u0130\u0001\u0000\u0000\u0000"+
		"\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u01355\u0001\u0000\u0000\u0000\u0136"+
		"\u0134\u0001\u0000\u0000\u0000\u0137\u013c\u00038\u001c\u0000\u0138\u0139"+
		"\u0007\u0002\u0000\u0000\u0139\u013b\u00038\u001c\u0000\u013a\u0138\u0001"+
		"\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013a\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d7\u0001\u0000"+
		"\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0144\u0003:\u001d"+
		"\u0000\u0140\u0141\u0007\u0003\u0000\u0000\u0141\u0143\u0003:\u001d\u0000"+
		"\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000"+
		"\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000"+
		"\u01459\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147"+
		"\u014c\u0003<\u001e\u0000\u0148\u0149\u0007\u0004\u0000\u0000\u0149\u014b"+
		"\u0003<\u001e\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001"+
		"\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d;\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0007\u0005\u0000\u0000\u0150\u0153\u0003<\u001e"+
		"\u0000\u0151\u0153\u0003>\u001f\u0000\u0152\u014f\u0001\u0000\u0000\u0000"+
		"\u0152\u0151\u0001\u0000\u0000\u0000\u0153=\u0001\u0000\u0000\u0000\u0154"+
		"\u0162\u0003B!\u0000\u0155\u0156\u00058\u0000\u0000\u0156\u0157\u0003"+
		".\u0017\u0000\u0157\u0158\u00059\u0000\u0000\u0158\u0161\u0001\u0000\u0000"+
		"\u0000\u0159\u015b\u00054\u0000\u0000\u015a\u015c\u0003@ \u0000\u015b"+
		"\u015a\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c"+
		"\u015d\u0001\u0000\u0000\u0000\u015d\u0161\u00055\u0000\u0000\u015e\u0161"+
		"\u0005\u001e\u0000\u0000\u015f\u0161\u0005\u001f\u0000\u0000\u0160\u0155"+
		"\u0001\u0000\u0000\u0000\u0160\u0159\u0001\u0000\u0000\u0000\u0160\u015e"+
		"\u0001\u0000\u0000\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163?\u0001\u0000\u0000\u0000\u0164\u0162\u0001"+
		"\u0000\u0000\u0000\u0165\u016a\u0003.\u0017\u0000\u0166\u0167\u00053\u0000"+
		"\u0000\u0167\u0169\u0003.\u0017\u0000\u0168\u0166\u0001\u0000\u0000\u0000"+
		"\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000"+
		"\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0165\u0001\u0000\u0000\u0000"+
		"\u016d\u016e\u0001\u0000\u0000\u0000\u016eA\u0001\u0000\u0000\u0000\u016f"+
		"\u0183\u0005\u0014\u0000\u0000\u0170\u0183\u0003D\"\u0000\u0171\u0172"+
		"\u00054\u0000\u0000\u0172\u0173\u0003.\u0017\u0000\u0173\u0174\u00055"+
		"\u0000\u0000\u0174\u0183\u0001\u0000\u0000\u0000\u0175\u0176\u0005\u0013"+
		"\u0000\u0000\u0176\u0179\u00054\u0000\u0000\u0177\u017a\u0003\u0000\u0000"+
		"\u0000\u0178\u017a\u0003.\u0017\u0000\u0179\u0177\u0001\u0000\u0000\u0000"+
		"\u0179\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000"+
		"\u017b\u017c\u00055\u0000\u0000\u017c\u0183\u0001\u0000\u0000\u0000\u017d"+
		"\u017e\u00054\u0000\u0000\u017e\u017f\u0003\u0000\u0000\u0000\u017f\u0180"+
		"\u00055\u0000\u0000\u0180\u0181\u0003.\u0017\u0000\u0181\u0183\u0001\u0000"+
		"\u0000\u0000\u0182\u016f\u0001\u0000\u0000\u0000\u0182\u0170\u0001\u0000"+
		"\u0000\u0000\u0182\u0171\u0001\u0000\u0000\u0000\u0182\u0175\u0001\u0000"+
		"\u0000\u0000\u0182\u017d\u0001\u0000\u0000\u0000\u0183C\u0001\u0000\u0000"+
		"\u0000\u0184\u0185\u0007\u0006\u0000\u0000\u0185E\u0001\u0000\u0000\u0000"+
		"(KRT]bjmv{\u0081\u0083\u008d\u0090\u0098\u00aa\u00b6\u00ca\u00cd\u00d1"+
		"\u00d8\u00ea\u00ee\u00f8\u0100\u010a\u0117\u0124\u012c\u0134\u013c\u0144"+
		"\u014c\u0152\u015b\u0160\u0162\u016a\u016d\u0179\u0182";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}