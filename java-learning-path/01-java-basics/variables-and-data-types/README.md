# Variables and Data Types

## 📋 Learning Goals

- Understand primitive and reference data types
- Learn variable declaration and initialization
- Master type conversion and casting
- Understand variable scope and lifetime
- Work with constants using `final`

## 🎯 Prerequisites

- Completed setup-and-tooling
- Basic understanding of programming concepts

## 💡 Key Concepts

### 1. Primitive Data Types
Java has 8 primitive types:

| Type | Size | Range | Default | Example |
|------|------|-------|---------|---------|
| `byte` | 8-bit | -128 to 127 | 0 | `byte age = 25;` |
| `short` | 16-bit | -32,768 to 32,767 | 0 | `short year = 2024;` |
| `int` | 32-bit | -2³¹ to 2³¹-1 | 0 | `int count = 100;` |
| `long` | 64-bit | -2⁶³ to 2⁶³-1 | 0L | `long distance = 1000L;` |
| `float` | 32-bit | ~±3.4e38 | 0.0f | `float price = 9.99f;` |
| `double` | 64-bit | ~±1.8e308 | 0.0d | `double pi = 3.14159;` |
| `char` | 16-bit | Unicode 0 to 65,535 | '\u0000' | `char grade = 'A';` |
| `boolean` | 1-bit | true or false | false | `boolean isValid = true;` |

### 2. Reference Types
- **String**: Sequence of characters (immutable)
- **Arrays**: Fixed-size collection of elements
- **Objects**: Instances of classes

### 3. Type Conversion
- **Implicit (Widening)**: Automatic, safe conversion (e.g., `int` → `double`)
- **Explicit (Narrowing)**: Manual casting, potential data loss (e.g., `double` → `int`)

### 4. Variable Naming Conventions
- Use **camelCase** for variables: `firstName`, `totalAmount`
- Use **UPPER_CASE** for constants: `MAX_VALUE`, `PI`
- Start with letter, `$`, or `_`
- Cannot be Java keywords

## 📂 Code Walkthrough

### VariablesDemo.java
Demonstrates variable declaration, initialization, and scope.

### DataTypesDemo.java
Shows all primitive types, type conversion, and wrapper classes.

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\variables-and-data-types
mvn clean compile
mvn exec:java -Dexec.mainClass="com.example.javaguide.variables.VariablesDemo"
mvn exec:java -Dexec.mainClass="com.example.javaguide.variables.DataTypesDemo"
mvn test
```

## 📤 Expected Output

```
=== Variables Demo ===
Local variable: 42
Instance variable: 100
Class variable: 200
Constant: 3.14159

=== Data Types Demo ===
Integer types: 10, 1000, 100000, 100000000000
Floating types: 3.14, 3.14159265359
Character: A (Unicode: 65)
Boolean: true
Type conversion: 10.5 -> 10
```

## 🔨 Exercises

1. **Create a program** that declares variables for:
   - Your age (byte)
   - Your height in cm (short)
   - Population of your city (int)
   - Distance to moon in km (long)
   - Calculate and display their sum as a long

2. **Experiment with overflow**:
   ```java
   byte b = 127;
   b = (byte)(b + 1); // What happens?
   ```

3. **Practice type casting**:
   - Convert double to int
   - Convert int to char
   - Convert char to int

## ⚠️ Common Pitfalls

1. **Integer overflow**: `int max = Integer.MAX_VALUE; max++;` wraps to negative
2. **Floating-point precision**: `0.1 + 0.2 != 0.3` (use `BigDecimal` for precision)
3. **Uninitialized variables**: Local variables must be initialized before use
4. **Narrowing conversion**: Data loss when casting larger to smaller types

## 🔗 Additional Resources

- [Oracle: Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Oracle: Variables](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
