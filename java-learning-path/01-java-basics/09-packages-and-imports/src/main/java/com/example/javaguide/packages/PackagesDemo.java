package com.example.javaguide.packages;

// Import specific classes from other packages
import com.example.javaguide.packages.util.Helper;
import com.example.javaguide.packages.model.Sample;

// Import from Java standard library
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Static import for constants and static methods
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/**
 * PackagesDemo - Demonstrates Java package organization, imports, and access modifiers.
 * 
 * This class covers:
 * - Specific class imports
 * - Statically importing constants and methods
 * - Standard library imports
 * - Public vs Package-Private access modifiers
 */
public class PackagesDemo {
    
    /**
     * Main method running all package demonstrations.
     */
    public static void main(String[] args) {
        System.out.println("=== Packages and Imports Demo ===\n");
        
        demonstratePackageUsage();
        demonstrateStaticImports();
        demonstrateStandardLibrary();
        demonstrateAccessModifiers();
    }
    /**
     * Demonstrates using classes imported from entirely different packages.
     */
    public static void demonstratePackageUsage() {
        System.out.println("--- Package Usage ---");

        // Using class from util package
        Helper helper = new Helper();
        helper.printMessage("Using Helper from util package");
        
        // Using class from model package
        Sample sample = new Sample("Sample Data");
        System.out.println("Sample value: " + sample.getValue());
        
        System.out.println();
    }
    /**
     * Demonstrates the use of static imports to directly call static fields 
     * and methods without specifying their class name.
     */
    public static void demonstrateStaticImports() {
        System.out.println("--- Static Imports ---");
        
        // Using statically imported constants
        System.out.println("PI value: " + PI);
        
        // Using statically imported methods
        double result = sqrt(16);
        System.out.println("Square root of 16: " + result);
        
        System.out.println();
    }
    /**
     * Demonstrates importing and utilizing classes from the Java standard library.
     */
    public static void demonstrateStandardLibrary() {
        System.out.println("--- Standard Library Imports ---");
        
        // Using ArrayList from java.util
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        
        System.out.println("Languages: " + list);
        
        System.out.println();
    }
    /**
     * Demonstrates visibility differences between public modifiers 
     * and default (package-private) access.
     */
    public static void demonstrateAccessModifiers() {
        System.out.println("--- Access Modifiers ---");
        
        // Public class - accessible from anywhere
        Sample publicSample = new Sample("Public");
        System.out.println("Public class accessible: " + publicSample.getValue());
        
        // Package-private (default) - accessible within same package
        PackagePrivateExample example = new PackagePrivateExample();
        example.display();
        
        System.out.println();
    }
}

/**
 * PackagePrivateExample is a package-private class (no modifier).
 * It is only accessible to other classes within the same package.
 */
class PackagePrivateExample {
    
    /**
     * Package-private method displaying a message.
     */
    void display() {
        System.out.println("This is a package-private class");
    }
}
