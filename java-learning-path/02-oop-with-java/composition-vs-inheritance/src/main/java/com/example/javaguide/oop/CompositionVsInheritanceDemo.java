package com.example.javaguide.oop;

/**
 * CompositionVsInheritanceDemo - Demonstrates composition vs inheritance
 */
public class CompositionVsInheritanceDemo {
    
    public static void main(String[] args) {
        demonstrateInheritance();
        demonstrateComposition();
        demonstrateDelegation();
        demonstrateFlexibility();
    }
    
    public static void demonstrateInheritance() {
        System.out.println("=== Inheritance Approach ===");
        
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        System.out.println();
    }
    
    public static void demonstrateComposition() {
        System.out.println("=== Composition Approach ===");
        
        Car car = new Car(new Engine());
        car.start();
        car.drive();
        System.out.println();
    }
    
    public static void demonstrateDelegation() {
        System.out.println("=== Delegation Pattern ===");
        
        Printer printer = new Printer(new Scanner(), new InkjetPrintEngine());
        printer.scan("document.pdf");
        printer.print("Hello World");
        System.out.println();
    }
    
    public static void demonstrateFlexibility() {
        System.out.println("=== Flexibility with Composition ===");
        
        // Can easily change behavior at runtime
        Bird bird = new Bird(new WingFlyBehavior());
        bird.performFly();
        
        Fish fish = new Fish(new FinSwimBehavior());
        fish.performSwim();
        System.out.println();
    }
}

// ========== Inheritance Example ==========
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
    
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Dog barks");
    }
}

// ========== Composition Example ==========
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    
    public void stop() {
        System.out.println("Engine stopped");
    }
}

class Car {
    private Engine engine; // HAS-A relationship
    
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    public void start() {
        engine.start();
        System.out.println("Car is ready to drive");
    }
    
    public void drive() {
        System.out.println("Car is driving");
    }
    
    public void stop() {
        engine.stop();
        System.out.println("Car stopped");
    }
}

// ========== Delegation Pattern ==========
interface ScanCapability {
    void scan(String document);
}

interface PrintCapability {
    void print(String content);
}

class Scanner implements ScanCapability {
    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }
}

class InkjetPrintEngine implements PrintCapability {
    @Override
    public void print(String content) {
        System.out.println("Inkjet printing: " + content);
    }
}

class LaserPrintEngine implements PrintCapability {
    @Override
    public void print(String content) {
        System.out.println("Laser printing: " + content);
    }
}

class Printer {
    private ScanCapability scanner;
    private PrintCapability printEngine;
    
    public Printer(ScanCapability scanner, PrintCapability printEngine) {
        this.scanner = scanner;
        this.printEngine = printEngine;
    }
    
    // Delegate to composed objects
    public void scan(String document) {
        scanner.scan(document);
    }
    
    public void print(String content) {
        printEngine.print(content);
    }
}

// ========== Strategy Pattern with Composition ==========
interface FlyBehavior {
    void fly();
}

interface SwimBehavior {
    void swim();
}

class WingFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Cannot fly");
    }
}

class FinSwimBehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("Swimming with fins");
    }
}

class Bird {
    private FlyBehavior flyBehavior;
    
    public Bird(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    
    public void performFly() {
        flyBehavior.fly();
    }
    
    // Can change behavior at runtime
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

class Fish {
    private SwimBehavior swimBehavior;
    
    public Fish(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }
    
    public void performSwim() {
        swimBehavior.swim();
    }
}

// ========== Problem with Inheritance ==========
// What if we need a FlyingFish? Multiple inheritance not allowed in Java!
// Solution: Use composition

class FlyingFish {
    private FlyBehavior flyBehavior;
    private SwimBehavior swimBehavior;
    
    public FlyingFish() {
        this.flyBehavior = new WingFlyBehavior();
        this.swimBehavior = new FinSwimBehavior();
    }
    
    public void performFly() {
        flyBehavior.fly();
    }
    
    public void performSwim() {
        swimBehavior.swim();
    }
}

// ========== Real-World Example: Employee System ==========
class Address {
    private String street;
    private String city;
    
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    
    public String getFullAddress() {
        return street + ", " + city;
    }
}

class Employee {
    private String name;
    private Address address; // Composition - Employee HAS-AN Address
    
    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    public String getEmployeeInfo() {
        return "Employee: " + name + ", Address: " + address.getFullAddress();
    }
}
