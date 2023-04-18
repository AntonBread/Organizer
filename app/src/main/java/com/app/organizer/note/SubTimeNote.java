package com.app.organizer.note;

import androidx.annotation.NonNull;

import java.time.LocalTime;

public class SubTimeNote implements INote {
    private String name;
    private String description;
    // String is used instead of LocalTime because gson can't serialize nested complex objects
    private String timeString;
    private boolean notificationEnabled;
    
    public SubTimeNote() {}
    
    public SubTimeNote(String name, String description, String timeString, boolean notificationEnabled) {
        this.name = name;
        this.description = description;
        this.timeString = timeString;
        this.notificationEnabled = notificationEnabled;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getTimeString() {
        return timeString;
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
    
    public void setTimeString(String timeString) {
        this.timeString = timeString;
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
    
    @NonNull
    @Override
    public String toString() {
        return String.format("%s: %s, %s", name, description, timeString);
    }
}
