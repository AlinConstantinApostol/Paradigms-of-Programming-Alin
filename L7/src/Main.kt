import java.text.SimpleDateFormat
import java.util.*

data class HistoryLogRecord(
    val timestamp: Long,
    val commandLine: String
) : Comparable<HistoryLogRecord> {

    override fun compareTo(other: HistoryLogRecord): Int {
        return timestamp.compareTo(other.timestamp)
    }
}

fun <T : Comparable<T>> maxOfTwo(first: T, second: T): T {
    return if (first > second) first else second
}

fun <T : Comparable<T>> findAndReplace(
    toFind: T,
    toReplaceWith: T,
    map: MutableMap<Long, T>
) {
    map.forEach { (key, value) ->
        if (value == toFind) {
            map[key] = toReplaceWith
        }
    }
}

fun main() {
    val logFile = "/var/log/apt/history.log"
    val historyRecords = mutableListOf<HistoryLogRecord>()

    // Citim fișierul și extragem ultimele 50 de intrări
    val lines = mutableListOf<String>()
    java.io.File(logFile).useLines { lines.addAll(it.toList()) }
    val last50Entries = lines.takeLast(50)

    // Procesăm fiecare linie pentru a extrage metadatele și a le converti în HistoryLogRecord
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    last50Entries.forEach { line ->
        if (line.startsWith("Start-Date:")) {
            val startDate = line.substringAfter(": ").trim()
            val timestamp = dateFormat.parse(startDate).time
            val commandLine = lines[lines.indexOf(line) + 1].substringAfter(": ").trim()
            val record = HistoryLogRecord(timestamp, commandLine)
            historyRecords.add(record)
        }
    }

    // Creăm un MutableHashMap cu obiectele HistoryLogRecord
    val recordMap = mutableMapOf<Long, HistoryLogRecord>()
    historyRecords.forEach { record ->
        recordMap[record.timestamp] = record
    }

    // Exemplu de utilizare a funcțiilor polimorfice
    val maxRecord = maxOfTwo(historyRecords[0], historyRecords[1])
    println("Max record: $maxRecord")

    val recordToFind = HistoryLogRecord(123456789, "example command")
    val replacementRecord = HistoryLogRecord(987654321, "replacement command")
    findAndReplace(recordToFind, replacementRecord, recordMap)
}