package com.example.javaguide.oop;

import java.util.*;

/**
 * ObjectEqualityDemo - Demonstrates equals(), hashCode(), and toString().
 *
 * Every Java class inherits these three methods from Object.
 * By default:
 *   equals()   — checks if two references point to the SAME object (==)
 *   hashCode() — returns a memory-based integer (inconsistent across runs)
 *   toString() — returns "ClassName@hexHashCode"
 *
 * Overriding them is essential when you want logical equality
 * (e.g. two Person objects with the same name and age should be "equal").
 *
 * This demo covers:
 * - Default Object behaviour vs overridden behaviour
 * - equals() contract (reflexive, symmetric, transitive, consistent, non-null)
 * - hashCode() contract (equal objects must have equal hash codes)
 * - toString() for meaningful string representation
 * - Using Objects.equals() and Objects.hash() utility methods
 * - Impact on collections like HashSet and HashMap
 */
public class ObjectEqualityDemo {

    public static void main(String[] args) {
        demonstrateDefaultBehaviour();
        demonstrateOverriddenEquality();
        demonstrateHashCodeContract();
        demonstrateToString();
        demonstrateCollectionImpact();
    }

    // ================================================================
    // 1. Default Object Behaviour
    // ================================================================

    public static void demonstrateDefaultBehaviour() {
        System.out.println("=== Default Object Behaviour ===");

        // Without overriding equals/hashCode, two objects with same data are NOT equal
        Object obj1 = new Object();
        Object obj2 = new Object();

        // == compares references (memory addresses), not content
        System.out.println("obj1 == obj2: " + (obj1 == obj2));        // false
        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2)); // false

        // Default toString() shows class name + hex hash code
        System.out.println("obj1.toString(): " + obj1);
        System.out.println();
    }

    // ================================================================
    // 2. Properly Overridden equals()
    // ================================================================

    public static void demonstrateOverriddenEquality() {
        System.out.println("=== Overridden equals() ===");

        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Alice", 101);
        Student s3 = new Student("Bob",   102);

        // With equals() overridden, objects with same data ARE logically equal
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // false

        // Reflexive: x.equals(x) is always true
        System.out.println("s1.equals(s1): " + s1.equals(s1)); // true

        // Symmetric: if x.equals(y) then y.equals(x)
        System.out.println("s2.equals(s1): " + s2.equals(s1)); // true

        // null safety: x.equals(null) should return false, never throw
        System.out.println("s1.equals(null): " + s1.equals(null)); // false

        System.out.println();
    }

    // ================================================================
    // 3. hashCode() Contract
    // ================================================================

    public static void demonstrateHashCodeContract() {
        System.out.println("=== hashCode() Contract ===");

        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Alice", 101);
        Student s3 = new Student("Bob",   102);

        // RULE: If two objects are equal, they MUST have the same hash code
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("Equal objects, same hash? " +
                (s1.hashCode() == s2.hashCode())); // must be true

        // NOTE: Unequal objects CAN have the same hash code (collision),
        // but ideally they should differ for performance
        System.out.println("s3.hashCode(): " + s3.hashCode());

        System.out.println();
    }

    // ================================================================
    // 4. toString()
    // ================================================================

    public static void demonstrateToString() {
        System.out.println("=== toString() ===");

        Student s = new Student("Alice", 101);

        // println() automatically calls toString()
        System.out.println("Student: " + s);

        // String concatenation also calls toString()
        String info = "Info: " + s;
        System.out.println(info);

        System.out.println();
    }

    // ================================================================
    // 5. Impact on Collections
    // ================================================================

    public static void demonstrateCollectionImpact() {
        System.out.println("=== Collection Impact ===");

        // HashSet uses hashCode() to bucket objects and equals() to check duplicates
        Set<Student> students = new HashSet<>();
        students.add(new Student("Alice", 101));
        students.add(new Student("Alice", 101)); // duplicate — will NOT be added
        students.add(new Student("Bob",   102));

        // Only 2 students (Alice and Bob) because equals+hashCode correctly identify duplicates
        System.out.println("Set size (should be 2): " + students.size());

        // HashMap also relies on hashCode+equals for key lookups
        Map<Student, String> grades = new HashMap<>();
        grades.put(new Student("Alice", 101), "A+");
        String grade = grades.get(new Student("Alice", 101)); // works because of overridden equals/hashCode
        System.out.println("Alice's grade: " + grade);

        System.out.println();
    }
}

// ================================================================
// Student class with properly overridden equals, hashCode, toString
// ================================================================

/**
 * A Student with a name and ID.
 * Demonstrates the correct way to override equals(), hashCode(), and toString().
 */
class Student {
    private final String name;
    private final int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Two Students are equal if they have the same name AND id.
     *
     * The equals() method must satisfy:
     * 1. Reflexive:  x.equals(x) == true
     * 2. Symmetric:  if x.equals(y) then y.equals(x)
     * 3. Transitive: if x.equals(y) and y.equals(z) then x.equals(z)
     * 4. Consistent: repeated calls return the same result
     * 5. Non-null:   x.equals(null) == false
     */
    @Override
    public boolean equals(Object obj) {
        // Step 1: Check if same reference (fast path)
        if (this == obj) return true;

        // Step 2: Check for null and exact class match
        // (using getClass() instead of instanceof prevents subclass issues)
        if (obj == null || getClass() != obj.getClass()) return false;

        // Step 3: Cast and compare fields
        Student other = (Student) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    /**
     * hashCode must be consistent with equals:
     * if two objects are equal, they MUST return the same hash code.
     *
     * Objects.hash() is a convenient way to combine multiple fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    /**
     * Provides a human-readable representation of the object.
     * Called automatically by println(), string concatenation, and debuggers.
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + "}";
    }

    public String getName() { return name; }
    public int getId()      { return id; }
}
