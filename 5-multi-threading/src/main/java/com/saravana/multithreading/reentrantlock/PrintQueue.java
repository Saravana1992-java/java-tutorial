package com.saravana.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private final ReentrantLock lock = new ReentrantLock(true); // fair lock

    public void printJob(String job) {
        lock.lock();
        try {
            System.out.println("Printing: " + job + " by " + Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }
}
