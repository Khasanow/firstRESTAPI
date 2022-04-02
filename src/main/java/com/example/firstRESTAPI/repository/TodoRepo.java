package com.example.firstRESTAPI.repository;

import com.example.firstRESTAPI.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<ToDoEntity, Long> {
}
