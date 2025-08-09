# 🧩 The Core Components of Programming

## 1️⃣ Data (Noun)

**Data** is the foundation of computer software and [It's First-class Citizens (or first-class object)]((#-what-are-first-class-citizens-in-programming)). It represents the essential **information** that a program processes, stores, or transmits. Effective software development begins with the careful **identification** and **classification** of data.

### Identifying and Classifying Data

**Data identification** is the first step in software development. For example, when building software for a bank, you identify key data elements such as accounts, customers, transactions, and employees.

**Data classification** follows identification and involves organizing data based on its type and characteristics. Proper classification ensures that data can be efficiently processed, stored, transmitted, and maintained within the software system.

### 🔹 Data Types and Logical Grouping

| Concept                        | Description                                   | Example                                      |
|--------------------------------|-----------------------------------------------|----------------------------------------------|
| Single Variable                | Represents a single value                     | `int customerAge = 30;`                      |
| Structure (Array)              | Collection of similar data items              | `int[] scores = {85, 90, 78};`               |
| Logical Grouping (Struct/Class)| Group related data logically                  | `class User { String name; int age; }`       |

- **Single variables** are used for [atomic data](./AtomicData.md) (e.g., age, bank balance). Primitive data types are used to store and retrieve them in RAM. Choose the right data type for your needs, as each type directly affects memory usage:
    1. byte
    2. short
    3. int
    4. long
    5. float
    6. double
    7. char
    8. boolean
- **Arrays/Lists** group similar items (same data type) (e.g., scores, names). **Example:**
    1. Arrays
    2. Java Collections are used to group similar data type elements for storage and retrieval.
- **Classes/Structs/Records** group related attributes (struct in C/C++, class in java), sometimes with behaviors, forming logical models.

    ```c
    // Struct in C language
    typedef struct {
        char accountNumber[20];
        double balance;
    } Account;
    ```

    ```java
    // Class in Java language
    class Account {
        String accountNumber;
        double balance;
    };
    ```

## 2️⃣ Function (Verb)

- A **function** is a **basic unit of work** performed on the the identified data. For example, in a banking application, a function like `transact(Account* fromAccount, Account* toAccount, double amount)` performs a transaction from one account to another.

    Functions are implementation to perform tasks, step by step. It focuses on **control flow**, **mutable state**, and **sequential execution**.

    1. Conditional statements ``` if(expression)...else ```
    2. Decission making statments ```switch(options)... case option:```
    3. looping ```while(expression) & do...while(expression)```,  ```for()```, ``` iterator. ```
    4. Assignments ```int result = methodCal()```

### 🔧 Basic Structure

```c
typedef struct {
    char accountNumber[20];
    double balance;
} Account;

void transact(Account* fromAccount, Account* toAccount, double amount) {
    if (fromAccount->balance >= amount) {
        fromAccount->balance -= amount;
        toAccount->balance += amount;
    }
```

- In Java, a **method** is a function that is defined inside a class and operates on instances (objects) of that class.

``` java
class Account {
    String accountNumber;
    double balance;
    
    void transact(Account toAccount, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            toAccount.balance += amount;
        }
    }
```

### Note

Data is often passed between functions, procedures, or methods to improve modularity and maintain consistent state in Java.

- Java is always [**pass-by-value**](./PassByValueVsPassByReference.md).
- For objects, the reference to the object is passed by value—meaning the method receives a copy of the reference, not the actual object or the original reference itself.

#### 🧠 What Are First-Class Citizens in Programming?

In programming, a **first-class citizen** (or first-class object) refers to entities that can be:

- assigned to a variable
- passed as an argument to a function
- returned from a function
- stored in data structures

In modern-paradigms like **Functional Programming Paradigm** even Functions are **first-class citizen** (or first-class function). That means, Functions can be,

- assigned to a variable
- passed as an argument to a function
- returned from a function
- stored in data structures.

These are implemented differently in different Programming languages.

Since Java is **strictly object-oriented**, and **before Java 8**:

- You couldn’t pass a function directly.
- You had to wrap behavior inside an object (e.g., anonymous classes).

> [**Functional interfaces**](#-functionalinterface-example) solve this by giving the compiler a **type** to associate with a lambda expression.
---

### 📦 Storing Functions in Data Structures

Here’s how it works across a few languages:

#### **JavaScript**

```javascript
const callbacks = [
  () => console.log("First"),
  () => console.log("Second"),
  () => console.log("Third")
];

callbacks.forEach(fn => fn()); // Executes all callbacks
```

#### **Python**

```python
callbacks = [
    lambda: print("First"),
    lambda: print("Second"),
    lambda: print("Third")
]

for fn in callbacks:
    fn()  # Executes each lambda
```

#### **Java (8+)**

```java
import java.util.List;
import java.util.function.Consumer;

List<Consumer<String>> callbacks = List.of(
    s -> System.out.println("Hello " + s),
    s -> System.out.println("Goodbye " + s)
);

callbacks.forEach(fn -> fn.accept("Saravana"));
```

You can also store them in maps:

```java
Map<String, Runnable> actions = Map.of(
    "start", () -> System.out.println("Starting..."),
    "stop", () -> System.out.println("Stopping...")
);

actions.get("start").run();
```

---

### 🧠 Why This Is Powerful

- **Dynamic dispatch**: Choose behavior at runtime based on keys or conditions.
- **Plugin architecture**: Store handlers or strategies in a registry.
- **Event systems**: Map events to handlers.
- **Functional pipelines**: Chain transformations or validations.

---

### 🧩 Why It Matters

Treating callbacks as first-class citizens enables:

- **Higher-order functions** (functions that take or return other functions)
- **Functional composition**
- **Event-driven and asynchronous programming**
- **Cleaner, modular code**

---

### 🔧 FunctionalInterface example

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

Here, `add` is a **function** passed as a **value** to `compute`. That’s **passing behavior as data**.

---
