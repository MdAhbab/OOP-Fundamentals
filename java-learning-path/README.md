# Java Learning Path

A comprehensive, hands-on guide to mastering Java programming from core basics through advanced Object-Oriented Programming (OOP) concepts, culminating in two full-scale projects.

## 🎯 Overview

This repository is structured as a progressive learning path designed for developers who want to build a solid foundation in Java and OOP principles. Each topic is self-contained with runnable examples, clear explanations, and JUnit tests.

**Java Version:** Java 17+  
**Build Tool:** Maven  
**Base Package:** `com.example.javaguide`

## 📚 Repository Structure

### 1️⃣ Java Basics (18 Topics)
Core Java fundamentals that every developer must master.

| Topic | Description | Key Concepts |
|-------|-------------|--------------|
| [setup-and-tooling](01-java-basics/setup-and-tooling) | Development environment setup | JDK, IDE, Maven |
| [variables-and-data-types](01-java-basics/variables-and-data-types) | Primitive and reference types | int, double, String, type conversion |
| [operators-and-expressions](01-java-basics/operators-and-expressions) | Arithmetic, logical, bitwise operators | +, -, &&, \|\|, precedence |
| [control-flow](01-java-basics/control-flow) | Conditionals and loops | if-else, switch, for, while |
| [methods-and-parameters](01-java-basics/methods-and-parameters) | Function definitions and calling | parameters, return types, overloading |
| [arrays](01-java-basics/arrays) | Array manipulation | single/multi-dimensional arrays |
| [strings](01-java-basics/strings) | String operations | String, StringBuilder, methods |
| [packages-and-imports](01-java-basics/packages-and-imports) | Code organization | package structure, import statements |
| [exceptions](01-java-basics/exceptions) | Error handling | try-catch, custom exceptions |
| [collections-framework](01-java-basics/collections-framework) | Data structures | List, Set, Map, Queue |
| [generics](01-java-basics/generics) | Type parameterization | Generic classes and methods |
| [lambdas-and-streams](01-java-basics/lambdas-and-streams) | Functional programming | Lambda expressions, Stream API |
| [dates-and-time](01-java-basics/dates-and-time) | Temporal operations | LocalDate, LocalDateTime, ZonedDateTime |
| [file-io-and-nio](01-java-basics/file-io-and-nio) | File operations | Reading/writing files, NIO.2 |
| [concurrency-basics](01-java-basics/concurrency-basics) | Multi-threading | Thread, Runnable, synchronization |
| [debugging-and-logging](01-java-basics/debugging-and-logging) | Troubleshooting | Debugger, logging frameworks |
| [unit-testing-junit](01-java-basics/unit-testing-junit) | Testing fundamentals | JUnit 5, assertions, test lifecycle |
| [build-tools-maven](01-java-basics/build-tools-maven) | Project management | Maven lifecycle, dependencies |

### 2️⃣ OOP with Java (13 Topics)
Object-Oriented Programming principles and advanced concepts.

| Topic | Description | Key Concepts |
|-------|-------------|--------------|
| [classes-and-objects](02-oop-with-java/classes-and-objects) | OOP fundamentals | Class definition, object instantiation |
| [encapsulation](02-oop-with-java/encapsulation) | Data hiding | private fields, getters/setters |
| [inheritance](02-oop-with-java/inheritance) | Code reuse | extends, super, method overriding |
| [polymorphism](02-oop-with-java/polymorphism) | Many forms | method overriding, dynamic binding |
| [abstraction](02-oop-with-java/abstraction) | Essential features | abstract classes, abstract methods |
| [interfaces](02-oop-with-java/interfaces) | Contracts | interface implementation, default methods |
| [abstract-classes](02-oop-with-java/abstract-classes) | Partial implementations | abstract vs concrete methods |
| [nested-and-inner-classes](02-oop-with-java/nested-and-inner-classes) | Class composition | static nested, inner, local, anonymous |
| [enums](02-oop-with-java/enums) | Type-safe constants | enum declaration, methods |
| [object-equality-hashcode-tostring](02-oop-with-java/object-equality-hashcode-tostring) | Object contract | equals(), hashCode(), toString() |
| [immutability](02-oop-with-java/immutability) | Unchangeable objects | final fields, defensive copies |
| [solid-principles](02-oop-with-java/solid-principles) | Design principles | SRP, OCP, LSP, ISP, DIP |
| [design-patterns-intro](02-oop-with-java/design-patterns-intro) | Common solutions | Singleton, Factory, Observer |

