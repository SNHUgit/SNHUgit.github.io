package com.cs499.organizer.dao;

import com.cs499.organizer.entity.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    List<Task> findByNameContaining(String name);
    List<Task> findByDescriptionContaining(String description);
    List<Task> findAllByOrderByNameAsc();
    List<Task> findAllByOrderByNameDesc();
    List<Task> findByNameContainingOrderByNameAsc(String name);
    List<Task> findByNameContainingOrderByNameDesc(String name);
}