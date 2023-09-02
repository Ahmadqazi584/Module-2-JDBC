/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.StudentCourse;

/**
 *
 * @author Ahmed
 */
public interface StudentCourseDao {

    final String INSERT_STUDENT_COURSE_RECORD = "INSERT INTO `dbs11786303`.`marks` (`student_id`, `course_id`, `mark`) VALUES (?, ?, ?);";
    final String UPDATE_STUDENT_COURSE = "UPDATE `marks` SET `mark` = ? WHERE `student_id` = ? AND `course_id` = ?";
    final String GET_STUDENT_COURSES = """
                                               SELECT s.student_id, s.name AS student_name, c.course_id, c.crse_name, m.mark
                                               FROM student s
                                               INNER JOIN marks m ON m.student_id = s.student_id
                                               INNER JOIN course c ON c.course_id = m.course_id""";

    void addStudentCourse(StudentCourse studentcourse);

    void updateMarks(StudentCourse studentcourse);

    List<StudentCourse> getStudentData();

}
