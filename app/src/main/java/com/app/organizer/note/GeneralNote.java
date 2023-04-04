package com.app.organizer.note;

import com.app.organizer.database.general.GeneralNoteEntity;

import java.time.LocalDateTime;
import java.util.*;

public class GeneralNote implements INote {
    private String name;
    private String description;
    private ArrayList<String> tags;
    private LocalDateTime creationDateTime;
    
    public GeneralNote() {}
    
    public GeneralNote(String name, String description, ArrayList<String> tags, LocalDateTime creationDateTime) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.creationDateTime = creationDateTime;
    }
    
    public GeneralNote(GeneralNoteEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.creationDateTime = LocalDateTime.parse(entity.getCreationDateTime());
        this.tags = entity.getTags();
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
    
    public boolean addTag(String tag) {
        return this.tags.add(tag);
    }
    
    public boolean removeTag(String tag) {
        return this.tags.remove(tag);
    }
    
    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
    
    public boolean create() {
        return true;
    }
    
    public boolean delete() {
        return true;
    }
    
    public boolean edit() {
        return true;
    }
    
    public boolean showNotification() {
        return true;
    }
    
    public GeneralNoteEntity toEntity() {
        GeneralNoteEntity entity = new GeneralNoteEntity();
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setCreationDateTime(this.creationDateTime.toString());
        entity.setTags(this.tags);
        return entity;
    }
    
}
