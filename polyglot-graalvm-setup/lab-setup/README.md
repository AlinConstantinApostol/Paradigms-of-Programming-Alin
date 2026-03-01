Text Processing Utility in Kotlin
📝 Description

This lightweight Kotlin application is designed for efficient string manipulation and data cleaning. It demonstrates the use of Kotlin's standard library functions to process raw text data, making it a foundational tool for text analysis or preparation for further data processing tasks.
🚀 Key Features

    Punctuation Stripping: Automatically detects and removes punctuation marks from input strings, leaving only alphanumeric characters.

    Case Inversion: Implements a "Swap Case" logic that transforms uppercase letters to lowercase and vice versa across the entire text.

    File-Based Input: Reads raw data from an external data.txt file, showcasing basic file I/O operations in Kotlin.

🏗️ Project Structure
Plaintext

project-root/
├── src/
│   ├── Main.kt            # Application entry point and I/O orchestration
│   └── TextProcessing.kt  # Core logic for string transformations
├── data.txt               # Input file containing raw text
└── .gitignore

🛠️ Implementation Details

The project is split into two main components to follow the Separation of Concerns principle:

    Logic Layer (TextProcessing.kt): Contains pure functions for string manipulation, ensuring the code is testable and reusable.

    Execution Layer (Main.kt): Handles the interaction with the file system and coordinates the transformation flow.

💻 Usage Example

Input (data.txt):
Hello, World! This is KOTLIN.

Processed Output:
hELLO wORLD tHIS IS kotlin
⚙️ Build & Run

To compile and run this project using the Kotlin command-line interface:

    Compile the source files:
    Bash

    kotlinc src/TextProcessing.kt src/Main.kt -include-runtime -d TextProcessor.jar

    Run the application:
    Bash

    java -jar TextProcessor.jar
