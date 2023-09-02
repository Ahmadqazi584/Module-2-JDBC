/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Service.DepartmentService;
import java.util.List;
import model.Department;

/**
 *
 * @author Ahmed
 */
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public void addDepartmentService() {
        System.out.print("Enter Department Name : ");
        String departmentname = input.next();
        System.out.print("Enter Department Code : ");
        String departmentcode = input.next();

        Department department = new Department();
        department.setName(departmentname);
        department.setCode(departmentcode);

        departmentobj.addDepartment(department);
    }

    @Override
    public void showDepartmentService() {
        List<Department> depart = departmentobj.getAllDepartment(); // Call the method on the database manager
        for (Department department : depart) {
            System.out.println("Department Id: " + department.getId());
            System.out.println("Department Name: " + department.getName());
            System.out.println("Department Code: " + department.getCode());
            System.out.println("=============================");
        }
    }

    @Override
    public void updateDepartmentService() {
        Department d = departmentobj.getDepartmentById(1);

        System.out.print("Enter your new Department code");
        String departmentcode = input.next();
        d.setCode(departmentcode);

        departmentobj.updateDeparment(d);
        System.out.print("Record Updated Successfully!");
    }

    @Override
    public void deleteDepartmentService() {
        departmentobj.deleteDepartment(7);
        System.out.print("Record Deleted Successfully!");
    }

}
