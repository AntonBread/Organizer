package com.app.organizer.note.state;

import android.util.Log;

import androidx.annotation.NonNull;

import com.app.organizer.note.TimeNote;

public class CollapsedState implements CardState {
    @Override
    public void onExpand(TimeNoteCard card) {
        card.setState(new ExpandedState());
        TimeNote cardNote = card.getNote();
        String newText = String.format("%s, %s. %s", cardNote.getName(), cardNote.getTime().toString(), cardNote.getDescription());
        card.setText(newText);
    }
    
    @Override
    public void onCollapse(TimeNoteCard card) {
        Log.d("CARD STATE", "ALREADY COLLAPSED");
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
        return "Collapsed State";
    }
}
