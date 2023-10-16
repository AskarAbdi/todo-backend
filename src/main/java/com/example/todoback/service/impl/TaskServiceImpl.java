package com.example.todoback.service.impl;

import com.example.todoback.dto.TaskChangeDTO;
import com.example.todoback.dto.TaskCreateDTO;
import com.example.todoback.entity.Category;
import com.example.todoback.entity.Task;
import com.example.todoback.repository.CategoryRepository;
import com.example.todoback.repository.TaskRepository;
import com.example.todoback.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    //TODO ADD TASK CREATOR!!!
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public Task createTask(TaskCreateDTO TaskDTO) {
        Task task=new Task();
        task.setData(task.getData());
        task.setTitle(task.getTitle());

        return taskRepository.save(task);
    }

    public List<Task> getTasksByCategoryId(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if(categoryId==null){
            return new ArrayList<>();
        }
        List<Task> result= taskRepository.findAllByCategory(category);
        return result;
    }

    public Task changeTaskCategory(Long taskId, Long categoryId) {
        Task task=taskRepository.findById(taskId).orElse(null);
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if (task==null || category==null){
            return null;
        }
        task.setCategory(category);
        taskRepository.save(task);
        return task;
    }

    public Boolean deleteTask(Long taskId) {
        Task task=taskRepository.findById(taskId).orElse(null);
        if (task==null){
            return false;
        }
        taskRepository.delete(task);
        return true;
    }

    public Task updateTask(Long id,TaskChangeDTO taskChangeDTO){
        Task task=taskRepository.findById(id).orElse(null);
        if (task==null){
            return null;
        }
        task.setTitle(taskChangeDTO.getTitle());
        task.setData(task.getData());
        return null;
    }
}
