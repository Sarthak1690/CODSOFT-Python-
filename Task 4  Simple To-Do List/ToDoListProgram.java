import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListProgram {

    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String newTask = scanner.nextLine();
                    addTask(toDoList, newTask);
                    break;
                case 2:
                    System.out.print("Enter the task to remove: ");
                    String taskToRemove = scanner.nextLine();
                    removeTask(toDoList, taskToRemove);
                    break;
                case 3:
                    viewTasks(toDoList);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void addTask(ArrayList<String> toDoList, String task) {
        toDoList.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask(ArrayList<String> toDoList, String task) {
        if (toDoList.contains(task)) {
            toDoList.remove(task);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found in the list. Cannot remove.");
        }
    }

    private static void viewTasks(ArrayList<String> toDoList) {
        if (toDoList.isEmpty()) {
            System.out.println("To-Do list is empty.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }
}
