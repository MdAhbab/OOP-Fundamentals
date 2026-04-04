package com.example.javaguide.oop;

import java.util.Objects;

/**
 * MethodOverridingDemo - Demonstrates method overriding in Java.
 *
 * Method overriding: a subclass provides a specific implementation
 * for a method already defined in its superclass. The method has the
 * same name, parameters, and return type (or covariant return type).
 *
 * This demo covers:
 * - Basic @Override usage
 * - Runtime polymorphism (dynamic method dispatch)
 * - Covariant return types
 * - Overriding Object methods (toString, equals, hashCode)
 * - Access modifier rules for overriding
 * - Final methods (cannot be overridden)
 */
public class MethodOverridingDemo {
    
    public static void main(String[] args) {
        demonstrateBasicOverriding();
        demonstrateRuntimePolymorphism();
        demonstrateCovariantReturnType();
        demonstrateObjectMethodsOverriding();
    }
    
    public static void demonstrateBasicOverriding() {
        System.out.println("=== Basic Method Overriding ===");
        
        Animal animal = new Animal();
        Animal dog = new Dog();
        
        animal.makeSound(); // Calls Animal's method
        dog.makeSound();    // Calls Dog's overridden method
        System.out.println();
    }
    
    public static void demonstrateRuntimePolymorphism() {
        System.out.println("=== Runtime Polymorphism ===");
        
        // Array of Animal references
        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Bird()
        };
        
        // Method call resolved at runtime based on actual object type
        for (Animal animal : animals) {
            animal.makeSound();
        }
        System.out.println();
    }
    
    public static void demonstrateCovariantReturnType() {
        System.out.println("=== Covariant Return Type ===");
        
        AnimalFactory factory = new DogFactory();
        Animal animal = factory.createAnimal();
        animal.makeSound();
        
        // Can use more specific return type
        DogFactory dogFactory = new DogFactory();
        Dog dog = dogFactory.createAnimal(); // Returns Dog, not Animal
        dog.makeSound();
        System.out.println();
    }
    
    public static void demonstrateObjectMethodsOverriding() {
        System.out.println("=== Object Methods Overriding ===");
        
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);
        
        // toString() override
        System.out.println(p1);
        
        // equals() override
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        
        // hashCode() override
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode()); // Same as p1
        System.out.println();
    }
}

// Basic overriding
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    public void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof!");
    }
    
    @Override
    public void eat() {
        super.eat(); // Call parent method
        System.out.println("Dog eats dog food");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow!");
    }
}

class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bird chirps: Tweet!");
    }
}

// Covariant return type (Java 5+)
class AnimalFactory {
    public Animal createAnimal() {
        return new Animal();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    public Dog createAnimal() { // Covariant return type
        return new Dog();
    }
}

// Overriding Object methods
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}

// Access modifier rules
class Parent {
    protected void method1() {
        System.out.println("Parent method1");
    }
    
    public void method2() {
        System.out.println("Parent method2");
    }
}

class Child extends Parent {
    @Override
    public void method1() { // Can widen from protected to public
        System.out.println("Child method1");
    }
    
    @Override
    public void method2() { // Same access modifier
        System.out.println("Child method2");
    }
    
    // Cannot do this - narrowing access:
    // @Override
    // protected void method2() { } // Compile error
}

// Final methods cannot be overridden
class FinalMethodExample {
    public final void cannotOverride() {
        System.out.println("This method cannot be overridden");
    }
}

class SubClass extends FinalMethodExample {
    // This would not compile:
    // @Override
    // public void cannotOverride() { } // Compile error
}
