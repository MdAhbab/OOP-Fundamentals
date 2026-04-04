# Composition vs Inheritance

## 📋 Learning Goals

- Understand "has-a" vs "is-a" relationships
- Apply favor composition over inheritance principle
- Implement delegation pattern
- Know when to use each approach

## 💡 Key Concepts

### 1. Inheritance ("is-a")
```java
class Dog extends Animal { } // Dog IS-AN Animal
```

### 2. Composition ("has-a")
```java
class Car {
    private Engine engine; // Car HAS-AN Engine
}
```

### 3. When to Use

| Use Inheritance When | Use Composition When |
|---------------------|---------------------|
| True "is-a" relationship | "has-a" relationship |
| Need polymorphism | Want flexibility |
| Shared behavior/state | Reuse functionality |
| Stable hierarchy | Changeable design |

### 4. Favor Composition
- More flexible
- Easier to test
- Avoids fragile base class problem
- Supports multiple "behaviors"

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\composition-vs-inheritance
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Composition vs Inheritance ===
Car engine started
Flying with wings
Swimming with fins
```

## 🔨 Exercises

1. Refactor inheritance hierarchy to use composition
2. Implement delegation pattern
3. Create flexible behavior system with composition
4. Compare testing inheritance vs composition
5. Solve diamond problem with composition

## ⚠️ Common Pitfalls

1. **Inheritance overuse:** Not everything needs inheritance
2. **Tight coupling:** Inheritance creates tight coupling
3. **Fragile base class:** Changes to base affect all subclasses
4. **Wrong abstraction:** Forcing "is-a" when "has-a" fits better

## 🔗 Additional Resources

- [Effective Java: Favor composition over inheritance](https://www.oreilly.com/library/view/effective-java/9780134686097/)
