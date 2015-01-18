package kz.metaphor.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				// connect DB
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinemaScheduler", "postgres", "realmadrid77");
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}

		return connection;
	}

}
