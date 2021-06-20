package alekseev.todo.controller;

import alekseev.todo.model.ToDo;
import alekseev.todo.model.UserProfile;
import alekseev.todo.service.ToDoService;
import alekseev.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/todo")
public class ToDoController {

    private final ToDoService toDoService;
    private final UserService userService;

    @Autowired
    public ToDoController(ToDoService toDoService, UserService userService) {
        this.toDoService = toDoService;
        this.userService = userService;
    }

    @GetMapping()
    public String todoPage(Model model, Principal principal) {
        List<ToDo> toDoList = toDoService.getAllByUsername(principal.getName());
        model.addAttribute("toDoList", toDoList);
        model.addAttribute("todo", new ToDo());
        model.addAttribute("username", principal.getName());
        return "todoBoot";
    }

    @PostMapping("/add")
    public String createToDo(@ModelAttribute ToDo toDo, Principal principal) {
        toDo.setStatus(false);
        UserProfile user = userService.getByUsername(principal.getName());
        toDo.setUser(user);
        toDoService.add(toDo);
        return "redirect:/todo";
    }

    @PostMapping("delete/{id}")
    public String deleteToDo(@PathVariable Long id) {
        toDoService.deleteById(id);
        return "redirect:/todo";
    }

    @PostMapping("status/{id}")
    public String editStatusToDo(@PathVariable Long id) {
        ToDo toDo = toDoService.getById(id);
        toDo.setStatus(true);
        toDoService.add(toDo);
        return "redirect:/todo";
    }

}
