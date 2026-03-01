# Concurrent Gauss Summation using Kotlin Coroutines

## 📝 Description
This application calculates the sum of numbers from $0$ to $n$ (Gauss summation) for multiple values of $n$ simultaneously. By leveraging **Kotlin Coroutines**, the program demonstrates how to process a queue of tasks concurrently, significantly reducing the total execution time compared to sequential processing.

## 🚀 Core Requirements
* **Input Management**: Uses a thread-safe `Queue` to store four distinct values of $n$.
* **Parallel Processing**: Each value is picked up by a separate coroutine.
* **Gauss Logic**: Implements $\sum_{i=0}^{n} i$ logic via a dedicated function.
* **Real-time Output**: Results are printed to the console as soon as each coroutine finishes its calculation, showcasing the non-deterministic nature of concurrent execution.

## 🏗️ Project Structure
```text
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Hello.kt  <-- Main Logic & GaussSummation function
├── pom.xml
└── .gitignore
