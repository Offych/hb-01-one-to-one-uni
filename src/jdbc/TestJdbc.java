package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to database: " + url);
            Connection myConn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection successfull!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
