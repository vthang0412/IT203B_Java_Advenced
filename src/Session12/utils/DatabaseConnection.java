package Session12.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/hospital";
    public static final String USER = "root";
    public static final String PASS = "Thang@bn1";

    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
