package com.app.organizer.note;

import java.time.LocalTime;

public class SubTimeNote implements INote {
    private String name;
    private String description;
    private LocalTime time;
    private boolean notificationEnabled;
    
    public SubTimeNote() {}
    
    public SubTimeNote(String name, String description, LocalTime time, boolean notificationEnabled,
                       TimeNote containerNote) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.notificationEnabled = notificationEnabled;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalTime getTime() {
        return time;
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
    
    public void setTime(LocalTime time) {
        this.time = time;
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
}
