package com.example.javaguide.methods;

/**
 * ParametersDemo - Additional parameter passing examples
 */
public class ParametersDemo {
    
    public static void main(String[] args) {
        demonstrateObjectParameters();
    }
    
    public static void demonstrateObjectParameters() {
        System.out.println("=== Object Parameters ===");
        
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Before: " + sb);
        
        modifyStringBuilder(sb);
        System.out.println("After: " + sb); // Modified!
        
        // This works because reference is copied, but points to same object
    }
    
    public static void modifyStringBuilder(StringBuilder builder) {
        builder.append(" World");
    }
    
    /**
     * Swaps two integers (won't work due to pass-by-value)
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        // Changes are local only
    }
    
    /**
     * Calculates average of numbers
     */
    public static double average(int... numbers) {
        if (numbers.length == 0) return 0;
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}
