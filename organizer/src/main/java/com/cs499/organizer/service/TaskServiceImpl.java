package com.cs499.organizer.service;

import java.util.List;
import java.util.Optional;

import com.cs499.organizer.dao.TaskRepository;
import com.cs499.organizer.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Task service implementation handles task logic.
//Includes:
//- saving tasks
//- searching tasks
//- sorting tasks

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
	this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
	return taskRepository.findAll();
    }

    @Override
    public Task findById(int id) {
	Optional<Task> taskCheck = taskRepository.findById(id);
	Task task = null;
	if (taskCheck.isPresent()) {
	    task = taskCheck.get();
	} else {
	    throw new RuntimeException("Did not find task id - " + id);
	}
	return task;
    }

    @Override
    public List<Task> findByNameContaining(String name) {
	return taskRepository.findByNameContaining(name);
    }

    @Override
    public List<Task> findByDescriptionContaining(String description) {
	return taskRepository.findByDescriptionContaining(description);
    }

    @Override
    public Task save(Task task) {
	return taskRepository.save(task);
    }

    @Override
    public void deleteById(int id) {
	taskRepository.deleteById(id);
    }

    // Returns all tasks in the selected sort order.
    @Override
    public List<Task> findAllSorted(String sort) {
        if ("asc".equals(sort)) {
            return taskRepository.findAllByOrderByNameAsc();
        } else {
            return taskRepository.findAllByOrderByNameDesc();
        }
    }

    @Override
    public List<Task> searchAndSortByName(String searchTask, String sort) {
        if ("asc".equals(sort)) {
            return taskRepository.findByNameContainingOrderByNameAsc(searchTask);
        } else {
            return taskRepository.findByNameContainingOrderByNameDesc(searchTask);
        }
    }

}
