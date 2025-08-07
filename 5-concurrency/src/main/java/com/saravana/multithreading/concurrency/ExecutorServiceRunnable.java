package com.saravana.multithreading.concurrency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunnable {

    public void execute() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            String fileName = "file" + i + ".txt";
            Runnable task = () -> {
                StringBuilder sb = new StringBuilder();
                System.out.println("Reading " + fileName + " on " + Thread.currentThread().getName());
                try (
                        InputStream is = ExecutorServiceRunnable.class.getClassLoader()
                                .getResourceAsStream(fileName);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append(System.lineSeparator());
                    }
                    System.out.println("Contents of " + fileName + ":\n" + sb);
                } catch (Exception e) {
                    System.out.println("Error reading " + fileName + ": " + e.getMessage());
                }
            };
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
    }
}
