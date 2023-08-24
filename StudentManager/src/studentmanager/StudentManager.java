/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanager;

import DBconnection.dbconnection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import DBmanager.DepartDbManager;
/**
 *
 * @author Ahmed
 */
public class StudentManager {
//   private final DepartmentOperations departmentoperation = null;
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        int choice;
        int moreoption;
        // TODO code application logic here
       Connection connect = dbconnection.getconnection();
        
        if(connect == null){
            System.out.print("Error established in database connection");
        }else{
            System.out.print("Connection Established!");
        }
        
        System.out.println("===== Welcome to my Student CRUD Application of JDBC");
        System.out.println("1- Department Management");
        System.out.println("2- Course Management");
        System.out.println("3- Student Management");
        System.out.println("4- Marks Management");
        System.out.println();
        System.out.print("Enter the Choice");
        choice = input.nextInt();
        
        if(choice == 1){
            DepartmentOperations departmentOperations = new DepartmentOperations();

            System.out.println("1) Add Department");
            System.out.println("2) Update Department (any column) ");
            System.out.println("3) Show Departments");
            System.out.println("4) Delete any Department");
            System.out.println();
            System.out.print("Enter the option");
            moreoption = input.nextInt();
            switch (moreoption) {
                case 1 -> departmentOperations.addDepartOperation();
                case 2 -> departmentOperations.updateDepartOperation();
                case 3 -> departmentOperations.showDepartOperation();
                case 4 -> departmentOperations.deleteDepartOperation();
                default -> {
                    System.out.println("Invalid Option Selected!");
                }
            }
        }else if(choice == 2){
            CourseOperations courseoperation = new CourseOperations();

            System.out.println("1) Add Course");
            System.out.println("2) Update Course (any column) ");
            System.out.println("3) Show Course");
            System.out.println("4) Delete any Course");
            System.out.println();
            System.out.print("Enter the option");
            moreoption = input.nextInt();
            switch (moreoption) {
        case 1 -> courseoperation.addCourseOperation();
                case 2 -> courseoperation.updateCourseOperation();
                case 3 -> courseoperation.showCourseOperation();
                case 4 -> courseoperation.deleteCourseOperation();
                default -> {
                    System.out.println("Invalid Option Selected!");
                }
            }
        }else if(choice == 3){
            StudentOperations studentoperation = new StudentOperations();
            
            System.out.println("1) Add Student");
            System.out.println("2) Update Student (any column) ");
            System.out.println("3) Show Student");
            System.out.println("4) Delete any Student");
            System.out.println();
            System.out.print("Enter the option");
            moreoption = input.nextInt();
            switch (moreoption) {
                case 1 -> studentoperation.addStudentOperation();
                case 2 -> studentoperation.updateStudentOperation();
                case 3 -> studentoperation.showAllStudentsOperation();
                case 4 -> studentoperation.deleteStudentOperation();
                default -> {
                    System.out.println("Invalid Option Selected!");
                }
            }
        }else if(choice == 4){
            MarksOperations marksoperation = new MarksOperations();
            
            System.out.println("1) Add Marks Record");
            System.out.println("2) Update Marks of Record ");
            System.out.println("3) Show Data Record of Single Student");
            System.out.println("4) Show Data Record of All Students");
            System.out.println();
            System.out.print("Enter the option");
            moreoption = input.nextInt();
            switch (moreoption) {
                case 1 -> marksoperation.addMarksOperation();
                case 2 -> marksoperation.updateMarksOperation();
                case 3 -> marksoperation.getSingleStudentMarksOperation();
                case 4 -> marksoperation.getAllStudentDataOperation();
                default -> {
                    System.out.println("Invalid Option Selected!");
                }
            }
        }
    }
}
