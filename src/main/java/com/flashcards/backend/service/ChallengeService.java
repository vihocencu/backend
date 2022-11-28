package com.flashcards.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.flashcards.backend.entities.Challenge;
import com.flashcards.backend.repository.ChallangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService
{
    @Autowired
    ChallangeRepository challangeRepository;
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
    public void saveOrUpdate(Challenge callenge)
    {
        challangeRepository.save(callenge);
    }
    //deleting a specific record
    public void delete(int id)
    {
        challangeRepository.deleteById(id);
    }
}  