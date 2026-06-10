package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MethodOverridingTest {
    
    @Test
    @DisplayName("Method overriding should call correct method at runtime")
    void testRuntimePolymorphism() {
        Animal animal = new Dog();
        
        // Even though reference is Animal, Dog's method is called
        assertDoesNotThrow(() -> animal.makeSound());
        assertTrue(animal instanceof Dog);
    }
    
    @Test
    @DisplayName("Covariant return type should work")
    void testCovariantReturnType() {
        DogFactory factory = new DogFactory();
        Dog dog = factory.createAnimal(); // Returns Dog, not Animal
        
        assertNotNull(dog);
        assertTrue(dog instanceof Dog);
        assertTrue(dog instanceof Animal);
    }
    
    @Test
    @DisplayName("toString() override should work")
    void testToStringOverride() {
        Person person = new Person("Alice", 30);
        String str = person.toString();
        
        assertTrue(str.contains("Alice"));
        assertTrue(str.contains("30"));
    }
    
    @Test
    @DisplayName("equals() override should work correctly")
    void testEqualsOverride() {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);
        
        assertEquals(p1, p2); // Same content
        assertNotEquals(p1, p3); // Different content
        
        // Reflexive
        assertEquals(p1, p1);
        
        // Symmetric
        assertEquals(p1, p2);
        assertEquals(p2, p1);
        
        // Null check
        assertNotEquals(p1, null);
    }
    
    @Test
    @DisplayName("hashCode() override should be consistent with equals()")
    void testHashCodeOverride() {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        
        // Equal objects must have same hash code
        assertEquals(p1.hashCode(), p2.hashCode());
        
        // Same object always returns same hash code
        assertEquals(p1.hashCode(), p1.hashCode());
    }
    
    @Test
    @DisplayName("super keyword should call parent method")
    void testSuperKeyword() {
        Dog dog = new Dog();
        
        // Dog's eat() calls super.eat()
        assertDoesNotThrow(() -> dog.eat());
    }
}
