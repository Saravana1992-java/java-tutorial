# 🆚 Imperative vs Declarative Programming

| Aspect                | Imperative Programming                                 | Declarative Programming                              |
|-----------------------|-------------------------------------------------------|------------------------------------------------------|
| **Focus**             | How to do it (step-by-step instructions)              | What result you want                                 |
| **Control Flow**      | Explicit (loops, conditionals, assignments)           | Implicit (handled by language/runtime)               |
| **State**             | Mutable, changes over time                            | Often immutable, minimal side effects                |
| **Examples**          | Java `for` loops, C, Python procedural code           | SQL, HTML, Java Streams, React JSX                   |

---

## Imperative Example (Java)

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

## Declarative Example (Java)

```java
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());
System.out.println(filteredNames); // Output: [Alice]
```
