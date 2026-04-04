package com.example.javaguide.oop;

import java.util.*;

/**
 * ImmutabilityDemo - Demonstrates immutable object design in Java.
 *
 * An immutable object's state cannot change after construction.
 *
 * Rules for creating an immutable class:
 * 1. Declare the class as 'final' (prevents subclasses from breaking immutability)
 * 2. Make all fields 'private final'
 * 3. Do NOT provide setter methods
 * 4. Return defensive copies for mutable fields (e.g. List, Date, arrays)
 * 5. Accept defensive copies in the constructor for mutable parameters
 *
 * This demo covers:
 * - Basic immutable class (Money)
 * - Immutable class with mutable field (ImmutableStudent with a List)
 * - Defensive copying
 * - Collections.unmodifiableList()
 * - Benefits: thread safety, safe HashMap keys, simpler reasoning
 */
public class ImmutabilityDemo {

    public static void main(String[] args) {
        demonstrateBasicImmutability();
        demonstrateDefensiveCopying();
        demonstrateUnmodifiableCollections();
        demonstrateBenefits();
    }

    // ================================================================
    // 1. Basic Immutable Class
    // ================================================================

    public static void demonstrateBasicImmutability() {
        System.out.println("=== Basic Immutability ===");

        Money price = new Money(19.99, "USD");
        System.out.println("Price: " + price);

        // There are NO setters — the only way to "change" is to create a new object
        Money discounted = price.withAmount(price.getAmount() * 0.9);
        System.out.println("Discounted: " + discounted);

        // Original is UNCHANGED
        System.out.println("Original still: " + price);
        System.out.println();
    }

    // ================================================================
    // 2. Defensive Copying
    // ================================================================

    public static void demonstrateDefensiveCopying() {
        System.out.println("=== Defensive Copying ===");

        List<String> courses = new ArrayList<>(List.of("Math", "Physics"));
        ImmutableStudent student = new ImmutableStudent("Alice", courses);

        System.out.println("Student: " + student);

        // Even though we modify the ORIGINAL list, the student is unaffected
        // because the constructor made a defensive copy
        courses.add("Chemistry");
        System.out.println("After modifying original list:");
        System.out.println("Student courses: " + student.getCourses());
        System.out.println("Original list: " + courses);

        // Trying to modify the returned list also fails — it's an unmodifiable copy
        try {
            student.getCourses().add("Biology");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify returned list: " + e.getClass().getSimpleName());
        }

        System.out.println();
    }

    // ================================================================
    // 3. Unmodifiable Collections
    // ================================================================

    public static void demonstrateUnmodifiableCollections() {
        System.out.println("=== Unmodifiable Collections ===");

        // List.of() creates an immutable list (Java 9+)
        List<String> immutableList = List.of("A", "B", "C");
        System.out.println("Immutable list: " + immutableList);

        // Collections.unmodifiableList() wraps a mutable list to prevent modification
        List<String> mutable = new ArrayList<>(List.of("X", "Y"));
        List<String> readOnly = Collections.unmodifiableList(mutable);
        System.out.println("Read-only view: " + readOnly);

        // The underlying mutable list can still be changed (this is a view, not a copy)
        mutable.add("Z");
        System.out.println("After mutating original: " + readOnly); // shows [X, Y, Z]

        // Map.of() creates an immutable Map (Java 9+)
        Map<String, Integer> immutableMap = Map.of("one", 1, "two", 2);
        System.out.println("Immutable map: " + immutableMap);

        System.out.println();
    }

    // ================================================================
    // 4. Benefits of Immutability
    // ================================================================

    public static void demonstrateBenefits() {
        System.out.println("=== Benefits of Immutability ===");

        System.out.println("1. Thread safety   — no synchronisation needed");
        System.out.println("2. Safe as keys    — HashMap/HashSet keys should be immutable");
        System.out.println("3. No side effects — methods never accidentally change state");
        System.out.println("4. Cacheable       — immutable objects can be freely shared/cached");
        System.out.println("5. Simpler code    — fewer things can go wrong");

        // Example: Money is safe to use as a HashMap key
        Map<Money, String> priceLabels = new HashMap<>();
        Money key = new Money(9.99, "USD");
        priceLabels.put(key, "Budget");
        System.out.println("Lookup by key: " + priceLabels.get(new Money(9.99, "USD")));

        System.out.println();
    }
}

// ================================================================
// Immutable Money class
// ================================================================

/**
 * Money is immutable:
 * - Class is final (no subclassing)
 * - Fields are private final (cannot be reassigned)
 * - No setters (state never changes)
 * - Only primitive/immutable fields (double, String) — no defensive copying needed
 */
final class Money {
    private final double amount;    // primitive — inherently immutable
    private final String currency;  // String is already immutable in Java

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Getters only — no setters
    public double getAmount()   { return amount; }
    public String getCurrency() { return currency; }

    /**
     * Instead of a setter, return a NEW Money with the changed amount.
     * The original object remains unchanged.
     */
    public Money withAmount(double newAmount) {
        return new Money(newAmount, this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0
                && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }
}

// ================================================================
// Immutable class with a mutable field (List)
// ================================================================

/**
 * ImmutableStudent demonstrates defensive copying.
 * The courses field is a List (mutable), so we must:
 *   1. Copy it in the constructor  (prevent external modification)
 *   2. Return an unmodifiable view in the getter (prevent client modification)
 */
final class ImmutableStudent {
    private final String name;
    private final List<String> courses; // mutable type — needs protection

    public ImmutableStudent(String name, List<String> courses) {
        this.name = name;
        // Defensive copy — the internal list is independent from the caller's list
        this.courses = new ArrayList<>(courses);
    }

    public String getName() { return name; }

    /**
     * Returns an unmodifiable view of the courses list.
     * The caller cannot add/remove elements through this reference.
     */
    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    @Override
    public String toString() {
        return "ImmutableStudent{name='" + name + "', courses=" + courses + "}";
    }
}
