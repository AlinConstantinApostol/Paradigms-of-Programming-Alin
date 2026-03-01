# Parallel Tic-Tac-Toe: Multi-Instance GUI via Python Threading

## 📝 Description
This project implements a Tic-Tac-Toe game that highlights the integration of **PySide6 (Qt for Python)** with Python's **`threading`** module. The application is unique because it attempts to bypass the standard single-thread limitation of Qt by launching two completely independent game instances in parallel from a single execution point.

It serves as a technical exploration of **Event-Driven Architecture**, **Signal/Slot mechanisms**, and the challenges of managing multiple GUI event loops within a multi-threaded environment.



## 🚀 Key Technical Features
* **Parallel UI Loops**: Uses the `threading` module to initiate multiple `QApplication` cycles simultaneously.
* **Separation of Concerns (MVC)**: 
    * **Model**: `TicTacToeGame` handles the board state and win logic.
    * **View/Controller**: `TicTacToeUI` manages the visual grid and user interactions.
* **Dynamic State Management**: Tracks the 3x3 board using a string-based representation (`"000000000"`) for efficient memory usage and state validation.
* **Qt Signals & Lambda Slots**: Uses anonymous functions (`lambdas`) to map 9 distinct UI buttons to a centralized move-handling function.



## 🏗️ Project Structure
```text
parallel-tic-tac-toe/
├── main.py          # Application logic, Threading orchestration, and Game Engine
├── ui_form.py       # Auto-generated UI class from Qt Designer (.ui to .py)
└── README.md

🛠️ Logic & Mapping

The board is flattened into a 1D string of length 9. When a player interacts with the GUI:

    Input Mapping: Buttons are indexed 0 through 8 (Left-to-Right, Top-to-Bottom).

    Move Validation: The engine checks if the target index is "0" (empty) before allowing a move.

    State Update: The game state string is updated using slicing: state[:index] + player_id + state[index+1:].

💻 Execution & Setup

    Install PySide6:
    Bash

    pip install PySide6

    Run the application:
    Bash

    python main.py
