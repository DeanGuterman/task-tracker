package com.example.tasktracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task savedTask = repository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

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
