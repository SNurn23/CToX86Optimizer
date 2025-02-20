package com.compiler.ASTNodes.declarations;

import com.compiler.ASTNodes.ASTNode;
import com.compiler.ASTNodes.ASTVisitor;

public class ParamDeclaration extends ASTNode {
    String type;
    String name;

    public ParamDeclaration(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitParamDeclaration(this);
    }
}
