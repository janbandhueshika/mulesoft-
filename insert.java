package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertApp {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO Movies(name,actor,actress,director,year) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        app.insert("Black Widow",2021);
        app.insert("Shang-chi and the legend of the ten rings",2021);
        app.insert("The avengers", "Robert Downey Jr.",2012);
    }

}
