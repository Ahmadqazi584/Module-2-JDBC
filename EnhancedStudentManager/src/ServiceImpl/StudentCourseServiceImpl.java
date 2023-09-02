/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Service.StudentCourseService;
import java.util.List;
import model.Course;
import model.Student;
import model.StudentCourse;

/**
 *
 * @author Ahmed
 */
public class StudentCourseServiceImpl implements StudentCourseService {

    @Override
    public void addSudentCourseService() {
        System.out.print("Enter the Student Id : ");
        int studentid = input.nextInt();
        System.out.print("Enter the Course Id : ");
        int courseid = input.nextInt();
        System.out.print("Enter the Marks of Course : ");
        int noofmarks = input.nextInt();

        StudentCourse sc = new StudentCourse();
        Student s = new Student();
        Course c = new Course();
        s.setId(studentid);
        c.setId(courseid);

        sc.setStudent(s);
        sc.setCourse(c);
        sc.setMarks(noofmarks);

        studentcourseobj.addStudentCourse(sc);
        System.out.print("Record Added Successfully!");
    }

    @Override
    public void updateStudentCourseService() {
        System.out.print("Enter the Student Id : ");
        int studentid = input.nextInt();
        System.out.print("Enter the Course Id : ");
        int courseid = input.nextInt();
        System.out.print("Enter the Updated Marks : ");
        int noofmarks = input.nextInt();

        StudentCourse studentcourse = new StudentCourse();
        Student s = new Student();
        Course c = new Course();
        s.setId(studentid);
        c.setId(courseid);

        studentcourse.setStudent(s);
        studentcourse.setCourse(c);
        studentcourse.setMarks(noofmarks);

        studentcourseobj.updateMarks(studentcourse);
        System.out.print("Record Updated Successfully!");
    }

    @Override
    public void getSingleStudentCourseService() {
        List<StudentCourse> studentcourse = studentcourseobj.getStudentData();

        System.out.println("Enter the Student Name : ");
        String studentname = input.next();
        boolean flag = false;
        int count = 0;

        for (StudentCourse sc : studentcourse) {
            if ((sc.getStudent().getName()).equals(studentname)) {
                flag = true;
                if (flag == true && count == 0) {
                    System.out.println("Student Name : " + sc.getStudent().getName());
                    System.out.println("=============================");
                    count++;
                }
                System.out.println("Course Name : " + sc.getCourse().getName());
                System.out.print("Marks Obtained in course : " + sc.getMarks());
                System.out.println();
            }
        }
    }

    @Override
    public void getAllStudentCourseService() {
        List<StudentCourse> studentcourse = studentcourseobj.getStudentData();

        String studentname = input.next();
        boolean flag = false;
        String getname;

        for (StudentCourse sc : studentcourse) {
    
            getname =  sc.getStudent().getName();
            
            if ((sc.getStudent().getName()).equals(getname)) {
                
                System.out.println("Student Name : " + getname );
                System.out.println("=============================");
                System.out.println("Course Name : " + sc.getCourse().getName());
                System.out.print("Marks Obtained in course : " + sc.getMarks());
                System.out.println();
                
            }
        }
    }

}
