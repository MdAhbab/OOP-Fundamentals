# Generics

## 📋 Learning Goals

- Understand type parameters and generic classes
- Master generic methods and bounded type parameters
- Learn about wildcards (?, extends, super)
- Understand type erasure and its implications
- Apply generics to create reusable, type-safe code

## 💡 Key Concepts

### 1. Generic Classes
```java
public class Box<T> {
    private T value;
    
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

### 2. Type Parameters
- **T** - Type
- **E** - Element
- **K** - Key
- **V** - Value
- **N** - Number

### 3. Bounded Type Parameters
```java
<T extends Number>  // Upper bound
<T super Integer>   // Lower bound
```

### 4. Wildcards
```java
List<?>              // Unbounded wildcard
List<? extends Number>  // Upper bounded wildcard
List<? super Integer>   // Lower bounded wildcard
```

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\generics
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Generic Box Demo ===
Integer Box: 42
String Box: Hello Generics

=== Generic Method Demo ===
Array: [1, 2, 3, 4, 5]
Reversed: [5, 4, 3, 2, 1]
```

## 🔨 Exercises

1. Create a generic Pair<K, V> class
2. Implement a generic method to find max element
3. Create a generic Stack<T> data structure
4. Use bounded type parameters with Comparable
5. Practice with wildcard captures

## ⚠️ Common Pitfalls

1. **Cannot instantiate generics:** `new T()` is invalid
2. **Cannot create arrays:** `new T[10]` is invalid
3. **Type erasure:** Generics removed at runtime
4. **Static context:** Cannot use type parameters in static fields/methods

## 🔗 Additional Resources

- [Oracle: Generics Tutorial](https://docs.oracle.com/javase/tutorial/java/generics/)
