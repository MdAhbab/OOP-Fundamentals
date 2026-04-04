package com.example.javaguide.generics;

import java.util.*;

/**
 * GenericsDemo - Demonstrates generic classes and methods in Java.
 * 
 * Generics enable types (classes and interfaces) to be parameters when defining
 * classes, interfaces and methods, providing stronger type checks at compile time.
 */
public class GenericsDemo {
    
    /**
     * Main method running all the generic demonstrations.
     */
    public static void main(String[] args) {
        demonstrateGenericBox();
        demonstrateGenericMethods();
        demonstrateBoundedTypes();
        demonstrateWildcards();
    }
    
    /**
     * Demonstrates the usage of generic class structures with varying parameter types.
     */
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
    
    /**
     * Demonstrates utilizing generic methods on array data elements.
     */
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
    
    /**
     * Demonstrates using bounded type parameters to restrict the types 
     * that can be used as arguments in generic methods.
     */
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
    
    /**
     * Demonstrates upper and unbounded wildcards allowing varying structured generic inputs.
     */
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
    
    /**
     * Generic method to print an array's contents sequentially.
     * 
     * @param <T> The parameterized type element defining the array contents
     * @param array Supported typed input array
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Generic method executing an in-place inversion sorting of elements.
     * 
     * @param <T> Parameter representing targeted elements
     * @param array Array requiring element positioning inversion
     * @return Fresh array consisting of inverted structural elements
     */
    public static <T> T[] reverseArray(T[] array) {
        @SuppressWarnings("unchecked")
        T[] reversed = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
    
    /**
     * Bounded type parameter implementation locating maxima against an element series.
     * Elements MUST implement the Comparable interface.
     * 
     * @param <T> Type param matching implementations of Comparable interfaces
     * @param array Target population
     * @return Derived maximum bound element inside parameter list
     */
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
    
    /**
     * Accumulates all elements mathematically matching an overarching Number generic type inheritance.
     * 
     * @param list Generic element listing conforming structurally with Number extension
     * @return Accumulated sum value dynamically derived 
     */
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    /**
     * Processes standard generic elements universally matching unbounded restrictions.
     * 
     * @param list Unknown parameter-based object enumeration
     */
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    
    /**
     * Extracts aggregate element summations utilizing Number bounded list targets directly.
     * 
     * @param <T> Derived parameters maintaining direct Number type lineage
     * @param numbers Targeted element array reference mapping
     * @return Compiled final calculated aggregate numeric elements
     */
    public static <T extends Number> double sumOfNumbers(List<T> numbers) {
        double sum = 0.0;
        for (T num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
}

/**
     * Generic Box class implementation illustrating simple structured encapsulation
     * logic mapped towards variable parameters representations at instantiation.
     * 
     * @param <T> Target object defined at instantiation time 
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
 * Generic Pair class dynamically encapsulating distinct double-key mappings 
 * for targeted structured definitions.
 * 
 * @param <K> Assigned primary Key structural type
 * @param <V> Defined stored Value variable type
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
