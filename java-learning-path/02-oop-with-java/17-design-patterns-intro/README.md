# Design Patterns Introduction

## 📋 Learning Goals

- Understand design pattern benefits
- Learn key creational patterns
- Master structural patterns
- Apply behavioral patterns

## 💡 Key Concepts

### 1. Pattern Categories

| Category | Purpose | Examples |
|----------|---------|----------|
| Creational | Object creation | Singleton, Factory, Builder |
| Structural | Object composition | Adapter, Decorator, Facade |
| Behavioral | Object interaction | Strategy, Observer, Command |

### 2. Common Patterns

**Singleton:** Ensure only one instance
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}
```

**Factory Method:** Create objects without specifying exact class
**Strategy:** Encapsulate algorithms
**Observer:** Notify dependents of state changes

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\design-patterns-intro
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Design Patterns Demo ===
Creating Circle
Processing payment with Credit Card
```

## 🔨 Exercises

1. Implement Singleton pattern
2. Create Factory Method for shapes
3. Use Strategy pattern for algorithms
4. Build Observer pattern for notifications
5. Apply Decorator pattern

## ⚠️ Common Pitfalls

1. **Overuse:** Not every problem needs a pattern
2. **Wrong pattern:** Choose appropriate pattern for problem
3. **Complexity:** Patterns can add unnecessary complexity
4. **Premature optimization:** Wait until need is clear

## 🔗 Additional Resources

- [Gang of Four: Design Patterns](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
- [Refactoring Guru](https://refactoring.guru/design-patterns)
