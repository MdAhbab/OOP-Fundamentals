package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PolymorphismTest {
    
    @Test
    @DisplayName("Polymorphic references should work")
    void testPolymorphicReferences() {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        assertTrue(dog instanceof Animal);
        assertTrue(dog instanceof Dog);
        assertTrue(cat instanceof Animal);
        assertTrue(cat instanceof Cat);
    }
    
    @Test
    @DisplayName("Circle area should calculate correctly")
    void testCircleArea() {
        Shape circle = new Circle(5.0);
        double area = circle.calculateArea();
        
        assertEquals(Math.PI * 25, area, 0.01);
    }
    
    @Test
    @DisplayName("Rectangle area should calculate correctly")
    void testRectangleArea() {
        Shape rectangle = new Rectangle(4.0, 5.0);
        double area = rectangle.calculateArea();
        
        assertEquals(20.0, area, 0.01);
    }
    
    @Test
    @DisplayName("Triangle area should calculate correctly")
    void testTriangleArea() {
        Shape triangle = new Triangle(6.0, 4.0);
        double area = triangle.calculateArea();
        
        assertEquals(12.0, area, 0.01);
    }
    
    @Test
    @DisplayName("Payments should process without errors")
    void testPayments() {
        assertDoesNotThrow(() -> {
            Payment cc = new CreditCardPayment("1234");
            Payment paypal = new PayPalPayment("test@test.com");
            Payment cash = new CashPayment();
            
            cc.processPayment(100.0);
            paypal.processPayment(50.0);
            cash.processPayment(25.0);
        });
    }
}
