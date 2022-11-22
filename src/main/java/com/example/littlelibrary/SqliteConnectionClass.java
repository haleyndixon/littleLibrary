package com.example.littlelibrary;

import java.sql.*;


public class SqliteConnectionClass {

    public static Connection getConnection() {
        Connection connection = null;

        try {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/haley/IdeaProjects/littleLibrary/littleLibrary.db");
        } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        }
        return connection;
    }

}


