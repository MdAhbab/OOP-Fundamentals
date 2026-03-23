package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ImmutabilityTest {

    @Test
    @DisplayName("Money should be immutable — withAmount returns new object")
    void testMoneyImmutability() {
        Money original = new Money(10.0, "USD");
        Money changed = original.withAmount(20.0);

        assertEquals(10.0, original.getAmount());
        assertEquals(20.0, changed.getAmount());
        assertNotSame(original, changed);
    }

    @Test
    @DisplayName("ImmutableStudent courses should be defended from external mutation")
    void testDefensiveCopy() {
        List<String> courses = new ArrayList<>(List.of("Math", "Physics"));
        ImmutableStudent student = new ImmutableStudent("Alice", courses);

        courses.add("Chemistry");
        assertEquals(2, student.getCourses().size());
    }

    @Test
    @DisplayName("ImmutableStudent getCourses should return unmodifiable list")
    void testUnmodifiable() {
        ImmutableStudent student = new ImmutableStudent("Bob", List.of("CS"));
        assertThrows(UnsupportedOperationException.class,
                () -> student.getCourses().add("Math"));
    }

    @Test
    @DisplayName("Main method should run without errors")
    void testMainRuns() {
        assertDoesNotThrow(() -> ImmutabilityDemo.main(new String[]{}));
    }
}
