package com.tej.JournalApp.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// This class represents a journal entry in the application.

@Data
// It uses Lombok for boilerplate code reduction.
// The tag @Data generates getters, setters, equals, hashCode, and toString methods.
@Document(collection = "journal_entries")
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

}