package com.example.ProjectConnectedDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ProjectConnectedDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectConnectedDatabaseApplication.class, args);

			String url = "jdbc:mysql://localhost:3306/school";
			String user = "root";
			String password = "Teodorek1810";

			try (Connection connection = DriverManager.getConnection(url, user, password)) {
				System.out.println("Connection established successfully.");
			} catch (SQLException e) {
				System.err.println("SQL Exception occurred.");
				e.printStackTrace();
			}
		}
	}

