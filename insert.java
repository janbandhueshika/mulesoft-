package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String actor, String actress, String director, double year) {
        String sql = "INSERT INTO Movies(name,actor,actress,director,year) VALUES(?,?,?,?,?)";
        		

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, name);
        	pstmt.setString(2, actor);
        	pstmt.setString(3, actress);
        	pstmt.setString(4, director);
        	pstmt.setDouble(5, year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        app.insert("Black Widow","Scarlett Johansson", "Florence Pugh", "Cate Shortland", 2021);
        app.insert("Shang-chi and the legend of the ten rings","Simu Liu", "Awkwafina","Destin Daniel Cretton",2021);
        app.insert("The avengers","Robert Downey Jr","Scarlett Johansson","Joss Whedon", 2012);
    }

}
