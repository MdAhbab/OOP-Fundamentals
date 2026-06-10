# Operators and Expressions

## 📋 Learning Goals

- Master arithmetic, relational, and logical operators
- Understand operator precedence and associativity
- Work with bitwise and shift operators
- Learn the ternary operator
- Understand operator overloading limitations

## 🎯 Prerequisites

- Completed variables-and-data-types
- Understanding of basic mathematics

## 💡 Key Concepts

### 1. Arithmetic Operators
- `+` Addition
- `-` Subtraction
- `*` Multiplication
- `/` Division
- `%` Modulus (remainder)

### 2. Relational Operators
- `==` Equal to
- `!=` Not equal to
- `>` Greater than
- `<` Less than
- `>=` Greater than or equal to
- `<=` Less than or equal to

### 3. Logical Operators
- `&&` Logical AND (short-circuit)
- `||` Logical OR (short-circuit)
- `!` Logical NOT

### 4. Assignment Operators
- `=` Simple assignment
- `+=`, `-=`, `*=`, `/=`, `%=` Compound assignment

### 5. Unary Operators
- `++` Increment
- `--` Decrement
- `+` Unary plus
- `-` Unary minus

### 6. Bitwise Operators
- `&` AND
- `|` OR
- `^` XOR
- `~` Complement
- `<<` Left shift
- `>>` Right shift
- `>>>` Unsigned right shift

### 7. Ternary Operator
- `condition ? value1 : value2`

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\operators-and-expressions
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Arithmetic Operators ===
10 + 5 = 15
10 - 5 = 5
10 * 5 = 50
10 / 5 = 2
10 % 3 = 1

=== Relational Operators ===
10 == 5: false
10 != 5: true
10 > 5: true
```

## 🔨 Exercises

1. Create a calculator program using all arithmetic operators
2. Write expressions using operator precedence rules
3. Implement a bit manipulation utility using bitwise operators
4. Practice with pre/post increment operators

## ⚠️ Common Pitfalls

1. **Integer division**: `5 / 2 = 2` (not 2.5)
2. **Operator precedence**: `2 + 3 * 4 = 14` (not 20)
3. **Short-circuit evaluation**: `false && expensive()` doesn't call expensive()
4. **Floating-point comparison**: Use epsilon for equality checks

## 🔗 Additional Resources

- [Oracle: Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
