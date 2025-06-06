# Calorie Tracker Application

## Overview
The Calorie Tracker Application is a Java-based program that enables users to log and track their daily calorie intake and exercise activities. It provides summaries and reports to help users monitor their health and fitness progress over time.

## Features
- Add calorie intake entries with descriptions.
- Add exercise activities with calories burned.
- View daily summaries showing calories consumed, burned, and net calories.
- Persistent data storage using SQLite database.
- Console-based user interface (CLI) for easy interaction.
- Robust input validation and error handling.

## Technologies Used
- **Java** (Core language for application development)
- **JDBC** (Java Database Connectivity for SQLite integration)
- **SQLite** (Lightweight, file-based database for data persistence)
- **Swing** (Optional: for GUI-based version)
- **SQL** (Database schema and queries)


## Setup & Installation

### Prerequisites
- Java Development Kit (JDK) 8 or above installed.
- SQLite JDBC driver (`sqlite-jdbc-<version>.jar`) placed in the `lib` folder.

### Steps to Run
1. Clone or download the project.
2. Open command prompt or terminal and navigate to the project root directory.
3. Compile the source code:

   ```bash
   javac -cp ".;lib/sqlite-jdbc-3.49.1.0.jar" -d out src/*.java
4.Run the Application:

   ```bash
   java -cp ".;lib/sqlite-jdbc-3.49.1.0.jar;out" Main


