Programming Paradigms & Software Design Patterns

This repository contains a collection of implementations developed during the "Programming Paradigms" course. The project focuses on exploring various software architecture styles, concurrency models, and multi-language interoperability using Kotlin, Python, and Java (GraalVM).

Instead of a simple laboratory list, this repository is organized by core software engineering competencies, demonstrating a deep dive into how different paradigms solve complex computational problems.
🚀 Key Technologies & Skills

    Languages: Python (Advanced OOP & Parallelism), Kotlin (Coroutines & Functional), Java, Prolog.

    Paradigms: Object-Oriented (OOP), Functional Programming, Logic Programming, Parallel & Concurrent Computing.

    Architecture: Event-Driven (Message Queues), Polyglot Programming (GraalVM), SOLID Principles.

    Tools: IntelliJ IDEA, PyCharm, Git, Multiprocessing libraries.

🛠️ Core Modules & Implementations
1. Polyglot Development & Interoperability

    GraalVM Integration: Leveraging the GraalVM runtime to execute and integrate code across different languages (Java/Kotlin/Python) within a single environment.

    Environment Optimization: Advanced IDE configuration for polyglot workflows and cross-language debugging.

2. Concurrency & High-Performance Computing

    Kotlin Coroutines: Implementation of non-blocking, native concurrency for efficient resource management and asynchronous task handling.

    Python Parallelism: Utilizing multiprocessing and threading libraries to optimize data-heavy operations and CPU-bound tasks.

3. Advanced Software Design (SOLID & Patterns)

    Design Patterns: Practical application of Creational, Structural, and Behavioral patterns to ensure code scalability and maintainability.

    Generics & Collections: Implementing flexible data structures using Kotlin's type system and optimized collection frameworks.

    SOLID Principles: Refactoring and structuring code based on industry-standard design principles.

4. Message-Oriented Middleware

    Queue-based Architecture: Modeling applications that use message queues to decouple components and manage asynchronous data flow.

5. Declarative Paradigms (Functional & Logic)

    Functional Programming: Heavy use of higher-order functions, immutability, and recursion in Kotlin to create predictable and side-effect-free logic.

    Logic Programming: Solving complex logical constraints and symbolic computation using Prolog integrated with Python wrappers.

📂 Project Structure

Each module represents a specific area of study:

    L01 - L02: Environment Setup & Polyglot (GraalVM) experiments.

    L05: Message Queue implementations and asynchronous workflows.

    L06 - L09: Advanced OOP, SOLID principles, and Design Patterns (Python/Kotlin).

    L10 - L11: Concurrency models: Coroutines (Kotlin) and Multiprocessing (Python).

    L12 - L14: Functional paradigms and Logic programming integration.

⚙️ How to Run

Each directory contains its own README.md with specific execution steps. Generally:

    For Kotlin modules: Open the project in IntelliJ IDEA and run the Main.kt files.

    For Python modules:
    Bash

    # Recommendation: Use a virtual environment
    python3 folder_name/main_script.py

    For Polyglot features: Ensure GraalVM is installed and configured as your default JDK.
