package com.example.javaguide.testing;

/**
 * StringUtils - String utility methods for testing
 */
public class StringUtils {
    
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
    
    public static int countVowels(String str) {
        if (str == null) return 0;
        return (int) str.toLowerCase()
            .chars()
            .filter(c -> "aeiou".indexOf(c) != -1)
            .count();
    }
}
