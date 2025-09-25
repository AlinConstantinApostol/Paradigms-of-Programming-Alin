# L03 - Linear Regression with Polyglot Integration

## Descriere
Aplicația realizează o regresie liniară pe un set de date utilizând limbajul Python pentru partea statistică, integrat din Java prin GraalVM. Graficul rezultat este salvat pe disc și poate fi vizualizat automat.  

Aceasta demonstrează integrarea între Java și Python, precum și manipularea și vizualizarea datelor.

## Funcționalitate
- Citește sau generează un set de date (`x` și `y`).  
- Calculează panta și interceptul regresiei liniare.  
- Plotează datele originale și linia de regresie.  
- Salvează graficul ca imagine (`plot_regresie.png`).  
- Poate fi extins pentru a primi seturi de date din fișiere externe sau alte limbaje suportate de GraalVM.  

## Cum se folosește
1. Navigați la folderul proiectului:
   ```bash
   cd L03

    Compilați codul Java:

javac Main.java

Rulați aplicația:

java pp.lab.Main

Rezultatul va genera un fișier plot_regresie.png și va afișa graficul în fereastra de vizualizare.
