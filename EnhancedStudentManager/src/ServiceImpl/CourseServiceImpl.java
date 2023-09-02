/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Service.CourseService;
import java.util.List;
import model.Course;

/**
 *
 * @author Ahmed
 */
public class CourseServiceImpl implements CourseService{

    @Override
    public void addCourseService() {
        System.out.print("Enter the Course Name : ");
        String coursename = input.next();
        
        System.out.print("Enter the Course Code : ");
        String coursecode = input.next();
        
        Course c = new Course();
        c.setName(coursename);
        c.setCode(coursecode);
        
        courseobj.addCourse(c);
        System.out.println("Course Inserted Successfully!");
    }

    @Override
    public void updateCourseService() {
        Course course = courseobj.getCourseById(1);
        
        System.out.print("Enter the course name : ");
        String coursename = input.nextLine();
        course.setName(coursename);
        
        System.out.print("Enter the course code : ");
        String coursecode = input.nextLine();
        course.setCode(coursecode);
        
        courseobj.updateCourse(course);
        System.out.println("course Updated Successfully!");
    }

    @Override
    public void showCourseService() {
        List<Course> crse = courseobj.getAllCourse();
        for(Course course : crse){
            System.out.println("Course Id: " + course.getId());
            System.out.println("Course Name: " + course.getName());
            System.out.println("Course Code: " + course.getCode());
            System.out.println("=============================");
        }
    }

    @Override
    public void deleteCourseService() {
        courseobj.deleteCourse(7);
        System.out.print("Record Deleted Successfully!");
    }
}
