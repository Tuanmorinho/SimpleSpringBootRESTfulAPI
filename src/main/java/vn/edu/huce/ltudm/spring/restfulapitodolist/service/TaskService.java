package vn.edu.huce.ltudm.spring.restfulapitodolist.service;

import vn.edu.huce.ltudm.spring.restfulapitodolist.entity.Task;

import java.util.Collection;

public interface TaskService {
    public abstract Task getTaskByID(Long id);

    public abstract void createTask(Task task);

    public abstract void updateTask(Long id, Task task);

    public abstract void deleteTask(Long id);

    public abstract Collection<Task> getTasksActived();

    public abstract Collection<Task> getListTask();
}
