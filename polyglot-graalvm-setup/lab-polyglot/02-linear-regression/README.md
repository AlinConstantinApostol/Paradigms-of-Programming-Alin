This project is a standout piece for your portfolio because it demonstrates Polyglot Programming—a high-level skill where you break the boundaries between programming languages. By using GraalVM, you show that you can leverage the strengths of both Java (for structure and execution) and Python (for rapid text processing) within a single runtime environment.
Polyglot Word Checksum: Java & Python Interoperability
📝 Description

This application implements a word grouping algorithm based on checksum values, powered by GraalVM Polyglot capabilities. It serves as a technical demonstration of how to execute and integrate Python logic directly within a Java application.

Instead of choosing one language, this project uses a "best-of-both-worlds" approach: Java handles the application lifecycle and entry point, while Python scripts are invoked dynamically to handle specific text processing tasks.
🚀 Key Features

    Cross-Language Execution: Invokes Python functions from a Java context using the GraalVM Context API.

    Checksum Algorithm: Calculates a unique numerical signature for words to identify "checksum collisions" or groupings.

    Dynamic Data Grouping: Efficiently categorizes large sets of words into clusters sharing the same checksum.

    Runtime Interoperability: Demonstrates zero-overhead data sharing between the JVM and the Python interpreter.

🏗️ Project Structure
Plaintext

polyglot-graalvm-setup/
└── lab-polyglot/
    ├── Polyglot.java      # Main Java entry point and Polyglot logic
    └── README.md          # Documentation

🛠️ Technical Workflow

    Context Creation: Java initializes a GraalVM Context with access to the Python engine.

    Script Evaluation: Python logic for calculating checksums is evaluated as a source.

    Result Aggregation: Java collects the results from the Python execution and performs the final grouping and console output.

💻 Execution Example

When running the program, the console outputs groups of words that share an identical checksum:
Plaintext

Checksum [342]: { "example", "word", "test" }
Checksum [128]: { "code", "java" }

⚙️ Build & Run

To run this polyglot application, you must have GraalVM installed and configured as your default JDK.

    Navigate to the project directory:
    Bash

    cd polyglot-graalvm-setup/lab-polyglot

    Compile the Java source:
    Bash

    javac Polyglot.java

    Execute the application:
    Bash

    java pp.lab.Polyglot

🛠️ Tech Stack

    Primary Language: Java

    Embedded Language: Python

    Runtime Environment: GraalVM (Polyglot API)

    Compiler: javac
