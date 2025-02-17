package com.in28minutes.springboot.myfirstwebapp.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

//@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    static {
        todos.add(Todo.builder()
                .id(UUID.randomUUID())
                .username("josephnady@yahoo.com")
                .description("study Python")
                .dueDate(LocalDate.now().plusDays(5))
                .done(true)
                .build());
        todos.add(Todo.builder()
                .id(UUID.randomUUID())
                .username("marian@yahoo.com")
                .description("study python")
                .dueDate(LocalDate.now().plusDays(10))
                .done(false)
                .build());
    }


    public List<Todo> findUserTodoList(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username) ;
        return todos.stream().filter(predicate).toList();
    }


    public void addNewTodo(Todo todo) {
        Todo todoNew = Todo.builder()
                .id(todo.getId())
                .username(todo.getUsername())
                .description(todo.getDescription())
                .dueDate(todo.getDueDate())
                .done(todo.isDone())
                .build();
        TodoService.todos.add(todoNew);
    }

    public void deleteTodoById(UUID id) {
        Predicate<? super Todo> predicate =
                todo -> todo.getId().equals(id);
        todos.removeIf(predicate);
    }

    public Todo findTodoById(UUID id) {
        Predicate<? super Todo> predicate =
                todo -> todo.getId().equals(id);
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void editTodoById(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }

}