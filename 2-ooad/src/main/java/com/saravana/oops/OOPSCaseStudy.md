# Case study
## 💼 LLD Prompt: Payment Transaction System – Banking Application

## 🧾 Scenario

Design a banking module that facilitates secure and consistent payment transactions between accounts. The system must also perform periodic interest calculations based on account type and available balance.

## ✅ Functional Requirements

1. When a transaction is successful:
   - Debit the specified amount from the source account.
   - Credit the specified amount to the destination account.
   - Update balances for both accounts.

2. On a quarterly basis:
   - Calculate interest for each account based on its type and current balance.
   - Accrue the calculated interest to the account’s balance.
---

### 🔍 Analysis

Identify and model the following entities:
- `Customer`: Holds personal and account details.
- `Account`: Maintains balance and type information.
- `Transaction`: Captures transfer details and metadata.
- `InterestCalculator`: Computes applicable interest for each account.

### 📐 Design Expectations

Define appropriate classes with relevant attributes and methods:
- Encapsulate business logic for debit, credit, and interest accrual.
- Ensure validation and transactional consistency.
- Represent relationships using class diagrams and associations.

> 📌 Include method signatures, visibility modifiers, and aggregation relationships where applicable.

## 📌 Use Case 1: Successful Payment Transaction

```classDiagram
+-------------+        +--------------+        +------------------+
| Customer    |        | Account      |        | Transaction      |
+-------------+        +--------------+        +------------------+
| - id        |        | - accountId  |        | - txnId          |
| - name      |        | - balance    |        | - fromAccountId  |
| - address   |        |              |        | - toAccountId    |
+-------------+        +--------------+        | - amount         |
      |                      |                 | - timestamp      |
      | 1                1..*|                 +------------------+
      +----------------------+
                             |
                             |----------------------------+
                             |                            |
                 +-------------------+         +-------------------+
                 | +debit(amount)    |         | +credit(amount)   |
                 | +getBalance()     |         |                   |
                 +-------------------+         +-------------------+

```

## 📌 Use Case 2: Quarterly Interest Addition

```classDiagram
+--------------+        +------------------+        +-------------------+
| Account      |        | AccountType      |        | InterestCalculator|
+--------------+        +------------------+        +-------------------+
| - accountId  |        | - typeId         |        | - rateMap         |
| - balance    |        | - name           |        +-------------------+
| - accountType|        | - interestRate   |        | +calculateInterest|
+--------------+        +------------------+        |   (Account)       |
         |                       |                  | +applyInterest()  |
         |-----------------------+                  +-------------------+
         |
         |---> +applyQuarterlyInterest()
```
```
