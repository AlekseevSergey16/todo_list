package alekseev.todo.service;

import alekseev.todo.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllByUsername(String username);
    ToDo getById(Long id);
    List<ToDo> getAll();
    void add(ToDo todo);
    void delete(ToDo todo);
    void deleteById(Long id);
}
