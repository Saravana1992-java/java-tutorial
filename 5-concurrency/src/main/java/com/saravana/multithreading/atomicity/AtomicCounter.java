package com.saravana.multithreading.atomicity;

public class AtomicCounter {

    private java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);

    // Method to increment the counter atomically
    public void increment() {
        count.incrementAndGet();
    }

    // Method to get the current value of the counter atomically
    public int getCount() {
        return count.get();
    }

}
