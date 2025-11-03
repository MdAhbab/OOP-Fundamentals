# Library Management System

## 📋 Project Overview

A comprehensive library management system demonstrating OOP principles, design patterns, and real-world Java application development.

## ✨ Features

- **Book Management:** Add, update, delete, search books
- **Member Management:** Register members, track borrowing history
- **Loan System:** Borrow, return, renew books
- **Search:** Multiple search criteria (title, author, ISBN)
- **Persistence:** JSON file storage
- **Design Patterns:** Factory, Strategy, Observer, Singleton

## 🏗️ Architecture

```
library-management/
├── model/           # Domain entities (Book, Member, Loan)
├── repository/      # Data persistence layer
├── service/         # Business logic
├── util/            # Utilities and helpers
└── cli/             # Command-line interface
```

## 🚀 How to Build and Run

```powershell
cd 03-large-projects\library-management
mvn clean compile
mvn exec:java

# Run tests
mvn test
```

## 📋 Design Patterns Used

| Pattern | Usage |
|---------|-------|
| **Singleton** | LibrarySystem instance |
| **Factory Method** | Book type creation |
| **Strategy** | Search algorithms |
| **Observer** | Loan notifications |
| **Repository** | Data access abstraction |

## 🎯 Learning Goals

- Apply OOP principles in real project
- Implement multiple design patterns
- Handle file I/O and JSON
- Create clean architecture
- Write comprehensive tests

## 📖 Usage Examples

```java
// Initialize library
LibrarySystem library = LibrarySystem.getInstance();

// Add book
Book book = new Book("1234567890", "Java Basics", "John Doe", 2024);
library.addBook(book);

// Register member
Member member = new Member("M001", "Alice Smith");
library.registerMember(member);

// Borrow book
library.borrowBook("M001", "1234567890");
```

## 🔗 Additional Resources

- Uses Gson for JSON persistence
- Follows Maven standard directory layout
- Comprehensive JUnit test coverage
