package com.example.javaguide.oop;

/**
 * AbstractionDemo - Demonstrates abstraction with abstract classes
 */
public class AbstractionDemo {
    
    public static void main(String[] args) {
        demonstrateShapeAbstraction();
        demonstrateEmployeeAbstraction();
        demonstrateTemplateMethod();
    }
    
    public static void demonstrateShapeAbstraction() {
        System.out.println("=== Shape Abstraction ===");
        
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        circle.draw();
        System.out.println("Circle area: " + circle.calculateArea());
        
        rectangle.draw();
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println();
    }
    
    public static void demonstrateEmployeeAbstraction() {
        System.out.println("=== Employee Abstraction ===");
        
        Employee salaried = new SalariedEmployee("Alice", 5000.0);
        Employee hourly = new HourlyEmployee("Bob", 20.0, 160);
        
        System.out.println(salaried.getName() + " pay: $" + salaried.calculatePay());
        System.out.println(hourly.getName() + " pay: $" + hourly.calculatePay());
        System.out.println();
    }
    
    public static void demonstrateTemplateMethod() {
        System.out.println("=== Template Method Pattern ===");
        
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor jsonProcessor = new JSONDataProcessor();
        
        csvProcessor.process();
        System.out.println();
        
        jsonProcessor.process();
        System.out.println();
    }
}

// Abstract Shape class
abstract class Shape {
    protected String color;
    
    public Shape() {
        this.color = "black";
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Abstract method
    public abstract void draw();
    
    // Concrete method - inherited by all subclasses
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle " + width + "x" + height);
    }
}

// Abstract Employee class
abstract class Employee {
    protected String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // Abstract method for calculating pay
    public abstract double calculatePay();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Employee: " + name);
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;
    
    public SalariedEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    
    public HourlyEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

// Template Method Pattern using abstraction
abstract class DataProcessor {
    // Template method - defines algorithm structure
    public final void process() {
        readData();
        processData();
        writeData();
    }
    
    // Abstract methods - implemented by subclasses
    protected abstract void readData();
    protected abstract void processData();
    protected abstract void writeData();
}

class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading CSV data");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing CSV data");
    }
    
    @Override
    protected void writeData() {
        System.out.println("Writing CSV data");
    }
}

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading JSON data");
    }
    
    @Override
    protected void processData() {
        System.out.println("Processing JSON data");
    }
    
    @Override
    protected void writeData() {
        System.out.println("Writing JSON data");
    }
}
