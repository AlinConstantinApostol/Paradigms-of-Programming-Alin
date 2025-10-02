# Double Chain of Responsibility (Coroutines + Abstract Factory)

## Descriere
Aplicația implementează un **lanț de responsabilități dublu** (două direcții — sus și jos) în care un request parcurs pe lanțul superior este procesat de handler-ul corespunzător, iar răspunsul este transmis înapoi pe lanțul inferior către superiorii ierarhici. Instanțierea handler-elor se face prin **Abstract Factory** (EliteFactory, HappyWorkerFactory). Tratarea cererilor folosește **corutine** și `delay` pentru a simula procesări de durată.

### Cerinţe esenţiale
- Lanț dublu: fiecare handler are legături spre `next` (înainte) și `prev` (înapoi).
- Handler-ele procesează request-uri în corutine.
- Dacă handler-ul curent este destinat cererii → procesează și trimite `Response - <mesaj>` pe lanțul de jos.
- Dacă handler-ul NU trebuie să proceseze → forward către `next`.
- Mesajele au formate standard:
  - Request: `Request - <mesaj>`
  - Response: `Response - <mesaj>`
- AbstractFactory: `EliteFactory` creează `CEOHandler`, `ExecutiveHandler`, `ManagerHandler`. `HappyWorkerFactory` creează `HappyWorkerHandler`.

---

## Structura proiectului



---

## Clase și roluri

- `AbstractFactory` — interfața pentru fabrici; `getHandler(handler: String): Handler`.
- `EliteFactory` — returnează `CEOHandler`, `ExecutiveHandler`, `ManagerHandler`.
- `HappyWorkerFactory` — returnează `HappyWorkerHandler`.
- `FactoryProducer` — furnizează instanța potrivită de fabrică.
- `Handler` — definește `handleRequest(message: String): Handler`.
- `CEOHandler`, `ExecutiveHandler`, `ManagerHandler`, `HappyWorkerHandler` — implementări concrete cu legături `next` și `prev`.
- `Hello.kt` — punct de intrare; creează fabricile, configurează lanțurile și trimite request-uri pentru test.

---

## Flux de execuție exemplu
1. Se creează fabrică `EliteFactory`.
2. Se obțin handler-ele și se configurează lanțul sus (`CEO -> Executive -> Manager -> HappyWorker`) și jos (`HappyWorker -> Manager -> Executive -> CEO`).
3. Se trimite mesaj: `Request - task for Executive`.
4. CEO forwardează, Executive procesează, generează `Response - processed by Executive` și îl trimite înapoi spre CEO pe lanțul jos.

---

## Build & Run

1. Compilează proiectul cu Maven:
```bash
mvn clean compile

## Build & Run

1. Compilează proiectul cu Maven:
```bash
mvn clean compile

    Rulează aplicația:

mvn exec:java -Dexec.mainClass="org.alin.HelloKt"
