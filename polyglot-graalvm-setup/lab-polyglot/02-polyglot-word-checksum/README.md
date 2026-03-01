Polyglot Linear Regression: Java & Python Data Visualization
📝 Description

This application performs a Linear Regression analysis on a dataset by leveraging Python's mathematical libraries from within a Java environment. Using GraalVM Polyglot technology, the project demonstrates how to pass data structures between languages to calculate statistical trends and generate high-quality visual reports.

Instead of a siloed approach, this tool uses Java to manage the application flow and Python to handle the heavy lifting of statistical modeling and plotting.
🚀 Key Features

    Cross-Language Data Flow: Seamlessly passes arrays of coordinates (x, y) from Java to a Python execution context.

    Statistical Modeling: Calculates the slope and intercept for a linear regression model using Python's specialized logic.

    Automated Visualization: Generates a professional scatter plot with a regression line and saves it as plot_regresie.png.

    Interoperability: Showcases the ability to use Python's ecosystem (like Matplotlib or NumPy) directly from a JVM-based application.

🏗️ Project Structure
Plaintext

polyglot-graalvm-setup/
└── lab-linear-regression/
    ├── Main.java          # Java entry point and Polyglot orchestration
    ├── plot_regresie.png  # Generated output visualization
    └── README.md          # Documentation

🛠️ Technical Workflow

    Data Generation: Java prepares or reads a dataset representing independent and dependent variables.

    Polyglot Execution: A GraalVM Context is established to evaluate Python code that calculates the regression coefficients.

    Plotting: The Python script uses a plotting library to visualize the data points and the line of best fit.

    Resource Management: The final image is exported to the local disk, and the Java application handles the process completion.

💻 Execution Example

Upon execution, the program calculates the trend and generates a visual report:
Plaintext

[Java] Sending dataset to Python...
[Python] Calculating Linear Regression: y = mx + c
[Python] Regression Line: y = 2.5x + 1.2
[Java] Success: plot_regresie.png generated.

⚙️ Build & Run

Ensure you have GraalVM installed and configured as your default JDK, with the Python component enabled.

    Navigate to the project directory:
    Bash

    cd polyglot-graalvm-setup/lab-linear-regression

    Compile the Java source:
    Bash

    javac Main.java

    Execute the application:
    Bash

    java pp.lab.Main

🛠️ Tech Stack

    Orchestration: Java

    Analytics & Plotting: Python

    Engine: GraalVM Polyglot API

    Output: PNG Visualization
