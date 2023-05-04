package com.app.organizer.note.strategy;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.strategy.click.OnClickStrategy;
import com.app.organizer.note.strategy.display.DisplayStrategy;

public class GeneralNoteCard {
    private GeneralNote note;
    private DisplayStrategy displayStrategy;
    private OnClickStrategy onClickStrategy;
    
    private Color backgroundColor;
    private String text;
    
    private boolean tagsVisible = false;
    private String subText = "";
    
    public GeneralNoteCard(GeneralNote note, DisplayStrategy displayStrategy, OnClickStrategy onClickStrategy) {
        this.note = note;
        this.displayStrategy = displayStrategy;
        this.onClickStrategy = onClickStrategy;
    }
    
    public GeneralNote getNote() {
        return note;
    }
    
    public DisplayStrategy getDisplayStrategy() {
        return displayStrategy;
    }
    
    public OnClickStrategy getOnClickStrategy() {
        return onClickStrategy;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public String getText() {
        return text;
    }
    
    public boolean isTagsVisible() {
        return tagsVisible;
    }
    
    public String getSubText() {
        return subText;
    }
    
    public void setNote(GeneralNote note) {
        this.note = note;
    }
    
    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }
    
    public void setOnClickStrategy(OnClickStrategy onClickStrategy) {
        this.onClickStrategy = onClickStrategy;
    }
    
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setTagsVisible(boolean tagsVisible) {
        this.tagsVisible = tagsVisible;
    }
    
    public void setSubText(String subText) {
        this.subText = subText;
    }
    
    public void display() {
        this.displayStrategy.display(this);
    }
    
    public void click() {
        this.onClickStrategy.onClick(this);
    }
    
    @NonNull
    @Override
    public String toString() {
        String hexColor = String.format("#%06X", (0xFFFFFF & backgroundColor.toArgb()));
        if (tagsVisible) {
            return String.format("TEXT: %s. BACKGROUND: %s. TAGS: %s", text, hexColor, subText);
        }
        else {
            return String.format("TEXT: %s. BACKGROUND: %s", text, hexColor);
        }
    }
}
