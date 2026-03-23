package com.example.javaguide.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * SolidPrinciplesDemo - Demonstrates the SOLID principles of OOP.
 *
 * SOLID is an acronym for five design principles that make software
 * more understandable, flexible, and maintainable:
 *
 *   S — Single Responsibility Principle (SRP)
 *   O — Open/Closed Principle (OCP)
 *   L — Liskov Substitution Principle (LSP)
 *   I — Interface Segregation Principle (ISP)
 *   D — Dependency Inversion Principle (DIP)
 *
 * Each section shows a VIOLATION and then the CORRECTED version.
 */
public class SolidPrinciplesDemo {

    public static void main(String[] args) {
        demonstrateSRP();
        demonstrateOCP();
        demonstrateLSP();
        demonstrateISP();
        demonstrateDIP();
    }

    // ================================================================
    // S — Single Responsibility Principle
    // "A class should have only ONE reason to change."
    // ================================================================

    public static void demonstrateSRP() {
        System.out.println("=== S — Single Responsibility Principle ===");

        // GOOD: Each class has one job
        Invoice invoice = new Invoice("INV-001", 250.0);
        InvoicePrinter printer = new InvoicePrinter();
        InvoiceSaver saver = new InvoiceSaver();

        printer.print(invoice);  // printing is its own responsibility
        saver.save(invoice);     // persistence is its own responsibility
        System.out.println();
    }

    // ================================================================
    // O — Open/Closed Principle
    // "Open for extension, closed for modification."
    // ================================================================

    public static void demonstrateOCP() {
        System.out.println("=== O — Open/Closed Principle ===");

        // GOOD: Adding a new shape does NOT require modifying AreaCalculator
        AreaShape[] shapes = {
            new AreaCircle(5.0),
            new AreaRectangle(4.0, 6.0),
            new AreaTriangle(3.0, 4.0)  // new shape — no changes to calculator
        };

        AreaCalculator calculator = new AreaCalculator();
        for (AreaShape shape : shapes) {
            System.out.printf("%s area: %.2f%n",
                    shape.getClass().getSimpleName(), calculator.calculate(shape));
        }
        System.out.println();
    }

    // ================================================================
    // L — Liskov Substitution Principle
    // "Subtypes must be substitutable for their base types."
    // ================================================================

    public static void demonstrateLSP() {
        System.out.println("=== L — Liskov Substitution Principle ===");

        // GOOD: Both Sparrow and Penguin are Birds, but only flyable ones implement Flyable
        LspBird sparrow = new Sparrow();
        LspBird penguin = new Penguin();

        sparrow.eat();
        penguin.eat();

        // Only Sparrow implements Flyable, so we check before calling fly()
        if (sparrow instanceof Flyable flyer) {
            flyer.fly();
        }
        if (penguin instanceof Flyable) {
            System.out.println("Penguin can fly"); // never reached
        } else {
            System.out.println("Penguin cannot fly — but still a valid Bird");
        }
        System.out.println();
    }

    // ================================================================
    // I — Interface Segregation Principle
    // "Clients should not be forced to depend on methods they don't use."
    // ================================================================

    public static void demonstrateISP() {
        System.out.println("=== I — Interface Segregation Principle ===");

        // GOOD: Separate interfaces so each class only implements what it needs
        Workable human = new HumanWorker();
        Workable robot = new RobotWorker();

        human.work();
        ((Eatable) human).eat(); // humans also eat

        robot.work();
        // robot does NOT implement Eatable — no unused eat() method to stub out
        System.out.println();
    }

    // ================================================================
    // D — Dependency Inversion Principle
    // "High-level modules should not depend on low-level modules.
    //  Both should depend on abstractions."
    // ================================================================

    public static void demonstrateDIP() {
        System.out.println("=== D — Dependency Inversion Principle ===");

        // GOOD: NotificationService depends on the MessageSender INTERFACE,
        // not on a concrete EmailSender or SmsSender class
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender   = new SmsSender();

        NotificationService emailNotifier = new NotificationService(emailSender);
        NotificationService smsNotifier   = new NotificationService(smsSender);

        emailNotifier.sendNotification("Hello via email!");
        smsNotifier.sendNotification("Hello via SMS!");
        System.out.println();
    }
}

// ================================================================
// SRP Classes
// ================================================================

/** Holds invoice data only — no printing, no persistence. */
class Invoice {
    private final String id;
    private final double amount;

    public Invoice(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId()     { return id; }
    public double getAmount() { return amount; }
}

/** Responsible ONLY for printing invoices. */
class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Printing invoice " + invoice.getId()
                + ": $" + invoice.getAmount());
    }
}

/** Responsible ONLY for saving invoices. */
class InvoiceSaver {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice " + invoice.getId() + " to database");
    }
}

// ================================================================
// OCP Classes
// ================================================================

/** Abstract shape — new shapes extend this WITHOUT modifying existing code. */
abstract class AreaShape {
    public abstract double area();
}

class AreaCircle extends AreaShape {
    private final double radius;
    public AreaCircle(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}

class AreaRectangle extends AreaShape {
    private final double width, height;
    public AreaRectangle(double width, double height) {
        this.width = width; this.height = height;
    }

    @Override
    public double area() { return width * height; }
}

class AreaTriangle extends AreaShape {
    private final double base, height;
    public AreaTriangle(double base, double height) {
        this.base = base; this.height = height;
    }

    @Override
    public double area() { return 0.5 * base * height; }
}

/** Calculator is CLOSED for modification — it works with any AreaShape. */
class AreaCalculator {
    public double calculate(AreaShape shape) {
        return shape.area();
    }
}

// ================================================================
// LSP Classes
// ================================================================

/** Base type for all birds. */
abstract class LspBird {
    public void eat() {
        System.out.println(getClass().getSimpleName() + " is eating");
    }
}

/** Separate interface for flying — NOT all birds can fly. */
interface Flyable {
    void fly();
}

class Sparrow extends LspBird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

/** Penguin IS-A Bird but does NOT implement Flyable — LSP-safe. */
class Penguin extends LspBird {
    // No fly() method — Penguin doesn't violate expectations
}

// ================================================================
// ISP Classes
// ================================================================

/** Small, focused interfaces. */
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    @Override
    public void work() { System.out.println("Human working"); }

    @Override
    public void eat()  { System.out.println("Human eating"); }
}

/** Robot only works — not forced to implement eat(). */
class RobotWorker implements Workable {
    @Override
    public void work() { System.out.println("Robot working"); }
}

// ================================================================
// DIP Classes
// ================================================================

/** Abstraction — high-level code depends on this, not on concrete classes. */
interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

/**
 * High-level module depends on the MessageSender ABSTRACTION,
 * not on EmailSender or SmsSender directly.
 * This makes it easy to swap implementations without changing this class.
 */
class NotificationService {
    private final MessageSender sender; // depends on interface, not concrete class

    public NotificationService(MessageSender sender) {
        this.sender = sender; // injected via constructor (Dependency Injection)
    }

    public void sendNotification(String message) {
        sender.send(message);
    }
}
