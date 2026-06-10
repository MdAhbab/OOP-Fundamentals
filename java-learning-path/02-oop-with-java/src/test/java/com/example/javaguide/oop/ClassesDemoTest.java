package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ClassesDemoTest {
    
    @Test
    @DisplayName("Person should be created with all constructors")
    void testPersonConstructors() {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob");
        Person p3 = new Person();
        
        assertEquals("Alice", p1.getName());
        assertEquals(25, p1.getAge());
        
        assertEquals("Bob", p2.getName());
        assertEquals(0, p2.getAge());
        
        assertEquals("Unknown", p3.getName());
        assertEquals(0, p3.getAge());
    }
    
    @Test
    @DisplayName("Person setters should modify fields")
    void testPersonSetters() {
        Person p = new Person();
        p.setName("Charlie");
        p.setAge(30);
        
        assertEquals("Charlie", p.getName());
        assertEquals(30, p.getAge());
    }
    
    @Test
    @DisplayName("Car copy constructor should create identical car")
    void testCarCopyConstructor() {
        Car original = new Car("Toyota", "Camry", 2024);
        Car copy = new Car(original);
        
        assertEquals(original.getMake(), copy.getMake());
        assertEquals(original.getModel(), copy.getModel());
        assertEquals(original.getYear(), copy.getYear());
    }
    
    @Test
    @DisplayName("Car methods should execute without errors")
    void testCarMethods() {
        Car car = new Car("Honda", "Accord", 2023);
        
        assertDoesNotThrow(() -> {
            car.start();
            car.stop();
            car.display();
        });
    }
}
