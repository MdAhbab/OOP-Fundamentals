package com.example.javaguide.oop;

/**
 * EnumsDemo - Demonstrates Java enumerations (enums).
 *
 * An enum is a special class that represents a fixed set of constants.
 * Unlike plain constants (static final int), enums are type-safe and can
 * have fields, constructors, and methods.
 *
 * This demo covers:
 * - Basic enum declaration and usage
 * - Enum with fields, constructor, and methods
 * - Iterating over enum values with values()
 * - Enum in switch statements
 * - valueOf() and ordinal()
 * - Enum implementing an interface
 */
public class EnumsDemo {

    public static void main(String[] args) {
        demonstrateBasicEnum();
        demonstrateEnumWithFields();
        demonstrateEnumOperations();
        demonstrateEnumInSwitch();
        demonstrateEnumInterface();
    }

    // ================================================================
    // 1. Basic Enum
    // ================================================================

    /**
     * The simplest enum — a fixed list of named constants.
     * Each constant is implicitly public, static, and final.
     */
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void demonstrateBasicEnum() {
        System.out.println("=== Basic Enum ===");

        // Assign an enum constant to a variable
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);

        // name() returns the exact constant name as a String
        System.out.println("Name: " + today.name());

        // ordinal() returns the zero-based position in the declaration
        System.out.println("Ordinal: " + today.ordinal()); // 2

        System.out.println();
    }

    // ================================================================
    // 2. Enum with Fields and Methods
    // ================================================================

    /**
     * Enums can have fields, a private constructor, and methods.
     * Each constant calls the constructor with the specified arguments.
     */
    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS  (4.869e+24, 6.0518e6),
        EARTH  (5.976e+24, 6.37814e6),
        MARS   (6.421e+23, 3.3972e6);

        private final double mass;   // in kilograms
        private final double radius; // in metres

        // Enum constructors are implicitly private — cannot be called externally
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        /** Calculate surface gravity using G * mass / radius² */
        public double surfaceGravity() {
            final double G = 6.67300E-11; // gravitational constant
            return G * mass / (radius * radius);
        }

        /** Calculate weight of object with given mass on this planet */
        public double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }

        public double getMass()   { return mass; }
        public double getRadius() { return radius; }
    }

    public static void demonstrateEnumWithFields() {
        System.out.println("=== Enum with Fields ===");

        double earthWeight = 75.0; // kg
        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        // Calculate weight on every planet
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %.2f N%n",
                    p, p.surfaceWeight(mass));
        }
        System.out.println();
    }

    // ================================================================
    // 3. Enum Operations (values, valueOf, comparisons)
    // ================================================================

    /**
     * Enums provide built-in methods:
     *   values()   — returns an array of all constants
     *   valueOf()  — converts a String to the matching constant
     *   ==         — safe to use for comparison (enums are singletons)
     */
    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void demonstrateEnumOperations() {
        System.out.println("=== Enum Operations ===");

        // values() returns all constants in declaration order
        System.out.print("All seasons: ");
        for (Season s : Season.values()) {
            System.out.print(s + " ");
        }
        System.out.println();

        // valueOf() converts a String to the corresponding enum constant
        Season summer = Season.valueOf("SUMMER");
        System.out.println("valueOf(\"SUMMER\"): " + summer);

        // Enum comparison with == (safe, no NullPointerException risk like .equals)
        System.out.println("summer == SUMMER? " + (summer == Season.SUMMER));

        System.out.println();
    }

    // ================================================================
    // 4. Enum in Switch
    // ================================================================

    /**
     * Enums work seamlessly with switch statements/expressions.
     */
    enum TrafficLight {
        RED, YELLOW, GREEN
    }

    public static void demonstrateEnumInSwitch() {
        System.out.println("=== Enum in Switch ===");

        TrafficLight light = TrafficLight.GREEN;

        // Switch expression (Java 14+)
        String action = switch (light) {
            case RED    -> "Stop";
            case YELLOW -> "Caution";
            case GREEN  -> "Go";
        };
        System.out.println("Light is " + light + ": " + action);
        System.out.println();
    }

    // ================================================================
    // 5. Enum Implementing an Interface
    // ================================================================

    /**
     * Enums can implement interfaces, allowing each constant
     * to provide its own implementation (constant-specific body).
     */
    interface Printable {
        String getDescription();
    }

    enum Priority implements Printable {
        LOW {
            @Override
            public String getDescription() {
                return "Low priority — handle when convenient";
            }
        },
        MEDIUM {
            @Override
            public String getDescription() {
                return "Medium priority — handle soon";
            }
        },
        HIGH {
            @Override
            public String getDescription() {
                return "High priority — handle immediately";
            }
        };

        // Common method shared by all constants
        public boolean isUrgent() {
            return this == HIGH;
        }
    }

    public static void demonstrateEnumInterface() {
        System.out.println("=== Enum Implementing Interface ===");

        for (Priority p : Priority.values()) {
            System.out.println(p + ": " + p.getDescription()
                    + " (urgent: " + p.isUrgent() + ")");
        }
        System.out.println();
    }

    // ================================================================
    // Utility methods (used by tests)
    // ================================================================

    /** Returns the number of days in the Day enum. */
    public static int getDayCount() {
        return Day.values().length;
    }

    /** Returns the surface gravity of Earth. */
    public static double getEarthGravity() {
        return Planet.EARTH.surfaceGravity();
    }
}
