import repository.TodoRepositoryImpl;
import services.TodoServiceImpl;
import view.TodoView;

public class TodoAppV2 {
    public static void main(String[] args) {
        final var todoRepository = new TodoRepositoryImpl();
        final var todoService = new TodoServiceImpl(todoRepository);
        final var todoView = new TodoView(todoService);
        todoView.MainMenu();
    }
}
