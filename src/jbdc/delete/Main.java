package jbdc.delete;

import jbdc.delete.database.Database;
import jbdc.delete.database.expections.DBIntegrityException;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");

            preparedStatement.setInt(1, 5);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DBIntegrityException(e.getMessage());
        } finally {
            Database.closeStatement(preparedStatement);
            Database.closeConnection();
        }
    }
}
