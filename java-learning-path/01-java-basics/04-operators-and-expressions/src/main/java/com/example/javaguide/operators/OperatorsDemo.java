package com.example.javaguide.operators;

/**
 * OperatorsDemo - Demonstrates all Java operators.
 * 
 * This class covers:
 * - Arithmetic operators (+, -, *, /, %)
 * - Relational operators (==, !=, >, <, >=, <=)
 * - Logical operators (&&, ||, !)
 * - Assignment operators (=, +=, -=, *=, /=, %=)
 * - Unary operators (+, -, ++, --)
 * - Bitwise operators (&, |, ^, ~, <<, >>)
 * - Ternary operator (?:)
 */
public class OperatorsDemo {
    
    /**
     * Main method running all operator demonstrations.
     */
    public static void main(String[] args) {
        demonstrateArithmeticOperators();
        demonstrateRelationalOperators();
        demonstrateLogicalOperators();
        demonstrateAssignmentOperators();
        demonstrateUnaryOperators();
        demonstrateBitwiseOperators();
        demonstrateTernaryOperator();
    }
    
    /**
     * Demonstrates basic mathematical operations yielding numerical results.
     */
    public static void demonstrateArithmeticOperators() {
        System.out.println("=== Arithmetic Operators ===");
        int a = 10, b = 5;
        
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b));
        System.out.println(a + " % " + b + " = " + (a % b));
        System.out.println();
    }
    /**
     * Demonstrates comparisons between values yielding boolean results.
     */
    public static void demonstrateRelationalOperators() {
        System.out.println("=== Relational Operators ===");
        int a = 10, b = 5;
        
        System.out.println(a + " == " + b + ": " + (a == b));
        System.out.println(a + " != " + b + ": " + (a != b));
        System.out.println(a + " > " + b + ": " + (a > b));
        System.out.println(a + " < " + b + ": " + (a < b));
        System.out.println(a + " >= " + b + ": " + (a >= b));
        System.out.println(a + " <= " + b + ": " + (a <= b));
        System.out.println();
    }
    /**
     * Demonstrates logical conjunction (AND), disjunction (OR), and negation (NOT).
     */
    public static void demonstrateLogicalOperators() {
        System.out.println("=== Logical Operators ===");
        boolean t = true, f = false;
        
        System.out.println("true && false: " + (t && f));
        System.out.println("true || false: " + (t || f));
        System.out.println("!true: " + (!t));
        System.out.println();
    }
    /**
     * Demonstrates compound assignment operations combining arithmetic and assignment.
     */
    public static void demonstrateAssignmentOperators() {
        System.out.println("=== Assignment Operators ===");
        int x = 10;
        
        x += 5;  System.out.println("After += 5: " + x);
        x -= 3;  System.out.println("After -= 3: " + x);
        x *= 2;  System.out.println("After *= 2: " + x);
        x /= 4;  System.out.println("After /= 4: " + x);
        x %= 5;  System.out.println("After %= 5: " + x);
        System.out.println();
    }
    /**
     * Demonstrates prefix (e.g., ++x) and postfix (e.g., x++) increments.
     */
    public static void demonstrateUnaryOperators() {
        System.out.println("=== Unary Operators ===");
        int x = 10;
        
        System.out.println("Original: " + x);
        System.out.println("++x (pre-increment): " + (++x));
        System.out.println("x++ (post-increment): " + (x++));
        System.out.println("After post-increment: " + x);
        System.out.println();
    }
    /**
     * Demonstrates bit-level operations on integer values.
     */
    public static void demonstrateBitwiseOperators() {
        System.out.println("=== Bitwise Operators ===");
        int a = 5;  // 0101
        int b = 3;  // 0011
        
        System.out.println(a + " & " + b + " = " + (a & b)); // 0001 = 1
        System.out.println(a + " | " + b + " = " + (a | b)); // 0111 = 7
        System.out.println(a + " ^ " + b + " = " + (a ^ b)); // 0110 = 6
        System.out.println("~" + a + " = " + (~a));
        System.out.println(a + " << 1 = " + (a << 1)); // Left shift
        System.out.println(a + " >> 1 = " + (a >> 1)); // Right shift
        System.out.println();
    }
    /**
     * Demonstrates the ternary conditional operator as a shorthand for if-else.
     */
    public static void demonstrateTernaryOperator() {
        System.out.println("=== Ternary Operator ===");
        int a = 10, b = 20;
        
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + ": " + max);
        
        String result = (a % 2 == 0) ? "even" : "odd";
        System.out.println(a + " is " + result);
        System.out.println();
    }
    
    /** Adds two integers */
    public static int add(int a, int b) { return a + b; }
    
    /** Subtracts integer b from integer a */
    public static int subtract(int a, int b) { return a - b; }
    
    /** Multiplies two integers */
    public static int multiply(int a, int b) { return a * b; }
    
    /** Divides integer a by integer b */
    public static int divide(int a, int b) { return a / b; }
    
    /** Calculates the modulo of integer a by integer b */
    public static int modulus(int a, int b) { return a % b; }
}
