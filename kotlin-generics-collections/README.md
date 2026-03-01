HistoryLogProcessor – Laborator Paradigms of Programming
Descriere proiect

Acest proiect implementează o aplicație care procesează ultimele intrări din fișierul de log al sistemului /var/log/apt/history.log și stochează informațiile relevante într-o structură de date tip MutableHashMap.

Aplicația extrage:

Start-Date – transformat în timestamp

Commandline – comanda executată

Opțional, alte metadate (Requested-By, Install, Upgrade, End-Date)

Obiectele sunt instanțe ale clasei HistoryLogRecord, care implementează interfața Comparable pentru a permite compararea timestamp-urilor.

Structura proiectului
HistoryLogProcessor/
│
├── src/
│   ├── HistoryLogRecord.kt      # Clasa care stochează timestamp și commandline, implementează Comparable
│   ├── Main.kt                  # Script principal pentru parsarea fișierului și operații pe MutableMap
│   ├── resources/
│   │   └── a.txt                # Exemplu de fișier de log cu intrări apt
│   ├── .gitignore
│   ├── ex1_homework.iml
│   ├── out/                     # Fișiere generate de compilatorul Kotlin
│   └── .idea/

Clasa principală
HistoryLogRecord.kt

import java.sql.Timestamp

class HistoryLogRecord(val timestamp: Timestamp, val command: String) : Comparable<HistoryLogRecord> {

    override fun compareTo(other: HistoryLogRecord): Int {
        return this.timestamp.compareTo(other.timestamp)
    }
}

    timestamp – timestamp-ul comenzii

    command – linia de comandă executată

    compareTo – compară două obiecte după timestamp

Funcții principale
getTimestamp(it: String): Timestamp

    Extrage Start-Date din blocul de log

    Transformă data într-un Timestamp Kotlin

getCommand(it: String): String

    Extrage linia de comandă (Commandline)

processingLogFile(pathName: String): MutableMap<Timestamp, HistoryLogRecord>

    Primește calea către fișierul de log

    Parsează fiecare bloc de log separat prin două linii noi (\n\n)

    Creează un HistoryLogRecord pentru fiecare intrare

    Returnează un MutableMap<Timestamp, HistoryLogRecord>

maxim(obj1: T, obj2: T): T

    Funcție generică pentru a compara două obiecte Comparable

    Returnează obiectul cu cel mai recent timestamp

findAndReplace(firstElem: T, secondElem: T, map: MutableMap<K,T>): MutableMap<out K, out T>

    Funcție generică polimorfică

    Caută un obiect într-un MutableMap și îl înlocuiește cu altul

Exemplu rulare

fun main() {
    var logsMap: MutableMap<Timestamp, HistoryLogRecord> = processingLogFile("resources/a.txt")

    val r1 = logsMap[Timestamp.valueOf("2025-04-01 01:05:49.0")]!!
    val r2 = logsMap[Timestamp.valueOf("2025-04-02 16:37:43.0")]!!

    val r3 = maxim(r1, r2)
    println(r3.timestamp.toString() + " " + r3.command)

    val newLogsMap = findAndReplace(r1, r2, logsMap)
    newLogsMap.forEach {
        println(it.key.toString() + " " + it.value.command)
    }
}

Exemplu de output:

Parsează fiecare bloc de log separat prin două linii noi (\n\n)

Creează un HistoryLogRecord pentru fiecare intrare

Returnează un MutableMap<Timestamp, HistoryLogRecord>

maxim(obj1: T, obj2: T): T

Funcție generică pentru a compara două obiecte Comparable

Returnează obiectul cu cel mai recent timestamp

findAndReplace(firstElem: T, secondElem: T, map: MutableMap<K,T>): MutableMap<out K, out T>

Funcție generică polimorfică

Caută un obiect într-un MutableMap și îl înlocuiește cu altul


Parsează fiecare bloc de log separat prin două linii noi (\n\n)

Creează un HistoryLogRecord pentru fiecare intrare

Returnează un MutableMap<Timestamp, HistoryLogRecord>

maxim(obj1: T, obj2: T): T

Funcție generică pentru a compara două obiecte Comparable

Returnează obiectul cu cel mai recent timestamp

findAndReplace(firstElem: T, secondElem: T, map: MutableMap<K,T>): MutableMap<out K, out T>

Funcție generică polimorfică

Caută un obiect într-un MutableMap și îl înlocuiește cu altul

Exemplu rulare
fun main() {
    var logsMap: MutableMap<Timestamp, HistoryLogRecord> = processingLogFile("resources/a.txt")

    val r1 = logsMap[Timestamp.valueOf("2025-04-01 01:05:49.0")]!!
    val r2 = logsMap[Timestamp.valueOf("2025-04-02 16:37:43.0")]!!

    val r3 = maxim(r1, r2)
    println(r3.timestamp.toString() + " " + r3.command)

    val newLogsMap = findAndReplace(r1, r2, logsMap)
    newLogsMap.forEach {
        println(it.key.toString() + " " + it.value.command)
    }
}

Exemplu de output:

2025-04-02 16:37:43.0 /usr/bin/unattended-upgrade
2025-04-01 01:05:49.0 apt install sqlite3 sqlitebrowser
2025-04-02 16:37:43.0 /usr/bin/unattended-upgrade
...
