package jbdc.select;

import jbdc.select.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");

                System.out.println(id + ", " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Database.closeResultSet(resultSet);
            Database.closeStatement(statement);
            Database.closeConnection();
        }
    }
}
