package jbdc.update;


import jbdc.update.database.Database;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)"
            );

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Database.closeStatement(preparedStatement);
            Database.closeConnection();
        }

    }
}
