# ⚙️ What Is Imperative Programming?

**Imperative programming** is a paradigm where the developer writes code that explicitly tells the computer **how to perform tasks**, step by step. It focuses on **control flow**, **mutable state**, and **sequential execution**.

## 🔑 Key Characteristics

- Uses statements like loops, conditionals, and assignments
- Relies on changing program state through variables
- Emphasizes *how* to achieve a result, not just *what* the result should be

---

## 🧪 Java Example: Imperative vs Declarative

### ✅ Imperative Style

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filteredNames = new ArrayList<>();

for (String name : names) {
    if (name.startsWith("A")) {
        filteredNames.add(name);
    }
}

System.out.println(filteredNames); // Output: [Alice]
```

- You explicitly tell the program how to loop, check conditions, and modify the list.
- This is **step-by-step instruction**, typical of imperative programming.

---

### 🆚 Declarative Style (for contrast)

```java
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());

System.out.println(filteredNames); // Output: [Alice]
```

- You declare *what* you want (filter names starting with "A") without specifying *how* to iterate or collect.

---
