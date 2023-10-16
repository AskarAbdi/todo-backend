package com.example.todoback.service;

import com.example.todoback.dto.CreateCategoryDTO;
import com.example.todoback.dto.UpdateCategoryDTO;
import com.example.todoback.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(CreateCategoryDTO createCategoryDTO);
    Boolean deleteCategory(Long categoryId);

    List<Category> getAll(Long userId);
    Category updateCategory(Long categoryId, UpdateCategoryDTO updateCategoryDTO);
}
