# Inheritance

## 📋 Learning Goals

- Understand inheritance hierarchy and "is-a" relationship
- Use `extends` keyword effectively
- Access superclass members with `super`
- Understand constructor chaining in inheritance
- Learn when to use inheritance vs composition

## 💡 Key Concepts

### 1. Inheritance Syntax
```java
public class Dog extends Animal {
    // Dog inherits from Animal
}
```

### 2. Key Points
- Single inheritance (one parent class only)
- `super()` calls parent constructor
- `super.method()` calls parent method
- All classes inherit from Object

### 3. Protected Access
- Protected members accessible in subclasses
- Allows controlled inheritance

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\inheritance
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Inheritance Demo ===
Dog says: Woof!
Cat says: Meow!
```

## 🔨 Exercises

1. Create Animal hierarchy (Dog, Cat, Bird)
2. Implement Vehicle hierarchy (Car, Motorcycle, Truck)
3. Override toString() in all classes
4. Use super to call parent methods
5. Create multilevel inheritance (A -> B -> C)

## ⚠️ Common Pitfalls

1. **Deep hierarchies:** Prefer composition over deep inheritance
2. **Fragile base class:** Changes in parent affect all children
3. **Constructor chaining:** Always call super() explicitly or implicitly
4. **Private members:** Not inherited, only accessible via public/protected methods

## 🔗 Additional Resources

- [Oracle: Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
