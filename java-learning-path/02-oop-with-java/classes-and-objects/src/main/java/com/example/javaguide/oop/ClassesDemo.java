package com.example.javaguide.oop;

/**
 * ClassesDemo - Demonstrates classes and objects
 */
public class ClassesDemo {
    
    public static void main(String[] args) {
        demonstratePersonClass();
        demonstrateCarClass();
        demonstrateObjectReferences();
    }
    
    public static void demonstratePersonClass() {
        System.out.println("=== Person Class Demo ===");
        
        // Create objects
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob");
        Person p3 = new Person();
        
        p1.display();
        p2.display();
        p3.display();
        
        // Modify using methods
        p3.setName("Charlie");
        p3.setAge(35);
        p3.display();
        System.out.println();
    }
    
    public static void demonstrateCarClass() {
        System.out.println("=== Car Class Demo ===");
        
        Car car1 = new Car("Toyota", "Camry", 2024);
        Car car2 = new Car(car1); // Copy constructor
        
        car1.display();
        car2.display();
        
        car1.start();
        car1.stop();
        System.out.println();
    }
    
    public static void demonstrateObjectReferences() {
        System.out.println("=== Object References ===");
        
        Person p1 = new Person("David", 40);
        Person p2 = p1;// Same reference
        Person p4 = new Person("Ahbab");
        Person p3 = new Person("David", 40); // Different object
        
        System.out.println("p1 == p2: " + (p1 == p2)); // true (same reference)
        System.out.println("p1 == p3: " + (p1 == p3)); // false (different objects)
        
        p2.setName("Modified");
        System.out.print("p1: "); p1.display();
        System.out.print("p2: "); p2.display();
        System.out.println();
    }
}

/**
 * Person class with constructor overloading
 */
class Person {
    private String name;
    private int age;
    
    // Default constructor
    public Person() {
        this("Unknown", 0);
    }
    
    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Constructor with name only
    public Person(String name) {
        this(name, 0);
    }
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public void display() {
        System.out.println("Person: " + name + ", " + age + " years old");
    }
}

/**
 * Car class demonstrating copy constructor
 */
class Car {
    private String make;
    private String model;
    private int year;
    
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    // Copy constructor
    public Car(Car other) {
        this.make = other.make;
        this.model = other.model;
        this.year = other.year;
    }
    
    public void start() {
        System.out.println(make + " " + model + " is starting...");
    }
    
    public void stop() {
        System.out.println(make + " " + model + " is stopping...");
    }
    
    public void display() {
        System.out.println("Car: " + make + " " + model + " (" + year + ")");
    }
    
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}
