package com.example.javaguide.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class CollectionsTest {
    
    @Test
    @DisplayName("ArrayList should maintain insertion order")
    void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        
        assertEquals(3, list.size());
        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
        assertTrue(list.contains("Third"));
    }
    
    @Test
    @DisplayName("Remove duplicates should work")
    void testRemoveDuplicates() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> unique = ListDemo.removeDuplicates(list);
        
        assertEquals(4, unique.size());
        assertTrue(unique.contains(1));
        assertTrue(unique.contains(2));
        assertTrue(unique.contains(3));
        assertTrue(unique.contains(4));
    }
    
    @Test
    @DisplayName("Get even numbers should filter correctly")
    void testGetEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = ListDemo.getEvenNumbers(numbers);
        
        assertEquals(3, evens.size());
        assertTrue(evens.contains(2));
        assertTrue(evens.contains(4));
        assertTrue(evens.contains(6));
    }
    
    @Test
    @DisplayName("HashSet should not allow duplicates")
    void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");  // Duplicate
        
        assertEquals(2, set.size());
        assertTrue(set.contains("Apple"));
        assertTrue(set.contains("Banana"));
    }
    
    @Test
    @DisplayName("Subset check should work")
    void testIsSubset() {
        Set<Integer> subset = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> superset = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        
        assertTrue(SetDemo.isSubset(subset, superset));
        assertFalse(SetDemo.isSubset(superset, subset));
    }
    
    @Test
    @DisplayName("HashMap should store key-value pairs")
    void testHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        
        assertEquals(2, map.size());
        assertEquals(25, map.get("Alice"));
        assertTrue(map.containsKey("Bob"));
    }
    
    @Test
    @DisplayName("Word frequency should count correctly")
    void testWordFrequency() {
        String text = "hello world hello java world";
        Map<String, Integer> freq = MapDemo.wordFrequency(text);
        
        assertEquals(2, freq.get("hello"));
        assertEquals(2, freq.get("world"));
        assertEquals(1, freq.get("java"));
    }
    
    @Test
    @DisplayName("Reverse map should swap keys and values")
    void testReverseMap() {
        Map<Integer, String> original = new HashMap<>();
        original.put(1, "One");
        original.put(2, "Two");
        
        Map<String, Integer> reversed = MapDemo.reverseMap(original);
        
        assertEquals(1, reversed.get("One"));
        assertEquals(2, reversed.get("Two"));
    }
}
