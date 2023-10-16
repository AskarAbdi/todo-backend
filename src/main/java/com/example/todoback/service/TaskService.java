package com.example.todoback.service;

import com.example.todoback.dto.TaskChangeDTO;
import com.example.todoback.dto.TaskCreateDTO;
import com.example.todoback.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task createTask(TaskCreateDTO TaskDTO);
    List<Task> getTasksByCategoryId(Long categoryId);
    Task changeTaskCategory(Long taskId,Long categoryId);

    Boolean deleteTask(Long taskId);

    Task updateTask(Long id,TaskChangeDTO taskChangeDTO);
}
