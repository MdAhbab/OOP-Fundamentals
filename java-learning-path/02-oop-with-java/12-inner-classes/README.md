# Inner Classes

## 📋 Learning Goals

- Understand nested classes types
- Use inner classes effectively
- Create anonymous classes
- Connect to lambda expressions

## 💡 Key Concepts

### 1. Inner Class Types

| Type | Description | Access to Outer |
|------|-------------|-----------------|
| Member Inner Class | Non-static nested class | Yes |
| Static Nested Class | Static class inside outer | Only static members |
| Local Inner Class | Defined in method | Yes |
| Anonymous Inner Class | No name, one-time use | Yes |

### 2. Member Inner Class
```java
class Outer {
    private int value = 10;
    
    class Inner {
        void display() {
            System.out.println(value); // Access outer member
        }
    }
}
```

### 3. When to Use
- Logical grouping
- Encapsulation
- Event handlers
- Callbacks

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\inner-classes
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Inner Classes Demo ===
Inner class accessing outer value: 10
Anonymous class implementation
```

## 🔨 Exercises

1. Create member inner class
2. Implement static nested class
3. Use local inner class in method
4. Create anonymous class for interface
5. Compare anonymous class vs lambda

## ⚠️ Common Pitfalls

1. **Memory leaks:** Inner classes hold reference to outer
2. **Serialization:** Inner classes can be tricky to serialize
3. **This reference:** Use `Outer.this` to access outer instance
4. **Accessibility:** Inner class can access private members

## 🔗 Additional Resources

- [Oracle: Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
