package com.compiler.ASTNodes;

import java.util.List;

public  class Program extends ASTNode {
    List<ASTNode> declarations; // Lista de declaraciones (funciones y variables)

    public Program(List<ASTNode> declarations) {
        this.declarations = declarations;
    }

    public List<ASTNode> getDeclarations() {
        return declarations;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }
}