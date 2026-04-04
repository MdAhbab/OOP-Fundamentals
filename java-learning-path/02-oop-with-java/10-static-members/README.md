# Static Members

## 📋 Learning Goals

- Understand static variables and methods
- Use static initialization blocks
- Create utility classes
- Know static vs instance differences

## 💡 Key Concepts

### 1. Static Variables
```java
class Counter {
    private static int count = 0; // Shared by all instances
    
    public Counter() {
        count++;
    }
    
    public static int getCount() {
        return count;
    }
}
```

### 2. Static Methods
- Belong to class, not instance
- Can access only static members
- Cannot use `this` or `super`
- Called via class name: `Math.sqrt(25)`

### 3. Static Blocks
```java
class Config {
    private static Properties props;
    
    static { // Runs once when class is loaded
        props = new Properties();
        // Load configuration
    }
}
```

## 🚀 How to Build and Run

```powershell
cd 02-oop-with-java\static-members
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Static Members Demo ===
Count: 3
Area of circle: 78.53981633974483
```

## 🔨 Exercises

1. Create utility class with static methods
2. Implement singleton pattern with static
3. Use static initialization block
4. Create static factory method
5. Demonstrate static import

## ⚠️ Common Pitfalls

1. **Non-static access:** Cannot access instance members from static methods
2. **Thread safety:** Static variables shared across threads
3. **Testing:** Static state makes testing harder
4. **Memory:** Static variables persist for application lifetime

## 🔗 Additional Resources

- [Oracle: Class Variables](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
