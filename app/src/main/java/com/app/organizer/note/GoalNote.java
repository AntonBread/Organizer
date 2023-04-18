package com.app.organizer.note;

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
}
