# Exceptions

## 📋 Learning Goals

- Understand exception handling mechanism
- Master try-catch-finally blocks
- Learn checked vs unchecked exceptions
- Create custom exceptions
- Follow exception handling best practices

## 💡 Key Concepts

### 1. Exception Hierarchy
```
Throwable
├── Error (system errors, don't catch)
└── Exception
    ├── RuntimeException (unchecked)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   └── IllegalArgumentException
    └── IOException (checked)
        ├── FileNotFoundException
        └── SQLException
```

### 2. Try-Catch-Finally
```java
try {
    // Code that might throw exception
} catch (SpecificException e) {
    // Handle specific exception
} catch (Exception e) {
    // Handle general exception
} finally {
    // Always executes (cleanup code)
}
```

### 3. Checked vs Unchecked
- **Checked**: Must be caught or declared (IOException, SQLException)
- **Unchecked**: RuntimeException and its subclasses (NullPointerException)

### 4. Throwing Exceptions
```java
throw new IllegalArgumentException("Invalid value");
throws IOException  // In method signature
```

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\exceptions
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Exception Handling Demo ===
Caught exception: / by zero
Finally block executed
Custom exception caught: Invalid age: -5
```

## 🔨 Exercises

1. Create a calculator with exception handling for division by zero
2. Implement file reading with proper exception handling
3. Create a validation framework with custom exceptions
4. Practice try-with-resources for auto-closing

## ⚠️ Common Pitfalls

1. **Catching Exception**: Too broad, catches everything
2. **Empty catch blocks**: Silently swallows errors
3. **Not closing resources**: Use try-with-resources
4. **Exception for control flow**: Use conditionals instead

## 🔗 Additional Resources

- [Oracle: Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
