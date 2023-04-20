package com.app.organizer.note;

import androidx.annotation.NonNull;

import com.app.organizer.database.DatabaseMediator;
import com.app.organizer.database.diary.TimeNoteEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TimeNote implements INote {
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private ArrayList<SubTimeNote> subNotes;
    private ArrayList<String> tags;
    private boolean notificationEnabled;
    
    @Deprecated
    private DatabaseMediator databaseMediator;
    
    public TimeNote() {}
    
    public TimeNote(String name, String description, LocalDate date, LocalTime time,
                    ArrayList<SubTimeNote> subNotes, ArrayList<String> tags, boolean notificationEnabled) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.subNotes = subNotes;
        this.tags = tags;
        this.notificationEnabled = notificationEnabled;
    }
    
    public TimeNote(TimeNoteEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.date = entity.getDate();
        this.time = entity.getTime();
        this.subNotes = entity.getSubNotes();
        this.tags = entity.getTags();
        this.notificationEnabled = entity.isNotificationEnabled();
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public ArrayList<SubTimeNote> getSubNotes() {
        return subNotes;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public void setSubNotes(ArrayList<SubTimeNote> subNotes) {
        this.subNotes = subNotes;
    }
    
    public boolean addSubNote(SubTimeNote subNote) {
        return this.subNotes.add(subNote);
    }
    
    public boolean removeSubNote(SubTimeNote subNote) {
        return this.subNotes.remove(subNote);
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
    
    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
    
    @Override
    public boolean create() {
        return false;
    }
    
    @Override
    public boolean delete() {
        return false;
    }
    
    @Override
    public boolean edit() {
        return false;
    }
    
    @Override
    public boolean showNotification() {
        return false;
    }
    
    public void addToFavorites() {
    
    }
    
    public void removeFromFavorites() {
    
    }
    
    public boolean isFavorite() {
        return false;
    }
    
    public TimeNoteEntity toEntity() {
        TimeNoteEntity entity = new TimeNoteEntity();
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setDate(this.date);
        entity.setTime(this.time);
        entity.setSubNotes(this.subNotes);
        entity.setTags(this.tags);
        entity.setNotificationEnabled(this.notificationEnabled);
        return entity;
    }
    
    @Deprecated
    public void setDatabaseMediator(DatabaseMediator databaseMediator) {
        this.databaseMediator = databaseMediator;
    }
    
    @Deprecated
    public DatabaseMediator getDatabaseMediator() {return this.databaseMediator;}
    
    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
