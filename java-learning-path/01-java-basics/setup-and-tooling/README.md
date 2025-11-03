# Setup and Tooling

## 📋 Learning Goals

- Install and configure JDK 17+
- Set up a Java development environment
- Understand basic Java project structure
- Learn to compile and run Java programs
- Get familiar with Maven basics

## 🎯 Prerequisites

- Basic command-line knowledge
- A computer with internet access

## 💡 Key Concepts

### 1. Java Development Kit (JDK)
The JDK includes:
- **JRE (Java Runtime Environment)**: Runs Java applications
- **Compiler (`javac`)**: Converts `.java` to `.class` bytecode
- **JVM (Java Virtual Machine)**: Executes bytecode
- **Development Tools**: debugger, documentation generator, etc.

### 2. Maven
Maven is a build automation and dependency management tool:
- Manages project dependencies
- Compiles source code
- Runs tests
- Packages applications

### 3. Project Structure
Standard Maven project layout:
```
project/
├── pom.xml (Project Object Model - Maven configuration)
└── src/
    ├── main/
    │   └── java/          (Source code)
    └── test/
        └── java/          (Test code)
```

## 📂 Code Walkthrough

### SetupDemo.java
This simple demo verifies your Java installation and displays system information.

**Key points:**
- `System.getProperty()` retrieves JVM properties
- `System.out.println()` outputs to console
- `main()` method is the entry point

## 🚀 How to Build and Run

### Compile and Run
```powershell
# Navigate to this directory
cd 01-java-basics\setup-and-tooling

# Compile with Maven
mvn clean compile

# Run the demo
mvn exec:java -Dexec.mainClass="com.example.javaguide.setup.SetupDemo"
```

### Run Tests
```powershell
mvn test
```

## 📤 Expected Output

```
=== Java Setup Verification ===
Java Version: 17.0.x
Java Home: C:\Program Files\Java\jdk-17
OS Name: Windows 11
OS Architecture: amd64
User Directory: C:\Users\ahbab\Downloads\oop\java-learning-path
===============================
Setup verification complete!
```

## 🔨 Exercises

1. **Modify the demo** to display additional properties:
   - `java.class.path`
   - `user.name`
   - `file.separator`

2. **Create a new class** `EnvironmentInfo.java` that prints all environment variables

3. **Experiment with Maven commands**:
   - `mvn clean` - Remove compiled files
   - `mvn compile` - Compile source code
   - `mvn package` - Create JAR file

## ⚠️ Common Pitfalls

1. **JAVA_HOME not set**: Ensure environment variable points to JDK installation
2. **Using JRE instead of JDK**: JRE doesn't include compiler
3. **Maven not in PATH**: Add Maven `bin` directory to system PATH
4. **Wrong Java version**: Ensure JDK 17+ is installed and active

## 🔗 Additional Resources

- [Oracle JDK Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)
- [Adoptium Downloads](https://adoptium.net/)
