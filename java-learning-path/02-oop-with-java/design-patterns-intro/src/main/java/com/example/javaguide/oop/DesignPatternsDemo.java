package com.example.javaguide.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * DesignPatternsDemo - Demonstrates common design patterns.
 *
 * Design patterns are reusable solutions to common software design problems.
 *
 * This demo covers:
 * - Creational:  Singleton, Factory Method, Builder
 * - Structural:  Decorator
 * - Behavioural: Strategy, Observer, Command
 *
 * Each pattern section is self-contained with its own classes.
 */
public class DesignPatternsDemo {
    
    public static void main(String[] args) {
        demonstrateSingleton();
        demonstrateFactory();
        demonstrateStrategy();
        demonstrateObserver();
    }
    
    public static void demonstrateSingleton() {
        System.out.println("=== Singleton Pattern ===");
        
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("Same instance? " + (db1 == db2));
        db1.connect();
        System.out.println();
    }
    
    public static void demonstrateFactory() {
        System.out.println("=== Factory Method Pattern ===");
        
        ShapeFactory factory = new ShapeFactory();
        
        Shape circle = factory.createShape("CIRCLE");
        Shape rectangle = factory.createShape("RECTANGLE");
        
        circle.draw();
        rectangle.draw();
        System.out.println();
    }
    
    public static void demonstrateStrategy() {
        System.out.println("=== Strategy Pattern ===");
        
        ShoppingCart cart = new ShoppingCart();
        
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.0);
        
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50.0);
        System.out.println();
    }
    
    public static void demonstrateObserver() {
        System.out.println("=== Observer Pattern ===");
        
        NewsAgency agency = new NewsAgency();
        
        NewsSubscriber subscriber1 = new NewsSubscriber("Alice");
        NewsSubscriber subscriber2 = new NewsSubscriber("Bob");
        
        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);
        
        agency.publishNews("Breaking: Design Patterns are awesome!");
        System.out.println();
    }
}

// ========== Singleton Pattern ==========
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    
    private DatabaseConnection() {
        System.out.println("Creating database connection...");
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("Connected to database");
    }
}

// ========== Factory Method Pattern ==========
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

class ShapeFactory {
    public Shape createShape(String type) {
        return switch (type.toUpperCase()) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            case "TRIANGLE" -> new Triangle();
            default -> throw new IllegalArgumentException("Unknown shape: " + type);
        };
    }
}

// ========== Strategy Pattern ==========
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + 
                          cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void checkout(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(amount);
    }
}

// ========== Observer Pattern ==========
interface Observer {
    void update(String news);
}

class NewsSubscriber implements Observer {
    private String name;
    
    public NewsSubscriber(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    private String news;
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void publishNews(String news) {
        this.news = news;
        notifyObservers();
    }
    
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

// ========== Builder Pattern ==========
class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }
    
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }
        
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
    
    @Override
    public String toString() {
        return "Computer{cpu='" + cpu + "', ram='" + ram + 
               "', storage='" + storage + "', gpu='" + gpu + "'}";
    }
}

// ========== Decorator Pattern ==========
interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }
    
    @Override
    public String description() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
    
    @Override
    public String description() {
        return coffee.description() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double cost() {
        return coffee.cost() + 0.3;
    }
    
    @Override
    public String description() {
        return coffee.description() + ", Sugar";
    }
}

// ========== Command Pattern ==========
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class TurnOnCommand implements Command {
    private Light light;
    
    public TurnOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Light light;
    
    public TurnOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        command.execute();
    }
}
