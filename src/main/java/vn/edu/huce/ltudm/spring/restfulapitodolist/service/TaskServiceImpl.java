package vn.edu.huce.ltudm.spring.restfulapitodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.huce.ltudm.spring.restfulapitodolist.entity.Task;
import vn.edu.huce.ltudm.spring.restfulapitodolist.repository.TaskRepository;

import java.util.Collection;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepo;

    @Override
    public Task getTaskByID(Long id) {
        return taskRepo.findById(id).get();
    }

    @Override
    public void createTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void updateTask(Long id, Task task) {
        task.setId(id);
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Collection<Task> getTasksActived() {
        return taskRepo.tasksActived();
    }

    @Override
    public Collection<Task> getListTask() {
        return taskRepo.findAll();
    }
}
