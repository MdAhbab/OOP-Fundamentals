# Strings

## 📋 Learning Goals

- Understand String immutability
- Master String manipulation methods
- Learn StringBuilder and StringBuffer
- Work with String formatting
- Understand String comparison

## 💡 Key Concepts

### 1. String Immutability
- Strings are immutable (cannot be changed after creation)
- Operations create new String objects
- String pool for memory efficiency

### 2. Common String Methods
- `length()`, `charAt()`, `substring()`
- `toUpperCase()`, `toLowerCase()`
- `trim()`, `strip()`, `replace()`
- `split()`, `join()`, `concat()`
- `startsWith()`, `endsWith()`, `contains()`

### 3. StringBuilder vs StringBuffer
- **StringBuilder**: Fast, not thread-safe (preferred)
- **StringBuffer**: Thread-safe, slower
- Both mutable (can be modified)

### 4. String Comparison
- `equals()`: Content comparison
- `==`: Reference comparison
- `compareTo()`: Lexicographic comparison

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\strings
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== String Basics ===
Length: 13
Uppercase: HELLO, WORLD!
Substring: Hello

=== StringBuilder ===
Appended: Hello World!
Reversed: !dlroW olleH
```

## 🔨 Exercises

1. Implement palindrome checker
2. Count vowels and consonants
3. Reverse words in a sentence
4. Remove duplicate characters
5. Check if two strings are anagrams

## ⚠️ Common Pitfalls

1. **Using == for comparison**: Use `.equals()` instead
2. **Concatenation in loops**: Use StringBuilder for efficiency
3. **NullPointerException**: Check for null before calling methods
4. **Index out of bounds**: Validate indices before accessing

## 🔗 Additional Resources

- [Oracle: Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
