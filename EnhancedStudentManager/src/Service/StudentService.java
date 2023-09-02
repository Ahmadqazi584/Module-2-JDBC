/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import dao.StudentDao;
import daoimpl.StudentDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public interface StudentService {
     final String CHECK_DEPARTMENT_NAME = "SELECT `dept_id` FROM `department` WHERE `dept_name` = ?";
    
     final StudentDao studentdbobj = new StudentDaoImpl();
     final Scanner input = new Scanner(System.in);
     
     void addStudentService();
     void showAllStudentService();
     void updateStudentService();
     void deleteStudentService();
     
}