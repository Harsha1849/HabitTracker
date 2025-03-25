public class Habit {
    private String name;
    private int progress;
    private int goal;

    // Constructor for new habit
    public Habit(String name, int goal) {
        this.name = name;
        this.goal = goal;
        this.progress = 0;
    }

    // Constructor for loading habit from file
    public Habit(String name, int goal, int progress) {
        this.name = name;
        this.goal = goal;
        this.progress = progress;
    }

    // Getters
    public String getName() { return name; }
    public int getProgress() { return progress; }
    public int getGoal() { return goal; }

    // Update progress (Prevents exceeding the goal)
    public void completeHabit() { 
        if (progress >= goal) {  
            System.out.println("⚠️ Habit already completed for today!"); 
            return;
        }
        progress++;
        System.out.println("✅ Habit progress updated!");
    }
    
    
    // Display habit details
    public void displayHabit() {
        System.out.println(name + " Progress: " + progress + "/" + goal);
    }
}
