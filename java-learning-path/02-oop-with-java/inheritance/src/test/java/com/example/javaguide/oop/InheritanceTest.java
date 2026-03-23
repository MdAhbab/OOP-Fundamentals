package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class InheritanceTest {

    @Test
    @DisplayName("Dog should inherit from Animal")
    void testDogInheritance() {
        Dog dog = new Dog("Buddy", "Labrador");
        assertTrue(dog instanceof Animal);
        assertTrue(dog instanceof Dog);
    }

    @Test
    @DisplayName("Cat should inherit from Animal")
    void testCatInheritance() {
        Cat cat = new Cat("Whiskers", "Orange");
        assertTrue(cat instanceof Animal);
        assertTrue(cat instanceof Cat);
    }

    @Test
    @DisplayName("Car should inherit from Vehicle")
    void testCarInheritance() {
        Car car = new Car("Honda", "Civic", 4);
        assertTrue(car instanceof Vehicle);
        assertTrue(car instanceof Car);
    }

    @Test
    @DisplayName("SportsCar should have multilevel inheritance")
    void testMultilevelInheritance() {
        SportsCar sportsCar = new SportsCar("Porsche", "911", 2, 300);

        assertTrue(sportsCar instanceof SportsCar);
        assertTrue(sportsCar instanceof Car);
        assertTrue(sportsCar instanceof Vehicle);
    }

    @Test
    @DisplayName("Methods should execute without errors")
    void testMethods() {
        assertDoesNotThrow(() -> {
            Dog dog = new Dog("Max", "Beagle");
            dog.makeSound();
            dog.sleep();
            dog.fetch();
            dog.numberOfFeet();
        });
    }
}

