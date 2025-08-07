package com.saravana.multithreading.reentrantlock;

import org.junit.jupiter.api.Test;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleTaskTest {

    @Test
    public void testInterruptibleTask() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        InterruptibleTask task = new InterruptibleTask(lock);

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        // Start first thread and let it acquire the lock
        t1.start();
        Thread.sleep(200); // Ensure t1 acquires the lock

        // Start second thread, which will block on lock
        t2.start();
        Thread.sleep(500); // Let t2 try to acquire the lock

        // Interrupt t2 while it's waiting for the lock
        t2.interrupt();

        t1.join();
        t2.join();

        // Check console output to verify t2 was interrupted while waiting for the lock
    }
}