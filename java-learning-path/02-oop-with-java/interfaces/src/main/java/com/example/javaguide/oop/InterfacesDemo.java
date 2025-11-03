package com.example.javaguide.oop;

/**
 * InterfacesDemo - Demonstrates interfaces in Java
 */
public class InterfacesDemo {
    
    public static void main(String[] args) {
        demonstrateBasicInterfaces();
        demonstrateMultipleInterfaces();
        demonstrateDefaultMethods();
        demonstrateFunctionalInterface();
    }
    
    public static void demonstrateBasicInterfaces() {
        System.out.println("=== Basic Interfaces ===");
        
        Drawable circle = new Circle(5.0);
        Drawable rectangle = new Rectangle(4.0, 6.0);
        
        circle.draw();
        rectangle.draw();
        System.out.println();
    }
    
    public static void demonstrateMultipleInterfaces() {
        System.out.println("=== Multiple Interfaces ===");
        
        SmartPhone phone = new SmartPhone();
        phone.getData();
        phone.call("123-456-7890");
        phone.takePicture();
        phone.browseInternet("www.example.com");
        System.out.println();
    }
    
    public static void demonstrateDefaultMethods() {
        System.out.println("=== Default Methods ===");
        
        MusicPlayer player = new MP3Player();
        player.play();
        player.pause(); // Default method
        player.stop();
        System.out.println();
    }
    
    public static void demonstrateFunctionalInterface() {
        System.out.println("=== Functional Interface ===");
        
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

// Multiple interfaces
interface Phone {
    void call(String number);
}

interface Camera {
    void takePicture();
}

interface WebBrowser {
    void browseInternet(String url);
}

class SmartPhone implements Phone, Camera, WebBrowser {
    private int a, b;
    public void getData(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void setData(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void call(String number) {
        System.out.println("Calling " + number);
    }
    
    @Override
    public void takePicture() {
        System.out.println("Taking picture");
    }
    
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
