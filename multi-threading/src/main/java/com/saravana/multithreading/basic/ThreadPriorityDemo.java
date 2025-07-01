package com.saravana.multithreading.basic;

public class ThreadPriorityDemo extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " with priority " + Thread.currentThread().getPriority());
    }

}
