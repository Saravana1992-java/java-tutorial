# Object Oriented Programming (OOPS)

**Object Oriented Programming (OOPS)** is a programming paradigm that organizes software design around data, or objects, rather than functions and logic. Objects are instances of classes, which encapsulate both data (attributes) and behavior (methods).

## Key Principles of OOPS

| Principle       | Description                                                                                  |
|-----------------|----------------------------------------------------------------------------------------------|
| **Class**       | ```Class```ification of related attributes (fields) and behaviors (methods). A blueprint for creating objects.      |
| **Object**      | An instance ``` new ``` of a class. Represents a real-world entity with state and behavior.              |
| **Encapsulation** | Classification of related data and methods in one unit and restricting access by keywords such as ```default```, ```private```, ```public```, ``` protected``` to another objects. |
| **Abstraction** | Hiding complex implementation details and showing only the necessary features of an object using ``` interface ``` & ``` abstract class ```  |
| **Inheritance** | Mechanism by which one class can inherit properties and behaviors from another class using ``` extend ``` and restricting access by ``` protected ``` or ``` private ```       |
| **Polymorphism**| **Many forms**. Ability of different objects to respond, each in its own way, to identical messages (methods). **Example:**  A method called `displayBalance()` can be called on both `Account` and `SavingsAccount` objects, but each class can have its own version of implementation. ``` 1. Compile time (method overloading) 2. Run time (method overriding) ```|

---

## Example

```java
// Class definition (related field & method)
class Account {
    String accountNumber;
    double balance;
    protected void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

// Inheritance and Polymorphism
class SavingsAccount extends Account {
    double interestRate;
    @Override
    void displayBalance() {
        System.out.println("Savings Account Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }
}

// Encapsulation and Object creation
public class Main {
    public static void main(String[] args) {
        Account myAccount = new SavingsAccount(); // Polymorphism. calls displayBalance() version of SavingsAccount not Account  
        myAccount.accountNumber = "123456";
        myAccount.balance = 5000.0;
        ((SavingsAccount) myAccount).interestRate = 3.5;
        myAccount.displayBalance(); // Output: Savings Account Balance: 5000.0, Interest Rate:
```

---

**Summary:**  
OOPS helps in building modular, reusable, and maintainable software by modeling real-world entities as objects and organizing code using the principles of encapsulation, abstraction, inheritance. Java is based on OOPS.

