# Concurrency Basics

## 📋 Learning Goals

- Understand threads and the Thread class
- Implement Runnable and Callable interfaces
- Use ExecutorService for thread pools
- Master synchronized keyword and locks
- Understand thread safety and race conditions

## 💡 Key Concepts

### 1. Creating Threads
- Extend Thread class
- Implement Runnable interface
- Lambda with Runnable

### 2. ExecutorService
- Thread pools
- Fixed, cached, single thread executors
- Submit tasks and get Future results

### 3. Synchronization
- synchronized keyword
- Lock interface
- volatile keyword
- Atomic classes

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\concurrency-basics
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Concurrency Demo ===
Thread started: Thread-0
Task completed
```

## 🔨 Exercises

1. Create multiple threads printing numbers
2. Use ExecutorService with 5 threads
3. Implement producer-consumer pattern
4. Demonstrate race condition and fix it
5. Use CountDownLatch for coordination

## ⚠️ Common Pitfalls

1. **Race conditions:** Use synchronization
2. **Deadlock:** Avoid circular dependencies
3. **Thread leaks:** Always shutdown executors
4. **Visibility:** Use volatile or synchronization

## 🔗 Additional Resources

- [Oracle: Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)
