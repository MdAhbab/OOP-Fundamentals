# Encapsulation

## 📋 Learning Goals

- Understand the principle of encapsulation
- Use access modifiers (private, public, protected, default)
- Implement getters and setters
- Apply JavaBeans conventions
- Create immutable classes

## 💡 Key Concepts

### 1. Access Modifiers
- **private:** Accessible only within the class
- **default:** Accessible within the package
- **protected:** Accessible within package and subclasses
- **public:** Accessible everywhere

### 2. Encapsulation Benefits
- Data hiding and protection
- Controlled access to fields
- Validation in setters
- Flexibility to change implementation

### 3. JavaBeans Pattern
```java
private String name;
public String getName() { return name; }
public void setName(String name) { this.name = name; }
```

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\encapsulation
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Encapsulation Demo ===
Account balance: $1000.0
Deposit successful
New balance: $1500.0
```

## 🔨 Exercises

1. Create BankAccount class with encapsulated balance
2. Implement validation in setters (age >= 0, etc.)
3. Create immutable Person class
4. Use builder pattern for complex objects
5. Implement read-only properties

## ⚠️ Common Pitfalls

1. **Public fields:** Always use private fields
2. **Missing validation:** Validate in setters
3. **Returning mutable objects:** Return copies
4. **Breaking encapsulation:** Don't expose internals

## 🔗 Additional Resources

- [Oracle: Encapsulation](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
