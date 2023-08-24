/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBmanager;

import DBconnection.dbconnection;
import model.Course;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class CourseDbManager {
    
    private final String INSERT_COURSE_VALUES = "INSERT INTO `dbs11786303`.`course` (`crse_name`, `crse_code`) VALUES (?, ?)";
    private final String UPDATE_COURSE_VALUES = "UPDATE `course` SET `crse_name`=?, `crse_code`=? WHERE `course_id`=?";
    private final String SHOW_COURSES = "SELECT * FROM `course`";
    private final String DELETE_MARKS_COURSE = "DELETE FROM marks WHERE course_id = ?";
    private final String DELETE_COURSE = "DELETE FROM course WHERE course_id = ?";
    
    public void addCourse(Course course){
        try {
            try (Connection connect = dbconnection.getconnection()) {
                PreparedStatement ps = connect.prepareStatement(INSERT_COURSE_VALUES);
                ps.setString(1, course.getName());
                ps.setString(2, course.getCode());
                ps.execute();
                connect.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCourse(Course course){
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_COURSE_VALUES);
            ps.setString(1, course.getName());
            ps.setString(2, course.getCode());
            ps.setInt(3, course.getId());
            ps.execute();
            connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Course getCourseById(int id){
        try {
            Connection connect = dbconnection.getconnection();
            Statement statement = connect.createStatement();
            ResultSet rstcourse = statement.executeQuery(SHOW_COURSES);
            while(rstcourse.next()){
                Course c = new Course();
                c.setId(rstcourse.getInt("course_id"));
                c.setName(rstcourse.getString("crse_name"));
                c.setCode(rstcourse.getString("crse_code"));
                
                if(c.getId() == id){
                    return c;
                }
            }
            connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Course> getAllCourse(){
        try {
            Connection connect = dbconnection.getconnection();
            List<Course> courses = new ArrayList<>();
            Statement statement = connect.createStatement();
            ResultSet rstcourse = statement.executeQuery(SHOW_COURSES);
            
            while(rstcourse.next()){
                Course c = new Course();
                c.setId(rstcourse.getInt("course_id"));
                c.setName(rstcourse.getString("crse_name"));
                c.setCode(rstcourse.getString("crse_code"));
                
                courses.add(c);
            }
            connect.close();
            return courses;
        
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteCourse(int courseid){
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps1 = connect.prepareStatement(DELETE_MARKS_CRSE);
            ps1.setInt(1, courseid);
            ps1.execute();
            
            PreparedStatement ps2 = connect.prepareStatement(DELETE_COURSE);
            ps2.setInt(1, courseid);
            ps2.execute();
            
            connect.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
