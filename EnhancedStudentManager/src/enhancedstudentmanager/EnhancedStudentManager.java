/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enhancedstudentmanager;

import DBconnection.dbconnection;
import Service.CourseService;
import Service.DepartmentService;
import Service.StudentCourseService;
import Service.StudentService;
import ServiceImpl.CourseServiceImpl;
import ServiceImpl.DepartmentServiceImpl;
import ServiceImpl.StudentCourseServiceImpl;
import ServiceImpl.StudentServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Ahmed
 */
public class EnhancedStudentManager {
//   private final DepartmentOperations departmentoperation = null;

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        int choice;
        int moreoption;
        // TODO code application logic here
        Connection connect = dbconnection.getconnection();

        if (connect == null) {
            System.out.print("Error established in database connection");
        } else {
            System.out.print("Connection Established!");
        }

        System.out.println("===== Welcome to my Student CRUD Application of JDBC");
        System.out.println("1- Department Management");
        System.out.println("2- Course Management");
        System.out.println("3- Student Management");
        System.out.println("4- Student Course Management");
        System.out.println();
        System.out.print("Enter the Choice : ");
        choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                DepartmentService departmentservice = new DepartmentServiceImpl();
                System.out.println("1) Add Department");
                System.out.println("2) Update Department (any column) ");
                System.out.println("3) Show Departments");
                System.out.println("4) Delete any Department");
                System.out.println();
                System.out.print("Enter the option : ");
                moreoption = input.nextInt();
                switch (moreoption) {
                    case 1 ->
                        departmentservice.addDepartmentService();
                    case 2 ->
                        departmentservice.updateDepartmentService();
                    case 3 ->
                        departmentservice.showDepartmentService();
                    case 4 ->
                        departmentservice.deleteDepartmentService();
                    default -> {
                        System.out.println("Invalid Option Selected!");
                    }
                }
            }
            case 2 -> {
                CourseService courseservice = new CourseServiceImpl();
                System.out.println("1) Add Course");
                System.out.println("2) Update Course (any column) ");
                System.out.println("3) Show Course");
                System.out.println("4) Delete any Course");
                System.out.println();
                System.out.print("Enter the option : ");
                moreoption = input.nextInt();
                switch (moreoption) {
                    case 1 ->
                        courseservice.addCourseService();
                    case 2 ->
                        courseservice.updateCourseService();
                    case 3 ->
                        courseservice.showCourseService();
                    case 4 ->
                        courseservice.deleteCourseService();
                    default -> {
                        System.out.println("Invalid Option Selected!");
                    }
                }
            }
            case 3 -> {
                StudentService studentservice = new StudentServiceImpl();
                System.out.println("1) Add Student");
                System.out.println("2) Update Student (any column) ");
                System.out.println("3) Show Student");
                System.out.println("4) Delete any Student");
                System.out.println();
                System.out.print("Enter the option : ");
                moreoption = input.nextInt();
                switch (moreoption) {
                    case 1 ->
                        studentservice.addStudentService();
                    case 2 ->
                        studentservice.updateStudentService();
                    case 3 ->
                        studentservice.showAllStudentService();
                    case 4 ->
                        studentservice.deleteStudentService();
                        
                    default -> {
                        System.out.println("Invalid Option Selected!");
                    }
                }
            }
            case 4 -> {
                StudentCourseService studentcourseservice = new StudentCourseServiceImpl();
                System.out.println("1) Add Student Course Record");
                System.out.println("2) Update Marks of Record ");
                System.out.println("3) Show Data Record of Single Student Course");
                System.out.println("4) Show Data Record of All Students Course");
                System.out.println();
                System.out.print("Enter the option : ");
                moreoption = input.nextInt();
                switch (moreoption) {
                    case 1 -> studentcourseservice.addSudentCourseService();
                    case 2 -> studentcourseservice.updateStudentCourseService();
                    case 3 -> studentcourseservice.getSingleStudentCourseService();
                    case 4 -> studentcourseservice.getAllStudentCourseService();
                    default -> {
                        System.out.println("Invalid Option Selected!");
                    }
                }
            }
            default -> {
            }
        }
    }
}
