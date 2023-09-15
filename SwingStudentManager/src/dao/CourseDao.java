/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Course;

/**
 *
 * @author Ahmed
 */
public interface CourseDao {

    final String INSERT_COURSE_VALUES = "INSERT INTO `dbs11786303`.`course` (`crse_name`, `crse_code`) VALUES (?, ?)";
    final String UPDATE_COURSE_VALUES = "UPDATE `course` SET `crse_name`=?, `crse_code`=? WHERE `course_id`=?";
    final String SHOW_COURSES = "SELECT * FROM `course`";
    final String SHOW_COURSES_BYNAME = "SELECT * FROM `course` WHERE `crse_name` = ?";
    final String DELETE_MARKS_COURSE = "DELETE FROM marks WHERE course_id = ?";
    final String DELETE_COURSE = "DELETE FROM course WHERE course_id = ?";

    void addCourse(Course course);

    void updateCourse(Course course);

    Course getCourseById(int id);
    
    Course getCourseByName(String name);

    List<Course> getAllCourse();

    void deleteCourse(int courseid);
}
