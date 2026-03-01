Polygon Perimeter Calculation using zipWithNext
📝 Description

This Kotlin application calculates the perimeter of a polygon (convex or concave) based on user-provided vertex coordinates. The project highlights the use of functional programming patterns, specifically the zipWithNext extension function, to elegantly process consecutive pairs of elements in a collection.

To ensure accuracy, the program automatically "closes" the polygon by connecting the final vertex back to the initial starting point before performing the calculation.
🚀 Key Features

    Functional Processing: Uses zipWithNext to generate pairs of consecutive vertices for distance calculation, avoiding manual index management.

    Geometric Logic: Implements the Euclidean distance formula to find the length of each polygon edge.

    Automation: Automatically handles the closure of the polygon circuit.

🏗️ Project Structure

    src/Main.kt: Contains the core logic for coordinate input and perimeter calculation.

    .gitignore: Standard Git ignore file.

    ex3_polygon_perimeter.iml: IntelliJ IDEA module file.

📐 Mathematical Approach

The program calculates the distance d between every pair of consecutive points (x1​,y1​) and (x2​,y2​) using the Euclidean formula:
d=(x2​−x1​)2+(y2​−y1​)2​

The total perimeter is the sum of all calculated edge distances.
💻 Execution Example

Input:
Plaintext

Number of polygon points: 
4
0 0
0 1
1 0
1 1

Output:
Plaintext

4.82842712474619

⚙️ Build & Run (Kotlin CLI)

To compile and run this project from the terminal:

    Compile:
    Bash

    kotlinc src/Main.kt -include-runtime -d polygon.jar

    Run:
    Bash

    java -jar polygon.jar
