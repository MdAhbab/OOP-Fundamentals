package com.example.javaguide.oop;

/**
 * EncapsulationDemo - Demonstrates encapsulation principles in Java.
 *
 * Encapsulation bundles data (fields) and the methods that operate on that data
 * into a single unit (class), and restricts direct access to the internals
 * through access modifiers (private, protected, public).
 *
 * This demo covers:
 * - Private fields with public getters/setters
 * - Validation inside setters
 * - Controlled access to sensitive data (BankAccount)
 * - Immutable objects (ImmutablePerson)
 */
public class EncapsulationDemo {

    public static void main(String[] args) {
        demonstrateBankAccount();
        demonstrateEmployee();
        demonstrateImmutablePerson();
    }

    /**
     * BankAccount uses encapsulation to protect the balance.
     * External code cannot set the balance directly; it must go
     * through deposit() and withdraw() which enforce business rules.
     */
    public static void demonstrateBankAccount() {
        System.out.println("=== Bank Account Encapsulation ===");

        BankAccount account = new BankAccount("12345", 1000.0);
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());

        // Deposit goes through validation (amount must be > 0)
        account.deposit(500.0);
        System.out.println("After deposit: $" + account.getBalance());

        // Withdrawal checks both positive amount AND sufficient funds
        boolean success = account.withdraw(200.0);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Final balance: $" + account.getBalance());
        System.out.println();
    }

    /**
     * Employee demonstrates setter validation.
     * Age must be 18-65; salary must be non-negative.
     */
    public static void demonstrateEmployee() {
        System.out.println("=== Employee Encapsulation ===");

        Employee emp = new Employee("Alice", 25, 50000.0);
        System.out.println("Employee: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Salary: $" + emp.getSalary());

        emp.giveRaise(10); // 10% raise via controlled method
        System.out.println("After raise: $" + emp.getSalary());
        System.out.println();
    }

    /**
     * An immutable object's state cannot change after construction.
     * This is achieved with: final class, final fields, no setters.
     */
    public static void demonstrateImmutablePerson() {
        System.out.println("=== Immutable Person ===");

        ImmutablePerson person = new ImmutablePerson("Bob", 30);
        System.out.println("Person: " + person.getName() + ", " + person.getAge());

        // Cannot modify — immutable (no setters available)
        System.out.println("Person is immutable - fields cannot be changed");
        System.out.println();
    }
}

/**
 * BankAccount - Encapsulated bank account.
 *
 * Key encapsulation points:
 * - accountNumber is final (set once, never changes)
 * - balance is private with NO public setter
 * - balance changes ONLY through deposit() and withdraw() which validate input
 */
class BankAccount {
    private final String accountNumber; // Immutable once set
    private double balance;             // Only modifiable through controlled methods

    /**
     * Constructs a new BankAccount.
     *
     * @param accountNumber unique identifier for the account
     * @param initialBalance starting balance (should be >= 0)
     */
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Read-only access to the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Read-only access to the balance
    public double getBalance() {
        return balance;
    }

    // NOTE: There is intentionally NO setBalance() — external code
    // cannot arbitrarily set the balance. It must go through
    // deposit() or withdraw() which enforce business rules.

    /**
     * Deposits a positive amount into the account.
     * Negative or zero amounts are rejected.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    /**
     * Withdraws an amount if sufficient funds are available.
     *
     * @return true if withdrawal succeeded, false otherwise
     */
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
