package com.example.javaguide.collections;

import java.util.*;

/**
 * ListDemo - Demonstrates List interface implementations in Java.
 *
 * A List is an ordered collection (sequence) that allows duplicate elements.
 * This class covers:
 * - ArrayList (Dynamic array)
 * - LinkedList (Doubly linked list)
 * - Common List operations (sort, shuffle, search)
 * - Different iteration strategies
 */
public class ListDemo {
    
    /**
     * Main method running all list demonstrations.
     */
    public static void main(String[] args) {
        demonstrateArrayList();
        demonstrateLinkedList();
        demonstrateListOperations();
        demonstrateIteration();
    }
    
    /**
     * Demonstrates ArrayList properties and methods.
     * ArrayList provides fast random access but slower insertions/deletions in the middle.
     */
    public static void demonstrateArrayList() {
        System.out.println("=== ArrayList Demo ===");
        
        // Create ArrayList
        List<String> languages = new ArrayList<>();
        
        // Add elements
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        
        System.out.println("ArrayList: " + languages);
        System.out.println("Size: " + languages.size());
        System.out.println("Get index 1: " + languages.get(1));
        System.out.println("Contains Python: " + languages.contains("Python"));
        
        // Add at specific index
        languages.add(1, "C++");
        System.out.println("After insert: " + languages);
        
        // Remove
        languages.remove("C++");
        languages.remove(0);
        System.out.println("After remove: " + languages);
        System.out.println();
    }
    /**
     * Demonstrates LinkedList properties and methods.
     * LinkedList provides fast insertions/deletions but slower random access.
     */
    public static void demonstrateLinkedList() {
        System.out.println("=== LinkedList Demo ===");
        
        LinkedList<Integer> numbers = new LinkedList<>();
        
        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        // LinkedList specific methods
        numbers.addFirst(5);
        numbers.addLast(40);
        
        System.out.println("LinkedList: " + numbers);
        System.out.println("First: " + numbers.getFirst());
        System.out.println("Last: " + numbers.getLast());
        
        numbers.removeFirst();
        numbers.removeLast();
        System.out.println("After remove first/last: " + numbers);
        System.out.println();
    }
    /**
     * Demonstrates Collections utility methods for List manipulation.
     * Operations like sort, shuffle, and binary search.
     */
    public static void demonstrateListOperations() {
        System.out.println("=== List Operations ===");
        
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        
        // Sort
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);
        
        // Reverse
        Collections.reverse(fruits);
        System.out.println("Reversed: " + fruits);
        
        // Shuffle
        Collections.shuffle(fruits);
        System.out.println("Shuffled: " + fruits);
        
        // Binary search (on sorted list)
        Collections.sort(fruits);
        int index = Collections.binarySearch(fruits, "Banana");
        System.out.println("Index of Banana: " + index);
        System.out.println();
    }
    /**
     * Demonstrates different ways to iterate over a List.
     * Covers for-each, Iterator, and Java 8 lambda forEach.
     */
    public static void demonstrateIteration() {
        System.out.println("=== Iteration Methods ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // For-each loop
        System.out.print("For-each: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Iterator
        System.out.print("Iterator: ");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // forEach with lambda
        System.out.print("Lambda: ");
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println("\n");
    }
    
    // Utility methods
    
    /**
     * Removes duplicate elements from a list while maintaining insertion order.
     * 
     * @param <T> The type of list elements
     * @param list The input list containing possible duplicates
     * @return A new list containing unique elements
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        // LinkedHashSet automatically removes duplicates and maintains order
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
    
    /**
     * Filters a list to return only the even numbers.
     * 
     * @param numbers The input list of integers
     * @return A new list containing only even integers
     */
    public static List<Integer> getEvenNumbers(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens;
    }
    
    /**
     * Safely gets the first element of a list, returning null if empty.
     * 
     * @param <T> The type of list elements
     * @param list The input list
     * @return The first element, or null if empty
     */
    public static <T> T getFirstElement(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }
    
    /**
     * Safely gets the last element of a list, returning null if empty.
     * 
     * @param <T> The type of list elements
     * @param list The input list
     * @return The last element, or null if empty
     */
    public static <T> T getLastElement(List<T> list) {
        return list.isEmpty() ? null : list.get(list.size() - 1);
    }
}
