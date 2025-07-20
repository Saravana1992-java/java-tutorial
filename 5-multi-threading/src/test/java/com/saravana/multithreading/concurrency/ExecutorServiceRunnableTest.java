package com.saravana.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ExecutorServiceRunnableTest {

    @Test
    public void testExecuteRunsWithoutException() {
        ExecutorServiceRunnable runnableExample = new ExecutorServiceRunnable();
        assertDoesNotThrow(() -> runnableExample.execute());
    }
}