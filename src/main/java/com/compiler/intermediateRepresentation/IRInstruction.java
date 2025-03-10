package com.compiler.intermediateRepresentation;

public class IRInstruction {
    public String operator;
    public Operand operand1;
    public Operand operand2;
    public String result;

    public IRInstruction(String operator, Operand operand1, Operand operand2, String result) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder resultStr = new StringBuilder();

        if (operator.equals("if_false_goto") || operator.equals("if_goto")) {
            resultStr.append(operator).append(" ").append(operand1.getValue()).append(", ").append(result);
        } else if (operand2 != null && operand1 != null) {
            resultStr.append(result).append(" = ").append(operand1.getValue()).append(" ").append(operator).append(" ").append(operand2.getValue());
        } else if (operand1 != null) {
            if (operator.equals("param")) {
                resultStr.append("param ").append(operand1.getValue());
            } else if (operator.equals("return")) {
                resultStr.append("return ").append(operand1.getValue());
            } else if (operator.equals("=")) {
                resultStr.append(result).append(" = ").append(operand1.getValue());
            } else {
                resultStr.append(operator).append(" ").append(operand1.getValue());
            }
        } else {
            if (operator.equals("label") || operator.equals("func_begin") || operator.equals("func_end") || operator.equals("goto")) {
                resultStr.append(operator).append(" ").append(result);
            } else if (operator.equals("return")) {
                resultStr.append("return");
            } else {
                resultStr.append(operator);
            }
        }

        return resultStr.toString();
    }

}
