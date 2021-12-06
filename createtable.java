package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createtable {
	public static void createNewTable() {
		String url = "jdbc:sqlite:C://sqlite/db/movies.db";
		
		String sql = "CREATE TABLE Movies (\n"
				  +"id integer PRIMARY KEY,\n"
				  +"name of movie TEXT NOT NULL,\n"
				  +"actor TEXT NOT NULL,\n"
				  +"actress TEXT NOT NULL,\n"
				  +"director TEXT NOT NULL,\n"
				  +"year INTEGER NOT NULL,\n"
				  + ");";
	
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
