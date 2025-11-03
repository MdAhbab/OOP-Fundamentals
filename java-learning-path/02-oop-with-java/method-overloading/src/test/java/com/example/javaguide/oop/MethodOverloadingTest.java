package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MethodOverloadingTest {
    
    @Test
    @DisplayName("Calculator should overload add() correctly")
    void testCalculatorOverloading() {
        Calculator calc = new Calculator();
        
        assertEquals(8, calc.add(5, 3));
        assertEquals(8.7, calc.add(5.5, 3.2), 0.01);
        assertEquals(6, calc.add(1, 2, 3));
        assertEquals("Hello World", calc.add("Hello", "World"));
    }
    
    @Test
    @DisplayName("Person constructors should be overloaded")
    void testConstructorOverloading() {
        Person p1 = new Person();
        Person p2 = new Person("Alice");
        Person p3 = new Person("Bob", 30);
        
        assertNotNull(p1);
        assertNotNull(p2);
        assertNotNull(p3);
        
        assertTrue(p1.toString().contains("Unknown"));
        assertTrue(p2.toString().contains("Alice"));
        assertTrue(p3.toString().contains("Bob"));
    }
    
    @Test
    @DisplayName("Varargs should work with overloading")
    void testVarargsOverloading() {
        Printer printer = new Printer();
        
        assertDoesNotThrow(() -> {
            printer.print(42);
            printer.print("Test");
            printer.print(1, 2, 3);
            printer.print("A", "B");
        });
    }
    
    @Test
    @DisplayName("Type promotion should select correct overload")
    void testTypePromotion() {
        TypePromotionDemo demo = new TypePromotionDemo();
        
        byte b = 10;
        short s = 20;
        int i = 30;
        long l = 40L;
        double d = 50.0;
        
        assertDoesNotThrow(() -> {
            demo.process(b);  // Promotes to int
            demo.process(s);  // Promotes to int
            demo.process(i);  // Exact match
            demo.process(l);  // Exact match
            demo.process(d);  // Exact match
        });
    }
    
    @Test
    @DisplayName("DistanceCalculator should calculate correctly")
    void testDistanceCalculator() {
        DistanceCalculator calc = new DistanceCalculator();
        
        assertEquals(5.0, calc.distance(3, 4), 0.01);
        assertEquals(5.0, calc.distance(3.0, 4.0), 0.01);
        
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assertEquals(5.0, calc.distance(p1, p2), 0.01);
    }
}
