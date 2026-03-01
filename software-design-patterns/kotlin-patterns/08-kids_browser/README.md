# Kids Browser - Browser pentru copii cu control parental

## Descriere
Acest proiect implementează un browser pentru copii folosind **modelele de design Prototype, Proxy și Facade**:

- **Prototype:** pentru a crea cereri HTTP generice reutilizabile (`GenericRequest`).
- **Proxy:** pentru a aplica control parental asupra cererilor HTTP de tip GET (`CleanGetRequest`).
- **Facade:** pentru a oferi o interfață simplificată către browser (`KidsBrowser`).

Browser-ul verifică automat dacă URL-ul accesat conține cuvinte restricționate și redirecționează către o pagină sigură dacă este cazul.

---

## Structura proiectului

```
ParentalControl/
├── blockedKeywords.txt      # Lista de cuvinte restricționate
src/
├── Clonable.kt
├── GenericRequest.kt
├── GetRequest.kt
├── CleanGetRequest.kt
├── PostRequest.kt
├── KidsBrowser.kt
└── Hello.kt                 # Punctul de intrare al aplicației
target/
pom.xml
```

---

## Cum funcționează

1. **GenericRequest** – clasa care implementează clonarea cererilor HTTP pentru reutilizare.
2. **GetRequest / PostRequest** – clase pentru realizarea cererilor HTTP GET și POST folosind librăria [khttp](https://khttp.readthedocs.io/en/latest/).
3. **CleanGetRequest** – proxy care interceptează cererile GET și verifică dacă URL-ul conține cuvinte restricționate din `blockedKeywords.txt`. Dacă da, browser-ul redirecționează către o pagină sigură.
4. **KidsBrowser** – fațada care oferă o interfață simplificată pentru a alege între GET și POST și pentru a obține răspunsul.
5. **Hello.kt** – scriptul principal care pornește browser-ul și testează funcționalitatea.

---

## Folosire

1. Clonează proiectul:

```bash
git clone <repo-url>
cd ParentalControl
```

2. Compilează și rulează aplicația:

```bash
mvn clean compile exec:java -Dexec.mainClass="org.alin.HelloKt"
```

3. Introdu tipul cererii (`GET` sau `POST`) când aplicația cere.

Exemplu:

```
GET
CANNOT ACCESS THIS WEBSITE! VALEA PE NORIEL COPILAS, N-AI CE CAUTA AICI!
```

---

## Control parental

- Lista de cuvinte restricționate se află în `ParentalControl/blockedKeywords.txt`.
- Orice URL care conține unul dintre aceste cuvinte este blocat automat și redirecționat.

---

## Dependențe

- Kotlin 1.3.71
- Maven
- [khttp](https://khttp.readthedocs.io/en/latest/) 0.1.0

```xml
<dependency>
    <groupId>com.github.jkcclemens</groupId>
    <artifactId>khttp</artifactId>
    <version>0.1.0</version>
</dependency>
```

