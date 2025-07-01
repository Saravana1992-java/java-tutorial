# Thread (True parallelism)
A thread in Java is a lightweight unit of execution within a process. It allows a program to perform multiple tasks concurrently. Each thread runs independently but shares the same memory and resources of the process.

### User thread
In Java, you can create a thread by:

1. Extending the Thread class, or
2. Implementing the Runnable interface.

Threads are managed by the Java Virtual Machine (JVM) and the underlying operating system, enabling parallel or concurrent execution of code.

### Daemon thread
- Daemon threads are background service threads that support user threads.
- Examples: garbage collector, monitoring threads, log flushers.
- The JVM will exit once all user threads finish—even if daemon threads are still running.

### Note
- Daemon threads are not suitable for critical tasks like saving data or writing to disk, because they may be killed mid-execution.

# Coroutine (high-concurrency)
A coroutine is a lightweight unit of execution that can suspend and resume its work at specific points, allowing other coroutines to run. Coroutines are managed by the programming language runtime, not the operating system, and are often used for asynchronous, non-blocking, or cooperative multitasking.

### Coroutines vs Threads

| Feature         | Coroutines                                 | Threads                                 |
|-----------------|--------------------------------------------|-----------------------------------------|
| Management      | Language/runtime                           | OS/JVM                                  |
| Resource usage  | Lightweight (thousands possible)           | Heavier (limited by OS resources)       |
| Concurrency     | Cooperative (yield/suspend explicitly)     | Preemptive (OS can switch at any time)  |
| Parallelism     | Usually single-threaded (unless combined)  | True parallelism on multi-core CPUs     |
| Use case        | I/O-bound, async, high concurrency         | CPU-bound, parallel tasks               |
| Context switch  | Fast, user-level                           | Slower, kernel-level                    |
| Example         | Python `async def`, Kotlin coroutines, Virtual threads (Project Loom in java 21), CompletableFuture (java 8+)       | Java `Thread`, Python `threading.Thread`|

# Parallelism vs Concurrency

| Feature         | Concurrency                                      | Parallelism                                 |
|-----------------|--------------------------------------------------|---------------------------------------------|
| Definition      | Multiple tasks make progress at the same time (may or may not be literally simultaneous) | Multiple tasks are executed exactly at the same time (simultaneously) |
| Execution       | Tasks are interleaved on one or more cores       | Tasks run at the same instant on multiple cores |
| Use case        | Handling many tasks (e.g., I/O, user requests)   | Speeding up computation-heavy tasks         |
| Example         | Single-core CPU running multiple threads (switching between them) | Multi-core CPU running multiple threads, each on its own core |
| Goal            | Improve responsiveness and resource utilization  | Reduce execution time by dividing work      |

**Summary:**  
- **Concurrency** is about dealing with lots of things at once (structure).
- **Parallelism** is about doing lots of things at once (execution).

# Mutual exclusion (lock)
Mutual exclusion is a concurrency control principle that ensures only one thread or process can access a shared resource or critical section at a time. This prevents race conditions and data inconsistency when multiple threads try to read or modify shared data simultaneously.

# Preemptive scheduling
Preemptive scheduling is a CPU scheduling technique used by operating systems where the scheduler can interrupt (preempt) a running thread or process to give CPU time to another thread or process, usually based on priority or time-slicing.

In preemptive scheduling, a thread does not control how long it runs; the OS can pause it at any time and switch to another thread.
This ensures better responsiveness and fairness, especially in multi-user or real-time systems.
In Java:
The JVM relies on the underlying OS’s preemptive scheduling for thread management. This means Java threads can be paused and resumed by the OS at any time, regardless of what the thread is doing (unless it holds a lock or is in a non-interruptible state).

### Summary
Preemptive scheduling allows the OS to forcibly switch between threads, ensuring all threads get a chance to run.

# Race condition
Race condition is a concurrency problem that occurs when two or more threads access shared data at the same time, and the final outcome depends on the timing or order of their execution. This can lead to unpredictable or incorrect results because the threads "race" to read or write the data.

### Example
If two threads increment the same counter variable without synchronization, both might read the same value and write back the same result, causing one increment to be lost.

### Summary
A race condition happens when multiple threads access and modify shared data concurrently without proper synchronization, leading to inconsistent or unexpected results.

# Atomicity 
Atomicity is a property of an operation or a set of operations that ensures they are performed as a single, indivisible unit. In the context of multi-threading, an atomic operation cannot be interrupted or observed in an incomplete state by other threads.

### Example
Incrementing an AtomicInteger using incrementAndGet() is atomic—no other thread can see the variable in a partially updated state.
In contrast, count++ is not atomic because it involves multiple steps (read, increment, write) that can be interleaved by other threads.

### Summary
Atomicity guarantees that a critical operation is completed fully or not at all, preventing race conditions in concurrent programming.

# Volatile (No gurantee for atomicity)
The volatile keyword in Java ensures visibility, not atomicity.

### Visibility 
When a variable is declared volatile, changes made by one thread are immediately visible to other threads.

### Atomicity 
Means an operation is performed as a single, indivisible step.

### Why volatile is not atomic?
- Operations like count++ are not atomic; they involve multiple steps (read, modify, write).
- Declaring count as volatile only ensures that threads see the latest value, but does not prevent race conditions during compound actions.

### Example

```java
volatile int count = 0;
count++; // Not atomic: read, increment, write (can be interleaved by threads)
```
### Summary
volatile guarantees visibility, but does not make compound operations atomic. For atomicity, use synchronization or atomic classes like AtomicInteger.

# Deadlock

