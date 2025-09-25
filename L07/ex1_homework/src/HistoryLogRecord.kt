import java.sql.Timestamp

class HistoryLogRecord(val timestamp: Timestamp, val command: String) : Comparable<HistoryLogRecord> {

    override fun compareTo(other: HistoryLogRecord): Int {
        return this.timestamp.compareTo(other.timestamp)
    }


}