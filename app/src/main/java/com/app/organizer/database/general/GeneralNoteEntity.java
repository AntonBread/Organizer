package com.app.organizer.database.general;

import androidx.room.*;

import java.util.ArrayList;

@Entity(tableName = "GENERAL_NOTES")
public class GeneralNoteEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    
    private String name;
    private String description;
    private String creationDateTime;
    private ArrayList<String> tags;
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getCreationDateTime() {
        return creationDateTime;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
    
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
