package j1.l.p0071_taskmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main code
 *
 * @version 10.00pm 25 Jan 2025
 * @author VQPC
 */
public class Manager {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Task> list = new ArrayList<>();

    /**
     * menu
     *
     * @return menu
     */
    public static int menu() {
        System.out.println("======== Task program =======");
        System.out.println("    1. Add Task");
        System.out.println("    2. Delete Task");
        System.out.println("    3. Display Task");
        System.out.println("    4. Exit");
        System.out.print("Choice one option: ");
        int n = Validate.checkInputLimit(1, 4);
        return n;
    }

    /**
     * add task
     */
    public static void addTask() {
        System.out.println("-------Add Task--------");
        int id;
        System.out.print("Requirement Name: ");
        String name = Validate.checkString();
        System.out.print("Task Type: ");
        int type = Validate.taskType();
        System.out.print("Date: ");
        String date = Validate.checkDate();
        System.out.print("From: ");
        double from = Validate.checkPlan();
        System.out.print("To: ");
        double to = Validate.checkPlanTo(from);
        System.out.print("Assignee: ");
        String assignee = Validate.checkString();
        System.out.print("Reviewer: ");
        String reviewer = Validate.checkString();
        if (list.isEmpty()) {
            id = 1;
            Task task = new Task(id, type, name, date, from, to, assignee, reviewer);
            list.add(task);
        } else {
            id = list.size()+1;
            Task task = new Task(id, type, name, date, from, to, assignee, reviewer);
            list.add(task);
        }
        System.out.println("Added successfully!");
    }

    public static String typeCode(int typeCode) {
        switch (typeCode) {
            case 1 -> {
                return "Code";
            }
            case 2 -> {
                return "Test";
            }
            case 3 -> {
                return "Design";
            }
            case 4 -> {
                return "Review";
            }
            default -> {
            }
        }
        return null;
    }

    /**
     * remove task
     */
    public static void deleteTask() {
        System.out.println("-------Del Task-----------");
        System.out.print("ID: ");
        int id = Validate.checkInteger();
        for (Task task : list) {
            if (task.getId() == id) {
                list.remove(task);
                System.out.println("Delelte sucessfully!");
            } else {
                System.out.println("There are no ID" + id);
            }
        }
    }
    
    /**
     * display
     */
    public static void display() {
        System.out.println("------------------------- Task -------------------------");
        System.out.printf("%-5s %-20s %-10s %-12s %-8s %-10s %-10s%n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : list) {
            System.out.printf("%-5s %-20s %-10s %-12s %-8s %-10s %-10s%n",
                     task.getId(), task.getName(), typeCode(task.getType()), task.getDate(), task.getPlanfrom(), task.getAssignee(), task.getReviewer());
        }
    }
}
