# Multi-Threaded Pipeline Processing in Kotlin

## 📝 Description
This project implements a data processing pipeline using native **Java/Kotlin Threads**. It demonstrates low-level synchronization techniques and manual memory sharing between threads to achieve a sequential processing flow.

The pipeline is divided into three distinct stages, each running in its own dedicated thread:
1.  **Multiplier Stage**: Performs scalar multiplication on the input vector.
2.  **Sorting Stage**: Consumes the multiplied values and applies a sorting algorithm.
3.  **Output Stage**: Retrieves the final processed data and handles console display.

Unlike the Coroutines version which uses Channels, this implementation uses **MutableLists** as shared buffers and uses the `.join()` method to orchestrate thread synchronization and ensure data integrity across the pipeline.

## 🏗️ Project Structure
```text
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Main.kt
├── pom.xml
└── .gitignore
