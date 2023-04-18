package com.app.organizer.note;

import java.time.LocalDateTime;

public class GoalStep {
    private String title;
    private String description;
    private LocalDateTime dateTime;
    
    public GoalStep() {}
    
    public GoalStep(String title, String description, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
