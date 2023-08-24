/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

import DBmanager.MarkDbManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Marks;
import model.Student;

/**
 *
 * @author Ahmed
 */
public class MarksOperations {

    MarkDbManager markdbobj = new MarkDbManager();
    Scanner input = new Scanner(System.in);

    public void addSudentCourseOperation() {
        System.out.print("Enter the Student Id : ");
        int studentid = input.nextInt();
        System.out.print("Enter the Course Id : ");
        int courseid = input.nextInt();
        System.out.print("Enter the Marks of Course : ");
        int noofmarks = input.nextInt();

        Marks m = new Marks();
        Student s = new Student();
        Course c = new Course();
        s.setId(studentid);
        c.setId(courseid);

        m.setStudent(s);
        m.setCourse(c);
        m.setMarks(noofmarks);

        markdbobj.addMarks(m);
        System.out.print("Record Added Successfully!");
    }

    public void updateStudentCourseOperation() {

        System.out.print("Enter the Student Id : ");
        int studentid = input.nextInt();
        System.out.print("Enter the Course Id : ");
        int courseid = input.nextInt();
        System.out.print("Enter the Updated Marks : ");
        int noofmarks = input.nextInt();

        Marks mark = new Marks();
        Student s = new Student();
        Course c = new Course();
        s.setId(studentid);
        c.setId(courseid);

        mark.setStudent(s);
        mark.setCourse(c);
        mark.setMarks(noofmarks);

        markdbobj.updateMarks(mark);
        System.out.print("Record Updated Successfully!");
    }

    public void getSingleStudentCourseOperation() {

        List<Marks> marks = markdbobj.getStudentData();

        System.out.println("Enter the Student Name : ");
        String studentname = input.next();
        boolean flag = false;
        int count = 0;

        for (Marks m : marks) {
            if ((m.getStudent().getName()).equals(studentname)) {
                flag = true;
                if (flag == true && count == 0) {
                    System.out.println("Student Name : " + m.getStudent().getName());
                    System.out.println("=============================");
                    count++;
                }
                System.out.println("Course Name : " + m.getCourse().getName());
                System.out.print("Marks Obtained in course : " + m.getMarks());
                System.out.println();
            }
        }
    }

    public void getAllStudentCourseOperation() {

        List<Marks> marks = markdbobj.getStudentData();

        String studentname = input.next();
        boolean flag = false;
        String getname;

        for (Marks m : marks) {
    
            getname =  m.getStudent().getName();
            
            if ((m.getStudent().getName()).equals(getname)) {
                
                System.out.println("Student Name : " + getname );
                System.out.println("=============================");
                System.out.println("Course Name : " + m.getCrse().getName());
                System.out.print("Marks Obtained in course : " + m.getMarks());
                System.out.println();
                
            }
        }
    }
}
