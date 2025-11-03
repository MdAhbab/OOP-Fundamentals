# Method Overriding

## 📋 Learning Goals

- Master @Override annotation
- Understand runtime polymorphism
- Learn covariant return types
- Use super keyword correctly

## 💡 Key Concepts

### 1. Method Overriding Rules
```java
class Parent {
    public void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override // Always use this annotation
    public void display() {
        super.display(); // Call parent method
        System.out.println("Child");
    }
}
```

### 2. Key Rules
- Same method signature (name + parameters)
- Same or wider access modifier
- Same or subtype return type (covariant)
- Cannot override final, static, or private methods

### 3. Runtime Polymorphism
- Method call resolved at runtime
- Based on actual object type, not reference type

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\method-overriding
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Method Overriding Demo ===
Dog makes sound: Woof!
Manager salary: 75000.0
```

## 🔨 Exercises

1. Override toString() method
2. Implement equals() and hashCode()
3. Use covariant return types
4. Demonstrate super keyword usage
5. Override methods from Object class

## ⚠️ Common Pitfalls

1. **Missing @Override:** Always use annotation for compile-time checking
2. **Narrowing access:** Cannot reduce visibility
3. **Checked exceptions:** Cannot throw broader exceptions
4. **Static methods:** Cannot override static methods (hiding instead)

## 🔗 Additional Resources

- [Oracle: Overriding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
