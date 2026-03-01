# Concurrent Gauss Summation using Python Asyncio

## 📝 Description
This application demonstrates asynchronous programming in Python by calculating the Gauss summation for multiple values of $n$ concurrently. Instead of using multiple OS threads, the program utilizes a single-threaded **Event Loop** via the `asyncio` module, allowing tasks to yield execution during simulated I/O delays.

## 🚀 Core Requirements
* **Task Management**: Uses a `collections.deque` as a task queue for four different values of $n$.
* **Non-blocking Execution**: Implements four distinct coroutines to process the queue.
* **Processing Simulation**: Uses `await asyncio.sleep(...)` to mimic latency, ensuring the event loop can switch between active tasks.
* **Concurrent Output**: Results are displayed in real-time as they are computed, showcasing non-sequential execution.

## 🏗️ Project Structure
```text
project-root/
├── main.py        # Core logic using asyncio.gather
├── .idea/         # IDE configuration
└── .venv/         # Python virtual environment

🛠️ Key Functions

    async def gauss_summation(task_id: str, n: Int)

        Calculates ∑i=0n​i and prints the result alongside the specific Task ID.

        Uses await to demonstrate yielding control back to the event loop.

    async def main()

        Initializes the task queue.

        Orchestrates the lifecycle of the coroutines using asyncio.gather.

💻 Execution Example

When running the script, the output will appear as tasks complete their "work":
Plaintext

TASK C : S(7) = 28
TASK D : S(5) = 15
TASK B : S(12) = 78
TASK A : S(15) = 120

Note: The order of results is non-deterministic as it depends on the simulated delay and event loop scheduling.
⚙️ How to Run

    Ensure you have Python 3.7+ installed.

    Run the script directly:
    Bash

    python main.py

🛠️ Tech Stack

    Language: Python 3.x

    Library: asyncio (Standard Library)

    Data Structures: collections.deque
