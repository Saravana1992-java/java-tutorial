package com.saravana.multithreading.core;

/*
 * Use Runnable when:
 * Your class already extends another class (Java does not support multiple inheritance).
 * You want to separate the task (logic) from the thread management.
 * You want to share the same task among multiple threads.
 */

public class SOCThreadRunnable implements Runnable {
    private String threadName;

    public SOCThreadRunnable(String name) {
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
