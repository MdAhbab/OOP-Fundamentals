package com.example.javaguide.oop;

/**
 * ClassesDemo - Demonstrates classes and objects in Java.
 *
 * A class is a blueprint/template that defines fields (data) and methods (behaviour).
 * An object is a concrete instance of a class created with the 'new' keyword.
 *
 * This demo covers:
 * - Class definition with fields and methods
 * - Constructor overloading (default, parameterized, single-arg)
 * - Getters and setters
 * - Copy constructors
 * - Object references vs objects themselves
 */
public class ClassesDemo {

    public static void main(String[] args) {
        demonstratePersonClass();
        demonstrateCarClass();
        demonstrateObjectReferences();
    }

    /**
     * Shows constructor overloading — multiple constructors accepting
     * different sets of parameters.
     */
    public static void demonstratePersonClass() {
        System.out.println("=== Person Class Demo ===");

        // Each 'new' call invokes a different constructor
        Person p1 = new Person("Alice", 25);  // (String, int) constructor
        Person p2 = new Person("Bob");         // (String) constructor
        Person p3 = new Person();              // no-arg constructor (delegates to ("Unknown", 0))

        p1.display();
        p2.display();
        p3.display();

        // Modify p3 through setter methods
        p3.setName("Charlie");
        p3.setAge(35);
        p3.display();
        System.out.println();
    }

    /**
     * Demonstrates a copy constructor — creating a new Car
     * by copying the fields of an existing one.
     */
    public static void demonstrateCarClass() {
        System.out.println("=== Car Class Demo ===");

        Car car1 = new Car("Toyota", "Camry", 2024);
        Car car2 = new Car(car1); // Copy constructor — car2 is a separate object

        car1.display();
        car2.display();

        car1.start();
        car1.stop();
        System.out.println();
    }

    /**
     * Shows how references work in Java.
     * Assigning one reference to another makes both point to the SAME object.
     */
    public static void demonstrateObjectReferences() {
        System.out.println("=== Object References ===");

        Person p1 = new Person("David", 40);
        Person p2 = p1;                         // p2 and p1 point to the SAME object
        Person p3 = new Person("David", 40);    // p3 is a DIFFERENT object with same data

        // == compares references (memory addresses), not field values
        System.out.println("p1 == p2: " + (p1 == p2)); // true — same reference
        System.out.println("p1 == p3: " + (p1 == p3)); // false — different objects

        // Since p2 is the same object as p1, modifying through p2 changes p1 too
        p2.setName("Modified");
        System.out.print("p1: "); p1.display(); // shows "Modified" — proof they're the same object
        System.out.print("p2: "); p2.display();
        System.out.println();
    }
}

/**
 * Person class demonstrating constructor overloading.
 *
 * Constructor chaining: the no-arg and single-arg constructors
 * delegate to the full (name, age) constructor via this(...).
 * This avoids repeating initialisation logic.
 */
class Person {
    private String name;
    private int age;

    // Default constructor — delegates to the 2-arg constructor
    public Person() {
        this("Unknown", 0);
    }

    // Full constructor — the one all others delegate to
    public Person(String name, int age) {
        this.name = name; // 'this' distinguishes field from parameter
        this.age = age;
    }

    // Constructor with name only — age defaults to 0
    public Person(String name) {
        this(name, 0);
    }

    // Getters and setters — provide controlled access to private fields
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Displays person info to the console
    public void display() {
        System.out.println("Person: " + name + ", " + age + " years old");
    }
}

/**
 * Car class demonstrating a copy constructor.
 *
 * A copy constructor creates a new object by copying fields from an existing object.
 * Unlike assignment (Car c2 = c1), a copy constructor creates a SEPARATE object in memory.
 */
class Car {
    private String make;
    private String model;
    private int year;

    // Primary constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Copy constructor — accepts another Car and copies its fields
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
