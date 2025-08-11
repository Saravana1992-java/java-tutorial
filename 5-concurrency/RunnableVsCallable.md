# Difference between Runnable and Callable

| Feature         | Runnable                          | `Callable<V>`                        |
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

---
