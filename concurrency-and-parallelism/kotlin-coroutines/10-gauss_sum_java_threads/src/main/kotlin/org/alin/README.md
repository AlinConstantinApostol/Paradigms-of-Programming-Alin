# Concurrent Gauss Summation using JVM Threads

## 📝 Description
This application demonstrates low-level parallel processing on the JVM by calculating the Gauss summation (sum of numbers from $0$ to $n$) for multiple inputs simultaneously. Unlike the Coroutines approach, this implementation uses native **JVM Threads** to handle concurrent tasks, showcasing manual thread management and task distribution via a shared queue.

## 🚀 Core Requirements
* **Input Architecture**: Uses a thread-safe `Queue` (based on `sun.misc.Queue`) to store four distinct values of $n$.
* **Parallel Execution**: Each summation task is dispatched to a dedicated JVM Thread.
* **Computation Logic**: Implements the $\sum_{i=0}^{n} i$ summation within each thread's execution context.
* **Asynchronous Output**: Results are printed to the console immediately upon completion, demonstrating the non-deterministic nature of parallel thread scheduling.

## 🏗️ Project Structure
```text
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Hello.kt  <-- Thread logic & GaussSummation function
├── pom.xml
└── .gitignore
