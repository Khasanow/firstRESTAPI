package com.example.firstRESTAPI.controller;

import com.example.firstRESTAPI.entity.ToDoEntity;
import com.example.firstRESTAPI.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todosService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todosService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity createTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todosService.completeTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
