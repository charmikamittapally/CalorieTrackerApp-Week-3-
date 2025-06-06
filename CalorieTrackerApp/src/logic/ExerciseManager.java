package src.logic;

import src.db.DatabaseManager;

import java.sql.*;

public class ExerciseManager {

    public void logExercise(String date, int caloriesBurned, String note) {
        String query = "INSERT INTO exercise_log (entry_date, calories_burned, note) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            stmt.setInt(2, caloriesBurned);
            stmt.setString(3, note);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error logging exercise: " + e.getMessage());
        }
    }

    public int getTotalBurned(String date) {
        String query = "SELECT SUM(calories_burned) AS total FROM exercise_log WHERE entry_date = ?";
        int total = 0;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            System.err.println("Error fetching total calories burned: " + e.getMessage());
        }

        return total;
    }
}
