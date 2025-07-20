package com.saravana.multithreading.core;

import org.junit.jupiter.api.Test;

public class ThreadRunnerTest {
    @Test
    public void testThreadExecution() {
        // Create a thread instance
        ThreadRunner thread1 = new ThreadRunner("TestThread1");
        ThreadRunner thread2 = new ThreadRunner("TestThread2");

        // Start the thread
        thread1.start();
        thread2.start();

        System.out.println("Interrupt message from main thread");
        // Wait for the thread to finish execution
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution");
    }
}
