import java.io.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private static final String FILE_NAME = "habits_data.txt";

    public static void saveHabits(ArrayList<Habit> habits) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(habits);
            System.out.println("Habits saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving habits: " + e.getMessage());
        }
    }

    public static ArrayList<Habit> loadHabits() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Habit>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous habit data found.");
            return new ArrayList<>();
        }
    }
}
