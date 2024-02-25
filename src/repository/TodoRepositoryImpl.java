package repository;

import entity.Todo;

import java.util.Objects;

public class TodoRepositoryImpl implements TodoRepository {
    private Todo[] todos = new Todo[10];
    private int size = 0;

    @Override
    public Todo[] getTodos() {
        return todos;
    }

    @Override
    public void addNewTodo(Todo todo) {
        if (size >= todos.length) {
            var tempTodos = todos;
            todos = new Todo[todos.length * 2];
            System.arraycopy(tempTodos, 0, todos, 0, tempTodos.length);
        }
        todos[size++] = todo;
    }

    @Override
    public boolean editTodo(int position, Todo todo) {
        if (position > todos.length) return false;
        if (todos[position - 1] == null) return false;
        todos[position - 1] = todo;
        return true;
    }

    @Override
    public boolean removeTodo(int position) {
        if (position > todos.length) return false;
        if (todos[position - 1] == null) return false;
        for (int index = position - 1; index < todos.length - 1; index++) {
            todos[index] = todos[index + 1];
            todos[index + 1] = null;
        }
        return true;
    }
}
