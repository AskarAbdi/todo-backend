package com.example.todoback.controller;


import com.example.todoback.dto.ChangeTaskCategoryDTO;
import com.example.todoback.dto.Response;
import com.example.todoback.dto.TaskChangeDTO;
import com.example.todoback.dto.TaskCreateDTO;
import com.example.todoback.entity.Task;
import com.example.todoback.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateDTO taskCreateDTO){
        Task result=taskService.createTask(taskCreateDTO);
        return new ResponseEntity<>( result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskChangeDTO taskChangeDTO){
        Task task=taskService.updateTask(id,taskChangeDTO);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }


    @PostMapping("/change")
    public ResponseEntity<Task> changeTaskCategory(@RequestBody ChangeTaskCategoryDTO changeTaskCategoryDTO){
        Task result=taskService.changeTaskCategory(changeTaskCategoryDTO.getTaskId(),changeTaskCategoryDTO.getCategoryId());
        return new ResponseEntity<>( result, HttpStatus.OK);
    }
}
