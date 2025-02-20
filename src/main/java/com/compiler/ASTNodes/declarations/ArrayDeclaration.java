package com.compiler.ASTNodes.declarations;

import com.compiler.ASTNodes.ASTNode;
import com.compiler.ASTNodes.ASTVisitor;

public class ArrayDeclaration extends ASTNode {
    String type;
    String name;
    int size;

    public ArrayDeclaration(String type, String name, int size) {
        this.type = type;
        this.name = name;
        this.size = size;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitArrayDeclaration(this);
    }
}