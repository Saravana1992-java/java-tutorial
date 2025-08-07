# 🧠 What Is Atomic Data?

**Atomic data** refers to information that is **indivisible and cannot be broken down into smaller meaningful parts**. It represents the most basic unit of data that retains its meaning and integrity.

---

## ✅ Definition

Atomic data is a **single, self-contained value** that:

- Cannot be further decomposed by the system
- Represents a concrete, uncalculated fact
- Is typically used in normalized databases and clean data models

---

## 📌 Examples of Atomic Data

| Data Type       | Atomic Example         | Non-Atomic Example             |
|------------------|------------------------|--------------------------------|
| **String**        | `"Saravana"`           | `"Saravana, Architect"`        |
| **Number**        | `42`                   | `"42, 84"`                     |
| **Boolean**       | `true`                 | `"true, false"`                |
| **Address Info**  | `"600001"` (Postal Code) | `"123 Main St, Chennai"`       |

---

## 🧪 In Database Design

- In **1NF (First Normal Form)**, atomicity means each column should hold **a single value**, not a list or composite.
- Example: Instead of storing `"Java, Python"` in one column, split them into separate rows or a related table.

---

## 🔍 Why It Matters

- Ensures **data integrity** and **query efficiency**
- Simplifies **filtering**, **sorting**, and **aggregation**
- Supports **normalization** and **scalable schema design**
