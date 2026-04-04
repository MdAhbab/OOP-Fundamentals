# Collections Framework

## 📋 Learning Goals

- Understand the Java Collections Framework hierarchy
- Master List, Set, Map, and Queue interfaces
- Learn when to use ArrayList vs LinkedList
- Work with HashSet, TreeSet, HashMap, TreeMap
- Understand iteration and stream operations on collections

## 💡 Key Concepts

### 1. Collection Hierarchy
```
Collection
├── List (ordered, allows duplicates)
│   ├── ArrayList (dynamic array)
│   ├── LinkedList (doubly-linked list)
│   └── Vector (synchronized ArrayList)
├── Set (no duplicates)
│   ├── HashSet (hash table)
│   ├── LinkedHashSet (maintains insertion order)
│   └── TreeSet (sorted, red-black tree)
└── Queue (FIFO)
    ├── PriorityQueue (heap)
    └── LinkedList (also implements Queue)

Map (key-value pairs)
├── HashMap (hash table)
├── LinkedHashMap (maintains insertion order)
└── TreeMap (sorted by keys)
```

### 2. Common Operations
- **Add:** `add()`, `put()`
- **Remove:** `remove()`, `clear()`
- **Search:** `contains()`, `get()`
- **Iterate:** `for-each`, `iterator()`, `forEach()`

### 3. Performance Characteristics
| Collection | Add | Remove | Get | Search |
|------------|-----|--------|-----|--------|
| ArrayList | O(1) | O(n) | O(1) | O(n) |
| LinkedList | O(1) | O(1) | O(n) | O(n) |
| HashSet | O(1) | O(1) | - | O(1) |
| TreeSet | O(log n) | O(log n) | - | O(log n) |
| HashMap | O(1) | O(1) | O(1) | O(1) |

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\collections-framework
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== List Demo ===
ArrayList: [Java, Python, JavaScript]
Size: 3
Contains Python: true

=== Set Demo ===
HashSet: [Apple, Banana, Orange]
No duplicates allowed!

=== Map Demo ===
HashMap: {1=Alice, 2=Bob, 3=Charlie}
```

## 🔨 Exercises

1. Implement a phonebook using HashMap
2. Remove duplicates from a list using Set
3. Create a priority queue for task management
4. Compare performance of ArrayList vs LinkedList
5. Implement a custom sorting using TreeSet

## ⚠️ Common Pitfalls

1. **Modifying during iteration:** Use Iterator.remove() or streams
2. **Null handling:** HashMap allows one null key, HashSet allows null
3. **Equals/HashCode:** Must override for custom objects in Set/Map
4. **Concurrent modification:** Use ConcurrentHashMap for thread-safety

## 🔗 Additional Resources

- [Oracle: Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)
