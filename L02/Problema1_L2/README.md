# L02 - Polyglot Word Checksum

## Descriere
Aplicația grupează cuvintele după suma lor de control (checksum) utilizând GraalVM Polyglot. Aceasta demonstrează integrarea Java cu Python pentru rezolvarea unei probleme de procesare a textului.

## Funcționalitate
- Calculează suma de control pentru fiecare cuvânt.  
- Grupează și afișează cuvintele care au aceeași sumă de control.  
- Folosește GraalVM Polyglot pentru integrarea funcțiilor Python în Java.  

## Cum se folosește
1. Navigați la folderul proiectului:
   ```bash
   cd L02

    Compilați și rulați codul Java:

javac Polyglot.java
java pp.lab.Polyglot

Rezultatul va afișa grupurile de cuvinte cu aceeași sumă de control în consolă.
