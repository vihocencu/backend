package com.flashcards.backend.repository;

import com.flashcards.backend.entities.Lesson;
import com.flashcards.backend.entities.Statistic;
import org.springframework.data.repository.CrudRepository;

public interface StatisticRepository extends CrudRepository<Statistic, Long>
{
}  
