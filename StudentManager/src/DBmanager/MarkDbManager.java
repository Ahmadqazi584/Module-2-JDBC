package DBmanager;

import DBconnection.dbconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Marks;
import model.Student;

public class StudentCourseDbManager {

    private final String INSERT_STUDENT_COURSE_RECORD = "INSERT INTO `dbs11786303`.`marks` (`student_id`, `course_id`, `mark`) VALUES (?, ?, ?);";
    private final String UPDATE_STUDENT_COURSE = "UPDATE `marks` SET `mark` = ? WHERE `student_id` = ? AND `course_id` = ?";
    private final String GET_STUDENT_COURSES = """
                                               SELECT s.student_id, s.name AS student_name, c.course_id, c.crse_name, m.mark
                                               FROM student s
                                               INNER JOIN marks m ON m.student_id = s.student_id
                                               INNER JOIN course c ON c.course_id = m.course_id""";

    public void addStudentCourse(Marks marks) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_MARKS_RECORD);
            ps.setInt(1, marks.getStu().getId());
            ps.setInt(2, marks.getCrse().getId());
            ps.setInt(3, marks.getMarks());
            ps.execute();

            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMarks(Marks marks) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_MARKS);
            ps.setInt(1, marks.getMarks());
            ps.setInt(2, marks.getStu().getId());
            ps.setInt(3, marks.getCrse().getId());
            ps.execute();

            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Marks> getStudentData() {
        List<Marks> marksList = new ArrayList<>();
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(GET_STUDENT_COURSES);
            ResultSet rstgetcourses = ps.executeQuery();
            while (rstgetcourses.next()) {
                Marks mark = new Marks();

                Student student = new Student();
                student.setId(rstgetcourses.getInt("student_id"));
                student.setStudentname(rstgetcourses.getString("student_name"));
                mark.setStu(student);

                Course course = new Course();
                course.setId(rstgetcourses.getInt("course_id"));
                course.setCoursename(rstgetcourses.getString("crse_name"));
                mark.setCrse(course);

                mark.setMarks(rstgetcourses.getInt("mark"));

                marksList.add(mark);
            }
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarkDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marksList;
    }
}
