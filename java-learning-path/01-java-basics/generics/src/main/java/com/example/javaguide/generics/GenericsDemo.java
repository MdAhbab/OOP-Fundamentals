package com.example.javaguide.generics;

import java.util.*;

/**
 * GenericsDemo - Demonstrates generic classes and methods
 */
public class GenericsDemo {
    
    public static void main(String[] args) {
        demonstrateGenericBox();
        demonstrateGenericMethods();
        demonstrateBoundedTypes();
        demonstrateWildcards();
    }
    
    public static void demonstrateGenericBox() {
        System.out.println("=== Generic Box Demo ===");
        
        // Box with Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Integer Box: " + intBox.get());
        
        // Box with String
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.println("String Box: " + strBox.get());
        
        // Pair
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair.getKey() + " = " + pair.getValue());
        System.out.println();
    }
    
    public static void demonstrateGenericMethods() {
        System.out.println("=== Generic Method Demo ===");
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World"};
        
        // Print array using generic method
        System.out.print("Integer Array: ");
        printArray(intArray);
        
        System.out.print("String Array: ");
        printArray(strArray);
        
        // Reverse array
        Integer[] reversed = reverseArray(intArray);
        System.out.print("Reversed: ");
        printArray(reversed);
        
        System.out.println();
    }
    
    public static void demonstrateBoundedTypes() {
        System.out.println("=== Bounded Type Parameters ===");
        
        Integer[] numbers = {5, 2, 8, 1, 9};
        Integer max = findMax(numbers);
        System.out.println("Max: " + max);
        
        String[] words = {"apple", "zebra", "banana"};
        String maxWord = findMax(words);
        System.out.println("Max word: " + maxWord);
        
        Double sum = sumOfNumbers(Arrays.asList(1.5, 2.5, 3.0));
        System.out.println("Sum: " + sum);
        System.out.println();
    }
    
    public static void demonstrateWildcards() {
        System.out.println("=== Wildcards Demo ===");
        
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        
        printList(integers);
        printList(doubles);
        
        double sum1 = sumOfList(integers);
        double sum2 = sumOfList(doubles);
        
        System.out.println("Sum of integers: " + sum1);
        System.out.println("Sum of doubles: " + sum2);
        System.out.println();
    }
    
    // Generic method to print array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // Generic method to reverse array
    public static <T> T[] reverseArray(T[] array) {
        @SuppressWarnings("unchecked")
        T[] reversed = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
    
    // Bounded type parameter - must implement Comparable
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
    
    // Upper bounded wildcard
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    // Unbounded wildcard
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    
    // Bounded type parameter with Number
    public static <T extends Number> double sumOfNumbers(List<T> numbers) {
        double sum = 0.0;
        for (T num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
}

/**
 * Generic Box class
 */
class Box<T> {
    private T value;
    
    public void set(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
    
    public boolean isEmpty() {
        return value == null;
    }
}

/**
 * Generic Pair class
 */
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}
