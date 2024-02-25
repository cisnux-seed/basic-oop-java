package repository;

import entity.Todo;

public interface TodoRepository {
    Todo[] getTodos();
    void addNewTodo(Todo todo);
    boolean editTodo(int position, Todo todo);
    boolean removeTodo(int position);
}