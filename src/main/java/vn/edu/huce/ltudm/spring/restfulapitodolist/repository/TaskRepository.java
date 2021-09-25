package vn.edu.huce.ltudm.spring.restfulapitodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import vn.edu.huce.ltudm.spring.restfulapitodolist.entity.Task;

import java.util.Collection;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT c FROM Task c WHERE c.status = 1")
    Collection<Task> tasksActived();
}
