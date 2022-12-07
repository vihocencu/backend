package com.flashcards.backend.controller;

import com.flashcards.backend.entities.Challenge;
import com.flashcards.backend.entities.Statistic;
import com.flashcards.backend.entities.User;
import com.flashcards.backend.service.ChallengeService;
import com.flashcards.backend.service.StatisticService;
import com.flashcards.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatisticController {

    @Autowired
    StatisticService statisticService;
    @Autowired
    ChallengeService challengeService;
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/statistic")
    private java.util.List<com.flashcards.backend.entities.Statistic> getStatistic() {
        return statisticService.getAllStatistics();
    }

    ;

    //   @CrossOrigin(origins = "http://localhost:4200")
    //   @GetMapping("/statistic/{language}")
    //   private java.util.List<com.flashcards.backend.entities.Statistic> getStatistic(@PathVariable("language")String language) {
    //       return statisticService.getAllStatistics4Language(language);
    //   }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/statistic/{user}")
    private java.util.List<com.flashcards.backend.entities.Statistic> getStatistic(@PathVariable("user") String user) {
        return statisticService.getAllStatistics4User(user);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/statistic/save")
    private int statisticsave(@RequestParam("userName") String userName, @RequestParam("challenge_id") int challenge_id, @RequestParam("correct") int correct, @RequestParam("hint") int hint, @RequestParam("question")String question, @RequestParam("answer")String answer) {

        Statistic sts = new Statistic();
        Challenge chl = challengeService.getChallengeById(challenge_id);
        sts.setChallenge(chl);
        User usr = userService.getUserByName(userName);
        sts.setUser(usr);
        sts.setQuestion(question);
        sts.setAnswer(answer);
        sts.setCorrect(correct);
        statisticService.saveOrUpdate(sts);
        return sts.getId();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/statistic/mostmissed/{userName}")
    private List<Statistic> getMostmissedForUser(@PathVariable("userName") String userName) {
        List<Statistic> result = statisticService.getMostMissed4User(userName);

        return result;
    }
}
