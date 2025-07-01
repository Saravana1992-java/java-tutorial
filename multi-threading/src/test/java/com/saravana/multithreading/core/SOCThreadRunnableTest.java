package com.saravana.multithreading.core;

import org.junit.jupiter.api.Test;

public class SOCThreadRunnableTest {

    @Test
    public void testRunnableExecution() throws InterruptedException {
        SOCThreadRunnable runnable1 = new SOCThreadRunnable("RunnableThread1");
        SOCThreadRunnable runnable2 = new SOCThreadRunnable("RunnableThread2");

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // No assertion here, but you can check the console output for expected behavior
        // For real-world cases, consider using mocks or flags to verify execution
    }
}