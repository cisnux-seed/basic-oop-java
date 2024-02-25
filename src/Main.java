import entity.Todo;

import java.util.Scanner;

public class Main {
    public static String[] todos = new String[10];
    public static int size = 0;
    public static final Scanner scanner = new Scanner(System.in);
    public static boolean isRunning = true;

    public static void main(String[] args) {
        homeView();
    }

    public static void addTodoList(String newTodo) {
        if (size >= todos.length) {
            var tempTodos = todos;
            todos = new String[todos.length * 2];
            System.arraycopy(tempTodos, 0, todos, 0, tempTodos.length);
        }
        todos[size++] = newTodo;
    }

    public static void testAddTodoListWhenLessThanInitLength() {
        for (int index = 0; index < 5; index++) {
            addTodoList("todo-" + (index + 1));
        }
    }

    public static void testAddTodoListWhenMoreThanInitLength() {
        for (int index = 0; index < 12; index++) {
            addTodoList("todo-" + (index + 1));
        }
    }

    public static boolean editTodoList(int todoNumber, String newTodo) {
        if (todoNumber > todos.length) return false;
        if (todos[todoNumber - 1] == null) return false;
        todos[todoNumber - 1] = newTodo;
        return true;
    }

    public static boolean removeTodoList(int todoNumber) {
        if (todoNumber > todos.length) return false;
        if (todos[todoNumber - 1] == null) return false;
        for (int index = todoNumber - 1; index < todos.length - 1; index++) {
            todos[index] = todos[index + 1];
        }
        return true;
    }

    public static void testEditTodoList() {
        for (int index = 0; index < 12; index++) {
            addTodoList("todo-" + (index + 1));
        }
        testShowTodoList();
        System.out.println(editTodoList(5, "Updated todo"));
        testShowTodoList();
    }

    public static void testRemoveTodoList() {
        for (int index = 0; index < 12; index++) {
            addTodoList("todo-" + (index + 1));
        }
        testShowTodoList();
        System.out.println(removeTodoList(11));
        testShowTodoList();
    }

    public static void showTodoList() {
        if (size != 0) System.out.println("Todo List:");
        for (var index = 0; index < todos.length; index++) {
            var todo = todos[index];
            if (todo == null) continue;
            var no = index + 1;
            System.out.println(no + ". " + todo);
        }
    }

    public static void testShowTodoList() {
        showTodoList();
    }

    public static String input(String hint) {
        System.out.print(hint);
        return scanner.nextLine();
    }

    public static int inputNumber(String hint) {
        System.out.print(hint);
        return scanner.nextInt();
    }

    public static void testInput() {
        final var result = input("What's your choice? ");
        System.out.println(result);
    }

    public static void homeView() {
        while (isRunning) {
            showTodoList();
            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Edit");
            System.out.println("3.Remove");
            System.out.println("4.Logout");
            final var selectedMenu = input("What's your choice? ");
            switch (selectedMenu) {
                case "1" -> addViewTodoList();
                case "2" -> editViewTodoList();
                case "3" -> removeViewTodoList();
                case "4" -> {
                    isRunning = !isRunning;
                }
                default -> {
                    System.out.println("Please select a different choice");
                }
            }
        }
        System.out.println("Good Bye! Have a nice day");
    }

    public static void testHomeView() {
        for (int index = 0; index < 5; index++) {
            addTodoList("todo-" + (index + 1));
        }
        homeView();
    }

    public static void addViewTodoList() {
        final var newTodo = input("Enter your todo! (enter x to cancel): ");
        if (!newTodo.equals("x"))
            addTodoList(newTodo);
    }

    public static void testAddViewTodoList() {
        for (int index = 0; index < 5; index++) {
            addTodoList("todo-" + (index + 1));
        }
        showTodoList();
        addViewTodoList();
        showTodoList();
    }

    public static void removeViewTodoList() {
        final var todoNumber = input("Enter a todo number! (enter x to cancel): ");
        if (todoNumber.equals("x"))
            return;
        final var isRemoved = removeTodoList(Integer.parseInt(todoNumber));

        if (!isRemoved) {
            System.out.println("the todo number was not found, please enter the correct number");
            removeViewTodoList();
        } else
            System.out.println("successfully removed the todo");
    }

    public static void testRemoveViewTodoList() {
        for (int index = 0; index < 5; index++) {
            addTodoList("todo-" + (index + 1));
        }
        showTodoList();
        removeViewTodoList();
        showTodoList();
    }

    public static void editViewTodoList() {
        final int todoNumber = inputNumber("Enter a todo number: ");
        scanner.skip("\n");
        final var newTodo = input("Enter new todo to update! (enter x to cancel): ");
        if (newTodo.equals("x"))
            return;

        final var isUpdated = editTodoList(todoNumber, newTodo);
        if (!isUpdated) {
            System.out.println("the todo number was not found, please enter the correct number");
            editViewTodoList();
        } else
            System.out.println("successfully updated the todo");
    }

    public static void testEditViewTodoList() {
        for (int index = 0; index < 5; index++) {
            addTodoList("todo-" + (index + 1));
        }
        showTodoList();
        editViewTodoList();
        showTodoList();
    }
}