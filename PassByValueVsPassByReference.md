# Java pass by value Or Pass by reference

## 🔁 What Is Pass-by-Value?

In **pass-by-value**, a **copy** of the variable is passed to the method. Changes made to the parameter **do not affect** the original variable.

### 🧪 Example in Java

```java
public class Demo {
    public static void main(String[] args) {
        int x = 10;
        modify(x);
        System.out.println(x); // Output: 10
    }

    static void modify(int value) {
        value = 20; // Only modifies the copy
    }
}
```

Here, `x` remains `10` because Java passes a **copy** of the primitive.

---

## 🔗 What Is Pass-by-Reference?

In **pass-by-reference**, the **actual memory address** of the variable is passed. Changes made inside the method **do affect** the original variable.

> ⚠️ **Java does not support true pass-by-reference.**

Languages like C++ (with pointers) or Python (with mutable objects) can exhibit pass-by-reference-like behavior.

---

## 🧠 Java’s Model: Always Pass-by-Value

Java is **strictly pass-by-value**, but with a twist for **objects**:

- For **primitives**: the value itself is copied.
- For **objects**: the **reference** is copied (not the object), so both caller and callee refer to the **same object**.

### 🧪 Example with Objects

```java
class Person {
    String name;
}

public class Demo {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Alice";
        changeName(p);
        System.out.println(p.name); // Output: Bob
    }

    static void changeName(Person person) {
        person.name = "Bob"; // Modifies the object via copied reference
    }
}
```

Here, the reference to `Person` is passed **by value**, but both point to the same object—so changes are visible.

---

## 🧩 Summary Table

| Type       | Java Behavior     | Changes Visible? | Notes |
|------------|-------------------|------------------|-------|
| Primitive  | Pass-by-value     | ❌ No             | Copy of value |
| Object     | Pass-by-value (of reference) | ✅ Yes (object state) | Reference is copied, not the object |
| Reference itself | ❌ Not passed by reference | ❌ Can't reassign original | You can't change the caller’s reference |

---

## 🛠️ Analogy

Think of it like this:

- **Pass-by-value**: You give someone a **photocopy** of a document.
- **Pass-by-reference**: You give them the **original**.

In Java, you always give a **photocopy**—but if that copy points to a shared object, changes to the object are visible.

---
