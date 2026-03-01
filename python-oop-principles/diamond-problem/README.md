# The Diamond Problem & Method Resolution Order (MRO)

## 📝 Description
This project explores one of the most famous challenges in Object-Oriented Programming: **The Diamond Problem**. It occurs in multiple inheritance when a class inherits from two classes that both inherit from a single base class. 

The implementation demonstrates how Python elegantly solves this ambiguity using the **C3 Linearization** algorithm and the `super()` function, ensuring a consistent and predictable **Method Resolution Order (MRO)**.



## 🚀 Key Concepts
* **Multiple Inheritance**: A class (`Subclass`) deriving features from more than one parent class (`LeftSubclass` and `RightSubclass`).
* **Method Resolution Order (MRO)**: The specific order in which Python looks for a method in a class hierarchy. This can be inspected using the `__mro__` attribute.
* **Super() Dependency**: Demonstrates that `super()` does not simply call the parent class, but rather the *next* class in the MRO stack.

## 🏗️ Class Hierarchy
1.  **BaseClass**: The root of the diamond.
2.  **LeftSubclass** & **RightSubclass**: Intermediate classes inheriting from `BaseClass`.
3.  **Subclass**: The leaf class inheriting from both `Left` and `Right`.



## 🔍 How Python Solves It
In this example, when `Subclass.call_me()` is invoked, Python follows this order:
`Subclass` → `LeftSubclass` → `RightSubclass` → `BaseClass` → `object`

By using `super().call_me()`, each class delegates the call to the next one in the chain, ensuring the base class method is reached in a structured way.

## 💻 Execution & Output
Running the script will print the MRO list and the execution flow of the method calls, showing how the `num_base_calls` counter is incremented across the hierarchy.

**Command:**
```bash
python main.py

Expected Output (MRO):
Plaintext

(<class '__main__.Subclass'>, <class '__main__.LeftSubclass'>, <class '__main__.RightSubclass'>, <class '__main__.BaseClass'>, <class 'object'>)

🛠️ Tech Stack

    Language: Python 3.x

    Paradigm: Object-Oriented Programming (Advanced Inheritance)
