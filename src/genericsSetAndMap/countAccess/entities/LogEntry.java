package genericsSetAndMap.countAccess.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry {

    private final String username;
    private final LocalDateTime moment;

    public LogEntry(String username, LocalDateTime moment) {
        this.username = username;
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(username, logEntry.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
