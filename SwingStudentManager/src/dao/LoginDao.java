/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Login;

/**
 *
 * @author Ahmed
 */
public interface LoginDao {
    
    final static String GET_LOGIN_DATA = "SELECT * FROM `login`";
    final static String GET_LOGIN_BY_EMAIL = "SELECT * FROM `login` WHERE `email` = ?";
    List<Login> getLoginData();
    Login getLoginByEmail(String email);
    
}
