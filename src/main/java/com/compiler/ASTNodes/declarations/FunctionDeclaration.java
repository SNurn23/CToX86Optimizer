package com.compiler.ASTNodes.declarations;

import com.compiler.ASTNodes.ASTNode;
import com.compiler.ASTNodes.ASTVisitor;
import com.compiler.ASTNodes.blocks.Block;

import java.util.List;

public class FunctionDeclaration extends ASTNode {
    String returnType;
    String name;
    List<ParamDeclaration> params;
    Block body;

    public FunctionDeclaration(String returnType, String name, List<ParamDeclaration> params, Block body) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionDeclaration(this);
    }
}