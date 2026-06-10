# Packages and Imports

## 📋 Learning Goals

- Understand Java package structure
- Learn package naming conventions
- Master import statements
- Organize code into packages
- Understand classpath and package visibility

## 💡 Key Concepts

### 1. Packages
- Organize related classes
- Prevent naming conflicts
- Control access with package-private visibility
- Convention: reverse domain name (com.example.project)

### 2. Import Statements
```java
import java.util.ArrayList;      // Specific class
import java.util.*;               // All classes (not recommended)
import static java.lang.Math.PI;  // Static import
```

### 3. Package Declaration
```java
package com.example.javaguide.packages;
```

### 4. Access Modifiers
- `public`: Accessible everywhere
- `protected`: Same package + subclasses
- (default): Same package only
- `private`: Same class only

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\packages-and-imports
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Packages Demo ===
Using Helper from util package
Using Sample from model package
Package organization successful!
```

## 🔨 Exercises

1. Create a multi-package project structure
2. Experiment with different access modifiers
3. Use static imports for utility methods
4. Organize a small application into logical packages

## ⚠️ Common Pitfalls

1. **Package name mismatch**: Package statement must match directory structure
2. **Missing imports**: Compiler error if class not imported
3. **Wildcard imports**: Can cause name conflicts
4. **Access violations**: Trying to access package-private members from outside

## 🔗 Additional Resources

- [Oracle: Packages](https://docs.oracle.com/javase/tutorial/java/package/packages.html)
