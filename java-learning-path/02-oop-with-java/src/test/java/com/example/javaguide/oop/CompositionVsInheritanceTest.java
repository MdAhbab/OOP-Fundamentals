package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CompositionVsInheritanceTest {
    
    @Test
    @DisplayName("Inheritance should work with Dog extending Animal")
    void testInheritance() {
        Dog dog = new Dog();
        
        assertTrue(dog instanceof Animal);
        assertDoesNotThrow(() -> {
            dog.eat();
            dog.bark();
        });
    }
    
    @Test
    @DisplayName("Composition should work with Car having Engine")
    void testComposition() {
        Engine engine = new Engine();
        Car car = new Car(engine);
        
        assertDoesNotThrow(() -> {
            car.start();
            car.drive();
            car.stop();
        });
    }
    
    @Test
    @DisplayName("Delegation should work in Printer")
    void testDelegation() {
        Scanner scanner = new Scanner();
        InkjetPrintEngine printEngine = new InkjetPrintEngine();
        Printer printer = new Printer(scanner, printEngine);
        
        assertDoesNotThrow(() -> {
            printer.scan("test.pdf");
            printer.print("Test content");
        });
        
        // Can easily swap print engine
        LaserPrintEngine laserEngine = new LaserPrintEngine();
        Printer laserPrinter = new Printer(scanner, laserEngine);
        assertDoesNotThrow(() -> laserPrinter.print("Test"));
    }
    
    @Test
    @DisplayName("Behavior can be changed at runtime with composition")
    void testBehaviorFlexibility() {
        Bird bird = new Bird(new WingFlyBehavior());
        
        assertDoesNotThrow(() -> bird.performFly());
        
        // Change behavior at runtime
        bird.setFlyBehavior(new NoFlyBehavior());
        assertDoesNotThrow(() -> bird.performFly());
    }
    
    @Test
    @DisplayName("FlyingFish demonstrates composition solving multiple inheritance problem")
    void testFlyingFish() {
        FlyingFish flyingFish = new FlyingFish();
        
        assertDoesNotThrow(() -> {
            flyingFish.performFly();
            flyingFish.performSwim();
        });
    }
    
    @Test
    @DisplayName("Employee should compose Address")
    void testEmployeeComposition() {
        Address address = new Address("123 Main St", "Springfield");
        Employee employee = new Employee("John Doe", address);
        
        String info = employee.getEmployeeInfo();
        assertTrue(info.contains("John Doe"));
        assertTrue(info.contains("123 Main St"));
        assertTrue(info.contains("Springfield"));
    }
}
