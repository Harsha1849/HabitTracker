import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private ArrayList<Habit> habits;
    private static final String FILE_NAME = "habits.txt"; // File to store habits

    // Constructor
    public User(String username) {
        this.username = username;
        this.habits = new ArrayList<>();
        loadHabitsFromFile(); // Load habits on startup
    }

    // Add a new habit
    public void addHabit(Habit habit) {
        habits.add(habit);
        saveHabitsToFile(); // Save after adding
    }

    // Display all habits
    public void displayHabits() {
        System.out.println("Habits for " + username + ":");
        for (Habit habit : habits) {
            habit.displayHabit();
        }
    }

    // Save habits to file
    public void saveHabitsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Habit habit : habits) {
                writer.write(habit.getName() + "," + habit.getProgress() + "," + habit.getGoal());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving habits: " + e.getMessage());
        }
    }

    // Load habits from file
    public void loadHabitsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 3) {
                    habits.add(new Habit(data[0], Integer.parseInt(data[2]), Integer.parseInt(data[1])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading habits: " + e.getMessage());
        }
    }

    // Get list of habits
    public ArrayList<Habit> getHabits() {
        return habits;
    }
}
