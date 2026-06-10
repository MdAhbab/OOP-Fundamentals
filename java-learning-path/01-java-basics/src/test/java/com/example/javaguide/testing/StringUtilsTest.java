package com.example.javaguide.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils Tests")
class StringUtilsTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    @DisplayName("isEmpty should handle null, empty, and whitespace")
    void testIsEmpty(String input) {
        assertTrue(StringUtils.isEmpty(input));
    }
    
    @Test
    @DisplayName("isEmpty should return false for non-empty strings")
    void testIsNotEmpty() {
        assertFalse(StringUtils.isEmpty("Hello"));
        assertFalse(StringUtils.isEmpty(" Hello "));
    }
    
    @Test
    @DisplayName("Reverse should work correctly")
    void testReverse() {
        assertEquals("dcba", StringUtils.reverse("abcd"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "A man a plan a canal Panama", "Was it a car or a cat I saw"})
    @DisplayName("Palindromes should be detected")
    void testIsPalindrome(String input) {
        assertTrue(StringUtils.isPalindrome(input));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "java"})
    @DisplayName("Non-palindromes should be detected")
    void testIsNotPalindrome(String input) {
        assertFalse(StringUtils.isPalindrome(input));
    }
    
    @Test
    @DisplayName("Count vowels should work correctly")
    void testCountVowels() {
        assertEquals(2, StringUtils.countVowels("hello"));
        assertEquals(3, StringUtils.countVowels("beautiful"));
        assertEquals(0, StringUtils.countVowels("xyz"));
        assertEquals(0, StringUtils.countVowels(null));
    }
}
