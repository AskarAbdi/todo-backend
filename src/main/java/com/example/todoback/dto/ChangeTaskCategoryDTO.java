package com.example.todoback.dto;

import lombok.Data;

@Data
public class ChangeTaskCategoryDTO {
    private Long categoryId;
    private Long taskId;
}
