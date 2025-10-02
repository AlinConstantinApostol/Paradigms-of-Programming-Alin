> Gauss Summation (Threads)
> Această aplicație calculează suma numerelor de la 0 până la n pentru patru valori diferite de n simultan, folosind threads JVM.
> Cerințe esențiale

Input: patru valori n puse într-o coadă (Queue<Int>).

Pentru fiecare valoare n, se calculează sum = 0 + 1 + 2 + ... + n.

Procesarea fiecărei valori este concurentă prin threads.

Rezultatele sunt afișate imediat după calculul fiecărei valori.

Structura proiectului
> project-root/
├── src/
│   └── main/
│       └── kotlin/
│           └── org/
│               └── alin/
│                   └── Hello.kt
├── pom.xml
└── .gitignore
Flux de execuție

Coada conține valori: 4, 10, 25, 14.

Fiecare thread preia o valoare din coadă.

Se calculează suma Gauss pentru acea valoare.

Se afișează rezultatul, în orice ordine (execuție concurentă).

Clase și roluri

Hello.kt — definește funcția GaussSummation(n: Int): Int și main.

Queue<Int> — coada simplă pentru stocarea valorilor n (folosind sun.misc.Queue).pom.xml — configurează Kotlin
> Build & Run
 
1.Compilează proiectul cu Maven:
> mvn clean compile
2. Rulează:
> mvn exec:java -Dexec.mainClass="org.alin.HelloKt"

