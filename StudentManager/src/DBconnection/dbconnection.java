/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBconnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 *
 * @author Ahmed
 */
public class dbconnection {
    public static Connection getconnection() throws SQLException{
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
