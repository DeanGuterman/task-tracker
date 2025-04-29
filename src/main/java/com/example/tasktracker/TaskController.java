package com.example.tasktracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private static final AtomicLong idCounter = new AtomicLong();
    private static final List<Task> tasks = new ArrayList<>(){{
        add(new Task(LocalDate.now(), "test title1", "test description1", TaskStatus.TODO, idCounter.getAndIncrement()));
        add(new Task(LocalDate.now(), "test title2", "test description2", TaskStatus.IN_PROGRESS, idCounter.getAndIncrement()));
    }};

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id){
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task newTask = new Task(task.getDueDate(), task.getTitle(), task.getDescription(), task.getStatus(), idCounter.getAndIncrement());
        tasks.add(newTask);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable long id){
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
