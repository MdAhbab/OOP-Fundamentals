# Debugging and Logging

## 📋 Learning Goals

- Set up logging with SLF4J and Logback
- Understand log levels (TRACE, DEBUG, INFO, WARN, ERROR)
- Configure logging output (console, file, patterns)
- Use debugging tools effectively
- Apply best logging practices

## 💡 Key Concepts

### 1. Log Levels
- **TRACE:** Very detailed information
- **DEBUG:** Debugging information
- **INFO:** Informational messages
- **WARN:** Warning messages
- **ERROR:** Error messages

### 2. SLF4J (Simple Logging Facade for Java)
- Abstraction layer for logging
- Works with Logback, Log4j, JUL

### 3. Logback
- Native SLF4J implementation
- Fast and flexible
- XML or Groovy configuration

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\debugging-and-logging
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
[INFO] Application started
[DEBUG] Debug message
[WARN] Warning message
[ERROR] Error occurred
```

## 🔨 Exercises

1. Configure console and file appenders
2. Use MDC for contextual logging
3. Create custom log patterns
4. Implement log rotation
5. Add logging to existing code

## ⚠️ Common Pitfalls

1. **Performance:** Avoid string concatenation, use {} placeholders
2. **Log levels:** Choose appropriate levels
3. **Sensitive data:** Never log passwords or secrets
4. **Over-logging:** Balance detail vs performance

## 🔗 Additional Resources

- [SLF4J Documentation](http://www.slf4j.org/)
- [Logback Manual](http://logback.qos.ch/manual/)
