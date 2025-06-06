package src.ui;

import src.logic.CalorieManager;
import src.logic.ExerciseManager;
import src.db.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackerGUI extends JFrame {

    private JTextField dateField, calorieField, noteField;
    private JTextArea outputArea;
    private JButton logIntakeBtn, logExerciseBtn, viewSummaryBtn;

    private final CalorieManager calorieManager = new CalorieManager();
    private final ExerciseManager exerciseManager = new ExerciseManager();

    public TrackerGUI() {
        setTitle("Calorie & Exercise Tracker");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Calories:"));
        calorieField = new JTextField();
        inputPanel.add(calorieField);

        inputPanel.add(new JLabel("Note:"));
        noteField = new JTextField();
        inputPanel.add(noteField);

        logIntakeBtn = new JButton("Log Intake");
        logExerciseBtn = new JButton("Log Exercise");
        inputPanel.add(logIntakeBtn);
        inputPanel.add(logExerciseBtn);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Summary"));

        // Bottom button
        viewSummaryBtn = new JButton("View Summary");

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(viewSummaryBtn, BorderLayout.SOUTH);

        // Event listeners
        logIntakeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText().trim();
                int calories = Integer.parseInt(calorieField.getText().trim());
                String note = noteField.getText().trim();
                calorieManager.logIntake(date, calories, note);
                outputArea.setText("✅ Intake logged successfully.");
            }
        });

        logExerciseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText().trim();
                int calories = Integer.parseInt(calorieField.getText().trim());
                String note = noteField.getText().trim();
                exerciseManager.logExercise(date, calories, note);
                outputArea.setText("✅ Exercise logged successfully.");
            }
        });

        viewSummaryBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText().trim();
                String summary = calorieManager.getSummary(date);
                outputArea.setText(summary);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase(); // make sure DB is ready
        SwingUtilities.invokeLater(() -> new TrackerGUI());
    }
}
