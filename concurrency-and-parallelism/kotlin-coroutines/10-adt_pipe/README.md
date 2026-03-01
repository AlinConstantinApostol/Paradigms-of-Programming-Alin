# Pipeline Processing for Integer ADT using Kotlin Coroutines

## 📝 Description
This application implements a **Pipeline Design Pattern** for processing an Integer Abstract Data Type (ADT). The core architecture leverages **Kotlin Coroutines** for non-blocking execution and **Channels** for thread-safe communication between processing stages.

The pipeline consists of three concurrent stages:
1.  **Constant Multiplier**: Multiplies each element of an input vector by a constant factor ($\alpha$).
2.  **Sorting Function**: Buffers and sorts the elements received from the previous stage.
3.  **Print ADT**: Consumes the sorted data and outputs it to the console.

Each stage runs as a separate coroutine, ensuring that data flows through the pipeline asynchronously without blocking the main execution thread.

## 🏗️ Project Structure
```text
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Hello.kt
├── pom.xml
└── .gitignore

🛠️ Key Functions

    suspend fun constantMultiplier(vector: List<Int>, alfa: Int, outputChannel: SendChannel<Int>)

        Processes the initial vector and streams the results to the output channel.

    suspend fun sortingFunction(inputChannel: ReceiveChannel<Int>, outputChannel: SendChannel<Int>)

        Collects elements from the input stream, performs sorting logic, and forwards them.

    suspend fun printADT(inputChannel: ReceiveChannel<Int>)

        Terminal stage of the pipeline that displays the final processed data.

    suspend fun main()

        Orchestrates the pipeline by initializing the coroutines and managing channel lifecycles.

💻 Execution Example

    Initial Vector: [21, 34, 12, 14, 7, 9, 81, 22]

    Multiplier Stage (α=5): [105, 170, 60, 70, 35, 45, 405, 110]

    Sorting Stage: [35, 45, 60, 70, 105, 110, 170, 405]

    Final Output: Displayed in console via the Print stage.

⚙️ Build & Run

    Compile the project using Maven:
    Bash

    mvn clean compile

    Run the application:
    Bash

    mvn exec:java -Dexec.mainClass="org.alin.HelloKt"
