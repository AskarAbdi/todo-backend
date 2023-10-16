package com.example.todoback.repository;

import com.example.todoback.entity.Category;
import com.example.todoback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> getAllByUser(User user);
}
