package DBmanager;

import DBconnection.dbconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartDbManager {

    private final String INSERT_DEPARTMENT_VALUES = "INSERT INTO `dbs11786303`.`department` (`dept_name`, `dept_code`) VALUES (?,?);";
    private final String SHOW_DEPARTMENTS = "SElECT * FROM department";
    private final String UPDATE_DEPARTMENT_VALUES = "UPDATE `department` SET `dept_name`=?,`dept_code`=? WHERE `dept_id` =? ";
    private final String DELETE_DEPARTMENT_VALUES = "DELETE FROM `department` WHERE `dept_id` =? ";
    
    
    public void addDepartment(Department department) {
        Connection connect;
        try {
            connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_DEPARTMENT_VALUES);
            ps.setString(1, department.getDepartname());
            ps.setString(2, department.getDepartcode());
            ps.execute();
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Department " + department.getDepartname() + " added successfully!");
    }
    
    public void updateDeparment(Department department){
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_DEPARTMENT_VALUES);
            
            ps.setString(1, department.getDepartname());
            ps.setString(2, department.getDepartcode());
            ps.setInt(3, department.getId());
            ps.execute();
            connect.close();
//            while(rstdepartment.next()){
//                Department d = new Department();
//                d.setId(rstdepartment.getInt("dept_id"));
//                d.setDepartname(rstdepartment.getString("dept_name"));
//                d.setDepartcode(rstdepartment.getString("dept_code"));
//                
//                departments.add(d);
//            }
            
//            return departments; // Return the list containing departments
        } catch (SQLException ex) {
            Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Department> getAllDepartment(){
        try {
            Connection connect = dbconnection.getconnection();
            List<Department> departments = new ArrayList<>();
            Statement showdepartment = connect.createStatement();
            ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS);
            
            while(rstdepartment.next()){
                Department d = new Department();
                d.setId(rstdepartment.getInt("dept_id"));
                d.setDepartname(rstdepartment.getString("dept_name"));
                d.setDepartcode(rstdepartment.getString("dept_code"));
                
                departments.add(d);
            }
            
            return departments; // Return the list containing departments
        } catch (SQLException ex) {
            Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public Department getDepartmentById(int id) {
        try (Connection connect = dbconnection.getconnection();
             Statement showdepartment = connect.createStatement();
             ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS)) {
            
            while (rstdepartment.next()) {
                Department d = new Department();
                d.setId(rstdepartment.getInt("dept_id"));
                d.setDepartname(rstdepartment.getString("dept_name"));
                d.setDepartcode(rstdepartment.getString("dept_code"));
                
                if (d.getId() == id) {
                    return d;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public void deleteDepartment(int departid) {
    try {
        Connection connect = dbconnection.getconnection();
        
        // First, delete related records in the student table
        String deleteStudentRecords = "DELETE FROM student WHERE dept_id = ?";
        PreparedStatement deleteStudentStmt = connect.prepareStatement(deleteStudentRecords);
        deleteStudentStmt.setInt(1, departid);
        deleteStudentStmt.execute();
        
        // Then, delete the department
        PreparedStatement deleteDeptStmt = connect.prepareStatement(DELETE_DEPARTMENT_VALUES);
        deleteDeptStmt.setInt(1, departid);
        deleteDeptStmt.execute();
        
        connect.close();
    } catch (SQLException ex) {
        Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public Department getDepartmentByName(String name){
        
             try{
                Connection connect = dbconnection.getconnection();
                PreparedStatement preparestatement = connect.prepareStatement("select * from department where dept_name = ?");
                preparestatement.setString(1, name);
             
             ResultSet rst = preparestatement.executeQuery();
                
             //ResultSet rstdepartment = showdepartment.executeQuery(SHOW_DEPARTMENTS)) {
            
            while (rst.next()) {
                Department d = new Department();
                d.setId(rst.getInt("dept_id"));
                d.setDepartname(rst.getString("dept_name"));
                d.setDepartcode(rst.getString("dept_code"));
                
                return d;
            }
            }catch (SQLException ex) {
            Logger.getLogger(DepartDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        return null;
    }

}
