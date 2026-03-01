# Functional List Processing Pipeline (Kotlin)

## 📝 Description
This project demonstrates the power and readability of **Functional Programming** in Kotlin by implementing a declarative data transformation pipeline. The application processes a numeric collection through a series of higher-order functions—`filter`, `chunked`, `map`, and `fold`—to achieve a specific computational result without using mutable state or manual loops.

The project highlights how complex logic can be condensed into a single, highly readable chain of operations, emphasizing the "what" rather than the "how."

## 🚀 The Functional Pipeline
The transformation follows these distinct stages:
1.  **Filtering**: Removes noise by keeping only elements strictly greater than or equal to 5.
2.  **Chunking**: Groups the filtered elements into sublists (pairs) of 2 consecutive elements.
3.  **Mapping**: Performs a transformation on each pair by calculating the product of its elements.
4.  **Folding**: Aggregates all individual products into a final sum, starting from an accumulator of 0.



## 🏗️ Project Structure
```text
project-root/
└── Hello.kt          # Core logic implementing the functional chain

🔄 Algorithm Breakdown

Given the initial input: [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]

    Step 1: Filter (it >= 5) → [21, 75, 39, 7, 35, 31, 7, 8]

    Step 2: Chunked (size = 2) → [[21, 75], [39, 7], [35, 31], [7, 8]]

    Step 3: Map (x * y) → [1575, 273, 1085, 56]

    Step 4: Fold (sum) → Result: 2989

💻 Execution Example

Output:
Plaintext

2989

⚙️ Build & Run (Kotlin CLI)

    Compile the source file:
    Bash

    kotlinc Hello.kt -include-runtime -d Hello.jar

    Run the application:
    Bash

    java -jar Hello.jar

🛠️ Tech Stack

    Language: Kotlin 1.8+

    Paradigm: Functional Programming

    Operations: List API (Filter, Chunked, Map, Fold)
