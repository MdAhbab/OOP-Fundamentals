package com.example.javaguide.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @AfterEach
    void tearDown() {
        calculator = null;
    }
    
    @Test
    @DisplayName("Addition should work correctly")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(0, 0));
        assertEquals(-1, calculator.add(2, -3));
    }
    
    @Test
    @DisplayName("Subtraction should work correctly")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(5, calculator.subtract(2, -3));
    }
    
    @Test
    @DisplayName("Multiplication should work correctly")
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-6, calculator.multiply(2, -3));
    }
    
    @Test
    @DisplayName("Division should work correctly")
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(2.5, calculator.divide(5, 2));
    }
    
    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120"
    })
    @DisplayName("Factorial should calculate correctly")
    void testFactorial(int input, int expected) {
        assertEquals(expected, calculator.factorial(input));
    }
    
    @Test
    @DisplayName("Factorial of negative should throw exception")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-1);
        });
    }
    
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    @DisplayName("Prime numbers should be detected")
    void testIsPrime(int number) {
        assertTrue(calculator.isPrime(number));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4, 6, 8, 9, 10})
    @DisplayName("Non-prime numbers should be detected")
    void testIsNotPrime(int number) {
        assertFalse(calculator.isPrime(number));
    }
    
    @Test
    @DisplayName("All assertions should pass")
    void testGroupedAssertions() {
        assertAll("calculator operations",
            () -> assertEquals(5, calculator.add(2, 3)),
            () -> assertEquals(1, calculator.subtract(3, 2)),
            () -> assertEquals(6, calculator.multiply(2, 3)),
            () -> assertEquals(2.0, calculator.divide(6, 3))
        );
    }
}
