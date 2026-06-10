# Abstraction

## 📋 Learning Goals

- Understand abstraction as a fundamental OOP principle
- Use abstract classes and methods effectively
- Distinguish between abstraction and encapsulation
- Create abstract base classes for hierarchies
- Apply abstraction to hide implementation details

## 💡 Key Concepts

### 1. Abstract Class
```java
public abstract class Animal {
    public abstract void makeSound(); // Abstract method
    public void sleep() { } // Concrete method
}
```

### 2. Key Rules
- Cannot instantiate abstract classes
- May contain abstract and concrete methods
- Subclasses must implement all abstract methods
- Can have constructors, fields, and concrete methods

### 3. When to Use
- Common behavior with varying implementations
- Template method pattern
- Framework design

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\abstraction
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Abstraction Demo ===
Drawing Circle
Drawing Rectangle
Processing salary payment
Processing hourly payment
```

## 🔨 Exercises

1. Create abstract Shape class with calculateArea()
2. Implement Employee hierarchy with abstract calculatePay()
3. Create abstract Database class with CRUD operations
4. Use template method pattern
5. Compare abstract class vs interface

## ⚠️ Common Pitfalls

1. **Cannot instantiate:** Abstract classes cannot be instantiated directly
2. **Incomplete implementation:** Subclasses must implement all abstract methods
3. **Constructor confusion:** Abstract classes can have constructors
4. **Overuse:** Don't make everything abstract

## 🔗 Additional Resources

- [Oracle: Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
