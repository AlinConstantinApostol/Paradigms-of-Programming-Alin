# Pipeline de procesare cu Thread-uri în Kotlin

## Descriere
Aplicația implementează un **pipeline de prelucrare a unui vector** utilizând **thread-uri**. Pipeline-ul conține trei etape principale:
1. Multiplicarea elementelor vectorului cu o constantă.
2. Sortarea rezultatelor obținute.
3. Afișarea vectorului rezultat.

Fiecare etapă este rulată într-un thread separat, iar datele sunt transmise între etape prin liste mutabile (`MutableList`).

---

## Cerinţe esenţiale
- Pipeline-ul conține trei thread-uri independente pentru fiecare etapă de procesare.
- Se utilizează liste mutabile ca canale între etape (`pipe1` și `pipe2`).
- Thread-urile sunt sincronizate cu `join()` pentru a asigura ordinea corectă a execuției.
- Operațiunile de procesare:
  - `constantMultiplier` — multiplică fiecare element cu o constantă (`alfa`).
  - `sortingFunction` — sortează rezultatul.
  - `printADT` — afișează rezultatele.

---

## Structura proiectului

```
project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Main.kt
├── pom.xml
└── .gitignore
```

---

## Flux de execuție
1. Se definește vectorul inițial: `[21, 34, 12, 14, 7, 9, 81, 22]`.
2. Se creează două canale (`MutableList`) pentru a lega etapele pipeline-ului.
3. Se lansează thread-urile:
   - `part1` — multiplică elementele și le adaugă în `pipe1`.
   - `part2` — sortează elementele din `pipe1` și le pune în `pipe2`.
   - `part3` — afișează rezultatele din `pipe2`.
4. Thread-urile se pornesc și se așteaptă cu `join()` pentru sincronizare.
5. Rezultatul final este afișat în consolă.

---

## Mesaje & Formate
- Datele se transmit prin liste mutabile între thread-uri.
- Ordinea pipeline-ului este garantată prin sincronizarea `join()`.

---

## Build & Run

1. Compilează proiectul cu Maven:
```bash
mvn clean compile
```

2. Rulează:
```bash
mvn exec:java -Dexec.mainClass="org.alin.MainKt"
```

