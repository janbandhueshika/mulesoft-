package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void createNewTable() {
		String url = "jdbc:sqlite:C://sqlite/db/movies.db";
		
		String sql = "CREATE TABLE "Movies" (
				"id "	INTEGER,
				"name of movie"	TEXT NOT NULL,
				"actor"	TEXT NOT NULL,
				"actress"	TEXT NOT NULL,
				"director"	TEXT NOT NULL,
				"year"	INTEGER NOT NULL,
				PRIMARY KEY("id ")
			);";
		
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