package com.saravana.multithreading.reentrantlock;

import org.junit.jupiter.api.Test;

public class PrintQueueTest {

    @Test
    public void testPrintQueueFairness() throws InterruptedException {
        PrintQueue printQueue = new PrintQueue();

        Runnable printTask = () -> {
            String job = "Job-" + Thread.currentThread().getName();
            printQueue.printJob(job);
        };

        Thread t1 = new Thread(printTask, "Thread-1");
        Thread t2 = new Thread(printTask, "Thread-2");
        Thread t3 = new Thread(printTask, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Check console output to verify jobs are printed in the order threads
        // requested the lock
    }
}