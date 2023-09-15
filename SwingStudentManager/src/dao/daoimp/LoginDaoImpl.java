/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.daoimp;

import DBconnectivity.dbconnection;
import com.mysql.cj.xdevapi.Statement;
import dao.LoginDao;
import static dao.LoginDao.GET_LOGIN_BY_EMAIL;
import static dao.LoginDao.GET_LOGIN_DATA;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;

/**
 *
 * @author Ahmed
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public List<Login> getLoginData() {
        try {
            Connection connect = dbconnection.getconnection();
            List<Login> logins = new ArrayList<>();
            java.sql.Statement showlogin = connect.createStatement();
            ResultSet rstlogin = showlogin.executeQuery(GET_LOGIN_DATA);
            while (rstlogin.next()) {
                Login login = new Login();
                login.setId(rstlogin.getInt("id"));
                login.setEmail(rstlogin.getString("email"));
                login.setPassword(rstlogin.getString("password"));

                logins.add(login);
            }

            return logins;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Login getLoginByEmail(String email) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(GET_LOGIN_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rstlogin = ps.executeQuery();

            while (rstlogin.next()) {
                Login login = new Login();
                login.setId(rstlogin.getInt("id"));
                login.setEmail(rstlogin.getString("email"));
                login.setPassword(rstlogin.getString("password"));

//                if (login.getEmail().equals(email)) {
                    return login;
//                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
