# Interfaces

## 📋 Learning Goals

- Understand interfaces as contracts
- Implement multiple interfaces
- Use default and static methods (Java 8+)
- Apply functional interfaces
- Compare interfaces vs abstract classes

## 💡 Key Concepts

### 1. Interface Definition
```java
public interface Drawable {
    void draw(); // Abstract by default
    
    default void display() { // Default method (Java 8+)
        System.out.println("Displaying...");
    }
    
    static void info() { // Static method (Java 8+)
        System.out.println("Drawable interface");
    }
}
```

### 2. Key Features
- All methods are public abstract by default
- Can contain constants (public static final)
- Support multiple inheritance
- Cannot be instantiated

### 3. When to Use
- Define contracts for unrelated classes
- Achieve multiple inheritance
- Polymorphic behavior

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\interfaces
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Interfaces Demo ===
Drawing a circle
Playing music
Stopping music
```

## 🔨 Exercises

1. Create Flyable interface for birds and planes
2. Implement Comparable interface
3. Create functional interface for calculations
4. Use multiple interface implementation
5. Demonstrate interface default methods

## ⚠️ Common Pitfalls

1. **Diamond problem:** Resolved with default methods
2. **Marker interfaces:** Empty interfaces for tagging
3. **Too many methods:** Keep interfaces focused
4. **Default method conflicts:** Must override if ambiguous

## 🔗 Additional Resources

- [Oracle: Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