A **deadlock** is a situation in concurrent programming where two or more threads are blocked forever, each waiting for the other to release a lock or resource. This causes the threads (and possibly the entire program) to stop making progress.

## Example

```java
// Example of potential deadlock
class A {
    synchronized void methodA(B b) {
        // Acquires lock on A, then tries to acquire lock on B
        b.last();
    }
    synchronized void last() {}
}

class B {
    synchronized void methodB(A a) {
        // Acquires lock on B, then tries to acquire lock on A
        a.last();
    }
    synchronized void last() {}
}

// If two threads call a.methodA(b) and b.methodB(a) at the same time,
// they can deadlock: each thread holds one lock and waits for the other.
```

## How to Prevent Deadlock

- **Lock ordering:** Always acquire locks in a consistent, predefined order.
- **Lock timeout:** Use try-lock with timeout (e.g., `tryLock(long timeout, TimeUnit unit)`) to avoid waiting forever.
- **Lock only what you need:** Minimize the scope and number of locks held at once.
- **Deadlock detection:** Use tools or algorithms to detect and recover from deadlocks.
- **Avoid nested locks:** Try to avoid acquiring multiple locks at the same time if possible.

## Example: Using tryLock to Avoid Deadlock

```java
import java.util.concurrent.locks.ReentrantLock;

ReentrantLock lockA = new ReentrantLock();
ReentrantLock lockB = new ReentrantLock();

public void safeMethod() {
    try {
        if (lockA.tryLock() && lockB.tryLock()) {
            // critical section
        }
    } finally {
        if (lockA.isHeldByCurrentThread()) lockA.unlock();
        if (lockB.isHeldByCurrentThread()) lockB.unlock();
    }
}
```

## Summary

Deadlock occurs when threads wait forever for resources held by each other. Prevent it by using consistent lock ordering, timeouts, and minimizing lock usage.

# Livelock

A **livelock** is a concurrency problem where two or more threads keep responding to each other and changing their state, but none of them make any real progress. Unlike deadlock, where threads are blocked, in livelock threads are actively running but unable to complete their tasks.

## Example

```java
class Spoon {
    private boolean isTaken = false;
    synchronized void take() throws InterruptedException {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }
    synchronized void putDown() {
        isTaken = false;
        notifyAll();
    }
}

class Philosopher implements Runnable {
    private final Spoon leftSpoon, rightSpoon;
    public Philosopher(Spoon left, Spoon right) {
        this.leftSpoon = left;
        this.rightSpoon = right;
    }
    public void run() {
        try {
            while (true) {
                leftSpoon.take();
                if (!rightSpoon.isTaken) {
                    rightSpoon.take();
                    // Eat
                    rightSpoon.putDown();
                    leftSpoon.putDown();
                    break;
                } else {
                    leftSpoon.putDown(); // Puts down and retries, but so does the other philosopher
                }
            }
        } catch (InterruptedException ignored) {}
    }
}
// Two philosophers may keep picking up and putting down spoons, but never eat (livelock).
```

## How to Prevent Livelock

- **Introduce random delays:** Add random sleep or backoff before retrying, so threads are less likely to interfere with each other in the same pattern.
- **Limit retries:** Restrict the number of retries before taking alternative action.
- **Use better coordination:** Design protocols so threads can make progress without constantly yielding to each other.

## Example: Preventing Livelock with Random Backoff

```java
import java.util.Random;

public void run() {
    Random random = new Random();
    try {
        while (true) {
            leftSpoon.take();
            if (!rightSpoon.isTaken) {
                rightSpoon.take();
                // Eat
                rightSpoon.putDown();
                leftSpoon.putDown();
                break;
            } else {
                leftSpoon.putDown();
                Thread.sleep(random.nextInt(100)); // Random backoff to avoid livelock
            }
        }
    } catch (InterruptedException ignored) {}
}
```

## Summary

Livelock occurs when threads keep changing state in response to each other but make no progress. Prevent it by introducing random delays, limiting retries, or improving coordination between threads.

# Starvation

**Starvation** is a concurrency problem where a thread is perpetually denied access to resources it needs for progress, because other threads are constantly acquiring those resources. As a result, the starved thread never gets a chance to execute its critical section.

## Example

```java
import java.util.concurrent.locks.ReentrantLock;

ReentrantLock lock = new ReentrantLock();

public void highPriorityTask() {
    while (true) {
        lock.lock();
        try {
            // High-priority work
        } finally {
            lock.unlock();
        }
        // Simulate frequent access
    }
}

public void lowPriorityTask() {
    while (true) {
        lock.lock();
        try {
            // Low-priority work
        } finally {
            lock.unlock();
        }
        // Simulate infrequent access
        try { Thread.sleep(100); } catch (InterruptedException ignored) {}
    }
}
// If highPriorityTask keeps acquiring the lock, lowPriorityTask may starve.
```

## How to Prevent Starvation

- **Fair locks:** Use fair locking mechanisms (e.g., `new ReentrantLock(true)`) to ensure threads acquire locks in the order they requested.
- **Thread priorities:** Avoid excessive reliance on thread priorities.
- **Resource allocation:** Ensure all threads get a chance to access shared resources.
- **Avoid infinite loops:** Design threads to yield or sleep periodically if they are long-running.

## Example: Using Fair Lock to Prevent Starvation

```java
import java.util.concurrent.locks.ReentrantLock;

ReentrantLock fairLock = new ReentrantLock(true); // fair lock

public void task() {
    fairLock.lock();
    try {
        // Critical section
    } finally {
        fairLock.unlock();
    }
}
```

## Summary

Starvation happens when a thread is continuously denied access to resources, preventing it from making progress. Prevent it by using fair locks, balanced resource allocation, and careful thread design.