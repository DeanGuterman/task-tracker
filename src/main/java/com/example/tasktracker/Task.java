package main.java.com.example.tasktracker;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private final long id;
    private LocalDate dueDate;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(long id, LocalDate dueDate, String title, String description){
        this.id = id;
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
        this.status = INPROGRESS;
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