# 🧩 What is OOAD?

**Object-Oriented Analysis and Design** (**OOAD**) is a software engineering approach that uses object-oriented principles to analyze (**what**) and design (**how**) a system.

### Key Concepts

- **Object-Oriented Analysis (OOA):**  
  Focuses on understanding and modeling the problem domain by **identifying** the objects, their relationships, and interactions based on real-world scenarios.

- **Object-Oriented Design (OOD):**  
  Translates the analysis model into a design model by defining how the system will be **structured** in terms of classes, interfaces, methods, and their interactions to solve the problem.



# 🧠 Object-Oriented Analysis and Design (OOAD) – Core Principles

OOAD is a methodical approach to software development that combines object-oriented programming concepts with analysis and design strategies. It focuses on modeling software using real-world entities and interactions.

---

## 🔑 Core OOAD Principles

### 1. ✅ Abstraction
- Focuses on capturing essential characteristics while hiding unnecessary details.
- Example: Representing `Account` with attributes like `balance`, without exposing internal calculations.

### 2. 🧩 Encapsulation
- Bundles data and behavior inside classes, restricting direct access.
- Example: Use private fields with getters/setters in `Transaction` class.

### 3. 🧬 Inheritance
- Enables one class to reuse attributes and methods of another.
- Example: `SavingsAccount` and `CurrentAccount` inherit from a generic `Account` class.

### 4. 🔁 Polymorphism
- Allows entities to take on multiple forms via method overriding or interface implementation.
- Supports flexibility and **dynamic** behavior.
- Example: `calculateInterest()` method behaves differently based on account type.

### 5. 🤝 Association
- Models “has-a” or “uses-a” relationships between classes.
- Can be unidirectional or bidirectional.
- Example: `Customer` ↔ `Account` association.

### 6. ⚪ Aggregation
- Represents whole-part relationships where parts can exist independently.
- Example: `Department` aggregates `Employee`.

### 7. ⚫ Composition
- Stronger form of aggregation with dependent lifecycles.
- Example: `Room` is part of a `House`, and cannot exist without it.

---

## 📌 Additional OOAD Concepts
1. Design principles - SOLID, DRY, KISS, YAGNI
2. Design patterns - Creational patterns, Structural patterns & Behavioural patterns

---


```mermaid
flowchart TD
    OOPS(["<a href='./Saravana1992-java/java-tutorial/blob/main/1-oops/OOPS.md/'>Previous</a>"])

    SOLID(["<a href='./Saravana1992-java/java-tutorial/blob/main/2-ooad/SOLID.md/'>Next</a>"])

```
---