/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import dao.DepartmentDao;
import daoimpl.DepartmentDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public interface DepartmentService {

    Scanner input = new Scanner(System.in);
    DepartmentDao departmentobj = new DepartmentDaoImpl();

    void addDepartmentService();

    void showDepartmentService();

    void updateDepartmentService();
    
    void deleteDepartmentService();
}
