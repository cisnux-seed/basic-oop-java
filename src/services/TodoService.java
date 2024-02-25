package services;

public interface TodoService {
    void showTodos();
    void addNewTodo(String todo);
    boolean editTodo(int position, String todo);
    boolean removeTodo(int position);
}
