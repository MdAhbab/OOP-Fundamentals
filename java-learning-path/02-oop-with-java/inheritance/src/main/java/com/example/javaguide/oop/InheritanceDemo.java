package com.example.javaguide.oop;

/**
 * InheritanceDemo - Demonstrates inheritance concepts
 */
public class InheritanceDemo {
    
    public static void main(String[] args) {
        demonstrateAnimalHierarchy();
        demonstrateVehicleHierarchy();
        demonstrateConstructorChaining();
    }
    
    public static void demonstrateAnimalHierarchy() {
        System.out.println("=== Animal Hierarchy ===");
        
        Animal animal = new Animal("Generic Animal");
        Dog dog = new Dog("Buddy", "Golden Retriever");
        Cat cat = new Cat("Whiskers", "Tabby");
        Zebra z = new Zebra("Marty");
        z.
        
        animal.makeSound();
        animal.sleep();

        dog.NoOfFeets();
        dog.makeSound();
        //dog.fetch();
        
        cat.makeSound();
        cat.scratch();
        System.out.println();
    }
    
    public static void demonstrateVehicleHierarchy() {
        System.out.println("=== Vehicle Hierarchy ===");
        
        Car car = new Car("Toyota", "Camry", 4);
        Motorcycle bike = new Motorcycle("Harley", "Sportster", true);
        
        car.start();
        car.honk();
        
        bike.start();
        bike.wheelie();
        System.out.println();
    }
    
    public static void demonstrateConstructorChaining() {
        System.out.println("=== Constructor Chaining ===");
        
        // Constructor chaining: SportsCar -> Car -> Vehicle
        SportsCar sportsCar = new SportsCar("Ferrari", "F8", 4, 340);
        sportsCar.displayInfo();
        System.out.println();
    }
}

// Base class
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called: " + name);
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    public void NoOfFeets(){
        int feets = 0;
        System.out.println(name + " have" +feets+" number of feets");
    }
}

class Zebra extends Animal {
    public Zebra(String name) {
        super(name);
    }

}
// Derived class
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name); // Call parent constructor
        this.breed = breed;
        System.out.println("Dog constructor called: " + breed);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
    @Override
    public void NoOfFeets(){
        System.out.println(name + " have 4 feets");
    }
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }

}

// Another derived class
class Cat extends Animal {
    private String color;
    
    public Cat(String name, String color) {
        super(name);
        this.color = color;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    public void scratch() {
        System.out.println(name + " is scratching");
    }
}

// Vehicle hierarchy
class Vehicle {
    protected String brand;
    protected String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    public void start() {
        System.out.println(brand + " " + model + " is starting");
    }
}

class Car extends Vehicle {
    private int doors;
    
    public Car(String brand, String model, int doors) {
        super(brand, model);
        this.doors = doors;
    }
    
    public void honk() {
        System.out.println("Beep beep!");
    }
}

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

// Multilevel inheritance
class SportsCar extends Car {
    private int topSpeed;
    
    public SportsCar(String brand, String model, int doors, int topSpeed) {
        super(brand, model, doors);
        this.topSpeed = topSpeed;
    }
    
    public void displayInfo() {
        System.out.println("Sports Car: " + brand + " " + model);
        System.out.println("Top Speed: " + topSpeed + " mph");
    }
}
