/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Department;

/**
 *
 * @author Ahmed
 */
public interface DepartmentDao {
    
    final String INSERT_DEPARTMENT_VALUES = "INSERT INTO `dbs11786303`.`department` (`dept_name`, `dept_code`) VALUES (?,?);";
    final String SHOW_DEPARTMENTS = "SElECT * FROM department";
    final String UPDATE_DEPARTMENT_VALUES = "UPDATE `department` SET `dept_name`=?,`dept_code`=? WHERE `dept_id` =? ";
    final String DELETE_DEPARTMENT_VALUES = "DELETE FROM `department` WHERE `dept_id` =? ";
    
    void addDepartment(Department department);
    void updateDeparment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(int id);
    void deleteDepartment(int departmentid);
    Department getDepartmentByName(String name);
    
}
