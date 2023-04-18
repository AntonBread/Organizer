package com.app.organizer.note;

import androidx.annotation.NonNull;

public class GoalStep {
    private String title;
    private String description;
    // String is used instead of LocalDateTime because gson can't serialize nested complex objects
    private String dateTimeString;
    
    public GoalStep() {}
    
    public GoalStep(String title, String description, String dateTimeString) {
        this.title = title;
        this.description = description;
        this.dateTimeString = dateTimeString;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getDateTimeString() {
        return dateTimeString;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDateTimeString(String dateTimeString) {
        this.dateTimeString = dateTimeString;
    }
    
    @NonNull
    @Override
    public String toString() {
        return String.format("%s: %s, %s", title, description, dateTimeString);
    }
}
