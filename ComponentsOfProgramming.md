# 🧩 The Core Components of Programming

## 1️⃣ Data

**Data** is the foundation of computer software. It represents the essential information that a program processes, stores, or transmits. Effective software development begins with the careful identification and classification of data.

### Identifying and Classifying Data

**Data identification** is the first step in software development. For example, when building software for a bank, you identify key data elements such as accounts, customers, transactions, and employees.

**Data classification** follows identification and involves organizing data based on its type and characteristics. Proper classification ensures that data can be efficiently processed, stored, transmitted, and maintained within the software system.

### 🔹 Data Types and Logical Grouping

| Concept                        | Description                                   | Example                                      |
|--------------------------------|-----------------------------------------------|----------------------------------------------|
| Single Variable                | Represents a single value                     | `int customerAge = 30;`                      |
| Structure (Array)              | Collection of similar data items              | `int[] scores = {85, 90, 78};`               |
| Logical Grouping (Struct/Class)| Group related data logically                  | `class User { String name; int age; }`       |

- **Single variables** are used for atomic data (e.g., age, bank balance). Primitive data types are used to store and retrieve them in RAM. Choose the right data type for your needs, as each type directly affects memory usage:
    1. byte
    2. short
    3. int
    4. long
    5. float
    6. double
    7. char
    8. boolean
- **Arrays/Lists** group similar items (same data type) (e.g., scores, names).
    1. Arrays
    2. Java Collections are used to group similar data type elements for storage and retrieval.
- **Classes/Structs/Records** group related attributes (struct in C/C++ for non-OOP, class in Java for OOP), sometimes with behaviors, forming logical models.

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

---

## 2️⃣ Function

- A **function** is a block of code that implements business logic using the identified data. For example, in a banking application, a function like `transact(Account* fromAccount, Account* toAccount, double amount)` performs a transaction from one account to another.

    Functions typically includes to implement any logics,
    1. Conditional statements ``` if(expression)...else ```
    2. Decission making statments ```switch(options)... case option:```
    3. looping ```while(expression) & do...while(expression)```,  ```for()```, ``` iterator. ```

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

- In Java (and other object-oriented languages), a **method** is a function that is defined inside a class and operates on instances (objects) of that class.

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

---
