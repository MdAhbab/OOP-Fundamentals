# Arrays

## 📋 Learning Goals

- Understand array declaration and initialization
- Work with single and multi-dimensional arrays
- Learn array manipulation techniques
- Use Arrays utility class
- Understand array limitations and when to use collections

## 💡 Key Concepts

### 1. Array Declaration
```java
int[] numbers;              // Preferred
int numbers[];              // Also valid
int[] arr = new int[5];     // With size
int[] arr = {1, 2, 3, 4, 5}; // With values
```

### 2. Array Characteristics
- Fixed size (cannot be resized)
- Zero-indexed
- Homogeneous (same type)
- Objects in Java

### 3. Multi-Dimensional Arrays
```java
int[][] matrix = new int[3][3];
int[][] grid = {{1,2}, {3,4}};
```

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\arrays
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Array Basics ===
Array length: 5
Element at index 0: 10
Array: [10, 20, 30, 40, 50]

=== Array Operations ===
Sum: 150
Average: 30.0
Max: 50
```

## 🔨 Exercises

1. Implement array sorting algorithms (bubble sort, selection sort)
2. Search for elements (linear search, binary search)
3. Reverse an array
4. Find duplicates in an array
5. Merge two sorted arrays

## ⚠️ Common Pitfalls

1. **ArrayIndexOutOfBoundsException**: Accessing invalid index
2. **NullPointerException**: Using null array
3. **Fixed size**: Cannot add/remove elements after creation
4. **Reference assignment**: `arr1 = arr2` copies reference, not elements

## 🔗 Additional Resources

- [Oracle: Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
