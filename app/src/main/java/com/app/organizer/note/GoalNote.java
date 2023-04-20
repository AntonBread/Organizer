package com.app.organizer.note;

import androidx.annotation.NonNull;

import com.app.organizer.database.goals.GoalNoteEntity;

import java.util.ArrayList;

public class GoalNote implements INote {
    private String name;
    private String description;
    private ArrayList<GoalStep> steps;
    
    public GoalNote() {}
    
    public GoalNote(String name, String description, ArrayList<GoalStep> steps) {
        this.name = name;
        this.description = description;
        this.steps = steps;
    }
    
    public GoalNote(GoalNoteEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.steps = entity.getSteps();
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setSteps(ArrayList<GoalStep> steps) {
        this.steps = steps;
    }
    
    public boolean addStep(GoalStep step) {
        return this.steps.add(step);
    }
    
    public boolean removeStep(GoalStep step) {
        return this.steps.remove(step);
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
    
    public GoalNoteEntity toEntity() {
        GoalNoteEntity entity = new GoalNoteEntity();
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setSteps(this.steps);
        return entity;
    }
    
    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
