package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class StaticMembersTest {
    
    @BeforeEach
    void resetCounter() {
        Counter.reset();
    }
    
    @Test
    @DisplayName("Static variables should be shared across instances")
    void testStaticVariables() {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        
        assertEquals(3, Counter.getCount());
        assertEquals(1, c1.getInstanceId());
        assertEquals(2, c2.getInstanceId());
        assertEquals(3, c3.getInstanceId());
    }
    
    @Test
    @DisplayName("MathUtils static methods should work")
    void testStaticMethods() {
        assertEquals(78.53981633974483, MathUtils.circleArea(5.0), 0.001);
        assertEquals(20, MathUtils.max(10, 20));
        assertEquals(10, MathUtils.min(10, 20));
        assertEquals(15.0, MathUtils.average(10, 20), 0.001);
    }
    
    @Test
    @DisplayName("Database static initialization should work")
    void testStaticInitialization() {
        assertTrue(Database.isInitialized());
        assertNotNull(Database.getUrl());
        assertTrue(Database.getUrl().contains("jdbc:mysql"));
    }
    
    @Test
    @DisplayName("Singleton should return same instance")
    void testSingleton() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        
        assertSame(s1, s2);
    }
    
    @Test
    @DisplayName("Static factory methods should create correct objects")
    void testStaticFactoryMethods() {
        Employee manager = Employee.createManager("Alice");
        Employee developer = Employee.createDeveloper("Bob");
        
        assertEquals("Manager", manager.getType());
        assertEquals("Developer", developer.getType());
        assertEquals("Alice", manager.getName());
        assertEquals("Bob", developer.getName());
    }
    
    @Test
    @DisplayName("StringUtils static methods should work")
    void testStringUtils() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty(null));
        assertEquals("olleh", StringUtils.reverse("hello"));
    }
    
    @Test
    @DisplayName("Static interest rate should affect all accounts")
    void testStaticVsInstance() {
        BankAccount acc1 = new BankAccount(1000);
        BankAccount acc2 = new BankAccount(2000);
        
        BankAccount.setInterestRate(0.1);
        
        assertEquals(100.0, acc1.calculateInterest(), 0.01);
        assertEquals(200.0, acc2.calculateInterest(), 0.01);
        
        // Change static rate affects both
        BankAccount.setInterestRate(0.05);
        
        assertEquals(50.0, acc1.calculateInterest(), 0.01);
        assertEquals(100.0, acc2.calculateInterest(), 0.01);
    }
}
