package com.example.javaguide.oop;

/**
 * PolymorphismDemo - Demonstrates polymorphism in Java.
 *
 * Polymorphism ("many forms") lets a single reference type refer to objects
 * of different classes. The actual method that runs is determined at runtime
 * (dynamic method dispatch), not compile time.
 *
 * This demo covers:
 * - Runtime polymorphism via method overriding (Animal hierarchy)
 * - Abstract class polymorphism (Shape hierarchy)
 * - Polymorphic arrays and loops
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        demonstrateAnimalPolymorphism();
        demonstrateShapePolymorphism();
        demonstratePaymentPolymorphism();
    }

    /**
     * Animal references can point to any subclass (Dog, Cat, Bird, etc.).
     * The JVM resolves which makeSound() to call at runtime
     * based on the actual object type, NOT the reference type.
     */
    public static void demonstrateAnimalPolymorphism() {
        System.out.println("=== Animal Polymorphism ===");

        // 'Animal' reference, but actual object is Dog — calls Dog.makeSound()
        Animal polymorphicDog = new Animal("Generic Animal");
        polymorphicDog.makeSound();

        // Polymorphic array — one reference type, multiple object types
        Animal[] animals = {
                new Dog("Buddy"),
                new Cat("Whiskers"),
                new Bird("Tweety"),
                new Animal("Generic Animal"),
                new Bird("Polly"),
        };

        // Dynamic method dispatch: each call resolves to the correct subclass method
        for (Animal animal : animals) {
            animal.makeSound();
        }
        System.out.println();
    }

    /**
     * Shape is abstract — it cannot be instantiated.
     * Each concrete subclass (Circle, Rectangle, Triangle) provides
     * its own calculateArea() implementation.
     */
    public static void demonstrateShapePolymorphism() {
        System.out.println("=== Shape Polymorphism ===");

        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 5.0),
            new Triangle(3.0, 4.0)
        };

        // getClass().getSimpleName() reveals the actual runtime type
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() +
                             " area: " + shape.calculateArea());
        }
        System.out.println();
    }

    /**
     * Payment is abstract — each concrete strategy defines how payment works.
     * This is also the foundation of the Strategy design pattern.
     */
    public static void demonstratePaymentPolymorphism() {
        System.out.println("=== Payment Polymorphism ===");

        Payment[] payments = {
            new CreditCardPayment("1234-5678-9012-3456"),
            new PayPalPayment("user@email.com"),
            new CashPayment()
        };

        // Same method call, different behaviour depending on concrete type
        for (Payment payment : payments) {
            payment.processPayment(100.0);
        }
        System.out.println();
    }
}

// Animal hierarchy
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet!");
    }
}

// Shape hierarchy
abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Payment hierarchy
abstract class Payment {
    public abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}

class PayPalPayment extends Payment {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
    }
}

class CashPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment: $" + amount);
    }
}
