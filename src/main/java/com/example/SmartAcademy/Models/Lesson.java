package com.example.SmartAcademy.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

}
