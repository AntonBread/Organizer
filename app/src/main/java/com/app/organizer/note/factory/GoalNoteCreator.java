package com.app.organizer.note.factory;

import com.app.organizer.note.GoalNote;
import com.app.organizer.note.INote;

public class GoalNoteCreator extends NoteCreator {
    public INote createNote(String name) {
        GoalNote note = new GoalNote();
        note.setName(name);
        return note;
    }
    
}
