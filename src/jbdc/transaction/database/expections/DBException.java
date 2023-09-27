package jbdc.transaction.database.expections;

public class DBException extends RuntimeException {

    public DBException(String message) {
        super(message);
    }
}
