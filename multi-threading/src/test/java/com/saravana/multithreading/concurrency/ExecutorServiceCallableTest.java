package com.saravana.multithreading.concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ExecutorServiceCallableTest {

    @Test
    public void testExecuteMethodRunsWithoutException() {
        ExecutorServiceCallable callableExample = new ExecutorServiceCallable();
        assertDoesNotThrow(() -> callableExample.execute());
    }
}