package com.example.javaguide.generics;

import java.util.*;

/**
 * GenericStack - A generic stack implementation
 */
public class GenericStack<T> {
    private List<T> elements;
    
    public GenericStack() {
        this.elements = new ArrayList<>();
    }
    
    public void push(T item) {
        elements.add(item);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    public int size() {
        return elements.size();
    }
    
    public void clear() {
        elements.clear();
    }
    
    @Override
    public String toString() {
        return elements.toString();
    }
    
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
