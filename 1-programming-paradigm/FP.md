# 🧠 What Is Functional Programming?

Functional programming is a **declarative paradigm** where computation is expressed as the **evaluation of pure mathematical functions**, rather than sequences of commands.

## 🔑 Core Principles

| Principle | Description |
|----------|-------------|
| **Pure Functions** | Always return the same output for the same input, with no side effects. |
| **Immutability** | Data is never modified—new data structures are created instead. |
| **First-Class & Higher-Order Functions** | Functions can be passed as arguments, returned, and stored. |
| **Referential Transparency** | Expressions can be replaced with their values without changing program behavior. |
| **Recursion over Loops** | Iteration is achieved via recursion, not mutable loops. |

> FP focuses on **what to solve**, not **how to solve it**—unlike imperative paradigms.

---

## 🧩 When to Choose Functional Programming

Functional programming excels in domains where **predictability, concurrency, and modularity** are critical:

- ✅ **Data transformation pipelines** (e.g., ETL, Spark)
- ✅ **Concurrent systems** (e.g., messaging apps, real-time analytics)
- ✅ **Mathematical modeling** (e.g., finance, ML algorithms)
- ✅ **Declarative UI frameworks** (e.g., React, Jetpack Compose)
- ✅ **Serverless functions** (e.g., AWS Lambda, GCP Cloud Functions)

---

## 💡 Example: Functional vs Imperative in Java

Let’s say we want to **filter even numbers and square them**.

### 🚫 Imperative Style (Mutable, Verbose)

```java
List<Integer> result = new ArrayList<>();
for (int n : numbers) {
    if (n % 2 == 0) {
        result.add(n * n);
    }
}
```

### ✅ Functional Style (Declarative, Immutable)

```java
List<Integer> result = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .collect(Collectors.toList());
```

This version:

- Uses **pure functions** (`filter`, `map`)
- Avoids mutable state
- Is **composable** and **readable**

---

## 🧠 Bonus: Functional Composition in Java

```java
Function<Integer, Integer> square = x -> x * x;
Function<Integer, Boolean> isEven = x -> x % 2 == 0;

List<Integer> result = numbers.stream()
    .filter(isEven::apply)
    .map(square::apply)
    .collect(Collectors.toList());
```

This showcases **first-class functions** and **composition**—hallmarks of FP.

---
