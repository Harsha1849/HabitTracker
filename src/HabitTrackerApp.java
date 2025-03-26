import java.util.Scanner;

public class HabitTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        User user = new User(userName);

        while (true) {
            System.out.println("\nHabit Tracker Menu:");
            System.out.println("1. Add Habit");
            System.out.println("2. View Habits");
            System.out.println("3. Complete Habit");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String habitName = scanner.nextLine();
                    user.addHabit(habitName);
                    System.out.println("Habit added successfully!");
                    break;

                case 2:
                    user.viewHabits();
                    break;

                case 3:
                    System.out.print("Enter habit name to mark as completed: ");
                    String habitToComplete = scanner.nextLine();
                    user.completeHabit(habitToComplete);
                    System.out.println("Habit progress updated!");
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
