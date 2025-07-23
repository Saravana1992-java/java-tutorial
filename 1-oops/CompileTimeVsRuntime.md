# 🆚 Compile time vs Run time

| Aspect            | Compile Time                                         | Runtime                                              |
|-------------------|-----------------------------------------------------|------------------------------------------------------|
| **Definition**    | The phase when source code is translated to bytecode. Part of JDK. JDK includes the JRE plus development tools like the **Java compiler (javac)**, **debugger**, and other utilities | The phase when the compiled code is executed by the JVM and CPU. Part of JRE. JRE contains everything needed to run Java applications: the **JVM**, **class loaders**, **bytecode verifier**, **JIT compiler**, and **core libraries**. |
| **Who Handles**   | Compiler (e.g., `javac` in Java)                    | Java Virtual Machine (JVM) and underlying hardware   |
| **Purpose**       | Checks syntax, type safety, and generates bytecode.  | Executes instructions, manages memory, handles input/output, etc. |
| **Error Type**    | Compile-time errors (syntax errors, type errors)    | Runtime errors (exceptions, logic errors, resource issues) |
| **Examples**      | - Syntax checking<br>- Type checking<br>- Code optimization | - Program execution<br>- Dynamic class loading<br>- Exception handling<br>- User interaction |
| **Output**        | Bytecode (`.class` files)                           | Program output (console, files, GUI, etc.)           |

---

```mermaid
flowchart TD
    OOPS(["<a href='./Saravana1992-java/java-tutorial/blob/main/1-oops/PlatformIndependance.md/'>Previous</a>"])

```
---
