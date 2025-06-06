package src;

import src.logic.CalorieManager;
import src.logic.ExerciseManager;
import src.db.DatabaseManager;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CalorieManager calorieManager = new CalorieManager();
    private static final ExerciseManager exerciseManager = new ExerciseManager();

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();
        System.out.println("Welcome to the Calorie & Exercise Tracker App!");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    logCalorieIntake();
                    break;
                case "2":
                    logExercise();
                    break;
                case "3":
                    viewSummary();
                    break;
                case "4":
                    System.out.println("Exiting the app. Stay healthy!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Log Calorie Intake");
        System.out.println("2. Log Exercise");
        System.out.println("3. View Daily Summary");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void logCalorieIntake() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        System.out.print("Enter calories consumed: ");
        int calories = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter a note (e.g., Breakfast): ");
        String note = scanner.nextLine().trim();

        calorieManager.logIntake(date, calories, note);
        System.out.println("✅ Calorie intake logged successfully.");
    }

    private static void logExercise() {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine().trim();

        System.out.print("Enter calories burned: ");
        int calories = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter a note (e.g., Running): ");
        String note = scanner.nextLine().trim();

        exerciseManager.logExercise(date, calories, note);
        System.out.println("✅ Exercise logged successfully.");
    }

    private static void viewSummary() {
        System.out.print("Enter date (YYYY-MM-DD) for summary: ");
        String date = scanner.nextLine().trim();
        calorieManager.showSummary(date);
    }
}
