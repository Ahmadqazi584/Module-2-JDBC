/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Student;

/**
 *
 * @author Ahmed
 */
public interface StudentDao {
    
    final String INSERT_STUDENT_RECORD = "INSERT INTO `dbs11786303`.`student` (`name`, `email`, `phone`, `dept_id`) VALUES (?, ?, ?, ?)";
    final String UPDATE_STUDENT_RECORD = "UPDATE `student` SET `name` = ? , `email` = ? , `phone` = ? , `dept_id` = ? WHERE `student_id` = ?";
    final String SHOW_STUDENT_RECORD = "SELECT * FROM `student` WHERE `student_id` = ?";
    final String SHOW_STUDENT_NAME = "SELECT * FROM `student` WHERE `name` = ?";
    final String DEPARTMENT_BY_NAME = "SELECT `dept_id` FROM `department` WHERE dept_name = ?";
    final String SHOWMORE_STUDENT_RECORD = """
                                                   SELECT s.`student_id`, s.`name`, s.`email`, s.`phone`, d.dept_id, d.dept_name, d.dept_code From student s 
                                                   inner join department d on s.dept_id = d.dept_id""";
    final String DELETE_MARKS = "DELETE FROM marks WHERE student_id = ?";
    final String DELETE_STUDENT_RECORD = "DELETE FROM student WHERE student_id = ?";
    
    void addStudent(Student student);
    void updateStudent(Student student);
//    int getStudentByName(String name);
    Student getStudentById(int id);
    Student getStudentByName(String name);
    List<Student> getAllStudent();
    void deleteStudent(int id);
    
}
