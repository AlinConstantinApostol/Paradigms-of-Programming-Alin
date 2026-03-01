Functional List Processing Pipeline (Python)
📝 Description

This project implements a declarative data transformation pipeline in Python. It processes a numeric collection using a series of functional operations—filter, chunking (via list slicing), map, and reduce.

The goal is to demonstrate how complex data manipulations can be achieved without explicit loops or mutable state, utilizing Python's robust support for lambda functions and higher-order primitives.
🚀 The Functional Pipeline

The application follows a strict sequence of transformations:

    Filtering: Removes all elements strictly less than 5 using filter().

    Chunking: Groups the filtered list into pairs (a, b) using list comprehension and slicing.

    Mapping: Transforms each pair into its product (a×b) using map().

    Reducing: Aggregates the resulting products into a final sum using functools.reduce().

🏗️ Project Structure
Plaintext

project-root/
└── main.py          # Core logic using filter, map, and reduce

🔄 Algorithm Breakdown

Initial Input: [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]

    Filter (x >= 5): [21, 75, 39, 7, 35, 31, 7, 8]

    Chunk (Step = 2): [[21, 75], [39, 7], [35, 31], [7, 8]]

    Map (pair[0] * pair[1]): [1575, 273, 1085, 56]

    Reduce (Sum): Result: 2989

💻 Execution Example

Output:
Plaintext

2989

⚙️ How to Run

    Ensure Python 3.x is installed.

    Run the script directly:
    Bash

    python main.py

🛠️ Tech Stack

    Language: Python 3.x

    Library: functools (for reduce)

    Paradigm: Functional Programming (Higher-order functions & Lambdas)
