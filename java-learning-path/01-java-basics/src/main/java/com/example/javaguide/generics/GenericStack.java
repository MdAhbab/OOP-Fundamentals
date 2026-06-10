package com.example.javaguide.generics;

import java.util.*;

/**
 * GenericStack - A generic stack (LIFO) implementation encapsulating structured data lists.
 * 
 * @param <T> The parameterized type characterizing components internally stored.
 */
public class GenericStack<T> {
    private List<T> elements;
    
    /**
     * Default constructor launching an independent dynamic tracking list configuration.
     */
    public GenericStack() {
        this.elements = new ArrayList<>();
    }
    
    /**
     * Appends elements sequentially dynamically extending stack volume directly overhead.
     * 
     * @param item Parameterized generic typed assignment
     */
    public void push(T item) {
        elements.add(item);
    }
    
    /**
     * Strips active top structural components rendering previous nested elements exposed directly.
     * 
     * @return Removed generic parameterized configuration
     * @throws EmptyStackException when attempting reduction against empty bounds arrays
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
    
    /**
     * Validates next extraction components identifying immediate top parameter returns.
     * 
     * @return Next parameterized entry reference targeted sequentially 
     * @throws EmptyStackException when arrays do not maintain internal depth
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }
    
    /**
     * Verifies array limits mathematically highlighting absolute zero depth configurations.
     * 
     * @return True structurally determining void lists
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Determines current operational array depth directly sequentially defining scale.
     * 
     * @return Total volume integer mapping
     */
    public int size() {
        return elements.size();
    }
    
    /**
     * Purges parameters removing components completely across standard List array limitations.
     */
    public void clear() {
        elements.clear();
    }
    
    @Override
    public String toString() {
        return elements.toString();
    }
    
    /**
     * Executes test validation arrays mapping operations manually defining operational successes.
     */
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack);
        System.out.println("Size: " + stack.size());
    }
}
