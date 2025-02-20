# CToX86Optimizer
## Descripción
C2X86Optimizer es un compilador que traduce código en C a ensamblador x86, aplicando optimizaciones en cada etapa para mejorar el rendimiento del código. Además, después de generar ensamblador optimizado, lo traduce nuevamente a C para obtener una versión optimizada del código original.

## Etapas del Compilador

### 1. Análisis Léxico y Sintáctico
Se utiliza **ANTLR** para analizar el código fuente en C y generar un **AST (Árbol de Sintaxis Abstracta)**.

### 2. Generación de Código Intermedio (IR)
Transforma el AST en una representación intermedia.

### 3. Optimización de Código
Se aplican optimizaciones tanto en el **IR** como en el **código ensamblador x86**.

### 4. Generación de Ensamblador x86
Traduce el código optimizado a ensamblador x86.

### 5. Regeneración de Código C Optimizado
Convierte el ensamblador optimizado nuevamente a código C más eficiente.

## Instalación

### Requisitos
- **Java 23**
- **ANTLR 4**
- **Maven**

