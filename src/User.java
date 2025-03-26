import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Habit> habits;

    public User(String name) {
        this.name = name;
        this.habits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addHabit(String habitName, int goal) {
        habits.add(new Habit(habitName, goal));
        System.out.println("Habit added: " + habitName);
    }

    public void viewHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits tracked yet.");
            return;
        }
        System.out.println("Habits for " + name + ":");
        for (Habit habit : habits) {
            System.out.println(habit);
        }
    }

    public void completeHabit(String habitName) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habit.completeHabit();
                System.out.println("Habit progress updated!");
                return;
            }
        }
        System.out.println("Habit not found!");
    }
}
