/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.daoimp;

import DBconnectivity.dbconnection;
import dao.StudentCourseDao;
import static dao.StudentCourseDao.GET_STUDENT_COURSES;
import static dao.StudentCourseDao.INSERT_STUDENT_COURSE_RECORD;
import static dao.StudentCourseDao.UPDATE_STUDENT_COURSE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Student;
import model.StudentCourse;

/**
 *
 * @author Ahmed
 */
public class StudentCourseDaoImpl implements StudentCourseDao {
   
    @Override
    public void addStudentCourse(StudentCourse studentcourse) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_STUDENT_COURSE_RECORD);
            ps.setInt(1, studentcourse.getStudent().getId());
            ps.setInt(2, studentcourse.getCourse().getId());
            ps.setInt(3, studentcourse.getMarks());
            ps.execute();

//            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateStudentCourse(StudentCourse studentcourse) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_STUDENT_COURSE);
            ps.setInt(1, studentcourse.getMarks());
            ps.setInt(2, studentcourse.getStudent().getId());
            ps.setInt(3, studentcourse.getCourse().getId());
            ps.execute();

//            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public StudentCourse getStudentCourseById(int id){
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(GET_STU_CRSE_BYID);
            ps.setInt(1, id);
            ResultSet rststucourse = ps.executeQuery();
            while(rststucourse.next()){
                StudentCourse sc = new StudentCourse();
                sc.setId(rststucourse.getInt("mark_id"));
                
                Student s = new Student();
                s.setId(rststucourse.getInt("student_id"));
                sc.setStudent(s);
                
                Course c = new Course();
                c.setId(rststucourse.getInt("course_id"));
                sc.setCourse(c);
                
                sc.setMarks(rststucourse.getInt("mark"));
                
                if(sc.getId() == id){
                    return sc;
                }
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<StudentCourse> getStudentData() {
        List<StudentCourse> marksList = new ArrayList<>();
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(GET_STUDENT_COURSES);
            ResultSet rstgetcourses = ps.executeQuery();
            while (rstgetcourses.next()) {
                StudentCourse studentcourse = new StudentCourse();

                studentcourse.setId(rstgetcourses.getInt("mark_id"));
                
                Student student = new Student();
                student.setId(rstgetcourses.getInt("student_id"));
                student.setName(rstgetcourses.getString("student_name"));
                studentcourse.setStudent(student);

                Course course = new Course();
                course.setId(rstgetcourses.getInt("course_id"));
                course.setName(rstgetcourses.getString("crse_name"));
                studentcourse.setCourse(course);

                studentcourse.setMarks(rstgetcourses.getInt("mark"));

                marksList.add(studentcourse);
            }
//            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marksList;
    }
    
    @Override
    public void deleteStudentCourse(int id){
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(DELETE_RECORD);
            ps.setInt(1, id);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
