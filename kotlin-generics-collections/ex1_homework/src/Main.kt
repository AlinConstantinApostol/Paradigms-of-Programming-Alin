import java.io.File
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun getTimestamp(it: String): Timestamp {
    var startDate = it.substringAfter("Start-Date: ").substringBefore("\n")
    startDate = startDate.replace("  ", " ")

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]")
    val dateTime = LocalDateTime.parse(startDate, formatter)

    return Timestamp.valueOf(dateTime)
}

fun getCommand(it: String): String {
    val command = it.substringAfter("Commandline: ").substringBefore("\n")
    return command
}

fun processingLogFile(pathName: String): MutableMap<Timestamp, HistoryLogRecord> {
    val logsString = File(pathName).readText().split("\n\n") // lista de loguri brute (ca text)
    val logsMap: MutableMap<Timestamp, HistoryLogRecord> = mutableMapOf()

    logsString.forEach() {log ->
        try {
            val timestamp = getTimestamp(log)
            val command = getCommand(log)

            logsMap[timestamp] = HistoryLogRecord(timestamp, command)
        } catch (e : Exception) {
            println("Error handling log.")
        }

    }
    return logsMap
}

fun <T : Comparable<T>> maxim(obj1: T, obj2: T): T {
    return if (obj1 > obj2) obj1 else obj2
}

fun <K, T> findAndReplace(firstElem: T, secondElem: T, map: MutableMap<K,T>): MutableMap<out K, out T> {
    // firstElem ->
    val  finalMap: MutableMap<K, T> = mutableMapOf()

    map.forEach() {
        if (it.value == firstElem) {
            finalMap[it.key] = secondElem
        }
         else {
            finalMap[it.key] = it.value
        }
    }
    return finalMap
}

fun main() {

    var logsMap: MutableMap<Timestamp, HistoryLogRecord> = mutableMapOf()


    logsMap = processingLogFile("resources/a.txt")

    val r1 = logsMap[Timestamp.valueOf("2024-03-28 13:19:15.0")]!!
    val r2 = logsMap[Timestamp.valueOf("2024-03-16 12:17:25.0")]!!

    val r3 = maxim(r1, r2) // comparare si gasire maxim

    println(r3.timestamp.toString() + " " + r3.command)

    val newLogsMap = findAndReplace(r1,r2, logsMap)

    newLogsMap.forEach() {
        println(it.key.toString() + " " + it.value.command)
    }

}