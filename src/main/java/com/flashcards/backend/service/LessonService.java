package com.flashcards.backend.service;

import com.flashcards.backend.entities.Lesson;
import com.flashcards.backend.entities.User;
import com.flashcards.backend.repository.LessonRepository;
import com.flashcards.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class LessonService
{
    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    UserService userService;

    //getting all challenges records
    public List<Lesson> getAllLessons(String userName)
    {
        User user = userService.getUserByName(userName);
        if (user == null || StringUtils.isEmpty(userName)) {
            return Collections.emptyList();
        }
        
        List<Lesson> lessons = new ArrayList<Lesson>();
        lessonRepository.findAll().forEach(lesson -> lessons.add(lesson));
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

    public List<Lesson> getAllLessons4Language(String language) {
        List<Lesson> lessonsFiltered = new ArrayList<>();
      lessonRepository.findAll().forEach(lesson -> {
          if (lesson.getLanguage().equalsIgnoreCase(language))
          {
              lessonsFiltered.add(lesson);
          }
      });
      return lessonsFiltered;
    }

    public List<Lesson> getAllLessons4Languages(ArrayList<String> languages, String userName) {
        User user = userService.getUserByName(userName);
        if (user == null || StringUtils.isEmpty(userName)) {
            return Collections.emptyList();
        }
        List<Lesson> lessonsFiltered = new ArrayList<>();
        ArrayList<String> lowerCaseLanguages = new ArrayList<>();
        languages.forEach(language -> lowerCaseLanguages.add(language.toLowerCase()));

        lessonRepository.findAll().forEach(lesson -> {
            if (languages.contains(lesson.getLanguage().toLowerCase()))
            {
                lessonsFiltered.add(lesson);
            }
        });
        return lessonsFiltered;
    }
}