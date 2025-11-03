package com.example.javaguide.strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    
    @Test
    @DisplayName("Palindrome check should work correctly")
    void testIsPalindrome() {
        assertTrue(StringsDemo.isPalindrome("racecar"));
        assertTrue(StringsDemo.isPalindrome("A man a plan a canal Panama"));
        assertFalse(StringsDemo.isPalindrome("hello"));
        assertTrue(StringsDemo.isPalindrome(""));
    }
    
    @Test
    @DisplayName("Count vowels should work correctly")
    void testCountVowels() {
        assertEquals(3, StringsDemo.countVowels("hello"));
        assertEquals(5, StringsDemo.countVowels("aeiou"));
        assertEquals(0, StringsDemo.countVowels("xyz"));
        assertEquals(2, StringsDemo.countVowels("HELLO"));
    }
    
    @Test
    @DisplayName("Reverse string should work correctly")
    void testReverse() {
        assertEquals("olleh", StringsDemo.reverse("hello"));
        assertEquals("", StringsDemo.reverse(""));
        assertEquals("a", StringsDemo.reverse("a"));
    }
    
    @Test
    @DisplayName("Anagram check should work correctly")
    void testIsAnagram() {
        assertTrue(StringsDemo.isAnagram("listen", "silent"));
        assertTrue(StringsDemo.isAnagram("evil", "vile"));
        assertFalse(StringsDemo.isAnagram("hello", "world"));
        assertTrue(StringsDemo.isAnagram("", ""));
    }
    
    @Test
    @DisplayName("String comparison should work correctly")
    void testStringComparison() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        
        assertTrue(s1.equals(s2));
        assertTrue(s1.equals(s3));
        assertSame(s1, s2);           // Same object in pool
        assertNotSame(s1, s3);        // Different objects
    }
    
    @Test
    @DisplayName("StringBuilder concatenation should work")
    void testConcatenateWithBuilder() {
        String result = StringBuilderDemo.concatenateWithBuilder("Hello", " ", "World", "!");
        assertEquals("Hello World!", result);
        
        result = StringBuilderDemo.concatenateWithBuilder();
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("String methods should work correctly")
    void testStringMethods() {
        String text = "  Hello World  ";
        
        assertEquals(15, text.length());
        assertEquals("Hello World", text.trim());
        assertTrue(text.contains("World"));
        assertTrue(text.trim().startsWith("Hello"));
        assertTrue(text.trim().endsWith("World"));
    }
}
