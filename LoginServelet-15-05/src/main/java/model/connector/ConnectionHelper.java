package model.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student_manager_information?user=root&password=");
        }
        return connection;
    }
}
