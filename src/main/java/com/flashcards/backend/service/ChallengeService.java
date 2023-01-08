package com.flashcards.backend.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.flashcards.backend.entities.Challenge;
import com.flashcards.backend.entities.Statistic;
import com.flashcards.backend.repository.ChallangeRepository;
import com.flashcards.backend.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toMap;

@Service
public class ChallengeService
{
    @Autowired
    ChallangeRepository challangeRepository;

    @Autowired
    StatisticRepository statisticRepository;

    //getting all challenges records
    public List<Challenge> getAllChallenge()
    {
        List<Challenge> challenges = new ArrayList<Challenge>();
        challangeRepository.findAll().forEach(challenge -> challenges.add(challenge));
        return challenges;
    }

    public List<Challenge> getAllChallengeForLesson(String lesson)
    {
        List<Challenge> challenges = new ArrayList<Challenge>();
        challangeRepository.findAll().forEach(challenge -> { if (lesson.equals(String.valueOf(challenge.getLesson().getId()))) challenges.add(challenge);});
        return challenges;
    }

    //getting a specific record
    public Challenge getChallengeById(int id)
    {
        return challangeRepository.findById(id).get();
    }
    public void saveOrUpdate(Challenge challenge)
    {
        challangeRepository.save(challenge);
    }
    //deleting a specific record
    public void delete(int id)
    {
        challangeRepository.deleteById(id);
    }

    public List<Challenge> getMostMissed4User(String user) {
            List<Statistic> result =    new ArrayList<>();

            statisticRepository.findAll().forEach(st -> {if (st.getUser()!=null && st.getUser().getName().equals(user)&&st.getCorrect()==0) result.add(st);});
            Map<Challenge, Long> mossedMissed =
                    result.stream().collect(Collectors.groupingBy(Statistic::getChallenge, Collectors.counting()))
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<Challenge, Long>comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByValue()))
                            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {throw new IllegalStateException();}, LinkedHashMap::new));

            List<Statistic> res = new ArrayList<>();

            return mossedMissed.keySet().stream().limit(10).collect(Collectors.toList());
        }

    }