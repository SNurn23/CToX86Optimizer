package com.compiler;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import com.compiler.antlr4.CGrammarParser;
import com.compiler.antlr4.CGrammarLexer;
import com.compiler.semantic.CSemanticAnalyzer;
import com.compiler.intermediateRepresentation.IRGenerator;
import com.compiler.intermediateRepresentation.IRInstruction;

import java.util.List;

public class Compiler {
    public static void main(String[] args) throws Exception {
        // Leer el código fuente desde un archivo o cadena
        String sourceCode = """
                int main() {
                    int x;
                    int y = x + 5;
                    return 0;
                }
                """;

        // Crear el lexer
        CGrammarLexer lexer = new CGrammarLexer(CharStreams.fromString(sourceCode));
        // Crear los tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Crear el parser
        CGrammarParser parser = new CGrammarParser(tokens);
        ParseTree tree = parser.program();
        System.out.println("Árbol de sintaxis:");
        System.out.println(tree.toStringTree(parser));

        // Crear el analizador semántico
        CSemanticAnalyzer semanticAnalyzer = new CSemanticAnalyzer();

        try {
            // Visitar el árbol con el analizador semántico
            semanticAnalyzer.visit(tree);
            System.out.println("Análisis semántico exitoso, sin errores.");

            // Crear el generador de IR solo si no hubo errores
           // IRGenerator irGenerator = new IRGenerator();
           // irGenerator.visit(tree);

            // Obtener las instrucciones generadas
            //List<IRInstruction> instructions = irGenerator.getInstructions();

            // Imprimir las instrucciones generadas
//            System.out.println("Código Intermedio (IR) generado:");
//            for (IRInstruction instruction : instructions) {
//                System.out.println(instruction);
//            }

        } catch (RuntimeException e) {
            System.err.println("Error semántico: " + e.getMessage());
        }
    }
}
