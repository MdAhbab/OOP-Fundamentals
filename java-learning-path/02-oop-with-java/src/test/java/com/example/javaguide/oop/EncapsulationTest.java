package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EncapsulationTest {
    
    @Test
    @DisplayName("BankAccount should handle deposits correctly")
    void testDeposit() {
        BankAccount account = new BankAccount("123", 1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }
    
    @Test
    @DisplayName("BankAccount should handle withdrawals correctly")
    void testWithdraw() {
        BankAccount account = new BankAccount("123", 1000.0);
        boolean success = account.withdraw(300.0);
        
        assertTrue(success);
        assertEquals(700.0, account.getBalance());
    }
    
    @Test
    @DisplayName("BankAccount should reject overdraft")
    void testOverdraft() {
        BankAccount account = new BankAccount("123", 100.0);
        boolean success = account.withdraw(200.0);
        
        assertFalse(success);
        assertEquals(100.0, account.getBalance());
    }
    
    @Test
    @DisplayName("Employee age validation should work")
    void testEmployeeAgeValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Test", 10, 50000.0);
        });
    }
    
    @Test
    @DisplayName("Employee salary validation should work")
    void testEmployeeSalaryValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Test", 25, -1000.0);
        });
    }
    
    @Test
    @DisplayName("Employee raise should calculate correctly")
    void testEmployeeRaise() {
        Employee emp = new Employee("Alice", 25, 1000.0);
        emp.giveRaise(10);
        assertEquals(1100.0, emp.getSalary());
    }
    
    @Test
    @DisplayName("ImmutablePerson should be created correctly")
    void testImmutablePerson() {
        ImmutablePerson person = new ImmutablePerson("Bob", 30);
        assertEquals("Bob", person.getName());
        assertEquals(30, person.getAge());
    }
}
