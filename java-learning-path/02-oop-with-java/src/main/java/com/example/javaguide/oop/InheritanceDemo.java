package com.example.javaguide.oop;

/**
 * InheritanceDemo - Demonstrates inheritance concepts in Java.
 *
 * Inheritance allows a class (child/subclass) to acquire fields and methods
 * from another class (parent/superclass), promoting code reuse.
 *
 * This demo covers:
 * - Single-level inheritance (Dog extends Animal)
 * - Multilevel inheritance (SportsCar extends Car extends Vehicle)
 * - Constructor chaining with super()
 * - Method overriding (@Override)
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        demonstrateAnimalHierarchy();
        demonstrateVehicleHierarchy();
        demonstrateConstructorChaining();
    }

    /**
     * Shows single-level inheritance: Dog and Cat extend Animal.
     * Each subclass inherits common behaviour (sleep) and overrides specific behaviour (makeSound).
     */
    public static void demonstrateAnimalHierarchy() {
        System.out.println("=== Animal Hierarchy ===");

        // Base class instance – uses default implementations
        Animal animal = new Animal("Generic Animal");
        // Subclass instances – constructors chain to super(name)
        Dog dog = new Dog("Buddy", "Golden Retriever");
        Cat cat = new Cat("Whiskers", "Tabby");
        Zebra zebra = new Zebra("Marty");

        // Calls the base-class makeSound() – prints generic message
        animal.makeSound();
        animal.sleep();

        // Dog overrides both numberOfFeet() and makeSound()
        dog.numberOfFeet();
        dog.makeSound();
        dog.fetch(); // Dog-specific method not available through Animal reference

        cat.makeSound();
        cat.scratch();

        // Zebra inherits Animal's defaults (no overrides)
        zebra.makeSound();
        zebra.numberOfFeet();
        System.out.println();
    }

    /**
     * Shows a Vehicle hierarchy with Car and Motorcycle subclasses.
     */
    public static void demonstrateVehicleHierarchy() {
        System.out.println("=== Vehicle Hierarchy ===");

        Car car = new Car("Toyota", "Camry", 4);
        Motorcycle bike = new Motorcycle("Harley", "Sportster", true);

        // Each subclass inherits start() from Vehicle
        car.start();
        car.honk(); // Car-specific method

        bike.start();
        bike.wheelie(); // Motorcycle-specific method
        System.out.println();
    }

    /**
     * Demonstrates multilevel inheritance: SportsCar → Car → Vehicle.
     * Constructor chaining ensures each level is initialised via super().
     */
    public static void demonstrateConstructorChaining() {
        System.out.println("=== Constructor Chaining ===");

        // Constructor chain: SportsCar(brand, model, doors, topSpeed)
        //   → Car(brand, model, doors) → Vehicle(brand, model)
        SportsCar sportsCar = new SportsCar("Ferrari", "F8", 4, 340);
        sportsCar.displayInfo();
        System.out.println();
    }
}

// Base class – the parent that Dog, Cat, and Zebra inherit from
class Animal {
    // 'protected' so subclasses can access name directly
    protected String name;

    // Constructor – called first during any subclass instantiation
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called: " + name);
    }

    // Default sound – subclasses override this to provide specific sounds
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }

    // Concrete method inherited by all subclasses without change
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    /**
     * Prints the default number of feet for an animal.
     * Subclasses can override this for specific foot counts.
     */
    public void numberOfFeet() {
        // Default: unknown number of feet
        System.out.println(name + " has an unknown number of feet");
    }
}

/**
 * Zebra extends Animal without overriding any methods,
 * so it inherits all default behaviours from Animal.
 */
class Zebra extends Animal {
    public Zebra(String name) {
        super(name); // Calls Animal(String name)
    }
}
// Derived class – Dog IS-AN Animal
class Dog extends Animal {
    private String breed; // Dog-specific field

    public Dog(String name, String breed) {
        super(name); // Call parent constructor first
        this.breed = breed;
        System.out.println("Dog constructor called: " + breed);
    }

    // Override makeSound() to provide dog-specific behaviour
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    // Override numberOfFeet() – dogs have 4 feet
    @Override
    public void numberOfFeet() {
        System.out.println(name + " has 4 feet");
    }

    // Dog-specific method – not available through Animal reference
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }
}

// Another derived class – Cat IS-AN Animal
class Cat extends Animal {
    private String color; // Cat-specific field

    public Cat(String name, String color) {
        super(name); // Chains to Animal constructor
        this.color = color;
    }

    // Override makeSound() – cats meow instead of generic sound
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    // Cat-specific method
    public void scratch() {
        System.out.println(name + " is scratching");
    }
}

// ===== Vehicle hierarchy demonstrating multilevel inheritance =====

// Base class for all vehicles
class Vehicle {
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Common behaviour shared by all vehicles
    public void start() {
        System.out.println(brand + " " + model + " is starting");
    }
}

// Car extends Vehicle – adds door count and honk capability
class Car extends Vehicle {
    private int doors;

    public Car(String brand, String model, int doors) {
        super(brand, model); // Chains to Vehicle constructor
        this.doors = doors;
    }

    public void honk() {
        System.out.println("Beep beep!");
    }
}

// Motorcycle extends Vehicle – adds sidecar info and wheelie capability
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, boolean hasSidecar) {
        super(brand, model);
        this.hasSidecar = hasSidecar;
    }

    public void wheelie() {
        System.out.println("Performing a wheelie!");
    }
}

/**
 * Multilevel inheritance: SportsCar → Car → Vehicle.
 * Each level adds specialisation while inheriting everything above.
 */
class SportsCar extends Car {
    private int topSpeed;

    public SportsCar(String brand, String model, int doors, int topSpeed) {
        super(brand, model, doors); // Chains: Car → Vehicle
        this.topSpeed = topSpeed;
    }

    public void displayInfo() {
        System.out.println("Sports Car: " + brand + " " + model);
        System.out.println("Top Speed: " + topSpeed + " mph");
    }
}
