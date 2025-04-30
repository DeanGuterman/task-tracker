package com.example.tasktracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller for handling task-related HTTP requests
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    // Inject repository via constructor
    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    // Return all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Return task by ID (or 404 if not found)
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new task
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task savedTask = repository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTaskData){
        return repository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(updatedTaskData.getTitle());
                    existingTask.setDescription(updatedTaskData.getDescription());
                    existingTask.setDueDate(updatedTaskData.getDueDate());
                    existingTask.setStatus(updatedTaskData.getStatus());
                    Task saved = repository.save(existingTask);
                    return new ResponseEntity<>(saved, HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete task by ID (204 on success, 404 if not found)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
