package vn.edu.huce.ltudm.spring.restfulapitodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.huce.ltudm.spring.restfulapitodolist.entity.Task;
import vn.edu.huce.ltudm.spring.restfulapitodolist.service.TaskService;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(path = "/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    // Add task
    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        taskService.createTask(task);
        return new ResponseEntity<>(null, HttpStatus.valueOf(201));
    }

    // Update task
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return new ResponseEntity<>(null, HttpStatus.valueOf(303));
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(null, HttpStatus.valueOf(204));
    }

    // List Task
    @GetMapping(path = "/all")
    public Collection<Task> listAllTask() {
        return taskService.getListTask();
    }

    //
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task t = taskService.getTaskByID(id);
        return t != null ? new ResponseEntity<Task>(t, HttpStatus.valueOf(200)) : new ResponseEntity<>(null, HttpStatus.valueOf(204));
    }


    // Get task actived
    @GetMapping("/actived")
    public Collection<Task> listTaskActived() {
        return taskService.getTasksActived();
    }
}
