package com.tej.JournalApp.service;

import com.tej.JournalApp.entity.JournalEntry;
import com.tej.JournalApp.entity.User;
import com.tej.JournalApp.repository.JournalEntryRepository;
import com.tej.JournalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}

