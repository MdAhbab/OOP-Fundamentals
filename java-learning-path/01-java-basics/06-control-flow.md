# Control Flow

## 📋 Learning Goals

- Master conditional statements (if-else, switch)
- Understand different loop types (for, while, do-while)
- Learn enhanced for-loop for collections
- Use break and continue statements effectively
- Understand control flow best practices

## 💡 Key Concepts

### 1. Conditional Statements
- **if-else**: Execute code based on conditions
- **switch**: Multi-way branch statement
- **Ternary operator**: Inline conditional expression

### 2. Loop Statements
- **for loop**: Known number of iterations
- **while loop**: Condition-based iteration
- **do-while loop**: Executes at least once
- **enhanced for loop**: Iterate over arrays/collections

### 3. Jump Statements
- **break**: Exit loop or switch
- **continue**: Skip to next iteration
- **return**: Exit method

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\control-flow
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== If-Else Statements ===
18 is an adult

=== Switch Statement ===
Day 1 is Monday

=== For Loop ===
Count: 0, 1, 2, 3, 4

=== While Loop ===
Countdown: 5, 4, 3, 2, 1
```

## 🔨 Exercises

1. Create a grade calculator using if-else
2. Implement a menu system using switch
3. Print patterns using nested loops
4. Write a number guessing game with while loop

## ⚠️ Common Pitfalls

1. **Infinite loops**: Ensure loop condition eventually becomes false
2. **Off-by-one errors**: Check loop boundaries carefully
3. **Switch fall-through**: Remember break statements
4. **Condition order**: More specific conditions should come first

## 🔗 Additional Resources

- [Oracle: Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
