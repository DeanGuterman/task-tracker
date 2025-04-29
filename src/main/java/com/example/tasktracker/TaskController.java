package com.example.tasktracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private static final List<Task> tasks = new ArrayList<>(){{
        add(new Task(LocalDate.now(), "test author1", "test description1", TaskStatus.TODO));
        add(new Task(LocalDate.now(), "test author2", "test description2", TaskStatus.IN_PROGRESS));
    }};

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return tasks;
    }
}
