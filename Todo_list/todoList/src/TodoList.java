package Todo_list.todoList.src;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    // Private inner class to represent a todo item
    public class TodoItem {
        private final String task;
        private boolean completed;

        public TodoItem(String task) {
            this.task = task;
            this.completed = false;
        }

        public String getTask() {
            return task;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }

        @Override
        public String toString() {
            return (completed ? "[X] " : "[] ") + task;
        }
    }

    // List to hold the todo items
    private final List<TodoItem> items = new ArrayList<>();

    // Method to add a todo item
    public void addItem(String task) {
        TodoItem item = new TodoItem(task);
        items.add(item);
        System.out.println("Added: " + task);
    }

    // Method to mark a todo item as completed
    public void markCompleted(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).markCompleted();
            System.out.println("Completed: " + items.get(index).getTask());
        } else {
            System.out.println("Invalid index");
        }
    }

    // Method to display the todo list
    public void displayList() {
        System.out.println("--- Todo List ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i)); 
        }
        System.out.println("----------------");
    }

    // Public static nested class for utility functions
    public static class TodoListUtils {
        // Public method to check if a task is valid
        public static boolean isValidTask(String task) {
            return task != null && !task.trim().isEmpty();
        }
    }

    // Method using an anonymous class to sort the todo list
    public void sortList(java.util.Comparator<TodoItem> comparator) {
        // Pass in a comparator object
        items.sort(comparator);
    }

    public static void main(String[] args) {
        TodoList myList = new TodoList();

        // Add items
        myList.addItem("Make Breakfast");
        myList.addItem("Do some research");
        myList.addItem("Go for lectures by 10am");
        myList.addItem("Complete Django Telex APM");
        myList.addItem("Buy Data");

        // Display initial list
        myList.displayList();

        // Mark an item as completed
        myList.markCompleted(1);

        // Display updated list
        myList.displayList();

        // Use the utility class
        String newTask = " "; // Invalid task (only whitespace)
        if (TodoListUtils.isValidTask(newTask)) {
            myList.addItem(newTask);
        } else {
            System.out.println("Invalid task: \"" + newTask + "\"");
        }

        // Anonymous class to sort by completion status (incomplete first)
        myList.sortList((item1, item2) -> {
            if (item1.isCompleted() && !item2.isCompleted()) {
                return 1; // item1 completed, item2 incomplete → item2 should come first
            } else if (!item1.isCompleted() && item2.isCompleted()) {
                return -1; // item1 incomplete, item2 completed → item1 should come first
            } else {
                return 0; // Same completion status, keep original order
            }
        });

        // Display sorted list
        myList.displayList();
    }
}
