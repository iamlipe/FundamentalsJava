package jbdc.insert;

import jbdc.insert.database.Database;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Database.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse("22/04/1985", formatter);
            Date sqlDate = Date.valueOf(date);

            preparedStatement.setString(1, "Carl Purple");
            preparedStatement.setString(2, "carl@gmail.com");
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setDouble(4, 3000.0);
            preparedStatement.setInt(5, 4);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);

                    System.out.println("Done! Id = " + id);
                }

            } else {
                System.out.println("No rows affected!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Database.closeStatement(preparedStatement);
            Database.closeConnection();
        }

    }
}
