package com.compiler.ASTNodes;

import com.compiler.ASTNodes.blocks.Block;
import com.compiler.ASTNodes.declarations.*;
import com.compiler.ASTNodes.expressions.*;
import com.compiler.ASTNodes.misc.ExprStatement;
import com.compiler.ASTNodes.statements.*;

public interface ASTVisitor<T> {
    //Nodo Raiz
    T visitProgram(Program node);

    // Declaraciones
    T visitVarDeclaration(VarDeclaration node);
    T visitArrayDeclaration(ArrayDeclaration node);
    T visitFunctionDeclaration(FunctionDeclaration node);
    T visitParamDeclaration(ParamDeclaration node);

    // Expresiones
    T visitBinaryOp(BinaryOp node);
    T visitUnaryOp(UnaryOp node);
    T visitIntLiteral(IntLiteral node);
    T visitFloatLiteral(FloatLiteral node);
    T visitCharLiteral(CharLiteral node);
    T visitStringLiteral(StringLiteral node);
    T visitArrayAccess(ArrayAccess node);
    T visitFunctionCall(FunctionCall node);
    T visitSizeOfExpression(SizeOfExpression node);

    // Sentencias de control
    T visitIfStatement(IfStatement node);
    T visitWhileStatement(WhileStatement node);
    T visitDoWhileStatement(DoWhileStatement node);
    T visitForStatement(ForStatement node);
    T visitSwitchStatement(SwitchStatement node);
    T visitCaseStatement(CaseStatement node);
    T visitDefaultStatement(DefaultStatement node);
    T visitBreakStatement(BreakStatement node);
    T visitContinueStatement(ContinueStatement node);
    T visitReturnStatement(ReturnStatement node);

    // Bloques
    T visitBlock(Block node);

    // Expresión como sentencia
    T visitExprStatement(ExprStatement node);
}
