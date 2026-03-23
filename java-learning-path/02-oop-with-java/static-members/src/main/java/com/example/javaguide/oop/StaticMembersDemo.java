package com.example.javaguide.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * StaticMembersDemo - Demonstrates static members in Java.
 *
 * 'static' means the member belongs to the CLASS, not to any particular instance.
 * Static fields are shared across all instances; static methods can be called
 * without creating an object.
 *
 * This demo covers:
 * - Static variables (shared state, object counting)
 * - Static methods (utility methods, no instance needed)
 * - Static initialization blocks (run once when class is loaded)
 * - Utility classes (private constructor, all-static methods)
 * - Singleton pattern using static
 * - Static factory methods
 * - Static vs instance members
 */
public class StaticMembersDemo {
    
    public static void main(String[] args) {
        demonstrateStaticVariables();
        demonstrateStaticMethods();
        demonstrateStaticBlocks();
        demonstrateUtilityClass();
    }
    
    public static void demonstrateStaticVariables() {
        System.out.println("=== Static Variables ===");
        
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        
        System.out.println("Total count: " + Counter.getCount()); // 3
        System.out.println();
    }
    
    public static void demonstrateStaticMethods() {
        System.out.println("=== Static Methods ===");
        
        // Static methods called via class name
        double area = MathUtils.circleArea(5.0);
        System.out.println("Circle area (radius 5): " + area);
        
        int max = MathUtils.max(10, 20);
        System.out.println("Max of 10 and 20: " + max);
        System.out.println();
    }
    
    public static void demonstrateStaticBlocks() {
        System.out.println("=== Static Initialization Blocks ===");
        
        System.out.println("Database URL: " + Database.getUrl());
        System.out.println("Initialization complete: " + Database.isInitialized());
        System.out.println();
    }
    
    public static void demonstrateUtilityClass() {
        System.out.println("=== Utility Class Example ===");
        
        String text = "hello world";
        System.out.println("Capitalize: " + StringUtils.capitalize(text));
        System.out.println("Is empty: " + StringUtils.isEmpty(""));
        System.out.println("Reverse: " + StringUtils.reverse(text));
        System.out.println();
    }
}

// Static variable example
class Counter {
    private static int count = 0; // Shared by all instances
    private int instanceId;
    
    public Counter() {
        instanceId = ++count;
    }
    
    public static int getCount() {
        return count;
    }
    
    public int getInstanceId() {
        return instanceId;
    }
    
    // Static method cannot access instance variables
    public static void reset() {
        count = 0;
        // Cannot do: instanceId = 0; // Compile error
    }
}

// Utility class with static methods
class MathUtils {
    private static final double PI = 3.14159265359;
    
    // Private constructor prevents instantiation
    private MathUtils() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static double circleArea(double radius) {
        return PI * radius * radius;
    }
    
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    public static int min(int a, int b) {
        return a < b ? a : b;
    }
    
    public static double average(int... numbers) {
        if (numbers.length == 0) return 0;
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}

// Static initialization block
class Database {
    private static String url;
    private static String username;
    private static boolean initialized;
    
    // Static initialization block - runs once when class is loaded
    static {
        System.out.println("Initializing Database configuration...");
        url = "jdbc:mysql://localhost:3306/mydb";
        username = "admin";
        initialized = true;
    }
    
    // Another static block (executed in order)
    static {
        System.out.println("Database static block 2");
    }
    
    public static String getUrl() {
        return url;
    }
    
    public static boolean isInitialized() {
        return initialized;
    }
}

// Singleton pattern using static
class Singleton {
    private static Singleton instance;
    
    private Singleton() {
        // Private constructor
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Thread-safe singleton (better approach)
class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

// Static factory method
class Employee {
    private String name;
    private String type;
    
    private Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    // Static factory methods
    public static Employee createManager(String name) {
        return new Employee(name, "Manager");
    }
    
    public static Employee createDeveloper(String name) {
        return new Employee(name, "Developer");
    }
    
    public String getName() { return name; }
    public String getType() { return type; }
}

// String utility class
class StringUtils {
    private StringUtils() {}
    
    public static String capitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    public static String reverse(String str) {
        if (isEmpty(str)) return str;
        return new StringBuilder(str).reverse().toString();
    }
}

// Static vs Instance example
class BankAccount {
    private static double interestRate = 0.05; // Static - same for all accounts
    private double balance; // Instance - unique per account
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    // Instance method - can access both static and instance members
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    // Static method - can only access static members
    public static void setInterestRate(double rate) {
        interestRate = rate;
        // Cannot access: balance // Compile error
    }
    
    public static double getInterestRate() {
        return interestRate;
    }
    
    public double getBalance() {
        return balance;
    }
}
