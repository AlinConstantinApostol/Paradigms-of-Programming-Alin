# Double Chain of Responsibility (compatible Hello.kt)

## Descriere
Aplicația implementează un lanț dublu (sus/jos) de responsabilități. Un `Request - <mesaj>` pleacă de la capătul superior (CEO) și este forwardat până la handler-ul potrivit, care procesează cererea (simulat cu `delay`) și trimite `Response - <mesaj>` înapoi pe lanțul inferior către superiori.

## Structura minimă
project-root/
├── src/
│ └── main/
│ └── kotlin/
│ └── org/
│ └── alin/
│ ├── AbstractFactory.kt
│ ├── EliteFactory.kt
│ ├── HappyWorkerFactory.kt
│ ├── FactoryProducer.kt
│ ├── Handler.kt
│ └── Hello.kt
├── pom.xml
└── .gitignore

## Clase principale
- `Handler` (existent în proiect) — interfață folosită de handler-e.
- `CEOHandler`, `ExecutiveHandler`, `ManagerHandler`, `HappyWorkerHandler` — implementări concrete (definite în `Hello.kt` pentru test).
- Fiecare handler are referințe `next` și `prev`.
- Logica de forward/process se realizează intern în `handleRequest`, folosind corutine (`kotlinx.coroutines`) și `delay`.

## Mesaje
- Cerere: `Request - <descriere>`
- Răspuns: `Response - <descriere>`

## Build & Run
1. `mvn clean compile`
2. `mvn exec:java -Dexec.mainClass="org.alin.HelloKt"`

## Observații de integrare
- `Hello.kt` test este compatibil cu fișierul `Handler.kt` din proiect (folosește interfața `Handler` existentă).
- Dacă în proiect există implementări de fabrici (`AbstractFactory`, `EliteFactory`, `HappyWorkerFactory`), acestea pot fi adaptate pentru a furniza instanțele concrete (`CEOHandler`, `ExecutiveHandler`, ...).

