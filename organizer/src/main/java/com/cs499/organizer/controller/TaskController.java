package com.cs499.organizer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs499.organizer.entity.Task;
import com.cs499.organizer.service.TaskService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Initialize task page
    @GetMapping
    public String taskPage(@RequestParam(required = false) String searchTask,
            @RequestParam(required = false) String sort,
            Model model) {

        loadTaskPageModel(model, searchTask, sort, "showTask");
        return "task";
    }

    // Add Task
    @PostMapping("/addTask")
    public String addTask(@Valid @ModelAttribute("newTask") Task newTask,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadTaskPageModel(model, null, "asc", "addTask");
            return "task";
        }

        taskService.save(newTask);
        return "redirect:/task";
    }

    // Edit Task
    @PostMapping("/edit")
    public String updateTask(@RequestParam int id,
            @Valid @ModelAttribute("editTask") Task editTask,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            loadTaskPageModel(model, null, "asc", "editTask");
            return "task";
        }

        Task task = taskService.findById(id);
        task.setName(editTask.getName());
        task.setDescription(editTask.getDescription());
        taskService.save(task);

        return "redirect:/task";
    }

    // Delete Task
    @PostMapping("/delete")
    public String deleteTask(@RequestParam int id) {
        taskService.deleteById(id);
        return "redirect:/task";
    }

    // Loads common model data needed for the task page
    private void loadTaskPageModel(Model model, String searchTask, String sort, String activeTab) {

        if (sort == null || sort.isBlank()) {
            sort = "asc";
        }

        List<Task> tasks;

        if (searchTask != null && !searchTask.isBlank()) {
            tasks = taskService.searchAndSortByName(searchTask, sort);
        } else {
            tasks = taskService.findAllSorted(sort);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("searchTaskValue", searchTask);
        model.addAttribute("sort", sort);
        model.addAttribute("activeTab", activeTab);

        if (!model.containsAttribute("newTask")) {
            model.addAttribute("newTask", new Task());
        }

        if (!model.containsAttribute("editTask")) {
            model.addAttribute("editTask", new Task());
        }
    }
}