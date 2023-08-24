
package studentmanager;

import DBconnection.dbconnection;
import DBmanager.StudentDbManager;
import model.Department;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentOperations {

    private final String CHECK_DEPARTMENT_NAME = "SELECT `dept_id` FROM `department` WHERE `dept_name` = ?";
    
    private final StudentDbManager studentdbobj = new StudentDbManager();
    private final Scanner input = new Scanner(System.in);

    public void addStudentOperation() {
        try (Connection connect = dbconnection.getconnection();
             PreparedStatement ps = connect.prepareStatement(CHECK_DEPARTMENT_NAME)) {
            
            Student std = new Student();
            
            System.out.print("Enter the Student Name: ");
            String studentname = input.nextLine();
            System.out.print("Enter the Student Email: ");
            String studentemail = input.nextLine();
            System.out.print("Enter the Student Phone: ");
            String studentphone = input.nextLine();
            System.out.print("Enter the Student Department Name: ");
            String studentdeptname = input.nextLine();

            ps.setString(1, studentdeptname);
            ResultSet deptResult = ps.executeQuery();
            
            int getdeptid = 0; // Initialize getdeptid
            boolean departmentExists = false;

            if (deptResult.next()) {
                departmentExists = true;
                getdeptid = deptResult.getInt("dept_id");
            }

            if (departmentExists) {
                // Department exists, proceed to add the student
                Student s = new Student();
                s.setStudentname(studentname);
                s.setStudentemail(studentemail);
                s.setStudentphone(studentphone);
                Department d = new Department();
                d.setId(getdeptid); // Use the retrieved department ID
                s.setDepart(d);

                studentdbobj.addStudent(s);
                System.out.print("Record Added Successfully!");
                
            } else {
                System.out.println("The department does not exist.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllStudentsOperation(){
        List<Student> list = studentdbobj.getAllStudent();
        for(Student student : list){
            System.out.println("Student Name : " + student.getStudentname());
            System.out.println("Student Email : " + student.getStudentemail());
            System.out.println("Student Phone : " + student.getStudentphone());
            System.out.println("Student Department Name : " + student.getDepart().getDepartname());
            System.out.println("Student Department Code : " + student.getDepart().getDepartcode());
            System.out.println("=============================");
        }
    }
    
    public void updateStudentOperation(){
        try {
            Student stu = studentdbobj.getStudentById(1);
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(CHECK_DEPARTMENT_NAME);
            
            System.out.print("Enter the Updated Name : ");
            String updatename = input.nextLine();
            System.out.print("Enter the Update Email : ");
            String updateemail = input.next();
            System.out.print("Enter the Updated Phone : ");
            String updatephone = input.next();
            System.out.print("Enter the Department Name : ");
            String departname = input.next();
            
            ps.setString(1, departname);
            ResultSet deptResult = ps.executeQuery();
            
            int getdeptid = 0; // Initialize getdeptid
            boolean departmentExists = false;
            
            while(deptResult.next()){
                departmentExists = true;
                getdeptid = deptResult.getInt("dept_id");
            }
            
            if(departmentExists){
                stu.setStudentname(updatename);
                stu.setStudentemail(updateemail);
                stu.setStudentphone(updatephone);
                Department d = new Department();
                d.setId(getdeptid);
                stu.setDepart(d);
                
                studentdbobj.updateStudent(stu);
                System.out.print("Record Updated Successfully!");
            }else {
                System.out.println("The department does not exist.");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteStudentOperation(){
        studentdbobj.deleteStudent(1);
        System.out.print("Record Deleted Successfully!");
    }
    
}
