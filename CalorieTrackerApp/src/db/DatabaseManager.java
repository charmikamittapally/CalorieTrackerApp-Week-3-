package src.db;

import java.sql.*;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:health_tracker.db";

    // Get a connection to the SQLite database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Initialize database with required tables
    public static void initializeDatabase() {
        String calorieTable = """
            CREATE TABLE IF NOT EXISTS calorie_log (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                entry_date TEXT NOT NULL,
                calories INTEGER NOT NULL,
                note TEXT
            );
        """;

        String exerciseTable = """
            CREATE TABLE IF NOT EXISTS exercise_log (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                entry_date TEXT NOT NULL,
                calories_burned INTEGER NOT NULL,
                note TEXT
            );
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(calorieTable);
            stmt.execute(exerciseTable);

            System.out.println("✅ Database initialized successfully.");

        } catch (SQLException e) {
            System.err.println("❌ Failed to initialize database: " + e.getMessage());
        }
    }
}
