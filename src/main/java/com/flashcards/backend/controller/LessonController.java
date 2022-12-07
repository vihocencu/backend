package com.flashcards.backend.controller;

import com.flashcards.backend.service.ChallengeService;
import com.flashcards.backend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LessonController {

    @Autowired
    LessonService lessonService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lesson")
    private java.util.List<com.flashcards.backend.entities.Lesson> getLesson(@RequestParam("userName") String userName) {
        return lessonService.getAllLessons(userName);
    };

 //   @CrossOrigin(origins = "http://localhost:4200")
 //   @GetMapping("/lesson/{language}")
 //   private java.util.List<com.flashcards.backend.entities.Lesson> getLesson(@PathVariable("language")String language) {
 //       return lessonService.getAllLessons4Language(language);
 //   }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lesson/{languages}")
    private java.util.List<com.flashcards.backend.entities.Lesson> getLesson(@PathVariable("languages") ArrayList<String> languages, @RequestParam("userName") String userName) {
        return lessonService.getAllLessons4Languages(languages, userName);
    }
}
