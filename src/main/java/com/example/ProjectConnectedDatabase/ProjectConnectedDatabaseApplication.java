package com.example.ProjectConnectedDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@SpringBootApplication
public class ProjectConnectedDatabaseApplication {

	/**
	 * This is the main class of a Spring Boot application that connects to a MySQL database.
	 * It establishes a connection to the database, executes a SQL query to retrieve data

	 * The application uses try-with-resources to manage the database connection and statement,
	 * ensuring they are closed automatically. If an SQL error occurs, it is handled with
	 * detailed logging, providing error messages, SQL state, and error codes.
	 */

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ProjectConnectedDatabaseApplication.class, args);

		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "Teodorek1810";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connection established successfully.");

			// Create statement and execute query within the try block
			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");

				// Process the result set if needed
				while (resultSet.next()) {
					System.out.println("Course ID: " + resultSet.getInt("course_id"));
					System.out.println("Course Name: " + resultSet.getString("nazev"));
				}
			} catch (SQLException e) {
				System.err.println("Error executing query:");
				System.err.println("Message: " + e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.err.println("Error executing query:");
			System.err.println("Message: " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			e.printStackTrace();
		}
	}


}
