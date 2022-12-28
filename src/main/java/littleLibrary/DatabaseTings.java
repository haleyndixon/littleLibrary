package littleLibrary;

import java.sql.*;


public class DatabaseTings {
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

    public static void CheckConnection() {
        Connection conn = DatabaseTings.getConnection();
        if (conn == null) {
            System.out.println("connection is not successful");
            System.exit(1);
        } else {
            System.out.println("connection successful");
        }
    }
}





