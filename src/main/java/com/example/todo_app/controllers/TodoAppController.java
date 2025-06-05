package com.example.todo_app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.todo_app.services.TodoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todo_app.model.Todo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/todos")
public class TodoAppController {

    @Autowired
    private TodoService todoService;

    public TodoAppController() {
    }

    @GetMapping("")
    public Iterable<Todo> getAll() {
        return todoService.getAll();
    }

    @PostMapping("")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PatchMapping("/{id}")
    public Optional<Todo> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable int id) {
        return todoService.delete(id);
    }

    @DeleteMapping("")
    public void deleteCompleted() {
        todoService.deleteCompleted();
    }

}