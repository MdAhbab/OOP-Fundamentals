package com.example.javaguide.oop;

/**
 * EncapsulationDemo - Demonstrates encapsulation principles
 */
public class EncapsulationDemo {
    
    public static void main(String[] args) {
        demonstrateBankAccount();
        demonstrateEmployee();
        demonstrateImmutablePerson();
    }
    
    public static void demonstrateBankAccount() {
        System.out.println("=== Bank Account Encapsulation ===");
        
        BankAccount account = new BankAccount("12345", 1000.0);
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());

        
        account.deposit(500.0);
        System.out.println("After deposit: $" + account.getBalance());
        
        boolean success = account.withdraw(200.0);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println();
    }
    
    public static void demonstrateEmployee() {
        System.out.println("=== Employee Encapsulation ===");
        
        Employee emp = new Employee("Alice", 25, 50000.0);
        System.out.println("Employee: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: $" + emp.getSalary());
        
        emp.giveRaise(10); // 10% raise
        System.out.println("After raise: $" + emp.getSalary());
        System.out.println();
    }
    
    public static void demonstrateImmutablePerson() {
        System.out.println("=== Immutable Person ===");
        
        ImmutablePerson person = new ImmutablePerson("Bob", 30);
        System.out.println("Person: " + person.getName() + ", " + person.getAge());
        
        // Cannot modify - immutable
        System.out.println("Person is immutable - fields cannot be changed");
        System.out.println();
    }
}

/**
 * BankAccount - Encapsulated bank account
 */
class BankAccount {
    private final String accountNumber;
    private double balance;
    
    public BankAccount(String AC, double IB) {
        this.accountNumber = AC;
        this.balance = IB;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        }
        System.out.println("Insufficient funds or invalid amount");
        return false;
    }
}

/**
 * Employee - Demonstrates validation in setters
 */
class Employee {
    private String name;
    private int age;
    private double salary;
    
    public Employee(String name, int age, double salary) {
        this.name = name;
        setAge(age);
        setSalary(salary);
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 18 and 65");
        }
    }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }
    
    public void giveRaise(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            salary += salary * (percentage / 100);
        }
    }
}

/**
 * ImmutablePerson - Immutable class example
 */
final class ImmutablePerson {
    private final String name;
    private final int age;
    
    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
}
