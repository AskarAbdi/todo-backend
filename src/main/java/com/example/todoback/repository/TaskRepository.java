package com.example.todoback.repository;

import com.example.todoback.entity.Category;
import com.example.todoback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCategory(Category category);
}
