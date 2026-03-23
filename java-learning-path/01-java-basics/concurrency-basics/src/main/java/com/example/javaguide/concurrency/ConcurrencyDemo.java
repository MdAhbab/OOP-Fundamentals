package com.example.javaguide.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrencyDemo - Demonstrates fundamental concurrency concepts in Java.
 * 
 * Provides illustrative structural examples of threading mechanisms, Runnable implementations,
 * Thread Pools via ExecutorService, and classical synchronization techniques.
 */
public class ConcurrencyDemo {
    
    /**
     * Executes defined thread components linearly displaying varying approaches.
     * 
     * @throws Exception generally handling execution Thread joins globally
     */
    public static void main(String[] args) throws Exception {
        demonstrateBasicThread();
        demonstrateRunnable();
        demonstrateExecutorService();
        demonstrateSynchronization();
    }
    
    /**
     * Demonstrates a basic anonymous Thread implementation utilizing modern Lambda structures.
     * 
     * @throws InterruptedException if waiting threads get interrupted physically
     */
    public static void demonstrateBasicThread() throws InterruptedException {
        System.out.println("=== Basic Thread ===");
        
        Thread thread = new Thread(() -> {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        });
        
        thread.start();
        thread.join(); // Wait for thread to complete
        System.out.println();
    }
    
    /**
     * Implements reusable Runnable tasks across differing parallel Thread allocations dynamically.
     * 
     * @throws InterruptedException if thread joining halts unsafely
     */
    public static void demonstrateRunnable() throws InterruptedException {
        System.out.println("=== Runnable Interface ===");
        
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        System.out.println();
    }
    
    /**
     * Replaces direct Thread instantiations natively via structural Thread Pools maximizing efficiency.
     * Extracts results securely via Future structures wrapping tasks generically.
     * 
     * @throws Exception matching overarching Future extraction limits mapping generically
     */
    public static void demonstrateExecutorService() throws Exception {
        System.out.println("=== ExecutorService ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Submit tasks
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(100);
            return 42;
        });
        
        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(100);
            return 100;
        });
        
        // Get results
        System.out.println("Result 1: " + future1.get());
        System.out.println("Result 2: " + future2.get());
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println();
    }
    
    /**
     * Illustrates classical critical section safeguards utilizing synchronized keywords.
     * Exposes multi-threading overlaps correctly validating thread-safe accumulations.
     * 
     * @throws InterruptedException highlighting thread termination block requirements
     */
    public static void demonstrateSynchronization() throws InterruptedException {
        System.out.println("=== Synchronization ===");
        
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Counter value: " + counter.getValue());
        System.out.println("Expected: 2000");
        System.out.println();
    }
}

/**
 * Thread-safe counter structure locking operations sequentially over common object monitors.
 */
class Counter {
    private int value = 0;
    
    /**
     * Safely increments the class state guarding changes tightly universally via mutual exclusion.
     */
    public synchronized void increment() {
        value++;
    }
    
    /**
     * Validates consistent atomic reads guaranteeing extraction during safe boundary phases.
     * 
     * @return Output state of synchronized accumulation element
     */
    public synchronized int getValue() {
        return value;
    }
}

/**
 * Alternate thread-safe encapsulation manipulating properties natively over Atomic hardware structures.
 * Bypasses intensive generic synchronized locks entirely utilizing CAS algorithms dynamically.
 */
class AtomicCounter {
    private AtomicInteger value = new AtomicInteger(0);
    
    /**
     * Non-blocking iteration update mathematically replacing locks directly via CPU primitives natively. 
     */
    public void increment() {
        value.incrementAndGet();
    }
    
    /**
     * Returns standard final calculated values mapped generically across active Atom instances.
     * 
     * @return Integer state
     */
    public int getValue() {
        return value.get();
    }
}
