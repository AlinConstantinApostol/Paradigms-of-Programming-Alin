Multi-Input AND Gate Builder: Advanced Design Patterns in Kotlin
📝 Description

This project implements a flexible logic gate simulation engine focusing on AND Gates with variable inputs (2, 3, 4, and 8). The core strength of this application lies in its architectural integrity, utilizing a combination of Structural, Creational, and Behavioral design patterns to solve hardware logic simulation in a software-oriented way.
🚀 Architectural Patterns

The project is built upon three pillar patterns to ensure "Clean Code" principles:

    Bridge Pattern: Decouples the gate's abstraction (ControlLogicGate) from its implementation (ANDGate). This allows the control logic and the physical gate logic to vary independently.

    Builder Pattern: Simplifies the construction of complex objects. Instead of manual instantiation, the ConcreteANDBuilder handles the creation of gates with specific input counts (2, 3, 4, or 8).

    Finite State Machine (FSM): The internal state of the gate is managed via a State pattern (StateTrue / StateFalse). The gate's output is not just a boolean, but a state transition triggered by input changes.

🏗️ Project Structure
Plaintext

ANDGateBuilder/
├── src/
│   ├── Main.kt             # Orchestration and usage demonstration
│   ├── State.kt            # FSM State interface and concrete states (True/False)
│   ├── LogicGate.kt        # Implementation interface (Bridge)
│   ├── Builder.kt          # Construction interface and Concrete Builder
│   └── ANDGate.kt          # Concrete implementation of the logic gate
├── .gitignore
└── ex1_and_logical_gate.iml

🛠️ Implementation Details
The Bridge & FSM

    LogicGate: Defines the contract for all gates (inputs, state changes, results).

    ControlLogicGate: Acts as the refined abstraction, providing a high-level API to calculate outputs from lists of booleans.

    State Logic: The gate uses changeState() to evaluate inputs. If all inputs are true, the internal state transitions to StateTrue; otherwise, it remains StateFalse.

The Builder

The ConcreteANDBuilder provides specialized methods:

    buildAND2Gate(), buildAND4Gate(), buildAND8Gate()

    Each method ensures the gate is initialized with the correct number of default false inputs.

💻 Usage Example
Kotlin

fun main() {
    val builder = ConcreteANDBuilder()
    builder.buildAND4Gate() // Orchestrate construction

    val gate = builder.getProductResult()
    val controlGate = ControlLogicGate(gate)

    val inputs = mutableListOf(true, false, false, true)
    println("Output is: " + controlGate.createOutput(inputs))
}

Expected Output:
Plaintext

4-inputs AND-Gate was built!
Output is: false
true false false true 

⚙️ Build & Run

    Compile using Kotlin CLI:
    Bash

    kotlinc src/*.kt -include-runtime -d GateBuilder.jar

    Run the application:
    Bash

    java -jar GateBuilder.jar
