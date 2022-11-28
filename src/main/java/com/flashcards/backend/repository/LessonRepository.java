package com.flashcards.backend.repository;

import com.flashcards.backend.entities.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long>
{
}  
