package com.example.todoback.controller;


import com.example.todoback.dto.CreateCategoryDTO;
import com.example.todoback.dto.UpdateCategoryDTO;
import com.example.todoback.entity.Category;
import com.example.todoback.entity.Category;
import com.example.todoback.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryDTO createCategoryDTO){
        Category result=categoryService.createCategory(createCategoryDTO);
        return new ResponseEntity<>( result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Category>>  deleteCategory(@PathVariable Long id){
        List<Category> res= categoryService.getAll(id);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryDTO categoryChangeDTO){
        Category category=categoryService.updateCategory(id,categoryChangeDTO);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
