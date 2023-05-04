package com.app.organizer.note.state;

import android.util.Log;

import androidx.annotation.NonNull;

import com.app.organizer.note.TimeNote;

public class ExpandedState implements CardState {
    @Override
    public void onExpand(TimeNoteCard card) {
        Log.d("CARD STATE", "ALREADY EXPANDED");
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
        card.setState(new HiddenState());
        String newText = "";
        card.setText(newText);
    }
    
    @NonNull
    @Override
    public String toString() {
        return "Expanded State";
    }
}
