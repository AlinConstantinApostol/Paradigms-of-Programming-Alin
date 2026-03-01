Cross-Language IPC: PyQt5 GUI to C via System V Message Queues
📝 Description

This project demonstrates a sophisticated integration between a high-level Python GUI and a low-level C processing engine. It utilizes System V Message Queues, a classic Inter-Process Communication (IPC) mechanism, to pass data across the language barrier in real-time.

The application allows users to load numeric datasets, transform them into structured HTML formats, and stream that data directly into a C-based receiver for high-performance processing (filtering, summation, or analysis).
🚀 Key Features

    Hybrid Architecture: Combines the rapid UI development of Python (PyQt5) with the raw execution speed of C.

    System V IPC: Implements kernel-level message queues for reliable, asynchronous communication between independent processes.

    HTML Generation Engine: A utility to convert raw text-based numeric data into valid HTML markup.

    Extensible C Backend: The receiver is designed to handle various data operations like prime number filtering or statistical summation.

🏗️ Project Structure
Plaintext

project-root/
├── html_converter.py  # Main Python GUI (Producer)
├── html_converter.ui  # PyQt5 Designer file
├── receiver.c         # C-based Message Consumer
├── .gitignore         # Configured for venv and IDE files
└── README.md

🔄 Technical Workflow

    Selection: The user selects a text file via the PyQt5 interface.

    Transformation: Python logic parses the numbers and generates an HTML string.

    Transmission: The Python process writes the HTML payload into a specific System V Message Queue (using sysv_ipc).

    Consumption: The C program, running in a separate terminal, polls the queue, retrieves the message, and performs the required logic.

💻 Usage Example

Scenario: Sending a list of 100 integers to be summed by the C engine.

    Python Terminal: Logs "Message sent to Queue ID: 12345"

    C Terminal: Logs "Received HTML content: ... | Processing complete."

⚙️ Build & Run
1. Setup Python Environment
Bash

python3 -m venv venv
source venv/bin/activate
pip install PyQt5 sysv_ipc

2. Compile the C Receiver
Bash

gcc receiver.c -o receiver

3. Execution

First, start the C listener in one terminal:
Bash

./receiver

Then, launch the Python GUI in another terminal:
Bash

python html_converter.py

🛠️ Tech Stack

    GUI: PyQt5 (Python)

    IPC Mechanism: System V Message Queues

    Backend: C (Standard Library)

    Build Tools: GCC, Pip
