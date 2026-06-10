package com.example.javaguide.oop;

/**
 * InterfacesDemo - Demonstrates interfaces in Java.
 *
 * Interfaces define contracts (abstract method signatures) that classes must implement.
 *
 * This demo covers:
 * - Basic interface implementation
 * - Implementing multiple interfaces (SmartPhone)
 * - Default and static methods in interfaces (Java 8+)
 * - Functional interfaces and lambda expressions
 * - Comparable interface for natural ordering
 */
public class InterfacesDemo {

    public static void main(String[] args) {
        demonstrateBasicInterfaces();
        demonstrateMultipleInterfaces();
        demonstrateDefaultMethods();
        demonstrateFunctionalInterface();
    }

    /**
     * A class implements an interface using the 'implements' keyword
     * and must provide concrete implementations for all abstract methods.
     */
    public static void demonstrateBasicInterfaces() {
        System.out.println("=== Basic Interfaces ===");

        // Polymorphic references via interface type
        Drawable circle = new Circle(5.0);
        Drawable rectangle = new Rectangle(4.0, 6.0);

        circle.draw();     // Calls Circle's implementation
        rectangle.draw();  // Calls Rectangle's implementation
        System.out.println();
    }

    /**
     * A single class can implement multiple interfaces,
     * achieving a form of multiple inheritance of behaviour.
     */
    public static void demonstrateMultipleInterfaces() {
        System.out.println("=== Multiple Interfaces ===");

        SmartPhone phone = new SmartPhone();
        phone.displayInfo();               // SmartPhone's own method
        phone.call("123-456-7890");         // From Phone interface
        phone.takePicture();               // From Camera interface
        phone.browseInternet("www.example.com"); // From WebBrowser interface
        System.out.println();
    }

    /**
     * Java 8+ allows interfaces to have 'default' methods with a body.
     * Classes can use the default or override it.
     */
    public static void demonstrateDefaultMethods() {
        System.out.println("=== Default Methods ===");

        MusicPlayer player = new MP3Player();
        player.play();
        player.pause(); // Uses the default method from the interface
        player.stop();
        System.out.println();
    }

    /**
     * A functional interface has exactly one abstract method,
     * so it can be implemented using a lambda expression.
     */
    public static void demonstrateFunctionalInterface() {
        System.out.println("=== Functional Interface ===");

        // Lambda expressions replace anonymous inner classes for functional interfaces
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
        System.out.println();
    }
}

// Basic interface
interface Drawable {
    void draw(); // Abstract method
}

class Circle implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing circle with radius " + radius);
    }
}

class Rectangle implements Drawable {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing rectangle " + width + "x" + height);
    }
}

// ===== Multiple interfaces =====

// Each interface defines a single capability contract
interface Phone {
    void call(String number);
}

interface Camera {
    void takePicture();
}

interface WebBrowser {
    void browseInternet(String url);
}

/**
 * SmartPhone implements all three interfaces, demonstrating that
 * a single class can fulfil multiple contracts simultaneously.
 */
class SmartPhone implements Phone, Camera, WebBrowser {

    /**
     * Prints basic device information.
     * This is a regular method (not from any interface).
     */
    public void displayInfo() {
        System.out.println("SmartPhone: All-in-one device");
    }

    // Fulfilling the Phone contract
    @Override
    public void call(String number) {
        System.out.println("Calling " + number);
    }

    // Fulfilling the Camera contract
    @Override
    public void takePicture() {
        System.out.println("Taking picture");
    }

    // Fulfilling the WebBrowser contract
    @Override
    public void browseInternet(String url) {
        System.out.println("Browsing " + url);
    }
}

// Interface with default methods
interface MusicPlayer {
    void play();
    void stop();
    
    // Default method (Java 8+)
    default void pause() {
        System.out.println("Pausing playback");
    }
    
    // Static method (Java 8+)
    static void info() {
        System.out.println("MusicPlayer interface v1.0");
    }
}

class MP3Player implements MusicPlayer {
    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping MP3");
    }
}

// Functional interface (single abstract method)
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// Comparable interface example
class Student implements Comparable<Student> {
    private String name;
    private int grade;
    
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }
    
    public String getName() { return name; }
    public int getGrade() { return grade; }
}
