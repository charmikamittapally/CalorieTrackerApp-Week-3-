package src.model;

public class Entry {
    private String date;
    private int calories;
    private String note;

    public Entry(String date, int calories, String note) {
        this.date = date;
        this.calories = calories;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public int getCalories() {
        return calories;
    }

    public String getNote() {
        return note;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Calories: " + calories + ", Note: " + note;
    }
}
