package com.example.javaguide.lambdas;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * LambdasDemo - Demonstrates lambda expressions and Stream API
 */
public class LambdasDemo {
    
    public static void main(String[] args) {
        demonstrateLambdas();
        demonstrateStreams();
        demonstrateCollectors();
    }
    
    public static void demonstrateLambdas() {
        System.out.println("=== Lambda Expressions ===");
        
        // Runnable with lambda
        Runnable runnable = () -> System.out.println("Running task");
        runnable.run();
        
        // Comparator with lambda
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + names);
        
        // Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("10 is even: " + isEven.test(10));
        
        // Function
        Function<String, Integer> length = s -> s.length();
        System.out.println("Length of 'Hello': " + length.apply("Hello"));
        
        // Consumer
        Consumer<String> printer = s -> System.out.println("Value: " + s);
        printer.accept("Test");
        
        // Supplier
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random: " + randomSupplier.get());
        System.out.println();
    }
    
    public static void demonstrateStreams() {
        System.out.println("=== Stream Operations ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);
        
        // Map
        List<Integer> doubled = numbers.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled);
        
        // Reduce
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);
        
        // Sorted
        List<String> words = Arrays.asList("banana", "apple", "cherry");
        List<String> sorted = words.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted words: " + sorted);
        
        // Distinct
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> distinct = withDuplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct: " + distinct);
        
        // Count
        long count = numbers.stream()
            .filter(n -> n > 5)
            .count();
        System.out.println("Count > 5: " + count);
        System.out.println();
    }
    
    public static void demonstrateCollectors() {
        System.out.println("=== Advanced Collectors ===");
        
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
        
        // Group by first letter
        Map<Character, List<String>> grouped = words.stream()
            .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println("Grouped: " + grouped);
        
        // Joining
        String joined = words.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);
        
        // Statistics
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = nums.stream()
            .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Stats: " + stats);
        System.out.println();
    }
    
    // Utility methods using streams
    
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    }
    
    public static List<String> convertToUpperCase(List<String> strings) {
        return strings.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }
    
    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream()
            .max(Integer::compareTo);
    }
    
    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
    }
}
