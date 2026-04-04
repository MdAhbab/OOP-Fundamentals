package com.example.javaguide.basicsyntax;

/**
 * BasicSyntaxDemo - Covers the fundamental building blocks of every Java program.
 *
 * Topics demonstrated:
 * - Program structure and the main() method
 * - System.out print methods (println, print, printf)
 * - Comment styles (single-line, multi-line, Javadoc)
 * - Statements and blocks (semicolons, curly braces)
 * - Naming conventions (camelCase, PascalCase, UPPER_SNAKE_CASE)
 * - Type casting (widening and narrowing)
 * - Primitive data types overview
 *
 * @author Java Learning Path
 * @version 1.0
 */
public class BasicSyntaxDemo {

    // ===== CONSTANTS use UPPER_SNAKE_CASE by convention =====
    static final double GRAVITY = 9.81;
    static final String GREETING = "Hello, Java!";

    /**
     * The main method is the entry point of every Java application.
     * Signature breakdown:
     *   public  – accessible from anywhere (JVM needs to call it)
     *   static  – belongs to the class, not an instance
     *   void    – returns nothing
     *   String[] args – command-line arguments passed to the program
     *
     * @param args command-line arguments (not used in this demo)
     */
    public static void main(String[] args) {

        // ---- 1. Console Output Methods ----
        demonstratePrintMethods();

        // ---- 2. Comment Styles (see inline examples below) ----
        demonstrateComments();

        // ---- 3. Statements and Blocks ----
        demonstrateStatementsAndBlocks();

        // ---- 4. Naming Conventions ----
        demonstrateNamingConventions();

        // ---- 5. Primitive Data Types ----
        demonstratePrimitiveTypes();

        // ---- 6. Type Casting ----
        demonstrateTypeCasting();
    }

    // ================================================================
    // 1. Console Output
    // ================================================================

    /**
     * Shows the three main ways to print to the console.
     */
    public static void demonstratePrintMethods() {
        System.out.println("=== Console Output Methods ===");

        // println – prints text followed by a newline character
        System.out.println("println: Prints with a newline at the end.");

        // print – prints text WITHOUT a trailing newline
        System.out.print("print: No newline... ");
        System.out.print("so this continues on the same line.\n");

        // printf – formatted output using %-placeholders (C-style)
        String language = "Java";
        int version = 21;
        System.out.printf("printf: %s version %d%n", language, version);
        // %s = string, %d = integer, %n = platform-independent newline

        System.out.println(); // blank line separator
    }

    // ================================================================
    // 2. Comment Styles
    // ================================================================

    /**
     * Demonstrates the three kinds of comments in Java.
     *   1. Single-line comments   // like this
     *   2. Multi-line comments    /* like this *​/
     *   3. Javadoc comments       /** like this *​/ (used for API docs)
     */
    public static void demonstrateComments() {
        System.out.println("=== Comment Styles ===");

        // This is a single-line comment — everything after // is ignored.

        /*
         * This is a multi-line (block) comment.
         * It can span as many lines as you need.
         * Useful for temporarily disabling code or long explanations.
         */

        // Javadoc comments (/** ... */) are placed ABOVE classes, methods,
        // and fields. They are extracted by the 'javadoc' tool to generate
        // HTML documentation.

        System.out.println("See source code for comment examples.");
        System.out.println();
    }

    // ================================================================
    // 3. Statements and Blocks
    // ================================================================

    /**
     * Every executable instruction in Java is a statement,
     * terminated by a semicolon (;).
     * A block groups zero or more statements inside { }.
     */
    public static void demonstrateStatementsAndBlocks() {
        System.out.println("=== Statements and Blocks ===");

        // A statement — semicolon is required
        int x = 10;

        // A block — code inside { } shares a scope
        {
            int y = 20; // y exists only inside this block
            System.out.println("Inside block: x=" + x + ", y=" + y);
        }
        // y is NOT accessible here — it went out of scope

        // if-else is a common block structure
        if (x > 5) {
            System.out.println(x + " is greater than 5");
        } else {
            System.out.println(x + " is 5 or less");
        }

        System.out.println();
    }

    // ================================================================
    // 4. Naming Conventions
    // ================================================================

