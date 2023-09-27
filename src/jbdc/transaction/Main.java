package jbdc.transaction;

import jbdc.delete.database.expections.DBException;
import jbdc.transaction.database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = Database.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            connection.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DBException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DBException("Error trying to roolback! Caused by: " + e1.getMessage());
            }
        } finally {
            Database.closeStatement(statement);
            Database.closeConnection();
        }
    }
}
