package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class AbstractionTest {
    
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
    @DisplayName("Salaried employee pay should be correct")
    void testSalariedEmployeePay() {
        Employee emp = new SalariedEmployee("Alice", 5000.0);
        assertEquals(5000.0, emp.calculatePay());
    }
    
    @Test
    @DisplayName("Hourly employee pay should calculate correctly")
    void testHourlyEmployeePay() {
        Employee emp = new HourlyEmployee("Bob", 20.0, 160);
        assertEquals(3200.0, emp.calculatePay());
    }
    
    @Test
    @DisplayName("Template method should execute without errors")
    void testTemplateMethod() {
        assertDoesNotThrow(() -> {
            DataProcessor processor = new CSVDataProcessor();
            processor.process();
        });
    }
    
    @Test
    @DisplayName("Shape color methods should work")
    void testShapeColor() {
        Shape circle = new Circle(3.0);
        assertEquals("black", circle.getColor());
        
        circle.setColor("red");
        assertEquals("red", circle.getColor());
    }
}
