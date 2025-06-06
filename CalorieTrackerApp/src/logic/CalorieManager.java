package src.logic;

import src.db.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalorieManager {

    public void logIntake(String date, int calories, String note) {
        String query = "INSERT INTO calorie_log (entry_date, calories, note) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            stmt.setInt(2, calories);
            stmt.setString(3, note);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error logging calorie intake: " + e.getMessage());
        }
    }

    public void showSummary(String date) {
        System.out.println(getSummary(date));
    }

    public String getSummary(String date) {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT calories, note FROM calorie_log WHERE entry_date = ?";
        int totalCalories = 0;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();

            sb.append("📅 Calorie Summary for ").append(date).append(":\n");
            while (rs.next()) {
                int cal = rs.getInt("calories");
                String note = rs.getString("note");
                sb.append(" - ").append(note).append(": ").append(cal).append(" kcal\n");
                totalCalories += cal;
            }

            sb.append("\nTotal Calories Consumed: ").append(totalCalories).append(" kcal\n");

        } catch (SQLException e) {
            sb.append("Error retrieving summary: ").append(e.getMessage());
        }

        return sb.toString();
    }
}
