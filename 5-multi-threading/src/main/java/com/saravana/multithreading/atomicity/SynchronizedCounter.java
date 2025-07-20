package com.saravana.multithreading.atomicity;

public class SynchronizedCounter {

    private int count = 0;

    // Synchronized method to ensure thread-safe increment
    public synchronized void increment() {
        count++;
    }

    // Synchronized method to ensure thread-safe read
    public synchronized int getCount() {
        return count;
    }

}
