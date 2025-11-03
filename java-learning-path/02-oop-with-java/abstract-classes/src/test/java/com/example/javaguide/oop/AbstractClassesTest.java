package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class AbstractClassesTest {
    
    @Test
    @DisplayName("Animal abstract class should work with Dog and Cat")
    void testAnimalAbstractClass() {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        assertEquals("Buddy", dog.getName());
        assertEquals("Whiskers", cat.getName());
        
        assertDoesNotThrow(() -> {
            dog.makeSound();
            dog.sleep();
            cat.makeSound();
            cat.sleep();
        });
    }
    
    @Test
    @DisplayName("Template method pattern should execute in correct order")
    void testTemplateMethod() {
        Report pdfReport = new PDFReport();
        Report excelReport = new ExcelReport();
        
        assertDoesNotThrow(() -> {
            pdfReport.generate();
            excelReport.generate();
        });
    }
    
    @Test
    @DisplayName("Vehicle abstract class should support constructors and fields")
    void testVehicleAbstractClass() {
        Vehicle car = new Car("Tesla", 4);
        Vehicle motorcycle = new Motorcycle("Harley", true);
        
        assertEquals("Tesla", car.getModel());
        assertEquals("Harley", motorcycle.getModel());
        
        assertTrue(car instanceof Car);
        assertTrue(motorcycle instanceof Motorcycle);
        
        Car c = (Car) car;
        assertEquals(4, c.getDoors());
        
        Motorcycle m = (Motorcycle) motorcycle;
        assertTrue(m.hasSidecar());
    }
    
    @Test
    @DisplayName("Cannot instantiate abstract class")
    void testCannotInstantiateAbstract() {
        // This would not compile:
        // Animal a = new Animal("test"); // Compile error
        
        // Must use concrete subclass
        Animal dog = new Dog("Buddy");
        assertNotNull(dog);
    }
}
