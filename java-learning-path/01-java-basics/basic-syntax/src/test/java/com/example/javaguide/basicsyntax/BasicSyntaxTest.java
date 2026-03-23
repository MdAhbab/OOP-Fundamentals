package com.example.javaguide.basicsyntax;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class BasicSyntaxTest {

    @Test
    @DisplayName("Gravity constant should be 9.81")
    void testGravityConstant() {
        assertEquals(9.81, BasicSyntaxDemo.getGravity(), 0.001);
    }

    @Test
    @DisplayName("Greeting constant should be 'Hello, Java!'")
    void testGreetingConstant() {
        assertEquals("Hello, Java!", BasicSyntaxDemo.getGreeting());
    }

    @Test
    @DisplayName("Widening cast int to double should preserve value")
    void testWidening() {
        assertEquals(42.0, BasicSyntaxDemo.widenIntToDouble(42));
        assertEquals(-10.0, BasicSyntaxDemo.widenIntToDouble(-10));
    }

    @Test
    @DisplayName("Narrowing cast double to int should truncate")
    void testNarrowing() {
        assertEquals(3, BasicSyntaxDemo.narrowDoubleToInt(3.99));
        assertEquals(-3, BasicSyntaxDemo.narrowDoubleToInt(-3.14));
    }

    @Test
    @DisplayName("Main method should run without errors")
    void testMainRuns() {
        assertDoesNotThrow(() -> BasicSyntaxDemo.main(new String[]{}));
    }
}
