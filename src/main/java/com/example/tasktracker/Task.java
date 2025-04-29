package com.example.tasktracker;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dueDate;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(){

    }

    public Task(LocalDate dueDate, String title, String description, TaskStatus status){
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public long getId(){
        return this.id;
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(TaskStatus status){
        this.status = status;
    }



}