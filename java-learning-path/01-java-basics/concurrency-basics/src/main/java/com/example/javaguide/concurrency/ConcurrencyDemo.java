package com.example.javaguide.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrencyDemo - Demonstrates basic concurrency concepts
 */
public class ConcurrencyDemo {
    
    public static void main(String[] args) throws Exception {
        demonstrateBasicThread();
        demonstrateRunnable();
        demonstrateExecutorService();
        demonstrateSynchronization();
    }
    
    public static void demonstrateBasicThread() throws InterruptedException {
        System.out.println("=== Basic Thread ===");
        
        Thread thread = new Thread(() -> {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        });
        
        thread.start();
        thread.join(); // Wait for thread to complete
        System.out.println();
    }
    
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
 * Thread-safe counter using synchronized
 */
class Counter {
    private int value = 0;
    
    public synchronized void increment() {
        value++;
    }
    
    public synchronized int getValue() {
        return value;
    }
}

/**
 * Atomic counter (alternative approach)
 */
class AtomicCounter {
    private AtomicInteger value = new AtomicInteger(0);
    
    public void increment() {
        value.incrementAndGet();
    }
    
    public int getValue() {
        return value.get();
    }
}
