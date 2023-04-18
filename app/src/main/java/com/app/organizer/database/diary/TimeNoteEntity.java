package com.app.organizer.database.diary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.app.organizer.note.SubTimeNote;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity(tableName = "DIARY_NOTES")
public class TimeNoteEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    
    @ColumnInfo(name = "sub_notes")
    private ArrayList<SubTimeNote> subNotes;
    
    private ArrayList<String> tags;
    
    @ColumnInfo(name = "notification_enabled")
    private boolean notificationEnabled;
    
    public long getId() {
        return id;
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
    
    public void setId(long id) {
        this.id = id;
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
    
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
    
    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }
}
