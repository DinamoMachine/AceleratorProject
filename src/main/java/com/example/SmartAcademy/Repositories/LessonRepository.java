package com.example.SmartAcademy.Repositories;

import com.example.SmartAcademy.Models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
