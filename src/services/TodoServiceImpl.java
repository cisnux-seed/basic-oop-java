package services;

import entity.Todo;
import repository.TodoRepository;

public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void showTodos() {
        final var todos = todoRepository.getTodos();
        if (todos.length != 0) System.out.println("Todo List:");
        for (var index = 0; index < todos.length; index++) {
            var todo = todos[index];
            if (todo == null) continue;
            var no = index + 1;
            System.out.printf("%d. %s\n", no, todo.activity());
        }
    }

    @Override
    public void addNewTodo(String todo) {
        final var newTodo = new Todo(todo);
        todoRepository.addNewTodo(newTodo);
    }

    @Override
    public boolean editTodo(int position, String todo) {
        final var newTodo = new Todo(todo);
        return todoRepository.editTodo(position, newTodo);
    }

    @Override
    public boolean removeTodo(int position) {
        return todoRepository.removeTodo(position);
    }
}
