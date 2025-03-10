package com.compiler.semantic;

import com.compiler.antlr4.CGrammarBaseVisitor;
import com.compiler.antlr4.CGrammarParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CSemanticAnalyzer extends CGrammarBaseVisitor<Type> {
    private SymbolTable symbolTable = new SymbolTable();
    private int loopDepth = 0; // Para validar break/continue
    private Type currentFunctionReturnType;
    private Type expectedElementType;
    private Type currentSwitchType; // Tipo de la expresión del switch actual
    private Set<Object> caseValues = new HashSet<>(); // Para detectar casos duplicados
    private boolean hasDefault = false; // Verificar solo un default por switch

    // 1. Manejo de tipos con arrays
    @Override
    public Type visitType(CGrammarParser.TypeContext ctx) {
        Type baseType = visitBaseType(ctx.baseType());
        int arrayDimensions = ctx.LBRACKET().size();

        // Aplicar dimensiones de array
        Type result = baseType;
        for (int i = 0; i < arrayDimensions; i++) {
            result = Type.createArray(result, -1); // -1 = tamaño no especificado
        }
        return result;
    }

    // 2. Tipos base (primitivos)
    @Override
    public Type visitBaseType(CGrammarParser.BaseTypeContext ctx) {
        return new Type(ctx.getText()); // "int", "char", etc.
    }

    // 3. Punto de entrada del programa
    @Override
    public Type visitProgram(CGrammarParser.ProgramContext ctx) {
        // Procesar todas las declaraciones globales
        ctx.children.forEach(child -> {
            if (child instanceof CGrammarParser.FunctionDeclContext) {
                visitFunctionDecl((CGrammarParser.FunctionDeclContext) child);
            } else if (child instanceof CGrammarParser.VarDeclContext) {
                visitVarDecl((CGrammarParser.VarDeclContext) child);
            }
        });
        return null;
    }

    // 4. Declaración de funciones
    @Override
    public Type visitFunctionDecl(CGrammarParser.FunctionDeclContext ctx) {
        Type returnType = visitType(ctx.type());
        String funcName = ctx.IDENTIFIER().getText();

        List<Type> paramTypes = new ArrayList<>();
        if (ctx.paramList() != null) {
            if (ctx.paramList().VOID() != null && ctx.paramList().param().size() > 0) {
                throw new RuntimeException("Función '" + funcName + "' no puede tener 'void' junto a otros parámetros");
            }

            for (CGrammarParser.ParamContext param : ctx.paramList().param()) {
                paramTypes.add(visitParam(param).decayArray());
            }
        }

        symbolTable.addFunction(funcName, returnType, paramTypes);
        symbolTable.enterScope();
        symbolTable.pushReturnType(returnType);

        if (ctx.paramList() != null) {
            ctx.paramList().param().forEach(param -> {
                String name = param.IDENTIFIER().getText();
                Type type = visitParam(param).decayArray();
                symbolTable.addVariable(name, type);
            });
        }

        if (ctx.block() != null) {
            visit(ctx.block());
            if (!returnType.isVoid() && !hasReturnStatement(ctx.block())) {
                throw new RuntimeException("Función '" + funcName + "' debe retornar un valor");
            }
        }

        symbolTable.popReturnType();
        symbolTable.exitScope();
        return returnType;
    }

    // 5. Lista de parámetros (no necesita lógica adicional)
    @Override
    public Type visitParamList(CGrammarParser.ParamListContext ctx) {
        return visitChildren(ctx); // Procesado en visitFunctionDecl
    }

    // 6. Parámetros individuales
    @Override
    public Type visitParam(CGrammarParser.ParamContext ctx) {
        Type paramType = visitType(ctx.type());
        if (paramType == null) {
            throw new RuntimeException("Error: El tipo del parámetro es nulo en " + ctx.getText());
        }
        return paramType.decayArray();
    }

    // Metodo auxiliar para detectar returns
    private boolean hasReturnStatement(CGrammarParser.BlockContext block) {
        return block.statement().stream().anyMatch(stmt ->
                stmt.returnStatement() != null ||
                        (stmt.block() != null && hasReturnStatement(stmt.block()))
        );
    }
    @Override
    public Type visitVarDecl(CGrammarParser.VarDeclContext ctx) {
        System.out.println("Entrando en visitVarDecl con variable: " + ctx.IDENTIFIER().getText());
        Type declaredType = visitType(ctx.type());
        String varName = ctx.IDENTIFIER().getText();

        // Procesar dimensiones del array
        Type currentType = declaredType;
        for (int i = 0; i < ctx.LBRACKET().size(); i++) {
            if (ctx.NUMBER(i) != null) {
                int size = Integer.parseInt(ctx.NUMBER(i).getText());
                if (size <= 0) throw new RuntimeException("Tamaño de array inválido: " + size);
            }
            currentType = Type.createArray(currentType, -1);
        }

        // Verificar redeclaración
        symbolTable.addVariable(varName, currentType);
        System.out.println("Variable " + varName + " declarada.");

        // Procesar inicializador
        if (ctx.arrayInitializer() != null) {
            symbolTable.lookupVariable(varName).markInitialized();
            expectedElementType = currentType.getElementType();
            visit(ctx.arrayInitializer());
            System.out.println("Variable " + varName + " inicializada.");
        } else {
            // Marcar la variable como no inicializada si no tiene inicializador
            symbolTable.lookupVariable(varName).markUninitialized();
            System.out.println("Variable " + varName + " no inicializada.");
        }

        return currentType;
    }


    @Override
    public Type visitArrayInitializer(CGrammarParser.ArrayInitializerContext ctx) {
        for (CGrammarParser.ExpressionContext expr : ctx.expression()) {
            Type exprType = visit(expr);

            // Verificar compatibilidad con el tipo esperado
            if (!exprType.isCompatibleWith(expectedElementType)) {
                throw new RuntimeException("Tipo incompatible en inicializador");
            }

            // Manejar arrays multidimensionales
            if (expectedElementType.isArray()) {
                Type previousExpected = expectedElementType;
                expectedElementType = expectedElementType.getElementType();
                visit(expr); // Procesar sub-inicializador
                expectedElementType = previousExpected;
            }
        }
        return expectedElementType;
    }
    // 3. Bloques de Código
    @Override
    public Type visitBlock(CGrammarParser.BlockContext ctx) {
        symbolTable.enterScope();
        ctx.statement().forEach(this::visit);
        symbolTable.exitScope();
        return null;
    }

    // 4. Declaraciones Genéricas
    @Override
    public Type visitStatement(CGrammarParser.StatementContext ctx) {
        // Delegar al tipo específico de declaración
        return visitChildren(ctx);
    }

    // 5. Expresiones como Declaraciones
    @Override
    public Type visitExprStatement(CGrammarParser.ExprStatementContext ctx) {
        Type exprType = visit(ctx.expression());
        // Verificar expresiones válidas (ej: asignaciones o llamadas a funciones)
        if (exprType == null) {
            throw new RuntimeException("Expresión inválida en contexto de declaración");
        }
        return exprType;
    }

    // 1. If Statement
    @Override
    public Type visitIfStatement(CGrammarParser.IfStatementContext ctx) {
        // Verificar condición
        Type condType = visit(ctx.expression());
        if (!condType.isIntegral() && !condType.isPointer()) {
            throw new RuntimeException("La condición del if debe ser tipo escalar");
        }

        visit(ctx.statement(0)); // Bloque then

        if (ctx.ELSE() != null) {
            visit(ctx.statement(1)); // Bloque else
        }
        return null;
    }

    // 2. While Loop
    @Override
    public Type visitWhileStatement(CGrammarParser.WhileStatementContext ctx) {
        // Verificar condición
        Type condType = visit(ctx.expression());
        if (!condType.isIntegral() && !condType.isPointer()) {
            throw new RuntimeException("La condición del while debe ser tipo escalar");
        }

        loopDepth++;
        visit(ctx.statement()); // Cuerpo del loop
        loopDepth--;
        return null;
    }
    // 3. Do-While Loop
    @Override
    public Type visitDoWhileStatement(CGrammarParser.DoWhileStatementContext ctx) {
        loopDepth++;
        visit(ctx.statement()); // Cuerpo del loop

        // Verificar condición
        Type condType = visit(ctx.expression());
        if (!condType.isIntegral() && !condType.isPointer()) {
            throw new RuntimeException("La condición del do-while debe ser tipo escalar");
        }

        loopDepth--;
        return null;
    }
    // 4. For Loop
    @Override
    public Type visitForStatement(CGrammarParser.ForStatementContext ctx) {
        // Nuevo ámbito para variables declaradas en el for
        symbolTable.enterScope();

        // Inicialización
        if (ctx.varDecl() != null) visit(ctx.varDecl());
        else if (ctx.exprStatement() != null) visit(ctx.exprStatement());

        // Condición
        if (ctx.expression(0) != null) {
            Type condType = visit(ctx.expression(0));
            if (!condType.isIntegral() && !condType.isPointer()) {
                throw new RuntimeException("La condición del for debe ser tipo escalar");
            }
        }

        // Iteración
        if (ctx.expression(1) != null) visit(ctx.expression(1));

        loopDepth++;
        visit(ctx.statement()); // Cuerpo del loop
        loopDepth--;

        symbolTable.exitScope();
        return null;
    }
    // 5. Return Statement
    @Override
    public Type visitReturnStatement(CGrammarParser.ReturnStatementContext ctx) {
        Type expected = symbolTable.getCurrentReturnType();

        if (ctx.expression() != null) {
            Type actual = visit(ctx.expression());
            if (!actual.isCompatibleWith(expected)) {
                throw new RuntimeException("Tipo de retorno incompatible. Esperado: " + expected + ", Obtenido: " + actual);
            }
        } else if (!expected.isVoid()) {
            throw new RuntimeException("Función no void debe retornar un valor");
        }
        return null;
    }
    // 6. Break Statement
    @Override
    public Type visitBreakStatement(CGrammarParser.BreakStatementContext ctx) {
        if (loopDepth == 0) {
            throw new RuntimeException("break fuera de un loop");
        }
        return null;
    }

    // 7. Continue Statement
    @Override
    public Type visitContinueStatement(CGrammarParser.ContinueStatementContext ctx) {
        if (loopDepth == 0) {
            throw new RuntimeException("continue fuera de un loop");
        }
        return null;
    }
    // 1. Switch Statement
    @Override
    public Type visitSwitchStatement(CGrammarParser.SwitchStatementContext ctx) {
        // Evaluar expresión del switch
        currentSwitchType = visit(ctx.expression());
        if (!currentSwitchType.isIntegral() && !currentSwitchType.isPointer()) {
            throw new RuntimeException("La expresión del switch debe ser entera o puntero");
        }

        symbolTable.enterScope();
        caseValues.clear();
        hasDefault = false;

        // Procesar case y default
        ctx.caseStatement().forEach(this::visitCaseStatement);
        if (ctx.defaultStatement() != null) {
            visitDefaultStatement(ctx.defaultStatement());
        }

        symbolTable.exitScope();
        currentSwitchType = null;
        return null;
    }

    // 2. Case Statement
    @Override
    public Type visitCaseStatement(CGrammarParser.CaseStatementContext ctx) {
        if (currentSwitchType == null) {
            throw new RuntimeException("Case fuera de un switch");
        }

        // Verificar expresión constante
        Type caseType = visit(ctx.expression());
        if (!caseType.isCompatibleWith(currentSwitchType)) {
            throw new RuntimeException("Tipo de case incompatible con el switch");
        }

        // Verificar duplicados
        Object value = getConstantValue(ctx.expression());
        if (value != null && !caseValues.add(value)) {
            throw new RuntimeException("Valor de case duplicado: " + value);
        }

        // Procesar sentencias dentro del case
        ctx.statement().forEach(this::visit);
        return null;
    }

    // 3. Default Statement
    @Override
    public Type visitDefaultStatement(CGrammarParser.DefaultStatementContext ctx) {
        if (currentSwitchType == null) {
            throw new RuntimeException("Default fuera de un switch");
        }
        if (hasDefault) {
            throw new RuntimeException("Solo un default permitido por switch");
        }
        hasDefault = true;

        ctx.statement().forEach(this::visit);
        return null;
    }

    // 4. Printf Statement
    @Override
    public Type visitPrintfStatement(CGrammarParser.PrintfStatementContext ctx) {
        // Verificar primer argumento es string literal
        String format = ctx.STRING_LITERAL().getText();
        List<Type> expectedTypes = parsePrintfFormat(format);

        // Verificar argumentos restantes
        List<CGrammarParser.ExpressionContext> args = ctx.expression().subList(1, ctx.expression().size());
        if (expectedTypes.size() != args.size()) {
            throw new RuntimeException("Número de argumentos incorrecto en printf");
        }

        for (int i = 0; i < args.size(); i++) {
            Type actualType = visit(args.get(i));
            if (!actualType.isCompatibleWith(expectedTypes.get(i))) {
                throw new RuntimeException("Tipo incompatible en printf: " + actualType);
            }
        }
        return null;
    }

    // 5. Scanf Statement
    @Override
    public Type visitScanfStatement(CGrammarParser.ScanfStatementContext ctx) {
        // Verificar primer argumento es string literal
        String format = ctx.STRING_LITERAL().getText();
        List<Type> expectedTypes = parseScanfFormat(format);

        // Verificar argumentos restantes son direcciones
        List<CGrammarParser.ExpressionContext> args = ctx.expression().subList(1, ctx.expression().size());
        if (expectedTypes.size() != args.size()) {
            throw new RuntimeException("Número de argumentos incorrecto en scanf");
        }

        for (int i = 0; i < args.size(); i++) {
            if (!(args.get(i) instanceof CGrammarParser.AddressOfExpressionContext)) {
                throw new RuntimeException("Argumento de scanf debe ser una dirección (&)");
            }
            Type actualType = visit(args.get(i)).decayArray(); // Arrays decaen a punteros
            if (!actualType.isCompatibleWith(expectedTypes.get(i))) {
                throw new RuntimeException("Tipo incompatible en scanf: " + actualType);
            }
        }
        return null;
    }

    // 6. Address-of Expression (&)
    @Override
    public Type visitAddressOfExpression(CGrammarParser.AddressOfExpressionContext ctx) {
        // Verificar que la expresión es un lvalue
        Type operandType = visit(ctx.expression());
        if (!operandType.isAssignable()) {
            throw new RuntimeException("Operando no direccionable en &");
        }
        return Type.createPointer(operandType);
    }

    // Helpers para análisis de formatos
    private List<Type> parsePrintfFormat(String format) {
        List<Type> types = new ArrayList<>();
        // Implementar lógica para extraer especificadores (ej: %d, %f, %s)
        // y mapearlos a tipos esperados (int, float, char*, etc.)
        return types;
    }

    private List<Type> parseScanfFormat(String format) {
        List<Type> types = new ArrayList<>();
        // Similar a printf, pero para scanf (ej: %d -> int*, %s -> char*)
        return types;
    }

    // Obtener valor constante (simplificado)
    private Object getConstantValue(CGrammarParser.ExpressionContext expr) {
        // Implementar lógica para evaluar expresiones constantes
        return null;
    }

    @Override
    public Type visitIdentifierExpression(CGrammarParser.IdentifierExpressionContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        System.out.println("Entrando en visitIdentifierExpression con variable: " + varName);
        SymbolTable.Symbol symbol = symbolTable.lookupVariable(varName);
        if (symbol == null) {
            throw new RuntimeException("Variable no declarada: " + varName);
        }
        if (!symbol.isInitialized()) {
            throw new RuntimeException("Error semántico: La variable '" + varName + "' no está inicializada.");
        }
        return symbol.getType().decayArray();
    }

    @Override
    public Type visitAssignmentExpression(CGrammarParser.AssignmentExpressionContext ctx) {
        System.out.println("Entrando en visitAssignmentExpression");
        Type leftType = visit(ctx.expression(0));
        Type rightType = visit(ctx.expression(1));

        if (ctx.expression(0) instanceof CGrammarParser.IdentifierExpressionContext) {
            String varName = ctx.expression(0).getText();
            System.out.println("Asignando valor a la variable: " + varName);
            SymbolTable.Symbol symbol = symbolTable.lookupVariable(varName);
            if (symbol == null) {
                throw new RuntimeException("Error semántico: La variable '" + varName + "' no está declarada.");
            }
            symbol.markInitialized();
            System.out.println("Variable " + varName + " marcada como inicializada.");
        }

        if (!leftType.isAssignable()) {
            throw new RuntimeException("Lado izquierdo no es asignable");
        }

        if (!rightType.isCompatibleWith(leftType)) {
            throw new RuntimeException("Tipos incompatibles en asignación: " + leftType.getName() + " vs " + rightType.getName());
        }

        return leftType;
    }


    @Override
    public Type visitNotExpression(CGrammarParser.NotExpressionContext ctx) {
        Type exprType = visit(ctx.expression());

        // Debe ser tipo escalar (entero, puntero o booleano)
        if (!exprType.isIntegral() && !exprType.isPointer()) {
            throw new RuntimeException("Operando inválido para operador !");
        }

        return new Type("int"); // En C, el resultado es siempre entero
    }

    @Override
    public Type visitParenExpression(CGrammarParser.ParenExpressionContext ctx) {
        // Simplemente retornar el tipo de la expresión interna
        return visit(ctx.expression());
    }

    @Override
    public Type visitCommaExpression(CGrammarParser.CommaExpressionContext ctx) {
        // Evaluar todas las expresiones y retornar el tipo de la última
        Type lastType = null;
        for (CGrammarParser.ExpressionContext expr : ctx.expression()) {
            lastType = visit(expr);
        }
        return lastType;
    }

    @Override
    public Type visitLogicalOrExpression(CGrammarParser.LogicalOrExpressionContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        // Ambos operandos deben ser escalares
        if (!left.isScalar() || !right.isScalar()) {
            throw new RuntimeException("Operandos no escalares para operador ||");
        }

        return new Type("int"); // Resultado es siempre entero en C
    }

    @Override
    public Type visitRelationalExpr(CGrammarParser.RelationalExprContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        // Validar tipos comparables
        if (!left.isCompatibleWith(right) && !right.isCompatibleWith(left)) {
            throw new RuntimeException("Tipos incomparables: " + left + " y " + right);
        }

        return new Type("int"); // Resultado booleano como entero
    }

    @Override
    public Type visitSizeofExpression(CGrammarParser.SizeofExpressionContext ctx) {
        // El operando de sizeof puede ser tipo o expresión
        if (ctx.type() != null) {
            visit(ctx.type());
        } else {
            visit(ctx.expression());
        }

        // sizeof siempre retorna size_t (lo representamos como unsigned long)
        return new Type("unsigned long");
    }

    @Override
    public Type visitCastExpression(CGrammarParser.CastExpressionContext ctx) {
        Type targetType = visit(ctx.type());
        Type exprType = visit(ctx.expression());

        // Validar conversión posible
        if (!targetType.isCastableFrom(exprType)) {
            throw new RuntimeException("Cast inválido de " + exprType + " a " + targetType);
        }

        return targetType;
    }

    @Override
    public Type visitArrayAccessExpression(CGrammarParser.ArrayAccessExpressionContext ctx) {
        Type arrayType = visit(ctx.expression(0));
        Type indexType = visit(ctx.expression(1));

        // Verificar índice es entero
        if (!indexType.isIntegral()) {
            throw new RuntimeException("Índice de array no es entero");
        }

        // Verificar que es array o puntero
        if (!arrayType.isArray() && !arrayType.isPointer()) {
            throw new RuntimeException("Intento de indexar no-array");
        }

        // Retornar tipo del elemento
        return arrayType.getElementType();
    }

    @Override
    public Type visitPrefixExpression(CGrammarParser.PrefixExpressionContext ctx) {
        Type exprType = visit(ctx.expression());

        if (!exprType.isAssignable()) {
            throw new RuntimeException("Operando no asignable en operador prefijo");
        }

        if (ctx.INCREMENT() != null || ctx.DECREMENT() != null) {
            if (!exprType.isNumeric() && !exprType.isPointer()) {
                throw new RuntimeException("Operando inválido para ++/--");
            }
        }

        return exprType; // El tipo no cambia
    }

    @Override
    public Type visitCompoundAssignmentExpression(CGrammarParser.CompoundAssignmentExpressionContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        // Verificar que el lado izquierdo es asignable
        if (!left.isAssignable()) {
            throw new RuntimeException("Lado izquierdo no es asignable");
        }

        // Verificar compatibilidad de tipos
        if (!right.isCompatibleWith(left)) {
            throw new RuntimeException("Tipos incompatibles en asignación compuesta");
        }

        // Verificar operaciones específicas
        switch (ctx.start.getType()) {
            case CGrammarParser.PLUS_ASSIGN:
            case CGrammarParser.MINUS_ASSIGN:
                if (left.isPointer() && !right.isIntegral()) {
                    throw new RuntimeException("Solo se puede sumar/restar enteros a punteros");
                }
                break;
            case CGrammarParser.MUL_ASSIGN:
            case CGrammarParser.DIV_ASSIGN:
            case CGrammarParser.MOD_ASSIGN:
                if (!left.isNumeric() || !right.isNumeric()) {
                    throw new RuntimeException("Operandos deben ser numéricos");
                }
                break;
        }

        return left;
    }
    @Override
    public Type visitLogicalAndExpression(CGrammarParser.LogicalAndExpressionContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        // Ambos operandos deben ser escalares
        if (!left.isScalar() || !right.isScalar()) {
            throw new RuntimeException("Operandos no escalares para operador &&");
        }

        return new Type("int"); // Resultado es siempre entero en C
    }
    @Override
    public Type visitFunctionCallExpression(CGrammarParser.FunctionCallExpressionContext ctx) {
        // Obtener el tipo de la expresión de función
        Type funcType = visit(ctx.expression());

        // Verificar que es un tipo función
        if (!funcType.isFunction()) {
            throw new RuntimeException("Intento de llamar a no-función");
        }

        // Procesar argumentos
        List<Type> argTypes = new ArrayList<>();
        if (ctx.expressionList() != null) {
            for (CGrammarParser.ExpressionContext arg : ctx.expressionList().expression()) {
                argTypes.add(visit(arg));
            }
        }

        // Verificar compatibilidad de parámetros
        if (!funcType.matchParameters(argTypes)) {
            throw new RuntimeException("Argumentos no coinciden con la declaración de función");
        }

        return funcType.getReturnType();
    }
    @Override
    public Type visitLiteralExpression(CGrammarParser.LiteralExpressionContext ctx) {
        if (ctx.literal().NUMBER() != null) {
            return new Type("int"); // Enteros son int por defecto
        }
        if (ctx.literal().FLOAT_LITERAL() != null) {
            return new Type("double"); // Flotantes son double por defecto
        }
        if (ctx.literal().CHAR_LITERAL() != null) {
            return new Type("char");
        }
        if (ctx.literal().STRING_LITERAL() != null) {
            return Type.createPointer(new Type("char"));
        }
        throw new RuntimeException("Literal no reconocido");
    }

    @Override
    public Type visitDereferenceExpression(CGrammarParser.DereferenceExpressionContext ctx) {
        Type pointerType = visit(ctx.expression());

        if (!pointerType.isPointer() && !pointerType.isArray()) {
            throw new RuntimeException("Intento de dereferenciar tipo no puntero/array: " + pointerType);
        }

        return pointerType.getElementType();
    }

    @Override
    public Type visitMultiplicativeExpr(CGrammarParser.MultiplicativeExprContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        // Verificar operandos numéricos
        if (!left.isNumeric() || !right.isNumeric()) {
            throw new RuntimeException("Operandos no numéricos para operación " + ctx.start.getText());
        }

        // Validación especial para módulo
        if (ctx.start.getType() == CGrammarParser.MOD &&
                (!left.isIntegral() || !right.isIntegral())) {
            throw new RuntimeException("Operación módulo requiere operandos enteros");
        }

        // Determinar tipo resultante (promoción de tipos)
        return left.getRank() > right.getRank() ? left : right;
    }

    @Override
    public Type visitEqualityExpr(CGrammarParser.EqualityExprContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        if (!left.isCompatibleWith(right) && !right.isCompatibleWith(left)) {
            throw new RuntimeException("Tipos incomparables: " + left + " y " + right);
        }

        if (left.isPointer() && right.isPointer()) {
            if (!left.getElementType().isCompatibleWith(right.getElementType()) &&
                    !left.isVoidPointer() && !right.isVoidPointer()) {
                throw new RuntimeException("Comparación inválida entre punteros de tipos diferentes");
            }
        }

        return new Type("int"); // El resultado siempre es entero (booleano)
    }

    @Override
    public Type visitPostfixExpression(CGrammarParser.PostfixExpressionContext ctx) {
        Type exprType = visit(ctx.expression());

        if (!exprType.isAssignable()) {
            throw new RuntimeException("Operando no asignable en operador postfijo");
        }

        if (!exprType.isNumeric() && !exprType.isPointer()) {
            throw new RuntimeException("Operando inválido para operador postfijo");
        }

        return exprType; // Tipo no cambia
    }

    @Override
    public Type visitExpressionList(CGrammarParser.ExpressionListContext ctx) {
        List<Type> types = new ArrayList<>();
        for (CGrammarParser.ExpressionContext expr : ctx.expression()) {
            types.add(visit(expr));
        }
        return new Type("expression_list", types); // Tipo especial para listas
    }
    @Override
    public Type visitLiteral(CGrammarParser.LiteralContext ctx) {
        if (ctx.NUMBER() != null) {
            String num = ctx.NUMBER().getText();
            // Detectar si es long (sufijo L)
            return num.toUpperCase().endsWith("L") ?
                    new Type("long") : new Type("int");
        }
        if (ctx.FLOAT_LITERAL() != null) {
            String floatNum = ctx.FLOAT_LITERAL().getText();
            // Detectar si es float (sufijo F) o double
            return floatNum.toUpperCase().endsWith("F") ?
                    new Type("float") : new Type("double");
        }
        if (ctx.CHAR_LITERAL() != null) {
            return new Type("char");
        }
        if (ctx.STRING_LITERAL() != null) {
            // String literal es char[] que decae a char*
            return Type.createPointer(new Type("char"));
        }
        throw new RuntimeException("Tipo de literal no reconocido");
    }

    @Override
    public Type visitAdditiveExpr(CGrammarParser.AdditiveExprContext ctx) {
        Type left = visit(ctx.expression(0));
        Type right = visit(ctx.expression(1));

        if (!left.isNumeric() && !left.isPointer()) {
            throw new RuntimeException("Operando izquierdo inválido en suma/resta: " + left);
        }
        if (!right.isNumeric() && !(left.isPointer() && right.isIntegral())) {
            throw new RuntimeException("Operando derecho inválido en suma/resta: " + right);
        }

        // Si es suma/resta entre puntero e entero, el resultado es puntero
        if (left.isPointer() && right.isIntegral()) {
            return left;
        }

        // Si ambos son numéricos, aplicar promoción de tipos
        return left.getRank() > right.getRank() ? left : right;
    }



}