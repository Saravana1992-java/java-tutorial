package com.saravana.multithreading.reentrantlock;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoundedBufferTest {

    @Test
    public void testProducerConsumer() throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(2);

        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Integer value = buffer.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }
}