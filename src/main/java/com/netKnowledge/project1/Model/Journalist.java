package com.netKnowledge.project1.Model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Getter
@Setter
public class Journalist {
    @Id
    private ObjectId myid;
    @NonNull
    private String name;
    private String description;
    private LocalDateTime date;
}