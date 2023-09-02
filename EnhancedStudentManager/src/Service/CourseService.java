/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import dao.CourseDao;
import daoimpl.CourseDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public interface CourseService {

    Scanner input = new Scanner(System.in);
    CourseDao courseobj = new CourseDaoImpl();

    void addCourseService();

    void updateCourseService();

    void showCourseService();

    void deleteCourseService();

}
