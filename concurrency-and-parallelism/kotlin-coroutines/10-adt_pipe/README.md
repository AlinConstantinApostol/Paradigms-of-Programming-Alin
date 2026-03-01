# Pipeline Processing for Integer ADT (Coroutines)

## Descriere
Aplicația implementează un **model pipeline** pentru procesarea unui ADT întreg. Fiecare etapă a pipeline-ului este realizată de o corutină care comunică prin **Channel**:

1. **Constant Multiplier** — înmulțește fiecare element din vector cu o constantă `alpha`.
2. **Sorting Function** — sortează elementele procesate de etapa anterioară.
3. **Print ADT** — afișează elementele procesate.

Fiecare etapă rulează concurent folosind **corutine Kotlin** și utilizează canale pentru transmiterea datelor între etape.

---

## Structura proiectului

project-root/
├── src/
│ └── main/
│ └── kotlin/
│ └── org/
│ └── alin/
│ └── Hello.kt
├── pom.xml
└── .gitignore

---

## Funcții principale

- `suspend fun constantMultiplier(vector: List<Int>, alfa: Int, outputChannel: SendChannel<Int>)`  
  Înmultiește fiecare element din vector cu `alfa` și trimite rezultatele pe canalul de ieșire.

- `suspend fun sortingFunction(inputChannel: ReceiveChannel<Int>, outputChannel: SendChannel<Int>)`  
  Primește elemente de la canalul de intrare, le sortează și le trimite pe canalul de ieșire.

- `suspend fun printADT(inputChannel: ReceiveChannel<Int>)`  
  Primește elementele sortate și le afișează pe ecran.

- `suspend fun main()`  
  Creează pipeline-ul de procesare, inițializează corutinele și canalele, și așteaptă finalizarea lor.

---

## Exemplu de execuție

1. Vector inițial: `[21, 34, 12, 14, 7, 9, 81, 22]`
2. Se aplică `constantMultiplier` cu `alfa = 5`: `[105, 170, 60, 70, 35, 45, 405, 110]`
3. Se sortează: `[35, 45, 60, 70, 105, 110, 170, 405]`
4. Se afișează rezultatul final în consolă.

---

## Build & Run

1. Compilează proiectul cu Maven:
```bash
mvn clean compile

2.Rulează aplicația:
mvn exec:java -Dexec.mainClass="org.alin.HelloKt"
