# Methods and Parameters

## 📋 Learning Goals

- Understand method declaration and invocation
- Master parameter passing (by value)
- Learn method overloading
- Work with variable arguments (varargs)
- Understand return types and void methods
- Learn recursion basics

## 🎯 Prerequisites

- Completed control-flow
- Understanding of data types

## 💡 Key Concepts

### 1. Method Structure
```java
returnType methodName(parameters) {
    // method body
    return value; // if not void
}
```

### 2. Parameter Passing
- Java uses **pass-by-value**
- Primitives: Copy of value is passed
- Objects: Copy of reference is passed

### 3. Method Overloading
- Same method name, different parameters
- Compile-time polymorphism

### 4. Variable Arguments (Varargs)
```java
public void method(String... args) { }
```

### 5. Recursion
- Method calling itself
- Must have base case to prevent infinite recursion

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\methods-and-parameters
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Method Basics ===
Sum: 15
Product: 50

=== Method Overloading ===
add(5, 3) = 8
add(5.5, 3.2) = 8.7

=== Recursion ===
Factorial of 5 = 120
```

## 🔨 Exercises

1. Create a calculator class with overloaded methods
2. Write recursive methods for Fibonacci sequence
3. Implement a method with varargs for averaging numbers
4. Practice parameter passing with objects

## ⚠️ Common Pitfalls

1. **Modifying primitives**: Parameters are copies, changes don't affect originals
2. **Missing return**: Non-void methods must return appropriate type
3. **Infinite recursion**: Always include base case
4. **Overloading confusion**: Must differ in parameter types or count, not just return type

## 🔗 Additional Resources

- [Oracle: Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
