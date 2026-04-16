package com.cs499.organizer.service;

import java.util.List;

import com.cs499.organizer.entity.Task;

//Task service defines task operations.
//Includes:
//- CRUD work
//- search
//- sorting

public interface TaskService {
    List<Task> findAll();
    Task findById(int id);
    Task save(Task task);
    void deleteById(int id);
    List<Task> findByNameContaining(String name);
    List<Task> findByDescriptionContaining(String description);
    List<Task> findAllSorted(String sort);
    List<Task> searchAndSortByName(String searchTask, String sort);
}
