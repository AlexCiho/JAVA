package com.company;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/Movies";
    private static final String USER = "roor";
    private static final String PASSWORD = "";
    private static Connection connection = null;

    private Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public static void createConnection() {
        try {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException e) {
            System.err.println(e);

        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            System.err.println(e);

        }
    }

    public static void commit() {

        try {
            connection.commit();
        }
        catch (SQLException e) {
            System.err.println(e);

        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        }
        catch (SQLException e) {
            System.err.println(e);

        }
    }
}


