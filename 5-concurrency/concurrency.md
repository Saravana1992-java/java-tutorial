# Java Concurrancy

## Executor Framework

The Executor Framework decouples task submission from task execution, abstracting away thread management. Instead of manually creating and starting threads, you submit tasks to an executor which handles threading efficiently

The Executor Framework provides a high-level API for managing threads and asynchronous task execution.

### Core Interfaces

- **Executor:** Basic interface for executing tasks.
- **ExecutorService:** Extends Executor, adds lifecycle management and task submission with results.
- **ScheduledExecutorService:** Supports scheduling tasks to run after a delay or periodically.

### Executor Framework Implementation Hierarchy

```
                +------------------+
                |    Executor      |
                +------------------+
                         |
                         v
                +----------------------+     +------------------+
                |  ExecutorService     | --> |   ForkJoinPool   |
                +----------------------+     +------------------+
                         |
         +---------------+-------------------+
         |                                   |
         v                                   v
+--------------------------+      +-----------------------------+
| ScheduledExecutorService |      |      ThreadPoolExecutor     |
+--------------------------+      +-----------------------------+
         |                                   ^
         v                                   |
+-------------------------------+            |
| ScheduledThreadPoolExecutor   |<------------+
+-------------------------------+
         ^
         |
+----------------------+
| Executors (factory)  |
+----------------------+
         |
         v
+-----------------------------+
| newFixedThreadPool()        |
| newCachedThreadPool()       |
| newSingleThreadExecutor()   |
| newScheduledThreadPool()    |
| newWorkStealingPool()       |
+-----------------------------+


```

- **Executor** is the root interface.
- **ExecutorService** extends Executor.
- **ScheduledExecutorService** extends ExecutorService.
- **ThreadPoolExecutor**, **ScheduledThreadPoolExecutor**, and **ForkJoinPool** are main implementations.
- **Executors** is a utility class providing factory methods for common executor types.

# ExecutorService

# Difference between Runnable and Callable

| Feature         | Runnable                          | Callable<V>                        |
|-----------------|-----------------------------------|------------------------------------|
| Return value    | Cannot return a result            | Can return a result (of type V)    |
| Exception       | Cannot throw checked exceptions   | Can throw checked exceptions       |
| Method          | `void run()`                      | `V call()`                         |
| Usage           | Used with `Thread` or `Executor`  | Used with `ExecutorService`        |
| Future support  | No direct support                 | Returns a `Future<V>` when submitted|

**Example:**

```java
// Runnable example
Runnable task = () -> System.out.println("Running task");

// Callable example
Callable<Integer> task = () -> {
    return 42;
};
```

### Step-by-step Explanation

1. **Create ExecutorService:**  
   A fixed thread pool with 2 threads is created to execute tasks concurrently.

2. **Submit Callable Tasks:**  
   Five `Callable<Integer>` tasks are submitted. Each task prints its start and end, sleeps for 300ms, and returns a result.

3. **Collect Results:**  
   The main thread waits for all tasks to complete using `future.get()` and prints each result.

4. **Shutdown Executor:**  
   `shutdown()` is called to stop accepting new tasks.  
   `awaitTermination()` waits for all tasks to finish before exiting.

**Note:**  

- `shutdown()` does not kill threads immediately; it lets running and queued tasks finish.
- `Callable` allows tasks to return results and throw checked exceptions, unlike `Runnable`.

---

```mermaid
flowchart TD
    MT(["<a href='./Saravana1992-java/java-tutorial/blob/main/5-concurrency/ConcurrantProgramming.md/'>Previous</a>"])

    ADV(["<a href='./Saravana1992-java/java-tutorial/blob/main/6-advanced/AdvancedJavaProgramming.md/'>Next</a>"])

```

---
