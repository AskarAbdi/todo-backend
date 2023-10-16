package com.example.todoback.service.impl;

import com.example.todoback.dto.CreateCategoryDTO;
import com.example.todoback.dto.UpdateCategoryDTO;
import com.example.todoback.entity.Category;
import com.example.todoback.entity.User;
import com.example.todoback.repository.CategoryRepository;
import com.example.todoback.repository.UserRepository;
import com.example.todoback.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    public Category createCategory(CreateCategoryDTO createCategoryDTO) {
        Category category=new Category();
        category.setName(createCategoryDTO.getName());

        return categoryRepository.save(category);
    }

    public Boolean deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if (category==null){
            return false;
        }
        categoryRepository.delete(category);
        return true;
    }

    public List<Category> getAll(Long userId) {
        User user=userRepository.findById(userId).orElse(null);
        if (user==null){
            return new ArrayList<>();
        }
        return categoryRepository.getAllByUser(user);
    }

    public Category updateCategory(Long categoryId,UpdateCategoryDTO updateCategoryDTO) {
        Category category=categoryRepository.findById(categoryId).orElse(null);
        if (category==null){
            return null;
        }
        category.setName(updateCategoryDTO.getName());
        category=categoryRepository.save(category);
        return category;
    }
}
