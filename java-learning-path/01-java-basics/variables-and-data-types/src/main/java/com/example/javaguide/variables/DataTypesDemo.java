package com.example.javaguide.variables;

import java.util.Scanner;

/**
 * DataTypesDemo - Demonstrates all Java primitive data types
 * 
 * This class covers:
 * - All 8 primitive types
 * - Type conversion (implicit and explicit)
 * - Wrapper classes
 * - Type limits and ranges
 */
public class DataTypesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Data Types Demo ===\n");
        
        demonstratePrimitiveTypes();
        demonstrateTypeConversion();
        demonstrateWrapperClasses();
        demonstrateTypeLimits();

    }
    
    /**
     * Demonstrates all primitive data types
     */
    public static void demonstratePrimitiveTypes() {
        System.out.println("--- Primitive Data Types ---");
        
        // Integer types
        byte byteVar = 127;                    // 8-bit
        short shortVar = 32000;                // 16-bit
        int intVar = 2_000_000;                // 32-bit (underscores for readability)
        long longVar = 9_000_000_000L;         // 64-bit (L suffix required)
        
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        
        // Floating-point types
        float floatVar = 2.14f;                // 32-bit (f suffix required)
        double doubleVar = 3.14159265359;      // 64-bit
        
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        
        // Character type
        char charVar = 'A';                    // 16-bit Unicode
        System.out.println("char: " + charVar);
        System.out.println("char as int: " + (int)charVar); // ASCII value

        // Boolean type
        boolean boolVar = true;
        System.out.println("boolean: " + boolVar);
        
        System.out.println();
    }
    
    /**
     * Demonstrates type conversion (casting)
     */
    public static void demonstrateTypeConversion() {
        System.out.println("--- Type Conversion ---");
//        Scanner scanner = new Scanner(System.in);
//        float cated = scanner.nextInt();
        // Implicit conversion (widening) - automatic
        int intValue = 100;
        long longValue = intValue;              // int -> long (safe)
        double doubleValue = intValue;          // int -> double (safe)
        
        System.out.println("Implicit: int " + intValue + " -> long " + longValue);
        System.out.println("Implicit: int " + intValue + " -> double " + doubleValue);
        
        // Explicit conversion (narrowing) - requires casting
        double pi = 3.14159;
        int piInt = (int) pi;                   // Truncates decimal part
        
        System.out.println("Explicit: double " + pi + " -> int " + piInt);
        
        // Character conversions
        char letter = 'Z';
        int asciiValue = letter;                // char -> int (implicit)
        char fromAscii = (char) 90;            // int -> char (explicit)
        
        System.out.println("char '" + letter + "' -> int " + asciiValue);
        System.out.println("int 90 -> char '" + fromAscii + "'");
        
        System.out.println();
    }
    
    /**
     * Demonstrates wrapper classes for primitives
     */
    public static void demonstrateWrapperClasses() {
        System.out.println("--- Wrapper Classes ---");
        
        // Autoboxing: primitive -> wrapper
        Integer intObj = 42;                    // Auto-boxing
        Double doubleObj = 3.14;
        Boolean boolObj = true;
        
        System.out.println("Integer object: " + intObj);
        System.out.println("Double object: " + doubleObj);
        System.out.println("Boolean object: " + boolObj);
        
        // Unboxing: wrapper -> primitive
        int primitiveInt = intObj;              // Auto-unboxing
        double primitiveDouble = doubleObj;
        
        System.out.println("Unboxed int: " + primitiveInt);
        System.out.println("Unboxed double: " + primitiveDouble);
        
        // Utility methods in wrapper classes
        String numberStr = "123";
        int parsed = Integer.parseInt(numberStr);
        System.out.println("Parsed string '123' to int: " + parsed);
        
        System.out.println();
    }
    
    /**
     * Demonstrates type limits and ranges
     */
    public static void demonstrateTypeLimits() {
        System.out.println("--- Type Limits ---");
        
        System.out.println("Byte: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("Short: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("Integer: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Long: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("Float: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("Double: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("Character: " + (int)Character.MIN_VALUE + " to " + (int)Character.MAX_VALUE);
        
        // Demonstrate overflow
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("\nOverflow demonstration:");
        System.out.println("Byte.MAX_VALUE: " + maxByte);
        System.out.println("Byte.MAX_VALUE + 1: " + (byte)(maxByte + 1)); // Wraps to MIN_VALUE
    }
    
    /**
     * Calculates sum of different numeric types
     */
    public static double calculateSum(int a, double b) {
        return a + b; // int is implicitly converted to double
    }
}
