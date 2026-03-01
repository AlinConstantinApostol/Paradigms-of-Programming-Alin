#!/bin/bash

echo "🚀 Starting repository reorganization..."

# 2. GUI & Multithreading
git mv L05 python-gui-multithreading
git mv python-gui-multithreading/05-tictactoe python-gui-multithreading/tictactoe-game
git mv python-gui-multithreading/05-Graphical-Interface-with-Tkinter-PyQt-Multithreading python-gui-multithreading/gui-frameworks-comparison

# 3. OOP & Collections
git mv L06 python-oop-principles
git mv L07 kotlin-generics-collections

# 4. Design Patterns
mkdir -p software-design-patterns
git mv L08 software-design-patterns/kotlin-patterns
git mv L09 software-design-patterns/python-patterns

# 5. Concurrency
mkdir -p concurrency-and-parallelism
git mv L10 concurrency-and-parallelism/kotlin-coroutines
git mv L11 concurrency-and-parallelism/python-multiprocessing

# 6. Functional & Logic
git mv L12 functional-programming-kotlin
git mv L14 logic-programming-prolog

echo "✅ Folders reorganized."

# 7. Git Commit & Push
git add .
git commit -m "Refactor: Systematically reorganized repository for portfolio clarity"
git push origin main

echo "🎉 All changes are now live on GitHub!"
