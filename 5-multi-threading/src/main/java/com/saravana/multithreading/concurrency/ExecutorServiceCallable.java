package com.saravana.multithreading.concurrency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceCallable {

    public void execute() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> results = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            String fileName = "file" + i + ".txt";
            Callable<String> task = () -> {
                StringBuilder sb = new StringBuilder();
                System.out.println("Reading " + fileName + " on " + Thread.currentThread().getName());
                try (
                        InputStream is = ExecutorServiceCallable.class.getClassLoader().getResourceAsStream(fileName);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append(System.lineSeparator());
                    }
                }
                return sb.toString();
            };
            System.out.println("Submitting task for " + fileName);
            results.add(executor.submit(task));
        }

        // Print the contents of each file as returned by the futures
        for (int i = 0; i < results.size(); i++) {
            Future<String> future = results.get(i);
            System.out.println("Contents of file" + (i + 1) + ".txt:");
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    public static void main(String[] args) throws Exception {

    }
}