# 🌱 What Is Functional Programming?

**Functional Programming** is a programming paradigm where computation is treated as the evaluation of mathematical functions and avoids changing state or mutable data. It emphasizes **declarative code**, **immutability**, and **pure functions**.

---

## 🔑 Core Concepts of Functional Programming

Here are the foundational principles that define FP:

### 1. **Pure Functions**

- A function is *pure* if:
  - It always returns the same output for the same input.
  - It has no side effects (e.g., modifying global state, I/O operations).
- ✅ Example: `int square(int x) { return x * x; }`

### 2. **Immutability**

- Data is never modified after it's created.
- Instead of changing existing objects, new ones are returned.
- This leads to safer, more predictable code—especially in concurrent environments.

### 3. **First-Class and Higher-Order Functions**

- Functions are treated as values:
  - Can be passed as arguments.
  - Returned from other functions.
  - Assigned to variables.
- Higher-order functions take other functions as parameters or return them.

### 4. **Function Composition**

- Building complex operations by combining simpler functions.
- Encourages modular, reusable code.

### 5. **Declarative Style**

- Focuses on *what* to do rather than *how* to do it.
- Contrast with imperative style, which involves step-by-step instructions.

---

## 🧠 Functional Programming in Java

Java isn’t a purely functional language, but since **Java 8**, it has adopted many FP features:

| Feature | Description | Example |
|--------|-------------|---------|
| **Lambda Expressions** | Anonymous functions for concise behavior definition | `(x) -> x * x` |
| **Streams API** | Declarative data processing pipeline | `list.stream().filter(...).map(...).collect(...)` |
| **Functional Interfaces** | Interfaces with a single abstract method | `Predicate<T>`, `Function<T,R>`, `Consumer<T>` |
| **Optional** | Avoids null checks using monadic behavior | `Optional.ofNullable(value).map(...).orElse(...)` |
| **Method References** | Shorthand for calling existing methods | `String::toUpperCase` |

---

## ⚙️ Benefits of FP in Java

- ✅ **Improved readability and maintainability**
- ✅ **Better concurrency and parallelism**
- ✅ **Fewer bugs due to immutability and pure functions**
- ✅ **Easier testing and debugging**

---

## 🧩 When to Use Functional Programming

- Data transformation pipelines (e.g., filtering, mapping, reducing)
- Event-driven or reactive systems
- Concurrent or parallel processing
- Clean separation of concerns in business logic

---
