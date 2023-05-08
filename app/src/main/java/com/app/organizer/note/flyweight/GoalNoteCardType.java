package com.app.organizer.note.flyweight;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.app.organizer.note.GoalNote;

public class GoalNoteCardType {
    private String name;
    private Drawable backgroundDrawable;
    private Color backgroundColor;
    private Drawable icon;
    
    public GoalNoteCardType(String name, Drawable backgroundDrawable, Color backgroundColor, Drawable icon) {
        this.name = name;
        this.backgroundDrawable = backgroundDrawable;
        this.backgroundColor = backgroundColor;
        this.icon = icon;
    }
    
    public void display(GoalNote note) {
        String msg = note.toString() + " " + this.toString();
        
        Log.d("TEST", msg);
    }
    
    @NonNull
    @Override
    public String toString() {
        return String.format("TYPE: %s. BACKGROUND: %s. COLOR: %s. ICON: %s.", name, backgroundDrawable.toString(),
                             backgroundColor.toString(), icon.toString());
    }
}
