package jbdc.transaction.database.expections;

public class DBIntegrityException extends RuntimeException {

    public DBIntegrityException(String message) {
        super(message);
    }
}
