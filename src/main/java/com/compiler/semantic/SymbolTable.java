package com.compiler.semantic;

import java.util.*;
import java.util.stream.Collectors;

public class SymbolTable {
    private Stack<Map<String, Symbol>> scopes = new Stack<>();
    private Stack<Type> returnTypeStack = new Stack<>();
    private Map<String, Symbol> symbolTable = new HashMap<>();
    public SymbolTable() {
        enterScope(); // Ámbito global
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        if (scopes.size() > 1) scopes.pop();
    }

    public void addVariable(String name, Type type) {
        if (scopes.peek().containsKey(name)) {
            throw new RuntimeException("Variable ya declarada: " + name);
        }
        scopes.peek().put(name, new Symbol(name, type, SymbolKind.VARIABLE));
    }

    public void addFunction(String name, Type returnType, List<Type> paramTypes) {
        if (scopes.size() > 1) {
            throw new RuntimeException("Las funciones deben ser globales");
        }

        List<Type> decayedParams = paramTypes.stream()
                .map(Type::decayArray)
                .collect(Collectors.toList());

        Symbol existing = lookupFunction(name, decayedParams);
        if (existing != null) {
            throw new RuntimeException("Función duplicada: " + name);
        }

        scopes.get(0).put(name, new Symbol(name, returnType, decayedParams));
    }

    public Symbol lookupFunction(String name, List<Type> paramTypes) {
        List<Type> decayedParams = paramTypes.stream()
                .map(Type::decayArray)
                .collect(Collectors.toList());

        for (int i = scopes.size() - 1; i >= 0; i--) {
            Symbol symbol = scopes.get(i).get(name);
            if (symbol != null && symbol.kind == SymbolKind.FUNCTION) {
                List<Type> expected = symbol.getParamTypes().stream()
                        .map(Type::decayArray)
                        .collect(Collectors.toList());

                if (areParamsCompatible(expected, decayedParams)) {
                    return symbol;
                }
            }
        }
        return null;
    }

    private boolean areParamsCompatible(List<Type> expected, List<Type> actual) {
        if (expected.size() != actual.size()) return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).isCompatibleWith(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void pushReturnType(Type type) {
        returnTypeStack.push(type);
    }

    public void popReturnType() {
        if (!returnTypeStack.isEmpty()) {
            returnTypeStack.pop();
        }
    }

    public Type getCurrentReturnType() {
        return returnTypeStack.isEmpty() ? null : returnTypeStack.peek();
    }

    // Añadir este nuevo metodo para buscar variables
    public Symbol lookupVariable(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Symbol symbol = scopes.get(i).get(name);
            if (symbol != null && symbol.kind == SymbolKind.VARIABLE) {
                return symbol;
            }
        }
        return null;
    }

    // Clase interna para representar un símbolo
    public static class Symbol {
        private String name;
        private Type type;
        private SymbolKind kind;
        private List<Type> paramTypes; // Nuevo campo para parámetros
        private boolean initialized;

        // Constructor para funciones
        public Symbol(String name, Type returnType, List<Type> paramTypes) {
            this.name = name;
            this.type = returnType;
            this.kind = SymbolKind.FUNCTION;
            this.initialized = false; // Inicialmente, no está inicializada

            this.paramTypes = paramTypes != null ?
                    new ArrayList<>(paramTypes) :
                    new ArrayList<>();
        }

        // Constructor para variables
        public Symbol(String name, Type type, SymbolKind kind) {
            this.name = name;
            this.type = type;
            this.kind = kind;
            this.paramTypes = null;
        }

        public SymbolKind getKind() {
            return kind;
        }

        // Getters
        public List<Type> getParamTypes() {
            return paramTypes;
        }

        public Type getType() {
            return type;
        }
        // Metodo para marcar la variable como inicializada
        public void markInitialized() {
            this.initialized = true;
        }

        // Metodo para verificar si la variable está inicializada
        public boolean isInitialized() {
            return initialized;
        }

        // Metodo para marcar la variable como no inicializada
        public void markUninitialized() {
            this.initialized = false;
        }

        public void addFunction(String name, Type returnType, List<Type> paramTypes) {
            // ... código existente

            // Verificar que los parámetros sean tipos válidos
            for (Type paramType : paramTypes) {
                if (paramType == null) {
                    throw new RuntimeException("Tipo de parámetro inválido en función " + name);
                }
            }
        }
    }

    // Enumeración para el tipo de símbolo
    public enum SymbolKind {
        VARIABLE,
        FUNCTION
    }
}
