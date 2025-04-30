package com.example.tasktracker;

import jakarta.persistence.*;
import java.time.LocalDate;

// Marks this class as a JPA entity
@Entity
public class Task {
    // Auto-generated primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dueDate;
    private String title;
    private String description;

    // Saves the enum as a readable string instead of a number
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // Required no-arg constructor for JPA
    public Task(){}

    // Constructor for manually creating task objects
    public Task(LocalDate dueDate, String title, String description, TaskStatus status, long id){
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
        this.status = status;
        this.id = id;
    }

    // Getters
    public long getId(){return this.id;}
    public LocalDate getDueDate(){return this.dueDate;}
    public String getTitle(){return this.title;}
    public String getDescription(){return this.description;}
    public TaskStatus getStatus(){return this.status;}

    // Setters
    public void setDueDate(LocalDate dueDate){this.dueDate = dueDate;}
    public void setTitle(String title){this.title = title;}
    public void setDescription(String description){this.description = description;}
    public void setStatus(TaskStatus status){this.status = status;}



}