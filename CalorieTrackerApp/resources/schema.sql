-- Table for logging daily calorie intake
CREATE TABLE IF NOT EXISTS calorie_log (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    entry_date TEXT NOT NULL,
    calories INTEGER NOT NULL,
    note TEXT
);

-- Table for logging daily exercise/calories burned
CREATE TABLE IF NOT EXISTS exercise_log (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    entry_date TEXT NOT NULL,
    calories_burned INTEGER NOT NULL,
    note TEXT
);
