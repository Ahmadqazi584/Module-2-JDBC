/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

import DBmanager.CourseDbManager;
import java.util.List;
import java.util.Scanner;
import model.Course;

/**
 *
 * @author Ahmed
 */
public class CourseOperations {
    Scanner input = new Scanner(System.in);
    CourseDbManager coursedbobj = new CourseDbManager();
    
    public void addCourseOperation(){
        System.out.print("Enter the Course Name : ");
        String crsename = input.next();
        
        System.out.print("Enter the Course Code : ");
        String crsecode = input.next();
        
        Course c = new Course();
        c.setCoursename(crsename);
        c.setCoursecode(crsecode);
        
        coursedbobj.addCourse(c);
        System.out.println("Course Inserted Successfully!");
    }
    
    public void updateCourseOperation(){
        Course course = coursedbobj.getCourseById(1);
        
        System.out.print("Enter the course name : ");
        String coursename = input.nextLine();
        course.setCoursename(coursename);
        
        System.out.print("Enter the course code : ");
        String coursecode = input.nextLine();
        course.setCoursecode(coursecode);
        
        coursedbobj.updateCourse(course);
        System.out.println("course Updated Successfully!");
    }
    
    public void showCourseOperation(){
        List<Course> crse = coursedbobj.getAllCourse();
        for(Course course : crse){
            System.out.println("Course Id: " + course.getId());
            System.out.println("Course Name: " + course.getCoursename());
            System.out.println("Course Code: " + course.getCoursecode());
            System.out.println("=============================");
        }
    }
    
    public void deleteCourseOperation(){
        coursedbobj.deleteCourse(7);
        System.out.print("Record Deleted Successfully!");
    }
}
