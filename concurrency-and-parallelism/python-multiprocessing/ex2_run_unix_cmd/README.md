# Command Executor with Multi-Stage Piping (Python)

## 📝 Description
This application is a Python-based command-line utility that mimics the behavior of a Unix Shell. It reads complex commands containing **pipes (`|`)**, splits them into individual segments, and executes each as a separate process. 

The core logic dynamically links the standard output (`stdout`) of one process to the standard input (`stdin`) of the next, creating a continuous data pipeline until the final result is produced.

## 🚀 Core Requirements
* **Command Parsing**: Reads a full string from the user and tokenizes it based on the `|` delimiter.
* **Process Orchestration**: Uses the `subprocess.Popen` constructor to launch concurrent processes for each sub-command.
* **Stream Redirecting**: Manually manages file descriptors to ensure data flows correctly from one process to another without manual intervention.
* **Final Collection**: Captures the terminal output of the last command in the pipeline using the `communicate()` method.

## 🏗️ Project Structure
```text
project-root/
├── main.py        # Logic for parsing and process chaining
├── .idea/         # IDE configuration files
└── .venv/         # Python virtual environment

🔄 Execution Logic

    Input Phase: The get_commands() function retrieves the raw input (e.g., cat file.txt | grep "error" | wc -l).

    Chaining Phase:

        The first process is initialized with its stdout set to a pipe.

        Intermediate processes are launched with their stdin connected to the previous process's stdout.

        The final process's stdout is captured as the overall result.

    Completion Phase: The program waits for the final process to finish and displays the output.

💻 Usage Example

Input Command:
Bash

ip a | grep inet | wc -l

Process Flow:

    ip a runs → sends output to Pipe 1.

    grep inet reads from Pipe 1 → sends filtered output to Pipe 2.

    wc -l reads from Pipe 2 → calculates line count.

Output:
Plaintext

3

⚙️ How to Run

    Ensure you have Python 3.x installed.

    Run the script:
    Bash

    python main.py

    Enter your command when prompted.

🛠️ Tech Stack

    Language: Python 3.x

    Module: subprocess (Standard Library)

    OS Concept: Inter-Process Communication (IPC) via Pipes
