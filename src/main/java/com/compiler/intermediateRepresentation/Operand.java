package com.compiler.intermediateRepresentation;

public class Operand {
    private String value;
    private String type;

    public Operand(String value, String type) {
        this.value = value;
        this.type = type;
    }

    // Getters
    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

}
