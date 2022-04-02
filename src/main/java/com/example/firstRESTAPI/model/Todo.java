package com.example.firstRESTAPI.model;

import com.example.firstRESTAPI.entity.ToDoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public Todo() {

    }

    public static Todo toModel(ToDoEntity entity){
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

//    public Todo(Long id, String title, Boolean completed) {
//        this.id = id;
//        this.title = title;
//        this.completed = completed;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
