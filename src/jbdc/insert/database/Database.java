package jbdc.insert.database;

import jbdc.delete.database.expections.DBException;

import java.sql.*;

public class Database {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db";
                String root = "root";
                String password = "password";

                connection = DriverManager.getConnection(url, root, password);
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }
}
