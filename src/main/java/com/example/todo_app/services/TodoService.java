package com.example.todo_app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo_app.repository.TodoRepository;

import com.example.todo_app.model.Todo;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> update(int id, Todo todo) {
        Optional<Todo> foundTodo = todoRepository.findById(id);

        if (foundTodo.isEmpty()) {
            return Optional.empty();
        }

        foundTodo.get().setCompleted(todo.getCompleted());

        todoRepository.save(foundTodo.get());

        return foundTodo;
    }

    public boolean delete(int id) {
        Optional<Todo> foundTodo = todoRepository.findById(id);

        if (foundTodo.isEmpty()) {
            return false;
        }

        todoRepository.delete(foundTodo.get());
        
        return true;
    }

    public void deleteCompleted() {
        todoRepository.deleteCompleted(true);
    }

}