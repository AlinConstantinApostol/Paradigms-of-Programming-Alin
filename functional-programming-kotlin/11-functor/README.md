# Generic MutableMap Functor Implementation (Kotlin)

## 📝 Description
This project implements a **Functor** pattern for `MutableMap<K, V>` collections. In functional programming, a Functor is a type of mapping between categories that allows for the transformation of values within a structure while strictly preserving the structure itself (in this case, the keys of the map).

The implementation provides a fluent `map` method that enables functional pipelining, allowing developers to chain transformations on map values in a clean, declarative manner.

## 🚀 Key Features
* **Structure Preservation**: Transforms values $v \in V$ such that $f(v) = v'$, while the associated keys $k \in K$ remain unchanged: $(k, v) \xrightarrow{f} (k, v')$.
* **Fluent API**: Supports method chaining, allowing multiple transformations to be applied in a single pipeline.
* **Generic Design**: The `MutableMapFunctor<K, V>` is fully generic, supporting any key and value types.
* **Extension Functions**: Includes custom String extensions like `toPascalCase()` to demonstrate real-world utility.



## 🏗️ Project Structure
```text
project-root/
├── src/
│   ├── Main.kt                # Application entry point and usage examples
│   └── MutableMapFunctor.kt   # Core Functor implementation
├── .gitignore
└── ex4_functor.iml

🔄 Functional Pipeline Example

The project demonstrates a pipeline that performs the following transformations on a MutableMap<Int, String>:

    Prefixing: Adds "Test " to every string value.

    Formatting: Converts the resulting string to PascalCase.

Code Snippet:
Kotlin

MutableMapFunctor(map)
    .map { addTestString(it) }
    .map { it.toPascalCase() }

💻 Execution Example

Initial Map:
{1="thank you", 2="multumesc mult", 3="danke schoen"}

Processed Result:
{1=TestThankYou, 2=TestMultumescMult, 3=TestDankeSchoen}
⚙️ Build & Run (Kotlin CLI)

    Compile the source files:
    Bash

    kotlinc src -include-runtime -d functor.jar

    Run the application:
    Bash

    java -jar functor.jar

🛠️ Tech Stack

    Language: Kotlin

    Paradigm: Functional Programming (Functors)

    Build Tool: Kotlin Compiler (CLI)
