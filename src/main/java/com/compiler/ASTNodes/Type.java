package com.compiler.ASTNodes;

public enum Type {
    INT("int"),
    CHAR("char"),
    FLOAT("float"),
    DOUBLE("double"),
    VOID("void");

    private final String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}