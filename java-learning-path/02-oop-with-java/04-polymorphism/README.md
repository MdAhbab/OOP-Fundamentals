# Polymorphism

## 📋 Learning Goals

- Understand compile-time vs runtime polymorphism
- Master method overriding for runtime polymorphism
- Use polymorphic references effectively
- Understand dynamic method dispatch
- Apply polymorphism in real-world scenarios

## 💡 Key Concepts

### 1. Polymorphism Types
- **Compile-time (Static):** Method overloading
- **Runtime (Dynamic):** Method overriding

### 2. Polymorphic Reference
```java
Animal animal = new Dog(); // Polymorphic reference
animal.makeSound(); // Calls Dog's makeSound()
```

### 3. Benefits
- Flexibility and extensibility
- Code reusability
- Abstraction

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\polymorphism
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Polymorphism Demo ===
Dog: Woof!
Cat: Meow!
Circle area: 78.54
Rectangle area: 20.0
```

## 🔨 Exercises

1. Create Shape hierarchy with polymorphic area() method
2. Implement Payment system (CreditCard, PayPal, Cash)
3. Use instanceof to check object types
4. Demonstrate upcasting and downcasting
5. Create factory pattern using polymorphism

## ⚠️ Common Pitfalls

1. **Type checking:** Minimize instanceof usage
2. **Downcasting:** Use with caution, can throw ClassCastException
3. **Private methods:** Cannot be overridden
4. **Static methods:** Cannot participate in runtime polymorphism

## 🔗 Additional Resources

- [Oracle: Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
