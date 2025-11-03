package com.example.javaguide.oop;

/**
 * PolymorphismDemo - Demonstrates polymorphism
 */
public class PolymorphismDemo {
    
    public static void main(String[] args) {
        demonstrateAnimalPolymorphism();
        demonstrateShapePolymorphism();
        demonstratePaymentPolymorphism();
    }
    
    public static void demonstrateAnimalPolymorphism() {
        System.out.println("=== Animal Polymorphism ===");

        Animal a1 = new Dog("Rex");
        a1.makeSound(); // Outputs: Rex says: Woof!
        Animal aa11 = new Animal("Generic Animal");
        aa11.makeSound(); // Outputs: Generic Animal makes a sound
        Dog d1 = new Dog("Donald");
        d1.makeSound(); // Outputs: Donald says: Woof!



        // Polymorphic references
        Animal[] animals = {
                new Dog("Buddy"),
                new Cat("Whiskers"),
                new Bird("Tweety"),
                new Animal("Generic Animal"),
                new Bird("Polly"),
                new Animal("Dog"),
                new Animal("Cat"),
        };
        for (int i = 0; i < animals.length; i++) {
            animals[i].makeSound(); // Dynamic method dispatch
        }
//        for (Animal i : animals) {
//            i.makeSound(); // Dynamic method dispatch
//            i.eat();
//        }
        System.out.println();
    }

    public static void demonstrateShapePolymorphism() {
        System.out.println("=== Shape Polymorphism ===");
        
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 5.0),
            new Triangle(3.0, 4.0)
        };

        
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + 
                             " area: " + shape.calculateArea());
        }
        System.out.println();
    }
    
    public static void demonstratePaymentPolymorphism() {
        System.out.println("=== Payment Polymorphism ===");
        
        Payment[] payments = {
            new CreditCardPayment("1234-5678-9012-3456"),
            new PayPalPayment("user@email.com"),
            new CashPayment()
        };
        
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
