package com.tej.JournalApp.controller;

import com.tej.JournalApp.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> printAllEntries() {
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getId(), journalEntry);
        return journalEntry;
    }
    @GetMapping("/id/{myId}")
    public JournalEntry getEntryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public void deleteEntryById(@PathVariable long myId) {
        journalEntries.remove(myId);
    }
    @PutMapping("/id/{myId}")
    public JournalEntry updateEntryById(@PathVariable long myId, @RequestBody JournalEntry updatedEntry) {
        journalEntries.put(myId, updatedEntry);
        return updatedEntry;
    }

}
