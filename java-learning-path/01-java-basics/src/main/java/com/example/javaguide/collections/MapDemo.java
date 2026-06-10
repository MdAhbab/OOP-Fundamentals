package com.example.javaguide.collections;

import java.util.*;

/**
 * MapDemo - Demonstrates Map interface implementations in Java.
 *
 * A Map is a collection that maps keys to values. Keys must be unique.
 * This class covers:
 * - HashMap (Fast, unordered, allows nulls)
 * - TreeMap (Sorted by keys, slower insertion)
 * - Iterating over Maps (keys, values, entries)
 */
public class MapDemo {
    
    /**
     * Main method running all Map demonstrations.
     */
    public static void main(String[] args) {
        demonstrateHashMap();
        demonstrateTreeMap();
        demonstrateMapOperations();
    }
    
    /**
     * Demonstrates HashMap properties and methods.
     * HashMap stores data in key-value pairs using a hash table implementation.
     */
    public static void demonstrateHashMap() {
        System.out.println("=== HashMap Demo ===");
        
        Map<Integer, String> students = new HashMap<>();
        
        // Put key-value pairs
        students.put(1, "Alice");
        students.put(2, "Bob");
        students.put(3, "Charlie");
        
        System.out.println("HashMap: " + students);
        System.out.println("Get key 2: " + students.get(2));
        System.out.println("Contains key 3: " + students.containsKey(3));
        System.out.println("Contains value Bob: " + students.containsValue("Bob"));
        
        // Update value
        students.put(2, "Bobby");
        System.out.println("After update: " + students);
        
        // Remove
        students.remove(1);
        System.out.println("After remove: " + students);
        System.out.println();
    }
    /**
     * Demonstrates TreeMap properties and methods.
     * TreeMap guarantees that keys will be in ascending key order.
     */
    public static void demonstrateTreeMap() {
        System.out.println("=== TreeMap Demo ===");
        
        // TreeMap maintains sorted order by keys
        Map<String, Integer> scores = new TreeMap<>();
        scores.put("Charlie", 85);
        scores.put("Alice", 95);
        scores.put("Bob", 90);
        
        System.out.println("TreeMap (sorted by keys): " + scores);
        
        TreeMap<String, Integer> treeMap = new TreeMap<>(scores);
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println();
    }
    /**
     * Demonstrates different ways to iterate through Maps and their entries.
     * Covers keySet, values, entrySet, and lambda forEach.
     */
    public static void demonstrateMapOperations() {
        System.out.println("=== Map Operations ===");
        
        Map<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington");
        capitals.put("UK", "London");
        capitals.put("France", "Paris");
        
        // Iterate over keys
        System.out.print("Keys: ");
        for (String key : capitals.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        
        // Iterate over values
        System.out.print("Values: ");
        for (String value : capitals.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Iterate over entries
        System.out.println("Entries:");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // forEach with lambda
        System.out.println("Lambda forEach:");
        capitals.forEach((k, v) -> System.out.println("  " + k + " = " + v));
        System.out.println();
    }
    /**
     * Swaps the keys and values of a map.
     * Note: If original map has duplicate values, some will be overwritten as keys must be unique.
     * 
     * @param <K> The type of keys in original map
     * @param <V> The type of values in original map
     * @param map The input map containing key-value pairs
     * @return A new map with the keys and values swapped
     */
    public static <K, V> Map<V, K> reverseMap(Map<K, V> map) {
        Map<V, K> reversed = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            reversed.put(entry.getValue(), entry.getKey());
        }
        return reversed;
    }
    /**
     * Analyzes a text string and counts the occurrence (frequency) of each word.
     *
     * @param text The input string to analyze
     * @return A map mapping each unique word to its frequency count
     */
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");
        
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        return frequency;
    }
}
