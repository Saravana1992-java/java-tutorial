package com.saravana.multithreading.basic;

public class VolatileCounter {

    private volatile int count = 0;

    // Method to increment the counter
    public void increment() {
        count++;
    }

    // Method to get the current value of the counter
    public int getCount() {
        return count;
    }

}
