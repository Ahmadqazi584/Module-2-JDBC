/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimpl;

import DBconnection.dbconnection;
import dao.DepartmentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;

/**
 *
 * @author Ahmed
 */
public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public void addDepartment(Department department) {
        Connection connect;
        try {
            connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_DEPARTMENT_VALUES);
            ps.setString(1, department.getName());
            ps.setString(2, department.getCode());
            ps.execute();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Department " + department.getName() + " added successfully!");
    }

    @Override
    public void updateDeparment(Department department) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_DEPARTMENT_VALUES);

            ps.setString(1, department.getName());
            ps.setString(2, department.getCode());
            ps.setInt(3, department.getId());
            ps.execute();
            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        try {
            Connection connect = dbconnection.getconnection();
            List<Department> departments = new ArrayList<>();
            Statement showdepartment = connect.createStatement();
            ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS);

            while (rstdepartment.next()) {
                Department d = new Department();
                d.setId(rstdepartment.getInt("dept_id"));
                d.setName(rstdepartment.getString("dept_name"));
                d.setCode(rstdepartment.getString("dept_code"));

                departments.add(d);
            }

            return departments; // Return the list containing departments
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Department getDepartmentById(int id) {
        try ( Connection connect = dbconnection.getconnection();  Statement showdepartment = connect.createStatement();  ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS)) {

            while (rstdepartment.next()) {
                Department d = new Department();
                d.setId(rstdepartment.getInt("dept_id"));
                d.setName(rstdepartment.getString("dept_name"));
                d.setCode(rstdepartment.getString("dept_code"));

                if (d.getId() == id) {
                    return d;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteDepartment(int departmentid) {
        try {
            Connection connect = dbconnection.getconnection();

            // First, delete related records in the student table
            String deleteStudentRecords = "DELETE FROM student WHERE dept_id = ?";
            PreparedStatement deleteStudentStmt = connect.prepareStatement(deleteStudentRecords);
            deleteStudentStmt.setInt(1, departmentid);
            deleteStudentStmt.execute();

            // Then, delete the department
            PreparedStatement deletestatement = connect.prepareStatement(DELETE_DEPARTMENT_VALUES);
            deletestatement.setInt(1, departmentid);
            deletestatement.execute();

            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Department getDepartmentByName(String name) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement preparestatement = connect.prepareStatement("select * from department where dept_name = ?");
            preparestatement.setString(1, name);

            ResultSet rst = preparestatement.executeQuery();

            //ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS)) {
            while (rst.next()) {
                Department d = new Department();
                d.setId(rst.getInt("dept_id"));
                d.setName(rst.getString("dept_name"));
                d.setCode(rst.getString("dept_code"));

                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
