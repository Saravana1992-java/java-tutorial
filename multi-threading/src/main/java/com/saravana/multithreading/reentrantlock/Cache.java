package com.saravana.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Cache {
    private final ReentrantLock lock = new ReentrantLock();

    public void tryUpdateCache() {
        if (lock.tryLock()) {
            try {
                // Update cache
                System.out.println("Cache updated by " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Cache busy, skipping update for " + Thread.currentThread().getName());
        }
    }
}
