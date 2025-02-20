package com.compiler.ASTNodes.misc;

import com.compiler.ASTNodes.ASTNode;
import com.compiler.ASTNodes.ASTVisitor;

import java.beans.Expression;

public class ExprStatement extends ASTNode {
    Expression expression;

    public ExprStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitExprStatement(this);
    }
}