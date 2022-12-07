package com.flashcards.backend.service;

import com.flashcards.backend.entities.User;
import com.flashcards.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    //getting all challenges records
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserByName(String name)
    {
        final User[] user = {null};
        userRepository.findAll().forEach(usr -> {if ( usr.getName().equals(name)) user[0] = usr;});
        return user[0];
    }

    //getting a specific record
    public User getUserById(Long id)
    {
        return userRepository.findById(id).get();
    }
    public void saveOrUpdate(User user)
    {
        userRepository.save(user);
    }
    //deleting a specific record
    public void delete(Long id)
    {
        userRepository.deleteById(id);
    }
}