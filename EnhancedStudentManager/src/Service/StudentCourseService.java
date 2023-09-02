/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import dao.StudentCourseDao;
import daoimpl.StudentCourseDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public interface StudentCourseService {

    StudentCourseDao studentcourseobj = new StudentCourseDaoImpl();
    Scanner input = new Scanner(System.in);

    void addSudentCourseService();

    void updateStudentCourseService();

    void getSingleStudentCourseService();

    void getAllStudentCourseService();
}
