# Lambdas and Streams

## 📋 Learning Goals

- Master lambda expression syntax
- Understand functional interfaces
- Use Stream API for data processing
- Apply map, filter, reduce operations
- Learn parallel streams and performance

## 💡 Key Concepts

### 1. Lambda Syntax
```java
(parameters) -> expression
(parameters) -> { statements; }
```

### 2. Functional Interfaces
- Runnable, Callable, Comparator
- Predicate<T>, Function<T,R>, Consumer<T>, Supplier<T>

### 3. Stream Operations
- **Intermediate:** filter, map, sorted, distinct
- **Terminal:** forEach, collect, reduce, count

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\lambdas-and-streams
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Lambda Demo ===
Numbers: [1, 2, 3, 4, 5]
Doubled: [2, 4, 6, 8, 10]
Even numbers: [2, 4]
```

## 🔨 Exercises

1. Filter list using Predicate
2. Transform data using map
3. Calculate sum using reduce
4. Group data using Collectors.groupingBy
5. Implement parallel stream processing

## ⚠️ Common Pitfalls

1. **Stateful lambdas:** Avoid modifying external variables
2. **Stream reuse:** Streams cannot be reused
3. **Parallel overhead:** Not always faster
4. **Exception handling:** Checked exceptions in lambdas

## 🔗 Additional Resources

- [Oracle: Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Oracle: Stream API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