    /**
     * Java has strong naming conventions that improve readability:
     *   - Classes/Interfaces → PascalCase   (e.g. BasicSyntaxDemo)
     *   - Methods/Variables  → camelCase     (e.g. myVariable)
     *   - Constants          → UPPER_SNAKE   (e.g. MAX_VALUE)
     *   - Packages           → all lowercase (e.g. com.example.javaguide)
     */
    public static void demonstrateNamingConventions() {
        System.out.println("=== Naming Conventions ===");

        // camelCase for local variables and method names
        int studentAge = 21;
        String firstName = "Alice";

        // UPPER_SNAKE_CASE for constants (already declared at the top)
        System.out.println("Gravity constant: " + GRAVITY);
        System.out.println("Greeting constant: " + GREETING);

        // PascalCase is used for class names (e.g. BasicSyntaxDemo)
        System.out.println("Class name convention: PascalCase (e.g. BasicSyntaxDemo)");
        System.out.println("Variable name: studentAge=" + studentAge + ", firstName=" + firstName);

        System.out.println();
    }

    // ================================================================
    // 5. Primitive Data Types
    // ================================================================

    /**
     * Java has 8 primitive data types.
     * Each has a fixed size and default value.
     */
    public static void demonstratePrimitiveTypes() {
        System.out.println("=== Primitive Data Types ===");

        // Integer types (signed)
        byte   byteVal   = 127;          // 8-bit,  range: -128 to 127
        short  shortVal  = 32_767;       // 16-bit, range: -32,768 to 32,767
        int    intVal    = 2_147_483_647; // 32-bit (most commonly used)
        long   longVal   = 9_000_000_000L; // 64-bit — 'L' suffix required

        // Floating-point types
        float  floatVal  = 3.14f;        // 32-bit — 'f' suffix required
        double doubleVal = 3.14159265;   // 64-bit (default for decimals)

        // Character type
        char   charVal   = 'A';          // 16-bit Unicode character

        // Boolean type
        boolean boolVal  = true;         // true or false only

        System.out.printf("byte:    %d%n", byteVal);
        System.out.printf("short:   %d%n", shortVal);
        System.out.printf("int:     %d%n", intVal);
        System.out.printf("long:    %d%n", longVal);
        System.out.printf("float:   %.2f%n", floatVal);
        System.out.printf("double:  %.8f%n", doubleVal);
        System.out.printf("char:    %c (Unicode: %d)%n", charVal, (int) charVal);
        System.out.printf("boolean: %b%n", boolVal);
        System.out.println();
    }

    // ================================================================
    // 6. Type Casting
    // ================================================================

    /**
     * Type casting converts a value from one data type to another.
     *
     * WIDENING (implicit): smaller → larger type — safe, no data loss
     *   byte → short → int → long → float → double
     *
     * NARROWING (explicit): larger → smaller type — may lose data,
     *   requires a cast operator: (targetType)
     */
    public static void demonstrateTypeCasting() {
        System.out.println("=== Type Casting ===");

        // Widening cast (automatic) — int to double
        int intValue = 42;
        double widenedValue = intValue; // No cast needed
        System.out.println("Widening  (int → double): " + intValue + " → " + widenedValue);

        // Narrowing cast (manual) — double to int
        double pi = 3.14159;
        int narrowedValue = (int) pi; // Truncates decimal part
        System.out.println("Narrowing (double → int): " + pi + " → " + narrowedValue);

        // char to int (widening — char's Unicode value)
        char letter = 'A';
        int unicodeValue = letter; // 'A' = 65
        System.out.println("Char → int: '" + letter + "' → " + unicodeValue);

        // int to char (narrowing)
        int code = 90;
        char fromCode = (char) code; // 90 = 'Z'
        System.out.println("Int → char: " + code + " → '" + fromCode + "'");

        System.out.println();
    }

    // ================================================================
    // Utility methods (used by tests)
    // ================================================================

    /** Returns the gravity constant. */
    public static double getGravity() {
        return GRAVITY;
    }

    /** Returns the greeting constant. */
    public static String getGreeting() {
        return GREETING;
    }

    /**
     * Performs a widening cast from int to double.
     *
     * @param value the integer to widen
     * @return the value as a double
     */
    public static double widenIntToDouble(int value) {
        return value; // implicit widening
    }

    /**
     * Performs a narrowing cast from double to int (truncates decimal).
     *
     * @param value the double to narrow
     * @return the truncated integer
     */
    public static int narrowDoubleToInt(double value) {
        return (int) value; // explicit narrowing
    }
}
