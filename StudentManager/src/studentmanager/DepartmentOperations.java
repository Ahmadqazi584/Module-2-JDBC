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

    public void addDepartmentOperation(){
        
        System.out.print("Enter Department Name : " );
        String departmentname = input.next();
        System.out.print("Enter Department Code : " );
        String departmentcode = input.next();
        
        Department department = new Department();
        department.setName(departmentname);
        department.setCode(departmentcode);
        
        departdbobj.addDepartment(department);
    }
   public void showDepartmentOperation() {
        List<Department> depart = departdbobj.getAllDepartment(); // Call the method on the database manager
        for (Department department : depart) {
            System.out.println("Department Id: " + department.getId());
            System.out.println("Department Name: " + department.getName());
            System.out.println("Department Code: " + department.getCode());
            System.out.println("=============================");
        }
    }
   public void updateDepartmentOperation(){        
        
        Department d = departdbobj.getDepartmentById(1);
        
        System.out.print("Enter your new Department code");
        String departmentcode = input.next();
        d.setCode(departmentcode);
        
        departdbobj.updateDeparment(d);
        System.out.print("Record Updated Successfully!");

   }
   
   public void deleteDepartmentOperation(){
        departdbobj.deleteDepartment(7);
        System.out.print("Record Deleted Successfully!");
   }  
}
