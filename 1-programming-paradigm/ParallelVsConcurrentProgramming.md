# 🆚 Parallel vs Concurrent Programming

| Feature               | **Concurrent Programming**                              | **Parallel Programming**                                 |
|-----------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Definition**         | Multiple tasks progress in overlapping time periods     | Multiple tasks run **at the same time** on multiple cores |
| **Execution**          | Tasks may share a single CPU via time-slicing           | Tasks run simultaneously on separate CPUs or cores        |
| **Goal**               | Improve responsiveness and task management              | Increase throughput and computation speed                 |
| **Hardware Need**      | Can run on a single-core processor                      | Requires multi-core or multi-processor systems            |
| **Example Use Case**   | Web server handling multiple requests                   | Data processing, machine learning, scientific computing   |
| **Programming Model**  | Threading, async tasks, event loops                     | Task splitting, distributed computing, GPU acceleration   |
| **Real-World Analogy** | One cashier serving multiple customers in turns         | Multiple cashiers serving multiple customers simultaneously |

---

## ✅ Refined Java Mapping

- **Virtual Threads** (Project Loom): Ideal for **concurrent I/O-bound** tasks — they scale well but don’t guarantee parallel execution.
- **CompletableFuture**: Enables **concurrent composition** of tasks, but actual parallelism depends on the executor used.
- **ExecutorService**: A flexible abstraction — can be used for both concurrency (single-threaded executor) and parallelism (fixed/thread pool).
- **Parallel Streams / ForkJoinPool**: Explicitly designed for **parallel execution** of CPU-bound tasks.

> Learn more about Java concurrency and parallelism [here](./).

---

## 🧠 Summary

- **Concurrency** is about managing multiple tasks efficiently. OS or runtime schedules tasks to share CPU resources.

- **Parallelism** is about executing tasks simultaneously for speed. OS or runtime assigns tasks to separate cores for true parallel execution.
