package com.flashcards.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.flashcards.backend.service.ChallengeService;
import com.flashcards.backend.entities.Challenge;
import com.flashcards.backend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//creating RestController
@RestController
public class ChallangeControler
{
    //autowired the challengeService class
    @Autowired
    ChallengeService challengeService;

    @Autowired
    LessonService lessonService;
    
    //creating a get mapping that retrieves all the challenges detail from the database
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/challenge")
    private List<Challenge> getAllChallenge()
    {
        return challengeService.getAllChallenge();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/challengesForLesson/{id}")
    private List<Challenge> getAllChallengeForLesson(@PathVariable("id")String lesson)
    {
        return challengeService.getAllChallengeForLesson(lesson);
    }



    //creating a get mapping that retrieves the detail of a specific challenge
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/challenge/{id}")
    private Challenge getChallenge(@PathVariable("id") int id)
    {
        return challengeService.getChallengeById(id);
    }
    //creating a delete mapping that deletes a specific challenge
    @DeleteMapping("/challenge/{id}")
    private void deleteChallenge(@PathVariable("id") int id)
    {
        challengeService.delete(id);
    }
    //creating post mapping that post the challenge detail in the database
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/challenge")
    private int saveChallenge(@RequestBody Challenge challenge)
    {
        challengeService.saveOrUpdate(challenge);
        return challenge.getId();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/challenge/saveWithFields")
    private int saveChallengeWithFields(@RequestParam("lessonId") Long lessonId, @RequestParam("question") String question, @RequestParam("answer") String answer)
    {
        Challenge challenge = new Challenge();
        challenge.setLesson(lessonService.getLessonById(lessonId));
        challenge.setAnswer(answer);
        challenge.setQuestion(question);
        challengeService.saveOrUpdate(challenge);
        return challenge.getId();
    }

}