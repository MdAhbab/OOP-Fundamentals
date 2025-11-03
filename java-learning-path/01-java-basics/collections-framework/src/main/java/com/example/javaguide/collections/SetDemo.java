package com.example.javaguide.collections;

import java.util.*;

/**
 * SetDemo - Demonstrates Set interface implementations
 */
public class SetDemo {
    
    public static void main(String[] args) {
        demonstrateHashSet();
        demonstrateTreeSet();
        demonstrateSetOperations();
    }
    
    public static void demonstrateHashSet() {
        System.out.println("=== HashSet Demo ===");
        
        Set<String> fruits = new HashSet<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // Duplicate - won't be added
        
        System.out.println("HashSet: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains Banana: " + fruits.contains("Banana"));
        
        // Remove
        fruits.remove("Banana");
        System.out.println("After remove: " + fruits);
        System.out.println();
    }
    
    public static void demonstrateTreeSet() {
        System.out.println("=== TreeSet Demo ===");
        
        // TreeSet maintains sorted order
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        
        System.out.println("TreeSet (sorted): " + numbers);
        
        // TreeSet specific methods
        TreeSet<Integer> treeSet = new TreeSet<>(numbers);
        System.out.println("First: " + treeSet.first());
        System.out.println("Last: " + treeSet.last());
        System.out.println("Subset (2-5): " + treeSet.subSet(2, 6));
        System.out.println();
    }
    
    public static void demonstrateSetOperations() {
        System.out.println("=== Set Operations ===");
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);
        System.out.println();
    }
    
    public static Set<String> removeDuplicatesFromArray(String[] array) {
        return new HashSet<>(Arrays.asList(array));
    }
    
    public static boolean isSubset(Set<?> subset, Set<?> superset) {
        return superset.containsAll(subset);
    }
}
