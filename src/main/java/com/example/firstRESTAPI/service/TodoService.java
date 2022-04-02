package com.example.firstRESTAPI.service;

import com.example.firstRESTAPI.entity.ToDoEntity;
import com.example.firstRESTAPI.entity.UserEntity;
import com.example.firstRESTAPI.model.Todo;
import com.example.firstRESTAPI.repository.TodoRepo;
import com.example.firstRESTAPI.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo (ToDoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo (Long id) {
        ToDoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
