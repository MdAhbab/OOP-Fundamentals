package com.example.javaguide.strings;

/**
 * StringsDemo - Demonstrates String class and operations
 */
public class StringsDemo {
    
    public static void main(String[] args) {
        demonstrateBasics();
        demonstrateMethods();
        demonstrateComparison();
        demonstrateFormatting();
    }
    
    public static void demonstrateBasics() {
        System.out.println("=== String Basics ===");
        
        // String creation
        String s1 = "Hello";                    // String literal (in pool)
        String s2 = new String("Hello");        // New object
        String s3 = "Hello";                    // Reuses from pool
        
        System.out.println("s1 == s3: " + (s1 == s3));           // true (same reference)
        System.out.println("s1 == s2: " + (s1 == s2));           // false (different objects)
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // true (same content)
        
        // String immutability
        String original = "Hello";
        String modified = original.concat(" World");
        System.out.println("Original: " + original);    // Still "Hello"
        System.out.println("Modified: " + modified);    // "Hello World"
        System.out.println();
    }
    
    public static void demonstrateMethods() {
        System.out.println("=== String Methods ===");
        
        String text = "  Hello, World!  ";
        
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Replace: " + text.replace("World", "Java"));
        
        // Substring
        System.out.println("Substring(2, 7): " + text.trim().substring(2, 7));
        
        // Character access
        System.out.println("CharAt(0): " + text.trim().charAt(0));
        
        // Check methods
        System.out.println("Starts with 'Hello': " + text.trim().startsWith("Hello"));
        System.out.println("Contains 'World': " + text.contains("World"));
        
        // Split
        String csv = "apple,banana,orange";
        String[] fruits = csv.split(",");
        System.out.println("Split result: " + java.util.Arrays.toString(fruits));
        System.out.println();
    }
    
    public static void demonstrateComparison() {
        System.out.println("=== String Comparison ===");
        
        String s1 = "apple";
        String s2 = "banana";
        String s3 = "apple";
        
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1.equalsIgnoreCase('APPLE'): " + s1.equalsIgnoreCase("APPLE"));
        
        int comparison = s1.compareTo(s2);
        System.out.println("s1.compareTo(s2): " + comparison + " (negative = before)");
        System.out.println();
    }
    
    public static void demonstrateFormatting() {
        System.out.println("=== String Formatting ===");
        
        String name = "Alice";
        int age = 30;
        double salary = 50000.50;
        
        // String.format()
        String formatted = String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary);
        System.out.println(formatted);
        
        // printf
        System.out.printf("Name: %s, Age: %d%n", name, age);
        
        // Text blocks (Java 15+)
        String json = """
                {
                    "name": "%s",
                    "age": %d
                }
                """.formatted(name, age);
        System.out.println("JSON:");
        System.out.println(json);
    }
    
    // Utility methods
    
    public static boolean isPalindrome(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        return java.util.Arrays.equals(arr1, arr2);
    }
}
