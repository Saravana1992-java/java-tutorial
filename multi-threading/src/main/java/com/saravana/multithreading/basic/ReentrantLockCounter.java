package com.saravana.multithreading.basic;

public class ReentrantLockCounter {

    private final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
    private int count = 0;

    // Method to increment the counter using reentrant lock
    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

    // Method to get the current value of the counter using reentrant lock
    public int getCount() {
        lock.lock(); // Acquire the lock
        try {
            return count;
        } finally {
            lock.unlock(); // Ensure the lock is released
        }
    }

}
