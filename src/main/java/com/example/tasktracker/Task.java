package main.java.com.example.tasktracker;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity //ive just copied this from you(chatgpt), not sure what it means - please explain and dont just show me code i wont understand without explaining. this is true for all the "@" lines
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;

    private LocalDate dueDate;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    public Task(long id, LocalDate dueDate, String title, String description, TaskStatus status){
        this.id = id;
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