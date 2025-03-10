// Generated from CGrammar.g4 by ANTLR 4.13.0
package com.compiler.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(CGrammarParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(CGrammarParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(CGrammarParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(CGrammarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(CGrammarParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(CGrammarParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#exprStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(CGrammarParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CGrammarParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(CGrammarParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(CGrammarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(CGrammarParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(CGrammarParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(CGrammarParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(CGrammarParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(CGrammarParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#defaultStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStatement(CGrammarParser.DefaultStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#printfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintfStatement(CGrammarParser.PrintfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#scanfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanfStatement(CGrammarParser.ScanfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(CGrammarParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(CGrammarParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(CGrammarParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(CGrammarParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(CGrammarParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(CGrammarParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#prefixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(CGrammarParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(CGrammarParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CGrammarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link CGrammarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(CGrammarParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link CGrammarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(CGrammarParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CGrammarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(CGrammarParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sizeofExpression}
	 * labeled alternative in {@link CGrammarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeofExpression(CGrammarParser.SizeofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castExpression}
	 * labeled alternative in {@link CGrammarParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(CGrammarParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CGrammarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CGrammarParser.LiteralContext ctx);
}