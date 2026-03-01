# Parallel Tic-Tac-Toe: Multi-Instance GUI with PySide6

## 📝 Description
This project implements a Tic-Tac-Toe game that showcases the integration of **PySide6 (Qt for Python)** with Python's **`threading`** module. The application is unique because it launches two completely independent game instances in parallel from a single execution point, each running in its own thread.

It demonstrates advanced GUI concepts such as dynamic UI loading, Signal/Slot mechanisms, and maintaining independent game states within a multi-threaded environment.

## 🚀 Key Technical Features
* **Multi-Threaded UI**: Uses the `threading` module to bypass the standard single-thread limitation of Qt application loops.
* **Event-Driven Architecture**: Leverages Qt Signals to connect button clicks to game logic.
* **State Management**: Tracks the 3x3 board state using a string-based representation (`"000000000"`) for efficient move validation.
* **Separation of Concerns**: Clearly divides the logic into a `TicTacToeGame` (Engine) and `TicTacToeUI` (View).



## 🏗️ Project Structure
```text
parallel-tic-tac-toe/
├── main.py          # Application logic, Threading, and Game Engine
├── ui_form.py       # Auto-generated UI class from Qt Designer
└── README.md

🛠️ Logic Breakdown

The board is mapped to a 1D string of length 9. When a player clicks a button, the index is sent to the engine:

    Index Mapping: Buttons are mapped to indices 0 through 8.

    Move Validation: The engine checks if the string at index x is "0" (empty).

    State Update: The string is updated by slicing and concatenating the player's ID.

💻 Execution Example

When running the script, two identical windows will appear. You can play on both simultaneously, demonstrating that the memory and logic of each TicTacToeGame instance are isolated.
⚙️ Setup & Run

    Install dependencies:
    Bash

    pip install PySide6

    Run the application:
    Bash

    python main.py
