# Calculul perimetrului unui poligon folosind `zipWithNext`

## Descriere
Programul citește de la tastatură coordonatele vârfurilor unui poligon convex sau concav (închis automat prin conectarea ultimului punct cu primul) și calculează perimetrul acestuia.  
Pentru determinarea perimetrului se folosește funcția `zipWithNext`, care creează perechi de puncte consecutive.

## Structura proiect
├── src/
│ └── Main.kt
├── .gitignore
└── ex3_polygon_perimeter.iml

## Funcționalitate
1. Se citește numărul `n` de puncte al poligonului.
2. Se citesc coordonatele fiecărui punct sub forma `(x, y)`.
3. Se închide poligonul adăugând primul punct la finalul listei.
4. Se calculează distanța euclidiană între fiecare pereche de puncte consecutive folosind:
   \[
   d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
   \]
5. Se însumează toate distanțele pentru a obține perimetrul.

## Compilare & rulare (Kotlin CLI)
```bash
kotlinc src/Main.kt -include-runtime -d polygon.jar
java -jar polygon.jar
Exemplu de rulare

Input:
Number of polygon points: 
4
0 0
0 1
1 0
1 1
Output:
4.82842712474619
Rezultatul reprezintă perimetrul poligonului format din punctele citite.
