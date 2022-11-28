package com.flashcards.backend.controller;

import com.flashcards.backend.service.ChallengeService;
import com.flashcards.backend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {

    @Autowired
    LessonService lessonService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lesson")
    private java.util.List<com.flashcards.backend.entities.Lesson> getLesson() {
        return lessonService.getAllLessons();
    }
}
