package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DesignPatternsTest {
    
    @Test
    @DisplayName("Singleton should return same instance")
    void testSingleton() {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        assertSame(db1, db2);
    }
    
    @Test
    @DisplayName("Factory should create correct shapes")
    void testFactory() {
        ShapeFactory factory = new ShapeFactory();
        
        Shape circle = factory.createShape("CIRCLE");
        Shape rectangle = factory.createShape("RECTANGLE");
        
        assertTrue(circle instanceof Circle);
        assertTrue(rectangle instanceof Rectangle);
        
        assertThrows(IllegalArgumentException.class, 
                    () -> factory.createShape("INVALID"));
    }
    
    @Test
    @DisplayName("Strategy pattern should allow changing payment method")
    void testStrategy() {
        ShoppingCart cart = new ShoppingCart();
        
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        assertDoesNotThrow(() -> cart.checkout(100.0));
        
        cart.setPaymentStrategy(new PayPalPayment("test@example.com"));
        assertDoesNotThrow(() -> cart.checkout(50.0));
    }
    
    @Test
    @DisplayName("Observer pattern should notify all subscribers")
    void testObserver() {
        NewsAgency agency = new NewsAgency();
        
        final String[] news1 = {null};
        final String[] news2 = {null};
        
        Observer subscriber1 = news -> news1[0] = news;
        Observer subscriber2 = news -> news2[0] = news;
        
        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);
        
        agency.publishNews("Test News");
        
        assertEquals("Test News", news1[0]);
        assertEquals("Test News", news2[0]);
    }
    
    @Test
    @DisplayName("Builder pattern should construct object correctly")
    void testBuilder() {
        Computer computer = new Computer.Builder()
                .cpu("Intel i7")
                .ram("16GB")
                .storage("512GB SSD")
                .gpu("NVIDIA RTX 3060")
                .build();
        
        assertNotNull(computer);
        String str = computer.toString();
        assertTrue(str.contains("Intel i7"));
        assertTrue(str.contains("16GB"));
    }
    
    @Test
    @DisplayName("Decorator pattern should add functionality")
    void testDecorator() {
        Coffee coffee = new SimpleCoffee();
        assertEquals(2.0, coffee.cost(), 0.01);
        
        coffee = new MilkDecorator(coffee);
        assertEquals(2.5, coffee.cost(), 0.01);
        
        coffee = new SugarDecorator(coffee);
        assertEquals(2.8, coffee.cost(), 0.01);
        
        assertTrue(coffee.description().contains("Milk"));
        assertTrue(coffee.description().contains("Sugar"));
    }
    
    @Test
    @DisplayName("Command pattern should execute commands")
    void testCommand() {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        
        Command turnOn = new TurnOnCommand(light);
        Command turnOff = new TurnOffCommand(light);
        
        remote.setCommand(turnOn);
        assertDoesNotThrow(() -> remote.pressButton());
        
        remote.setCommand(turnOff);
        assertDoesNotThrow(() -> remote.pressButton());
    }
}
