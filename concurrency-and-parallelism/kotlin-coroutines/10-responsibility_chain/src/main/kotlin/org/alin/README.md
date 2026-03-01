# Bidirectional Chain of Responsibility with Factory Patterns

## 📝 Description
This project implements an advanced **Double Chain of Responsibility** pattern in Kotlin. It simulates a corporate hierarchy where a `Request` flows downward from the top-level management to a worker, and a subsequent `Response` is propagated back up the chain.

The implementation is enhanced by incorporating the **Abstract Factory** pattern to decouple the creation of handlers from their execution logic, showcasing clean code principles and architectural scalability.

## 🚀 Key Features
* **Bidirectional Propagation**: Requests move from `CEO` $\to$ `Worker`, while responses travel from `Worker` $\to$ `CEO`.
* **Asynchronous Simulation**: Uses **Kotlin Coroutines** and `delay` to simulate real-world processing time without blocking threads.
* **Design Patterns Integration**:
    * **Chain of Responsibility**: Manages the delegation of tasks across the hierarchy.
    * **Abstract Factory**: Encapsulates the instantiation of specific handler groups (Elite vs. Happy Workers).

## 🏗️ Project Structure
```text
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   ├── AbstractFactory.kt      # Factory Interface
│                   ├── EliteFactory.kt         # Concrete Factory for Management
│                   ├── HappyWorkerFactory.kt   # Concrete Factory for Workers
│                   ├── FactoryProducer.kt      # Factory Generator
│                   ├── Handler.kt              # Base Handler Interface
│                   └── Hello.kt                # Implementation & Execution Logic
├── pom.xml
└── .gitignore
