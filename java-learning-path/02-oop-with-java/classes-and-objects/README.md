# Classes and Objects

## 📋 Learning Goals

- Understand class structure and object creation
- Master constructors (default, parameterized, overloaded)
- Use `this` keyword effectively
- Understand object references and memory
- Create and manage object instances

## 💡 Key Concepts

### 1. Class Structure
```java
public class Person {
    // Fields (instance variables)
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Methods
    public void display() {
        System.out.println(name + ", " + age);
    }
}
```

### 2. Object Creation
```java
Person person = new Person("Alice", 25);
```

### 3. Constructor Types
- **Default:** No parameters
- **Parameterized:** With parameters
- **Copy:** Creates copy of object
- **Overloaded:** Multiple constructors

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\classes-and-objects
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Classes and Objects Demo ===
Person: Alice, 25
Car: Toyota Camry (2024)
```

## 🔨 Exercises

1. Create a Book class with title, author, price
2. Implement constructor overloading (3+ constructors)
3. Create a copy constructor
4. Demonstrate object references
5. Create immutable class using final fields

## ⚠️ Common Pitfalls

1. **Null references:** Check before dereferencing
2. **this keyword:** Required when param names match fields
3. **Constructor chaining:** Use this() to call other constructors
4. **Object equality:** Override equals() and hashCode()

## 🔗 Additional Resources

- [Oracle: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/)
