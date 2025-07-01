package com.saravana.multithreading.basic;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.saravana.multithreading.basic.AtomicCounter;
import com.saravana.multithreading.basic.ReentrantLockCounter;
import com.saravana.multithreading.basic.SynchronizedCounter;
import com.saravana.multithreading.basic.VolatileCounter;

public class CounterTest {
    int iterations = 1_000_000;
    int threadCount = 10;
    int expectedCount = iterations * threadCount;
    int actualCount = 0;

    static Stream<Object[]> counterProvider() {
        return Stream.of(
                new Object[] { "Synchronized", new SynchronizedCounter() },
                new Object[] { "ReentrantLock", new ReentrantLockCounter() },
                new Object[] { "Atomic", new AtomicCounter() },
                new Object[] { "Volatile", new VolatileCounter() });
    }

    @ParameterizedTest
    @MethodSource("counterProvider")
    @DisplayName("Counter concurrency test")
    public void runTest(String label, Object counter) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < iterations; i++) {
                if (counter instanceof SynchronizedCounter)
                    ((SynchronizedCounter) counter).increment();
                else if (counter instanceof ReentrantLockCounter)
                    ((ReentrantLockCounter) counter).increment();
                else if (counter instanceof AtomicCounter)
                    ((AtomicCounter) counter).increment();
                else if (counter instanceof VolatileCounter)
                    ((VolatileCounter) counter).increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();

        int finalCount = 0;
        if (counter instanceof SynchronizedCounter)
            finalCount = ((SynchronizedCounter) counter).getCount();
        else if (counter instanceof ReentrantLockCounter)
            finalCount = ((ReentrantLockCounter) counter).getCount();
        else if (counter instanceof AtomicCounter)
            finalCount = ((AtomicCounter) counter).getCount();
        else if (counter instanceof VolatileCounter)
            finalCount = ((VolatileCounter) counter).getCount();

        System.out.printf("%s Counter: Final count = %d, Time = %d ms%n", label, finalCount, (end - start));
    }

}
