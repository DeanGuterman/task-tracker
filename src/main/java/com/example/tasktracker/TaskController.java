package com.example.tasktracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {

    private static AtomicLong id = new AtomicLong();
    private static final List<Task> tasks = new ArrayList<>(){{
        add(new Task(LocalDate.now(), "test author1", "test description1", TaskStatus.TODO, id.getAndIncrement()));
        add(new Task(LocalDate.now(), "test author2", "test description2", TaskStatus.IN_PROGRESS, id.getAndIncrement()));
    }};

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id){
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        Task newTask = new Task(task.getDueDate(), task.getTitle(), task.getDescription(), task.getStatus(), id.getAndIncrement());
        tasks.add(newTask);
        return newTask;
    }
}
