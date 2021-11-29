package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void createNewTable() {
		String url = "jdbc:sqlite:C://sqlite/db/movies.db";
		
		String sql = "CREATE TABLE \"Movies\" (\r\n" + 
				"	\"id \"	INTEGER,\r\n" + 
				"	\"name of movie\"	TEXT NOT NULL,\r\n" + 
				"	PRIMARY KEY(\"id \")\r\n" + 
				");";
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		createNewTable();
	}
}