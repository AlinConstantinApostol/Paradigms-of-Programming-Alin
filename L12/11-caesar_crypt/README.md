# Caesar Cipher — criptare selectivă (cuvinte 4..7 caractere)

## Descriere
Programul citește text din fișierul `fisier.txt` și criptează, folosind cifrul Caesar, **doar** cuvintele a căror lungime este între 4 și 7 caractere (inclusiv). Off­set-ul pentru cifru este introdus de la tastatură. Rezultatul (lista de cuvinte criptate, separate prin virgulă și spațiu) este afișat în consolă.

## Structura proiect
├── src/
│ └── Main.kt
├── fisier.txt
├── .gitignore
└── ex2_caesar_script.iml

## Comportament
- Se elimină din text semnele „.” și „,” înainte de procesare.
- Se împarte textul în cuvinte după spațiu.
- Pentru fiecare cuvânt cu `4 <= lungime <= 7` se aplică cifrul Caesar cu offsetul introdus.
- Se afișează rezultatul ca listă de cuvinte criptate separate prin `, `.

## Compilare & rulare (Kotlin CLI)
Din directorul proiectului:

```bash
kotlinc -script src/Main.kt
# sau pentru a produce jar:
kotlinc src/Main.kt -include-runtime -d caesar.jar
java -jar caesar.jar
Rulare (exemplu)

La rulare programul va cere:
Type the offset for the caesar_cipher:
Introduceți un număr întreg (de exemplu 3) și apăsați Enter. Programul va procesa fisier.txt și va afișa în consolă lista cuvintelor criptate.

Fișier de intrare

Numele fișierului folosit implicit este fisier.txt aflat în rădăcina proiectului. Dacă doriți alt fișier, modificați linia din Main.kt:
val file = File("fisier.txt")
Exemplu scurt

Textul din fisier.txt:
Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Dacă offset = 1, cuvintele cu lungime între 4 și 7 vor fi criptate (ex: Lorem -> Mpsfn, ipsum -> jqtvn, etc.) și vor fi listate în output.
