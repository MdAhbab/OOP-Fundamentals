# Method Overloading

## 📋 Learning Goals

- Master compile-time polymorphism
- Understand overloading rules
- Use varargs with overloading
- Apply type promotion

## 💡 Key Concepts

### 1. Method Overloading Definition
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

### 2. Overloading Rules
- Same method name
- Different parameter list (type, number, or order)
- Return type alone is NOT sufficient
- Resolved at compile-time

### 3. Type Promotion
- byte → short → int → long → float → double
- char → int

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\method-overloading
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Method Overloading Demo ===
5 + 3 = 8
5.5 + 3.2 = 8.7
```

## 🔨 Exercises

1. Overload print() method for different types
2. Create constructor overloading examples
3. Use varargs with overloading
4. Demonstrate type promotion
5. Show ambiguous overloading cases

## ⚠️ Common Pitfalls

1. **Ambiguous calls:** Can occur with type promotion
2. **Return type:** Cannot overload by return type alone
3. **Varargs:** Use carefully to avoid ambiguity
4. **Autoboxing:** Can cause unexpected overload selection

## 🔗 Additional Resources

- [Oracle: Method Overloading](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
