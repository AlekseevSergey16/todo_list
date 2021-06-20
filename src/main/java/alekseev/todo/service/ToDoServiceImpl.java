package alekseev.todo.service;

import alekseev.todo.model.ToDo;
import alekseev.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> getAllByUsername(String username) {
        return toDoRepository.findAllByUserUsername(username);
    }

    @Override
    public ToDo getById(Long id) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);
        return toDoOptional.orElse(null);
    }

    @Override
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @Override
    public void add(ToDo todo) {
        toDoRepository.save(todo);
    }

    @Override
    public void delete(ToDo todo) {
        toDoRepository.delete(todo);
    }

    @Override
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
