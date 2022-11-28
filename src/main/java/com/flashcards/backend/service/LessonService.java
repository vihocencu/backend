package com.flashcards.backend.service;

import com.flashcards.backend.entities.Lesson;
import com.flashcards.backend.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService
{
    @Autowired
    LessonRepository lessonRepository;
    //getting all challenges records
    public List<Lesson> getAllLessons()
    {
        List<Lesson> lessons = new ArrayList<Lesson>();
        lessonRepository.findAll().forEach(challenge -> lessons.add(challenge));
        return lessons;
    }
    //getting a specific record
    public Lesson getLessonById(Long id)
    {
        return lessonRepository.findById(id).get();
    }
    public void saveOrUpdate(Lesson lesson)
    {
        lessonRepository.save(lesson);
    }
    //deleting a specific record
    public void delete(Long id)
    {
        lessonRepository.deleteById(id);
    }
}  