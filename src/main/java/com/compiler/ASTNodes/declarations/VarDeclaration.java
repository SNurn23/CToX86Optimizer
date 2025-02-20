package com.compiler.ASTNodes.declarations;

import com.compiler.ASTNodes.ASTNode;
import com.compiler.ASTNodes.ASTVisitor;

import java.beans.Expression;

public class VarDeclaration extends ASTNode {
    String type;
    String name;
    Expression value;

    public VarDeclaration(String type, String name, Expression value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVarDeclaration(this);
    }
}
