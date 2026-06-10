package com.example.javaguide.testing;

/**
 * StringUtils - String utility methods designed specifically for unit testing demonstrations.
 * 
 * Provides static methods covering common string operations like empty checks, reversals,
 * palindrome validation, and character filtering algorithms natively mechanically.
 */
public class StringUtils {
    
    /**
     * Checks whether a sequence contains elements conditionally explicitly missing spaces natively.
     * 
     * @param str Validated string target sequence
     * @return True natively whenever parameter limits strictly match nulls conditionally structurally.
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Reverses character boundaries completely translating structurally.
     * 
     * @param str Input sequentially formatted string
     * @return Fully reversed parameter dynamically structurally generated
     */
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Mathematically measures palindrome patterns symmetrically verifying mirrored bounds sequentially natively.
     * 
     * @param str Tested reference mapped string
     * @return True specifically whenever limits match palindrome geometries
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
    
    /**
     * Filters char boundaries sequentially accumulating vowels specifically mapped natively.
     * 
     * @param str Validated element parameter sequence
     * @return Integer total capturing counted vowels universally dynamically
     */
    public static int countVowels(String str) {
        if (str == null) return 0;
        return (int) str.toLowerCase()
            .chars()
            .filter(c -> "aeiou".indexOf(c) != -1)
            .count();
    }
}
