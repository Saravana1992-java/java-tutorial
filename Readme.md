# Java Tutorial

This GitHub project offers a comprehensive collection of Java topics, spanning from fundamental computer concepts to advanced Java programming. Each topic is accompanied by clear documentation, sample programs, and corresponding test cases. The content is organized into individual Gradle modules for structured and focused learning.

- Each Gradle project is configured as a **java-library** ``` plugins {
    id 'java-library'
} ``` and does not contain a main class for direct execution. To run or explore the code, please refer to the relevant test cases provided within each module.
- Diagrams such as FlowChart, uml diagrams (ClassDiagrams), etc used in this documentation are drawn with [mermaid](https://mermaid.js.org/intro/)


## 📦 Multi-Module Gradle Project Hierarchy

```mermaid

flowchart LR
    Root["java-tutorial"]
    Root --> OOPS["<a href='./Saravana1992-java/java-tutorial/blob/main/1-oops/ProgrammingParadigm.md/'>1-oops</a>"]
    Root --> OOAD["<a href='./Saravana1992-java/java-tutorial/blob/main/2-ooad/OOAD.md'>2-ooad</a>"]
    Root --> Generics["<a href='./Saravana1992-java/java-tutorial/blob/main/3-generics/JavaGenerics.md'>3-generics</a>"]
    Root --> Collections["<a href='./Saravana1992-java/java-tutorial/blob/main/4-collections/JavaCollections.md'>4-collections</a>"]
    Root --> MultiThreading["<a href='./Saravana1992-java/java-tutorial/blob/main/5-multi-threading/ConcurrantProgramming.md'>5-multi-threading</a>"]
    Root --> Advanced["<a href='./Saravana1992-java/java-tutorial/blob/main/6-advanced/AdvancedJavaProgramming.md'>6-advanced</a>"]
```

```mermaid
flowchart RL
    OOPS["<a href='./Saravana1992-java/java-tutorial/blob/main/1-oops/ProgrammingParadigm.md/'>Next</a>"]
```
---
