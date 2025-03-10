package com.compiler.semantic;

import java.util.List;
import java.util.Objects;

public class Type {
    private String typeName;
    public boolean isArray;
    private boolean isPointer;
    private Type elementType;
    public int arraySize = -1;
    public Type returnType; // Tipo de retorno (solo para funciones)
    public List<Type> paramTypes; // Lista de tipos de parámetros (solo para funciones)
    public List<Type> containedTypes;

    // Constructor para tipos básicos
    public Type(String typeName) {
        this.typeName = typeName;
        this.returnType = null;
        this.paramTypes = null;
    }

    // Constructor para funciones
    public Type(String typeName, Type returnType, List<Type> paramTypes) {
        this.typeName = typeName;
        this.returnType = returnType;
        this.paramTypes = paramTypes;
    }
    // Constructor para listas de expresiones
    public Type(String typeName, List<Type> containedTypes) {
        this.typeName = typeName;
        this.containedTypes = containedTypes;
    }

    public List<Type> getContainedTypes() {
        return containedTypes;
    }

    public boolean isInteger() {
        return typeName.matches("int|long|short|char");
    }

    // Metodo para promoción de tipos
    public static Type promote(Type t1, Type t2) {
        if (!t1.isNumeric() || !t2.isNumeric()) return null;
        return t1.getRank() > t2.getRank() ? t1 : t2;
    }

    public String getName() {
        // Devuelve el nombre del tipo, por ejemplo "int", "float", etc.
        return this.typeName;  // o alguna propiedad que contenga el nombre del tipo
    }


    public static Type createArray(Type baseType, int size) {
        Type type = new Type(baseType.typeName + "[]");
        type.isArray = true;
        type.elementType = baseType;
        type.arraySize = size;
        return type;
    }

    public static Type createPointer(Type baseType) {
        Type type = new Type(baseType.typeName + "*");
        type.isPointer = true;
        type.elementType = baseType;
        return type;
    }

    public Type decayArray() {
        return isArray ? Type.createPointer(elementType) : this;
    }

    public boolean isCompatibleWith(Type other) {
        Type thisDecayed = this.decayArray();
        Type otherDecayed = other.decayArray();

        // Si los tipos ya son exactamente iguales, son compatibles
        if (thisDecayed.equals(otherDecayed)) return true;

        // Verificar compatibilidad numérica sin permitir conversión entre tipos diferentes (como float a int)
        if (thisDecayed.isNumeric() && otherDecayed.isNumeric()) {
            // No permitir conversiones implícitas (por ejemplo, de float a int)
            return false; // Si son numéricos pero de tipo distinto, no son compatibles
        }

        // Verificar compatibilidad entre punteros
        if (thisDecayed.isPointer && otherDecayed.isPointer) {
            return thisDecayed.elementType.isVoid() ||
                    otherDecayed.elementType.isVoid() ||
                    thisDecayed.elementType.isCompatibleWith(otherDecayed.elementType);
        }

        // Si no es compatible en ningún otro caso, retorna falso
        return false;
    }


    public Type getElementType() {
        return elementType;
    }

    public int getRank() {
        switch (this.typeName) {
            case "char":    return 1;
            case "short":   return 2;
            case "int":    return 3;
            case "long":   return 4;
            case "float":  return 5;
            case "double": return 6;
            default:        return -1;
        }
    }

    // Metodo para crear un tipo de función
    public static Type createFunction(Type returnType, List<Type> paramTypes) {
        return new Type("function", returnType, paramTypes);
    }

    // Metodo para verificar si es un tipo función
    public boolean isFunction() {
        return returnType != null && paramTypes != null;
    }

    // Metodo para obtener el tipo de retorno (solo para funciones)
    public Type getReturnType() {
        if (!isFunction()) {
            throw new RuntimeException("No es un tipo función");
        }
        return returnType;
    }

    // Metodo para obtener los tipos de los parámetros (solo para funciones)
    public List<Type> getParamTypes() {
        if (!isFunction()) {
            throw new RuntimeException("No es un tipo función");
        }
        return paramTypes;
    }

    // Metodo para verificar si los parámetros coinciden
    public boolean matchParameters(List<Type> argTypes) {
        if (paramTypes == null) return argTypes.isEmpty();
        if (paramTypes.size() != argTypes.size()) return false;

        for (int i = 0; i < paramTypes.size(); i++) {
            if (!paramTypes.get(i).isCompatibleWith(argTypes.get(i))) {
                return false;
            }
        }
        return true;
    }

    public enum TypeKind {
        BASIC,
        POINTER,
        ARRAY,
        FUNCTION
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Type)) return false;
        Type other = (Type) obj;
        return this.typeName.equals(other.typeName) &&
                this.isArray == other.isArray &&
                this.isPointer == other.isPointer &&
                Objects.equals(this.elementType, other.elementType);
    }

    public boolean isVoid() {
        return "void".equals(typeName);
    }

    public boolean isNumeric() {
        return isIntegral() || "float".equals(typeName) || "double".equals(typeName);
    }

    public boolean isIntegral() {
        return typeName.matches("char|short|int|long");
    }

    public boolean isAssignable() {
        return !isArray;
    }

    public boolean isArray() {
        return this.isArray;
    }

    public boolean isPointer() {
        return this.isPointer;
    }

    public boolean isScalar() {
        return isIntegral() || isFloat() || isPointer();
    }

    public boolean isFloat() {
        return "float".equals(typeName) || "double".equals(typeName);
    }

    public boolean isChar() {
        return "char".equals(typeName);
    }

    // Metodo para verificar si es un tipo válido para operadores de prefijo (++, --)
    public boolean isValidForPrefixOp() {
        return isNumeric() || isPointer();
    }
    // Metodo para verificar si es un tipo válido para operadores de asignación compuesta (+=, -=, etc.)
    public boolean isValidForCompoundAssignment(Type rhsType) {
        if (isPointer()) {
            return rhsType.isIntegral(); // Solo se puede sumar/restar enteros a punteros
        }
        return isNumeric() && rhsType.isNumeric();
    }
    // Metodo para verificar si es un tipo válido para operadores lógicos (&&, ||)
    public boolean isValidForLogicalOp() {
        return isScalar(); // Tipos escalares son válidos para operaciones lógicas
    }
    // Metodo para verificar si es un tipo de cadena (char*)
    public boolean isString() {
        return isPointer() && elementType.isChar();
    }
    // Metodo para verificar si es un puntero válido para desreferenciación
    public boolean isValidForDereference() {
        return isPointer() && !elementType.isVoid(); // No se puede desreferenciar un puntero void*
    }
    // Metodo para crear un tipo de cadena (char*)
    public static Type createStringType() {
        return Type.createPointer(new Type("char"));
    }
    public boolean isCastableFrom(Type other) {
        // Conversiones entre tipos numéricos
        if (this.isNumeric() && other.isNumeric()) return true;

        // Conversiones de punteros
        if (this.isPointer() && other.isPointer()) {
            return this.elementType.isVoid() ||
                    other.elementType.isVoid() ||
                    this.elementType.isCompatibleWith(other.elementType);
        }

        // Conversión de entero a puntero
        if (this.isPointer() && other.isIntegral()) return true;

        // Conversión de puntero a booleano
        if (this.isIntegral() && other.isPointer()) return true;

        return false;
    }

    public boolean isVoidPointer() {
        return isPointer() && elementType.isVoid();
    }


}