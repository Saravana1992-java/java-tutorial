package com.saravana.multithreading.reentrantlock;

import org.junit.jupiter.api.Test;

public class CacheTest {

    @Test
    public void testTryUpdateCache_MultiThreaded() throws InterruptedException {
        Cache cache = new Cache();

        Runnable task = () -> cache.tryUpdateCache();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Check console output to verify mutual exclusion
    }
}