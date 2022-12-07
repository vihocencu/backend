package com.flashcards.backend.repository;

import com.flashcards.backend.entities.Lesson;
import com.flashcards.backend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}  
