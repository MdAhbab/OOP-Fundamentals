package com.example.javaguide.concurrency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.*;

class ConcurrencyTest {
    
    @Test
    @DisplayName("Counter should be thread-safe")
    void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        int iterations = 1000;
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        assertEquals(2000, counter.getValue());
    }
    
    @Test
    @DisplayName("AtomicCounter should be thread-safe")
    void testAtomicCounter() throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        int iterations = 1000;
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        assertEquals(2000, counter.getValue());
    }
    
    @Test
    @DisplayName("ExecutorService should execute tasks")
    void testExecutorService() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Future<String> future = executor.submit(() -> {
            Thread.sleep(50);
            return "Task completed";
        });
        
        assertEquals("Task completed", future.get());
        
        executor.shutdown();
        assertTrue(executor.awaitTermination(1, TimeUnit.SECONDS));
    }
}
