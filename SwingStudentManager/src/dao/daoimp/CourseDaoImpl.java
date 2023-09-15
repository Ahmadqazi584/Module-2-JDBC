/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.daoimp;

import DBconnectivity.dbconnection;
import dao.CourseDao;
import static dao.CourseDao.DELETE_COURSE;
import static dao.CourseDao.DELETE_MARKS_COURSE;
import static dao.CourseDao.INSERT_COURSE_VALUES;
import static dao.CourseDao.SHOW_COURSES;
import static dao.CourseDao.UPDATE_COURSE_VALUES;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;

/**
 *
 * @author Ahmed
 */
public class CourseDaoImpl implements CourseDao {

    @Override
    public void addCourse(Course course) {
        try {
            try ( Connection connect = dbconnection.getconnection()) {
                PreparedStatement ps = connect.prepareStatement(INSERT_COURSE_VALUES);
                ps.setString(1, course.getName());
                ps.setString(2, course.getCode());
                ps.execute();
                connect.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_COURSE_VALUES);
            ps.setString(1, course.getName());
            ps.setString(2, course.getCode());
            ps.setInt(3, course.getId());
            ps.execute();
            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Course getCourseById(int id) {
        try {
            Connection connect = dbconnection.getconnection();
            Statement statement = connect.createStatement();
            ResultSet rstcourse = statement.executeQuery(SHOW_COURSES);
            while (rstcourse.next()) {
                Course c = new Course();
                c.setId(rstcourse.getInt("course_id"));
                c.setName(rstcourse.getString("crse_name"));
                c.setCode(rstcourse.getString("crse_code"));

                if (c.getId() == id) {
                    return c;
                }
            }
            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Course getCourseByName(String name) {
        try {
            Connection connect = dbconnection.getconnection();
//            Statement statement = connect.createStatement();
            PreparedStatement ps = connect.prepareStatement(SHOW_COURSES_BYNAME);
            ps.setString(1, name);

            ResultSet rstcourse = ps.executeQuery();

            while (rstcourse.next()) {
                Course c = new Course();
                c.setId(rstcourse.getInt("course_id"));
                c.setName(rstcourse.getString("crse_name"));
                c.setCode(rstcourse.getString("crse_code"));

                if (c.getName().equals(name)) {
                    return c;
                }
            }
            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        try {
            Connection connect = dbconnection.getconnection();
            List<Course> courses = new ArrayList<>();
            Statement statement = connect.createStatement();
            ResultSet rstcourse = statement.executeQuery(SHOW_COURSES);

            while (rstcourse.next()) {
                Course c = new Course();
                c.setId(rstcourse.getInt("course_id"));
                c.setName(rstcourse.getString("crse_name"));
                c.setCode(rstcourse.getString("crse_code"));

                courses.add(c);
            }
            connect.close();
            return courses;

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteCourse(int courseid) {
        try {
            Connection connect = dbconnection.getconnection();
            PreparedStatement ps1 = connect.prepareStatement(DELETE_MARKS_COURSE);
            ps1.setInt(1, courseid);
            ps1.execute();

            PreparedStatement ps2 = connect.prepareStatement(DELETE_COURSE);
            ps2.setInt(1, courseid);
            ps2.execute();

            connect.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
