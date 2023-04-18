package com.app.organizer.database.goals;

import androidx.room.*;

import com.app.organizer.note.GoalStep;

import java.util.ArrayList;

@Entity(tableName = "GOAL_NOTES")
public class GoalNoteEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    
    private String name;
    private String description;
    private ArrayList<GoalStep> steps;
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ArrayList<GoalStep> getSteps() {
        return steps;
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
    
    public void setSteps(ArrayList<GoalStep> steps) {
        this.steps = steps;
    }
}
