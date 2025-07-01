package com.saravana.multithreading.core;

public class ThreadPriorityDemo extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " with priority " + Thread.currentThread().getPriority());
    }

}
