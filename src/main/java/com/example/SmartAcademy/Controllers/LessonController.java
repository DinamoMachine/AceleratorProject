package com.example.SmartAcademy.Controllers;

import com.example.SmartAcademy.Models.Lesson;
import com.example.SmartAcademy.Repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
