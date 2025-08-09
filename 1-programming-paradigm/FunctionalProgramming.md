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
  - Assigned to variables.
  - Can be passed as arguments.
  - Returned from other functions.
  - Stored in data structures
  
- A higher-order function (HOF) is a function that does at least one of the following:

  - Takes one or more functions as arguments
  - Returns a function as its result
    This means functions are treated as values—passed around, composed, and returned just like data.

### 4. **Function Composition**

- Building complex operations by combining simpler functions.
- Encourages modular, reusable code.

### 5. **Declarative Style**

- Focuses on *what* to do rather than *how* to do it.
- Contrast with imperative style, which involves step-by-step instructions.

---

## 🧩 When to Use Functional Programming

- Data transformation pipelines (e.g., filtering, mapping, reducing)
- Event-driven or reactive systems
- Concurrent or parallel processing
- Clean separation of concerns in business logic

---

## Functional Interface

A **Functional Interface** in Java is an interface that contains **exactly one abstract method**.

---

## 🔍 Definition

A [**Functional Interface**](./FunctionalInterface.md) provides a target type for lambda expressions and method references. It can have:

- One **abstract method** (required)
- Any number of **default** or **static** methods
- Annotated with `@FunctionalInterface` (optional but recommended)

### ✅ Example

```java
@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}

Operation add;

// Before Java 8 without Lambda expression
add = new Operation() {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
};
int result = compute(5, 3, add); // Passing add object as argument

// After Java 8 with Lambda expression - avoid complexity of strict class structure due to OOPS 
add = (a, b) -> a + b;
int result = compute(5, 3, add); // Passing behavior as data argument

public static int compute(int x, int y, Operation op) {
    return op.apply(x, y);
}

```

`@FunctionalInterface` annotation helps the compiler enforce the rule of **one abstract method**:

If you accidentally add a second abstract method, the compiler will throw an error.
You can now use it like this:

```java
Converter<String, Integer> stringToInt = s -> Integer.parseInt(s);
System.out.println(stringToInt.convert("123")); // Output: 123
```

---
