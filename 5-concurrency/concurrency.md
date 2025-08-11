# 🧵 Java Concurrency & Parallelism Comparison

| # | Model / API | What It Is | How to Implement | Code Example | When to Choose |
|---|-------------|------------|------------------|--------------|----------------|
| 1 | **Runnable** | Interface for tasks without return value | Implement `run()` and pass to `Thread` or `Executor` | `new Thread(() -> { /* task */ }).start();` | Simple CPU-bound tasks; fire-and-forget logic |
| 2 | **Callable** | Interface for tasks with return value | Implement `call()` and submit to `ExecutorService` | `executor.submit(() -> "result");` | When task needs to return a result or throw checked exceptions |
| 3 | **Thread** | Class representing a native thread | Pass `Runnable` to constructor or extend `Thread` | `new Thread(new MyRunnable()).start();` | Direct thread control; low-level threading (rarely preferred now) |
| 4 | **Virtual Thread**<br>(Project Loom) | Lightweight JVM-managed thread | `Thread.startVirtualThread(() -> {})` or `Thread.ofVirtual().start()` | `Thread.startVirtualThread(() -> { /* blocking I/O */ });` | High-concurrency I/O-bound apps; simplify async logic |
| 5 | **Executor / ExecutorService** | Framework for managing thread pools | Use `Executors.newFixedThreadPool()` or `newSingleThreadExecutor()` | `executor.execute(() -> { /* task */ });` | Structured thread management; decouple task from thread |
| 6 | **ScheduledExecutorService** | Scheduler variant of Executor | Use `schedule()` or `scheduleAtFixedRate()` | `scheduler.schedule(task, 1, TimeUnit.SECONDS);` | Time-based task execution; cron-like scheduling |
| 7 | **ForkJoinPool** | Pool for divide-and-conquer parallelism | Extend `RecursiveTask` or `RecursiveAction` | `pool.invoke(new MyRecursiveTask());` | CPU-bound recursive tasks; parallel data processing |
| 8 | **CompletableFuture** | Async computation framework | Chain tasks with `thenApply`, `thenCompose`, etc. | `CompletableFuture.supplyAsync(() -> "result")` | Async workflows; orchestration of dependent tasks |
| 9 | **Project Reactor (Flux/Mono)** | Reactive streams framework | Use `Flux.just()`, `Mono.fromCallable()`, etc. | `Flux.range(1, 10).map(i -> i * 2)` | Event-driven, streaming, backpressure-sensitive systems |

---

## 🧠 Additional Notes

- **Backpressure**: Only **Reactor** (Flux/Mono) has built-in support. Virtual threads require **manual handling** (e.g., queues, semaphores).
- **Parallelism vs Concurrency**:
  - *Concurrency*: Multiple tasks in progress (may not run simultaneously).
  - *Parallelism*: Tasks run simultaneously (true multi-core execution).
- **Virtual Threads** simplify concurrency but don’t replace reactive streams in **streaming or backpressure-critical** systems.

```mermaid
flowchart TD
    MT(["<a href='./Saravana1992-java/java-tutorial/blob/main/5-concurrency/ConcurrantProgramming.md/'>Previous</a>"])

    ADV(["<a href='./Saravana1992-java/java-tutorial/blob/main/6-advanced/AdvancedJavaProgramming.md/'>Next</a>"])

```

---
