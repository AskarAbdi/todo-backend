package com.example.todoback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String title;
    private String data;

    @ManyToOne(fetch = FetchType.EAGER, optional=true)
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne(fetch = FetchType.EAGER, optional=true)
    @JoinColumn(name="user_id")
    private User creator;
}
