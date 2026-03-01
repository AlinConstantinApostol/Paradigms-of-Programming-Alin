History Log Processor: System Log Parsing & Data Management
📝 Description

This application is a robust log processor designed to parse and manage entries from the Linux system log file /var/log/apt/history.log. It transforms raw text data into structured HistoryLogRecord objects, enabling efficient querying, comparison, and manipulation through a custom data pipeline.

The project showcases a strong command of Kotlin's type system, specifically the implementation of the Comparable interface and the use of Generic Constraints to create reusable, polymorphic functions.
🚀 Key Features

    Intelligent Log Parsing: Splits logs into distinct blocks using \n\n delimiters and extracts metadata like Start-Date (converted to timestamps) and Commandline.

    Custom Domain Objects: Implements the HistoryLogRecord class with custom comparison logic based on temporal data.

    Generic Utility Library:

        maxim<T : Comparable<T>>: A generic function to determine the most recent record.

        findAndReplace: A polymorphic function that handles map manipulation with strict type safety.

🏗️ Project Structure
Plaintext

HistoryLogProcessor/
├── src/
│   ├── HistoryLogRecord.kt  # Comparable domain class
│   ├── Main.kt              # Log parsing logic & map operations
│   └── resources/
│       └── a.txt            # Sample APT log entries for testing
├── .gitignore
└── ex1_homework.iml

🛠️ Implementation Details
The Comparable Record

The core data structure implements Comparable<HistoryLogRecord>, allowing it to be used with standard sorting algorithms and our custom generic maxim function.
Kotlin

class HistoryLogRecord(val timestamp: Timestamp, val command: String) : Comparable<HistoryLogRecord> {
    override fun compareTo(other: HistoryLogRecord): Int {
        return this.timestamp.compareTo(other.timestamp)
    }
}

Generic Logic

The project demonstrates advanced polymorphism by defining constraints on generic types to ensure they support comparison operations:

    maxim(obj1: T, obj2: T): T: Returns the object with the most recent timestamp.

    findAndReplace(firstElem, secondElem, map): Searches for an element in the MutableMap and replaces it while maintaining map integrity.

💻 Execution Example

The application parses a log block, calculates the most recent entry, and performs a search-and-replace operation:

Output:
Plaintext

2025-04-02 16:37:43.0 /usr/bin/unattended-upgrade
2025-04-01 01:05:49.0 apt install sqlite3 sqlitebrowser
2025-04-02 16:37:43.0 /usr/bin/unattended-upgrade

⚙️ Build & Run

    Compile with Kotlin CLI:
    Bash

    kotlinc src/HistoryLogRecord.kt src/Main.kt -include-runtime -d LogProcessor.jar

    Run the application:
    Bash

    java -jar LogProcessor.jar
