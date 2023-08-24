/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;
import DBmanager.DepartDbManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Department;

/**
 *
 * @author Ahmed
 */
public class DepartmentOperations {
    Scanner input = new Scanner(System.in);
    DepartDbManager departdbobj = new DepartDbManager();

    public void addDepartOperation(){
        
        System.out.print("Enter Department Name : " );
        String departname = input.next();
        System.out.print("Enter Department Code : " );
        String departcode = input.next();
        
        Department department = new Department();
        department.setDepartname(departname);
        department.setDepartcode(departcode);
        
        departdbobj.addDepartment(department);
    }
   public void showDepartOperation() {
        List<Department> depart = departdbobj.getAllDepartment(); // Call the method on the database manager
        for (Department department : depart) {
            System.out.println("Department Id: " + department.getId());
            System.out.println("Department Name: " + department.getDepartname());
            System.out.println("Department Code: " + department.getDepartcode());
            System.out.println("=============================");
        }
    }
   public void updateDepartOperation(){        
        
        Department d = departdbobj.getDepartmentById(1);
        
        System.out.print("Enter your new Department code");
        String departcode = input.next();
        d.setDepartcode(departcode);
        
        departdbobj.updateDeparment(d);
        System.out.print("Record Updated Successfully!");

   }
   
   public void deleteDepartOperation(){
        departdbobj.deleteDepartment(7);
        System.out.print("Record Deleted Successfully!");
   }  
}
