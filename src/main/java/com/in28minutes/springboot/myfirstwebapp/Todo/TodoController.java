package com.in28minutes.springboot.myfirstwebapp.Todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes("username")
public class TodoController {
    public TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String listAllTodos(Model model) {
        List<Todo> todos = todoService.findUserTodoList("josephnady@yahoo.com");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping(value = "new-todo")
    public String showNewTodoPage(Model model) {
        /* We should add a blank Todo to the model to collect the Todo Attributes from the mode*/
        model.addAttribute("todo", Todo.builder().build());
        return "newTodo";
    }


    @PostMapping(value = "new-todo")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult results) {
        if (results.hasErrors()) {
            return "newTodo";
        }
        todo = Todo.builder()
                .username((String) model.getAttribute("username"))
                .description(todo.getDescription())
                .dueDate(todo.getDueDate())
                .done(todo.isDone())
                .build();
        model.addAttribute("todo", todo);
        todoService.addNewTodo(todo);
//       return this.listAllTodos(model);
//      we can use the redirect expression and in that case there is no-
//      need to pass the Model in the method param
        return "redirect:list-todos";
    }

    @GetMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam("id") UUID id) {
        todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @GetMapping("edit-todo")
    public String showUpdatedTodoPage(@RequestParam("id") UUID id, Model model) {
        model.addAttribute(todoService.findTodoById(id));
        return "editTodo";
    }

    @PostMapping("edit-todo")
    public String editTodoById(@RequestParam("id") UUID id,
                               Model model,
                               @Valid Todo todo,
                               BindingResult results) {
        if (results.hasErrors()) {
            return "editTodo";
        }
        todo.setUsername((String) model.getAttribute("username"));
        todo.setId(id);
        todoService.editTodoById(todo);
        return "redirect:list-todos";
    }
}


