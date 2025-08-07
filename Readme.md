# 🧠 Design-Driven Java Programming Tutorial

This repository presents a **comprehensive and modular Java tutorial** built with a strong focus on [design thinking](./DesignThinking.md), helping learners move beyond coding not just by syntax, but through the lens of **robust design** and **real-world applicability**.

## 👥 For Whom?

Designed to benefit:

- **Beginners** seeking conceptual clarity and real-world relevance  
- **Experienced developers** aiming to sharpen design skills and system thinking  

This tutorial bridges **theory and execution**, preparing learners to architect robust, scalable software systems using Java in dynamic, cloud-native environments.

---

## Hello, World from Java

Before diving into the tutorial, let’s first understand [what software is](./Software.md) and With the help of [OS](./OS.md), [How the software is running as a OS process or service](./CPUCycleOfProcess.md) and utilizing a underlying computer hardware such as CPU, RAM, Hard disk and etc.

However, a common challenge arises: since [different operating systems are implemented using different programming languages and architectures](./OS.md/#️-operating-systems--their-language-roots) , developers often need to rewrite the same business logic in multiple programming languages to support different platforms.

**Java** addresses this complexity through its [platform-independent](./PlatformIndependance.md) nature, enabling the principle of **Write Once, Run Anywhere**. This means Java applications can run on any system equipped with a compatible Java Virtual Machine (JVM), regardless of the underlying OS. Understanding JVM helps to write a better app in java.

> This tutorial offers a comprehensive guide to developing software applications using ```Java```. While Java is fundamentally rooted in the Object-Oriented Programming paradigm, it is important to recognize and explore other prominent programming paradigms that can enhance software design and implementation. These include:
>
> 1. Declarative Programming  
> 2. Functional Programming  
> 3. Concurrent Programming  
> 4. Reactive Programming  
> 5. Event-Driven Programming, among others.

```mermaid
flowchart TD
    OOPS(["<a href='./Saravana1992-java/java-tutorial/blob/main/1-programming-paradigm/ProgrammingParadigm.md/'>programming-paradigm</a>"])
```

---

## About this Git Repository

### 🔍 Key Highlights

- 🎯 Explains [**programming paradigms**](./1-programming-paradigm/ProgrammingParadigm.md) — including [Object-Oriented](./1-programming-paradigm/OOPS.md), Event-Driven, Concurrent, and Reactive models  
- 🧠 Introduces core **design principles** (e.g., SOLID, DRY, KISS, YAGNI) and **design patterns** applicable to modern Java development  
- 🛠 Covers the full spectrum — from foundational **operating system concepts** to advanced **software architecture techniques**  
- ☁️ Equips learners to **design, implement, deploy, secure, maintain, and scale** Java applications in the **modern cloud era**  
- 🧱 Organized into **Gradle modules** with clear documentation, sample programs, test cases, and [visual aids](https://mermaid.js.org/intro/) for structured learning
- 📦 Each Gradle project is configured as a **java-library** ``` plugins {
    id 'java-library'
} ``` and does not contain a main class for direct execution. To run or explore the code, please refer to the relevant test cases provided within each module.

### 📦 Multi-Module Gradle Project Hierarchy

```mermaid

flowchart LR
    Root["java-tutorial"]
    Root --> OOPS["<a href='./Saravana1992-java/java-tutorial/blob/main/1-programming-paradigm/ProgrammingParadigm.md/'>1-programming-paradigm</a>"]
    Root --> OOAD["<a href='./Saravana1992-java/java-tutorial/blob/main/2-system-design/OOAD.md'>2-system-design</a>"]
    Root --> Generics["<a href='./Saravana1992-java/java-tutorial/blob/main/3-generics/JavaGenerics.md'>3-generics</a>"]
    Root --> Collections["<a href='./Saravana1992-java/java-tutorial/blob/main/4-collections/JavaCollections.md'>4-collections</a>"]
    Root --> MultiThreading["<a href='./Saravana1992-java/java-tutorial/blob/main/5-concurrency/ConcurrantProgramming.md'>5-concurrency</a>"]
    Root --> Advanced["<a href='./Saravana1992-java/java-tutorial/blob/main/6-advanced/AdvancedJavaProgramming.md'>6-advanced</a>"]
```

---
