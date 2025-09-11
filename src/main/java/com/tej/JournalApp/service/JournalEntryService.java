package com.tej.JournalApp.service;

import com.tej.JournalApp.entity.JournalEntry;
import com.tej.JournalApp.entity.User;
import com.tej.JournalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        User user = userService.findByUserName(userName); // Retrieve the user by username
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry savedJournalEntry = journalEntryRepository.save(journalEntry);// Save the journal entry to the repository
        user.getJournalEntries().add(savedJournalEntry); // Add the saved entry to the user's journal entries
        //user.setUserName(null); //For testing the @Transactional tag working or not
        userService.saveUser(user);// Save the user with the updated journal entries
    }
    public void saveEntry(JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);// Save the journal entry to the repository
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id,String userName) {
        User user = userService.findByUserName(userName); // Retrieve the user by username
        JournalEntry entryToDelete = journalEntryRepository.findById(id).orElse(null);
        user.getJournalEntries().removeIf(entry -> entry.getId().equals(id));// Remove the entry from the user's journal entries Only if it exists already
        userService.saveUser(user); // Save the user with the updated journal entries
        journalEntryRepository.deleteById(id); // Delete the entry from the repository
    }
}

