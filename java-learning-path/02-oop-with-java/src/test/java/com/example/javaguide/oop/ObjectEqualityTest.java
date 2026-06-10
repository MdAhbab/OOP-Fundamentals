package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ObjectEqualityTest {

    @Test
    @DisplayName("Equal students should have same equals() result")
    void testEquals() {
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Alice", 101);
        Student s3 = new Student("Bob", 102);

        assertEquals(s1, s2);
        assertNotEquals(s1, s3);
    }

    @Test
    @DisplayName("Equal objects must have same hashCode")
    void testHashCodeContract() {
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Alice", 101);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    @DisplayName("toString should produce meaningful representation")
    void testToString() {
        Student s = new Student("Alice", 101);
        assertTrue(s.toString().contains("Alice"));
        assertTrue(s.toString().contains("101"));
    }

    @Test
    @DisplayName("HashSet should treat equal students as duplicates")
    void testSetDeduplication() {
        Set<Student> set = new HashSet<>();
        set.add(new Student("Alice", 101));
        set.add(new Student("Alice", 101));
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Main method should run without errors")
    void testMainRuns() {
        assertDoesNotThrow(() -> ObjectEqualityDemo.main(new String[]{}));
    }
}
