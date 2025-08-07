package com.saravana.multithreading.core;

/*
 * Use Thread when:
 * You want to override other Thread methods or customize the thread itself.
 * You don’t need to extend any other class.
 */

public class ThreadRunner extends Thread {
    private String threadName;

    public ThreadRunner(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is running");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + threadName + " is executing step " + i);
                Thread.sleep(1000); // Simulate work by sleeping for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " was interrupted");
        }
        System.out.println("Thread " + threadName + " has finished execution");
    }
}