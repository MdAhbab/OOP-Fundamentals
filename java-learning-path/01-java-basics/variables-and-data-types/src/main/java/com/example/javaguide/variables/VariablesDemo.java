package com.example.javaguide.variables;

/**
 * VariablesDemo - Demonstrates variable types, scope, and usage
 * 
 * This class covers:
 * - Local variables
 * - Instance variables
 * - Class (static) variables
 * - Constants
 * - Variable scope
 */
public class VariablesDemo {
    
    // Instance variable (belongs to each object)
    private int instanceVariable = 100;
    
    // Class variable (shared across all instances)
    private static int classVariable = 200;
    
    // Constant (cannot be changed after initialization)
    private static final double PI = 3.14159;
    
    public static void main(String[] args) {
        System.out.println("=== Variables Demo ===\n");
        
        // Local variable (exists only within this method)
        int localVariable = 42;
        System.out.println("Local variable: " + localVariable);
        
        // Create an instance to access instance variables
        VariablesDemo demo = new VariablesDemo();
        System.out.println("Instance variable: " + demo.instanceVariable);
        System.out.println("Class variable: " + classVariable);
        System.out.println("Constant: " + PI);
        
        // Demonstrate variable shadowing
        demo.demonstrateScope();
        
        // Demonstrate variable modification
        demo.modifyVariables();
    }
    
    /**
     * Demonstrates variable scope and shadowing
     */
    public void demonstrateScope() {
        System.out.println("\n=== Variable Scope ===");
        
        int x = 10; // Local variable
        
        // Block scope
        {
            int y = 20; // Only exists within this block
            System.out.println("Inside block - x: " + x + ", y: " + y);
        }
        // y is no longer accessible here
        
        // Loop variable scope
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop iteration: " + i);
        }
        // i is no longer accessible here
    }
    
    /**
     * Demonstrates modifying different types of variables
     */
    public void modifyVariables() {
        System.out.println("\n=== Modifying Variables ===");
        
        // Modify instance variable
        this.instanceVariable = 150;
        System.out.println("Modified instance variable: " + this.instanceVariable);
        
        // Modify class variable
        classVariable = 250;
        System.out.println("Modified class variable: " + classVariable);
        
        // Constants cannot be modified
        // PI = 3.14; // This would cause a compilation error
    }
    
    /**
     * Gets the instance variable value
     */
    public int getInstanceVariable() {
        return instanceVariable;
    }
    
    /**
     * Gets the class variable value
     */
    public static int getClassVariable() {
        return classVariable;
    }
    
    /**
     * Gets the constant value
     */
    public static double getPI() {
        return PI;
    }
}
