package com.app.organizer.note.state;

import android.util.Log;

import androidx.annotation.NonNull;

import com.app.organizer.note.TimeNote;

public class HiddenState implements CardState {
    @Override
    public void onExpand(TimeNoteCard card) {
        card.setState(new ExpandedState());
        TimeNote cardNote = card.getNote();
        String newText = String.format("%s, %s. %s", cardNote.getName(), cardNote.getTime().toString(), cardNote.getDescription());
        card.setText(newText);
    }
    
    @Override
    public void onCollapse(TimeNoteCard card) {
        card.setState(new CollapsedState());
        TimeNote cardNote = card.getNote();
        String newText = String.format("%s, %s", cardNote.getName(), cardNote.getTime().toString());
        card.setText(newText);
    }
    
    @Override
    public void onHide(TimeNoteCard card) {
        Log.d("CARD STATE", "ALREADY HIDDEN");
    }
    
    @NonNull
    @Override
    public String toString() {
        return "Hidden State";
    }
}
