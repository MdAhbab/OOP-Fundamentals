# Abstract Classes

## 📋 Learning Goals

- Master abstract class concepts
- Understand when to use abstract classes vs interfaces
- Implement template method pattern
- Use abstract classes for code reuse

## 💡 Key Concepts

### 1. Abstract Class Definition
```java
public abstract class Animal {
    protected String name; // Can have state
    
    public Animal(String name) { // Can have constructors
        this.name = name;
    }
    
    public abstract void makeSound(); // Abstract method
    
    public void sleep() { // Concrete method
        System.out.println(name + " is sleeping");
    }
}
```

### 2. Key Features
- Cannot be instantiated
- Can have constructors, fields, and concrete methods
- Subclasses must implement all abstract methods
- Single inheritance only

### 3. Abstract Classes vs Interfaces

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Inheritance | Single | Multiple |
| Constructors | Yes | No |
| Fields | Any | public static final only |
| Methods | Abstract + Concrete | Abstract + default + static |
| Use when | "is-a" with shared code | Contract for unrelated classes |

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\abstract-classes
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Abstract Classes Demo ===
Dog barks: Woof!
Dog is sleeping
```

## 🔨 Exercises

1. Create abstract Vehicle class with concrete and abstract methods
2. Implement template method for report generation
3. Compare abstract class vs interface for a scenario
4. Create abstract class with protected fields
5. Demonstrate constructor chaining in abstract classes

## ⚠️ Common Pitfalls

1. **Cannot instantiate:** Cannot create instances of abstract classes
2. **Must implement all:** Subclass must implement all abstract methods
3. **Overuse:** Don't use when interface would suffice
4. **Too many abstracts:** Balance abstract and concrete methods

## 🔗 Additional Resources

- [Oracle: Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
