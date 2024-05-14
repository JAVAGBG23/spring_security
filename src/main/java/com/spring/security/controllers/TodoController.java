package com.spring.security.controllers;

import com.spring.security.models.Todo;
import com.spring.security.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.addTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
}
