# MutableMap Functor (Kotlin)

## Descriere
Implementare a unui **functor** pentru colecții de tip `MutableMap<K, V>` care permite aplicarea succesivă a transformărilor asupra valorilor din map, păstrând cheile. Functorul expune metoda `map(function: (V) -> V)` care returnează un nou `MutableMapFunctor` cu valorile transformate.

## Comportament implementat
- `MutableMapFunctor.map` iterează perechile `(cheie, valoare)` din map și aplică funcția primită pe valoare, construind un nou `MutableMap`.
- Exemplu de pipeline folosit în proiect:
  1. adăugarea prefixului `"Test "` la fiecare valoare;
  2. conversia fiecărei valori în PascalCase (funcție extensie `toPascalCase`).

## Structura proiect
├── src/
│ ├── Main.kt
│ └── MutableMapFunctor.kt
├── .gitignore
└── ex4_functor.iml

## Fișiere cheie
- `MutableMapFunctor.kt` — implementarea functorului generic `MutableMapFunctor<K, V>`.
- `Main.kt` — exemplu de utilizare:
  - definirea funcției `addTestString(string: String): String` (adaugă prefixul `"Test "`),
  - extensia `String.toPascalCase()` (transformă un text în PascalCase),
  - creare `MutableMap<Int, String>` cu valori de test,
  - aplicare `MutableMapFunctor(map).map { addTestString(it) }.map { it.toPascalCase() }.map` și afișarea rezultatului.

## Compilare & rulare (Kotlin CLI)
```bash
kotlinc src -include-runtime -d functor.jar
java -jar functor.jar
Exemplu de rulare (output)

Pornind de la map-ul:
1 -> "thank you"
2 -> "multumesc mult"
3 -> "danke schoen"
4 -> "gracias"
5 -> "merci beaucoup"
6 -> "grazie"
După aplicarea map { addTestString } și map { it.toPascalCase() }, rezultatul tipic afișat va arăta astfel:
{1=TestThankYou, 2=TestMultumescMult, 3=TestDankeSchoen, 4=TestGracias, 5=TestMerciBeaucoup, 6=TestGrazie}
Observații de utilizare

MutableMapFunctor este generic și funcționează pentru orice tip K și V; funcțiile transformat trebuie să returneze același tip V.

Poate fi folosit pentru pipeline-uri funcționale de transformare a valorilor din hărți fără a modifica cheile originale.
