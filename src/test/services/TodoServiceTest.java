package test.services;

import entity.Todo;
import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import services.TodoService;
import services.TodoServiceImpl;

public class TodoServiceTest {
    public static void main(String[] args) {
//        testShowTodos();
//        testAddTodo();
//        testRemoveTodo();
        testEditTodo();
    }

    private static void testEditTodo() {
        final TodoRepository todoRepository = new TodoRepositoryImpl();
        final TodoService todoService = new TodoServiceImpl(todoRepository);
        for (int i = 0; i < 10; i++) {
            todoService.addNewTodo(String.format("test %d", i + 1));
        }
        todoService.showTodos();
        todoService.editTodo(7, "Hi 💪");
        todoService.editTodo(12, "Hi 💪");
        todoService.showTodos();
    }

    private static void testRemoveTodo() {
        final TodoRepository todoRepository = new TodoRepositoryImpl();
        final TodoService todoService = new TodoServiceImpl(todoRepository);
        for (int i = 0; i < 10; i++) {
            todoService.addNewTodo(String.format("test %d", i + 1));
        }
        todoService.showTodos();
        todoService.removeTodo(2);
        todoService.removeTodo(12);
        todoService.removeTodo(7);
        todoService.showTodos();
    }

    private static void testAddTodo() {
        final TodoRepository todoRepository = new TodoRepositoryImpl();
        final TodoService todoService = new TodoServiceImpl(todoRepository);
        for (int i = 0; i < 10; i++) {
            todoService.addNewTodo(String.format("test %d", i + 1));
        }
        todoService.showTodos();
    }

    private static void testShowTodos() {
        final TodoRepository todoRepository = new TodoRepositoryImpl();
        final TodoService todoService = new TodoServiceImpl(todoRepository);
        for (int i = 0; i < 10; i++) {
            todoRepository.addNewTodo(new Todo(String.format("test %d", i + 1)));
        }
        todoService.showTodos();
    }
}
