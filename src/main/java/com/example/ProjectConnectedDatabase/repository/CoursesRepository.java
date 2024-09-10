package com.example.ProjectConnectedDatabase.repository;

import com.example.ProjectConnectedDatabase.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CoursesRepository {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    private static final String SELECT_ALL_COURSES_QUERY = "SELECT * FROM courses";


    /**
     * Connects to the database using credentials from dataSourceProperties.
     * Executes a predefined SQL query to fetch all records from the courses table.
     * Maps each record to a CourseModel object and adds it to a list.
     * Returns the list of CourseModel objects.
     */

    public List<CourseModel> getAllCourses() {
        List<CourseModel> courses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dataSourceProperties.getUrl(), dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_COURSES_QUERY)) {

            while (resultSet.next()) {
                CourseModel course = new CourseModel();
                course.setCourseID(resultSet.getInt("course_id"));
                course.setName(resultSet.getString("nazev"));
                courses.add(course); //add to the ArrayList
            }

        } catch (SQLException e) {
            System.err.printf("SQL Error: %s, State: %s, Code: %d%n", e.getMessage(), e.getSQLState(), e.getErrorCode());
            e.printStackTrace();
        }

        return courses;
    }



}


