package com.saravana.multithreading.basic;

import org.junit.jupiter.api.Test;

public class ThreadPriorityDemoTest {

    @Test
    public void testThreadPriority() {
        Thread thread1 = new Thread(new ThreadPriorityDemo(), "Thread-1");
        Thread thread2 = new Thread(new ThreadPriorityDemo(), "Thread-2");

        // Set priorities
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}
