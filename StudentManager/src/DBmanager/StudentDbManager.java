/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBmanager;

import DBconnection.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Student;

/**
 *
 * @author Ahmed
 */
public class StudentDbManager {

    private final String INSERT_STUDENT_RECORD = "INSERT INTO `dbs11786303`.`student` (`name`, `email`, `phone`, `dept_id`) VALUES (?, ?, ?, ?)";
    private final String UPDATE_STUDENT_RECORD = "UPDATE `student` SET `name` = ? , `email` = ? , `phone` = ? , `dept_id` = ? WHERE `student_id` = ?";
    private final String SHOW_STUDENT_RECORD = "SELECT * FROM `student`";
    private final String SHOWMORE_STUDENT_RECORD = """
                                                   SELECT s.`student_id`, s.`name`, s.`email`, s.`phone`, d.dept_id, d.dept_name, d.dept_code From student s 
                                                   inner join department d on s.dept_id = d.dept_id""";
    private final String DELETE_MARKS = "DELETE FROM marks WHERE student_id = ?";
    private final String DELETE_STUDENT_RECORD = "DELETE FROM student WHERE student_id = ?";
//    private final String GET_ID_BY_NAME = "SELECT name FROM student WHERE student_id = ?";

    public void addStudent(Student student) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_STUDENT_RECORD);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setInt(4, student.getDepartment().getId());
            ps.execute();

            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStudent(Student student) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_STUDENT_RECORD);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setInt(4, student.getDepartment().getId());
            ps.setInt(5, student.getId());
            ps.execute();
            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getStudentById(int id) {
        try {
            Connection connect = dbconnection.getconnection();
            Statement statement = connect.createStatement();
            ResultSet rststudent = statement.executeQuery(SHOW_STUDENT_RECORD);

            while (rststudent.next()) {
                Student s = new Student();
                s.setId(rststudent.getInt("student_id"));
                s.setName(rststudent.getString("name"));
                s.setEmail(rststudent.getString("email"));
                s.setPhone(rststudent.getString("phone"));

                Department d = new Department();
                d.setId(rststudent.getInt("dept_id"));

                s.setDepartment(d);

                if (s.getId() == id) {
                    return s;
                }
                connect.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> student = new ArrayList<>();
        try {
            Connection connect = dbconnection.getconnection();

            Statement statement = connect.createStatement();
            ResultSet rststudent = statement.executeQuery(SHOWMORE_STUDENT_RECORD);

            while (rststudent.next()) {
                Student s = new Student();
                s.setId(rststudent.getInt("student_id"));
                s.setName(rststudent.getString("name"));
                s.setEmail(rststudent.getString("email"));
                s.setPhone(rststudent.getString("phone"));

                Department d = new Department();
                d.setId(rststudent.getInt("dept_id"));
                d.setName(rststudent.getString("dept_name"));
                d.setCode(rststudent.getString("dept_code"));

                s.setDepartment(d);
                student.add(s);

                connect.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public void deleteStudent(int id) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps1 = connect.prepareStatement(DELETE_MARKS);
            PreparedStatement ps2 = connect.prepareStatement(DELETE_STUDENT_RECORD);

            ps1.setInt(1, id);
            ps2.setInt(1, id);

            ps1.execute();
            ps2.execute();

            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
