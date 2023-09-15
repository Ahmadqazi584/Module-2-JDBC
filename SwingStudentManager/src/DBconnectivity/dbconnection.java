package DBconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnection {

    public static Connection getconnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs11786303", "root", "javatesting");
//            connection.close();
            return connection;
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs11786303","root", "javatesting");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
//    private dbconnection() {
//    }

//    private static Connection connection = null;
//    private static final String url = "jdbc:mysql://localhost:3306/dbs11786303";
//    private static final String user = "root";
//    private static final String password = "javatesting";
//
//    public static Connection getconnection() throws SQLException {
//
//        if (connection == null) {
//            try {
//                // Ensure the correct JDBC driver class name
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException ex) {
//                // Handle the exception (e.g., throw a runtime exception or log it)
//                throw new RuntimeException("MySQL JDBC Driver not found", ex);
//            }
//        }
//
//        return connection;
////            }
//        }
//
//        return connection;
//    }
//}
