import java.util.Scanner;

public class HabitTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("John Doe");

        while (true) {
            System.out.println("\nHabit Tracker Menu:");
            System.out.println("1. Add Habit");
            System.out.println("2. View Habits");
            System.out.println("3. Complete Habit");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter goal (times per day): ");
                    int goal = scanner.nextInt();
                    user.addHabit(new Habit(name, goal));
                    System.out.println("Habit added successfully!");
                    break;
                case 2:
                    user.displayHabits();
                    break;
                case 3:
                    System.out.print("Enter habit name to mark as completed: ");
                    String habitName = scanner.nextLine();
                    boolean found = false;
                    for (Habit habit : user.getHabits()) {
                        if (habit.getName().equals(habitName)) {
                            habit.completeHabit();
                            user.saveHabitsToFile(); // Save after updating progress
                            System.out.println("Habit progress updated!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Habit not found!");
                    break;
                case 4:
                    System.out.println("Exiting Habit Tracker. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
