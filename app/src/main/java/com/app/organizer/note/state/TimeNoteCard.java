package com.app.organizer.note.state;

import androidx.annotation.NonNull;

import com.app.organizer.note.TimeNote;

public class TimeNoteCard {
    private TimeNote note;
    private CardState state;
    private String text;
    
    public TimeNoteCard(TimeNote note) {
        this.note = note;
        this.state = new CollapsedState();
        this.text = String.format("%s, %s", note.getName(), note.getTime().toString());
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public TimeNote getNote() {
        return note;
    }
    
    public void setNote(TimeNote note) {
        this.note = note;
    }
    
    public CardState getState() {
        return state;
    }
    
    public void setState(CardState state) {
        this.state = state;
    }
    
    public void expand() {
        state.onExpand(this);
    }
    
    public void collapse() {
        state.onCollapse(this);
    }
    
    public void hide() {
        state.onHide(this);
    }
    
    @NonNull
    @Override
    public String toString() {
        return String.format("Text: %s. State: %s.", text, state.toString());
    }
}
