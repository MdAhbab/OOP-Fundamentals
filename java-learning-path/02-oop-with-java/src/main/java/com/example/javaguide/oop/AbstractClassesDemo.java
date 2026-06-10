package com.example.javaguide.oop;

/**
 * AbstractClassesDemo - Demonstrates abstract classes in Java.
 *
 * An abstract class:
 * - Cannot be instantiated (no "new Animal()" allowed)
 * - Can have both abstract methods (no body) AND concrete methods (with body)
 * - Can have constructors, fields, and static methods
 * - Forces subclasses to implement all abstract methods
 *
 * This demo covers:
 * - Basic abstract class (Animal with makeSound())
 * - Template Method Pattern (Report generation)
 * - Abstract class with constructor and fields (Vehicle)
 */
public class AbstractClassesDemo {
    
    public static void main(String[] args) {
        demonstrateBasicAbstractClass();
        demonstrateTemplateMethod();
        demonstrateAbstractWithConstructor();
    }
    
    public static void demonstrateBasicAbstractClass() {
        System.out.println("=== Basic Abstract Class ===");
        
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        dog.makeSound();
        dog.sleep();
        
        cat.makeSound();
        cat.sleep();
        System.out.println();
    }
    
    public static void demonstrateTemplateMethod() {
        System.out.println("=== Template Method Pattern ===");
        
        Report pdfReport = new PDFReport();
        Report excelReport = new ExcelReport();
        
        pdfReport.generate();
        excelReport.generate();
        System.out.println();
    }
    
    public static void demonstrateAbstractWithConstructor() {
        System.out.println("=== Abstract Class with Constructor ===");
        
        Vehicle car = new Car("Tesla Model 3", 4);
        Vehicle motorcycle = new Motorcycle("Harley Davidson", true);
        
        car.start();
        car.displayInfo();
        
        motorcycle.start();
        motorcycle.displayInfo();
        System.out.println();
    }
}

// Basic abstract class
abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    
    // Concrete method - inherited by all subclasses
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }
}

// Template Method Pattern
abstract class Report {
    // Template method - defines the algorithm structure
    public final void generate() {
        fetchData();
        formatData();
        createReport();
        saveReport();
    }
    
    // Common implementation
    private void fetchData() {
        System.out.println("Fetching data from database...");
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void formatData();
    protected abstract void createReport();
    
    // Hook method - can be overridden
    protected void saveReport() {
        System.out.println("Saving report to disk");
    }
}

class PDFReport extends Report {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for PDF");
    }
    
    @Override
    protected void createReport() {
        System.out.println("Creating PDF report");
    }
}

class ExcelReport extends Report {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for Excel");
    }
    
    @Override
    protected void createReport() {
        System.out.println("Creating Excel report");
    }
    
    @Override
    protected void saveReport() {
        System.out.println("Saving Excel report to SharePoint");
    }
}

// Abstract class with fields and constructors
abstract class Vehicle {
    protected String model;
    protected int year;
    
    public Vehicle(String model) {
        this.model = model;
        this.year = 2024; // Default year
    }
    
    public abstract void start();
    
    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }
    
    public String getModel() {
        return model;
    }
}

class Car extends Vehicle {
    private int doors;
    
    public Car(String model, int doors) {
        super(model);
        this.doors = doors;
    }
    
    @Override
    public void start() {
        System.out.println("Car starting with key ignition");
    }
    
    public int getDoors() {
        return doors;
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(String model, boolean hasSidecar) {
        super(model);
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle starting with kick start");
    }
    
    public boolean hasSidecar() {
        return hasSidecar;
    }
}