### 3️⃣ OOP Projects (2 Large Applications)
Real-world applications demonstrating OOP design patterns and best practices.

#### 🏛️ [Library Management System](03-oop-projects/project-library-management)
A comprehensive library management application with book lending, member management, and fine calculation.

**Features:**
- Book and member CRUD operations
- Loan management with due dates
- Fine calculation using Strategy pattern
- Item creation using Factory Method pattern
- JSON persistence
- CLI interface

**Design Patterns:** Factory Method, Strategy  
**Classes:** 15+  
**Packages:** model, service, repository, factory, strategy, util, ui

#### 🛒 [E-commerce Shopping Cart](03-oop-projects/project-ecommerce-cart)
A feature-rich shopping cart system with product catalog, order processing, and notifications.

**Features:**
- Product catalog management
- Shopping cart operations
- Multiple pricing strategies (regular, percentage discount, bulk)
- Order placement and history
- Event-driven notifications using Observer pattern
- JSON persistence
- CLI interface

**Design Patterns:** Strategy, Observer  
**Classes:** 15+  
**Packages:** model, service, repository, strategy, observer, util, ui

## 🚀 Quick Start

### Prerequisites
- **JDK 17** or newer ([Download](https://adoptium.net/))
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **IDE:** IntelliJ IDEA, Eclipse, or VS Code with Java extensions

### Running a Topic Example

Navigate to any topic directory and run:

```powershell
cd 01-java-basics\variables-and-data-types
mvn clean compile
mvn exec:java
```

### Running Tests

```powershell
mvn test
```

### Running a Project

```powershell
cd 03-oop-projects\project-library-management
mvn clean package
java -jar target\library-management-1.0-SNAPSHOT.jar
```

## 📖 Learning Path

### Recommended Order

1. **Start with Java Basics** (Topics 1-18)
   - Follow the order listed above
   - Complete exercises in each README
   - Ensure all tests pass before moving forward

2. **Progress to OOP Concepts** (Topics 1-13)
   - Build on Java basics knowledge
   - Pay special attention to SOLID principles
   - Study design patterns introduction

3. **Apply Knowledge in Projects**
   - Library Management System (simpler)
   - E-commerce Cart (more complex)
   - Read architecture documentation
   - Extend features as exercises

### Time Estimates
- **Java Basics:** 2-3 weeks (2-3 hours per topic)
- **OOP with Java:** 2-3 weeks (3-4 hours per topic)
- **Projects:** 1-2 weeks each (study + extend)

## 🎓 Learning Objectives

By completing this learning path, you will:

✅ Write clean, idiomatic Java code  
✅ Understand and apply OOP principles effectively  
✅ Use design patterns to solve common problems  
✅ Build testable, maintainable applications  
✅ Work with Maven for project management  
✅ Handle files, collections, and streams proficiently  
✅ Implement multi-tier application architectures  

## 🛠️ Build All Modules

To verify the entire repository builds successfully:

```powershell
# Build all Java Basics topics
Get-ChildItem -Path 01-java-basics -Directory | ForEach-Object { cd $_.FullName; mvn clean test; cd ..\.. }

# Build all OOP topics
Get-ChildItem -Path 02-oop-with-java -Directory | ForEach-Object { cd $_.FullName; mvn clean test; cd ..\.. }

# Build all projects
Get-ChildItem -Path 03-oop-projects -Directory | ForEach-Object { cd $_.FullName; mvn clean test; cd ..\.. }
```

## 📝 Contributing

This is a learning repository. Feel free to:
- Add more examples
- Improve documentation
- Report issues
- Suggest additional topics

## 📄 License

This project is licensed for educational purposes. Feel free to use, modify, and share.

## 🤝 Support

For questions or discussions:
- Review the topic-specific README files
- Check the inline code comments
- Study the test cases for usage examples

---

**Happy Learning! 🎉**

Start your journey with [setup-and-tooling](01-java-basics/setup-and-tooling) and work your way through systematically.
