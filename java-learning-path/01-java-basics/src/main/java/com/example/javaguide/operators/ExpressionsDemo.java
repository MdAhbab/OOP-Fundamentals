package com.example.javaguide.operators;

/**
 * ExpressionsDemo - Demonstrates complex expressions and operator precedence in Java.
 * 
 * An expression is a construct made up of variables, operators, and method 
 * invocations that evaluates to a single value.
 * Precedence determines the order in which operators are evaluated.
 */
public class ExpressionsDemo {
    
    /**
     * Main method running all expression demonstrations.
     */
    public static void main(String[] args) {
        demonstratePrecedence();
        demonstrateComplexExpressions();
    }
    
    /**
     * Demonstrates how operator precedence affects the evaluated result
     * of mathematical and logical expressions.
     */
    public static void demonstratePrecedence() {
        System.out.println("=== Operator Precedence ===");
        
        int result1 = 2 + 3 * 4;  // * has higher precedence than +
        System.out.println("2 + 3 * 4 = " + result1 + " (not 20)");
        
        int result2 = (2 + 3) * 4;  // Parentheses force addition first
        System.out.println("(2 + 3) * 4 = " + result2);
        
        boolean result3 = 5 > 3 && 10 < 20;
        System.out.println("5 > 3 && 10 < 20 = " + result3);
        System.out.println();
    }
    /**
     * Demonstrates more complex combinations of operators,
     * including arithmetic, relational, and logical operators in single expressions.
     */
    public static void demonstrateComplexExpressions() {
        System.out.println("=== Complex Expressions ===");
        
        int x = 10, y = 5, z = 2;
        int result = x + y * z - x / z;
        System.out.println("x + y * z - x / z = " + result);
        
        boolean complex = (x > y) && (y > z) || (z == 2);
        System.out.println("(x > y) && (y > z) || (z == 2) = " + complex);
    }
}
