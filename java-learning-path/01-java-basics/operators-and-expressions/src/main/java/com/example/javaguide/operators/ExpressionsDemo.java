package com.example.javaguide.operators;

/**
 * ExpressionsDemo - Demonstrates complex expressions and precedence
 */
public class ExpressionsDemo {
    
    public static void main(String[] args) {
        demonstratePrecedence();
        demonstrateComplexExpressions();
    }
    
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
    
    public static void demonstrateComplexExpressions() {
        System.out.println("=== Complex Expressions ===");
        
        int x = 10, y = 5, z = 2;
        int result = x + y * z - x / z;
        System.out.println("x + y * z - x / z = " + result);
        
        boolean complex = (x > y) && (y > z) || (z == 2);
        System.out.println("(x > y) && (y > z) || (z == 2) = " + complex);
    }
}
