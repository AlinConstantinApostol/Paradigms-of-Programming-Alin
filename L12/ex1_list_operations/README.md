# Prelucrare funcțională a unei liste în Kotlin (filter → chunked → map → fold)

## Descriere
Se aplică operații funcționale pe lista `[1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]`:
1. Se elimină elementele mai mici decât 5.
2. Se grupează elementele rămase în subliste de câte 2 elemente.
3. Se înmulesc elementele din fiecare pereche.
4. Se însumează produsele obținute.

Rezultatul final: `2989`.

## Algoritm (pași)
- `.filter { it >= 5 }` — păstrează doar elementele `>= 5`.
- `.chunked(2)` — creează subliste de câte 2 elemente consecutive.
- `.map { (x, y) -> x * y }` — calculează produsul pentru fiecare pereche.
- `.fold(0) { acc, i -> acc + i }` — însumează produsele obținute.

## Fișier
`Hello.kt` — conține implementarea în Kotlin.

Exemplu de cod (implementare folosită):
```kotlin
fun main() {
    val result = listOf(1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)
        .filter { it >= 5 }
        .chunked(2)
        .map { (x, y) -> x * y }
        .fold(0) { acc, i -> acc + i }

    println(result)
}

Cerințe

    Kotlin 1.8+ sau compatibil

Execuție

Din linia de comandă:

kotlinc Hello.kt -include-runtime -d Hello.jar
java -jar Hello.jar

Output așteptat

Rezultat asteptat: 2989
