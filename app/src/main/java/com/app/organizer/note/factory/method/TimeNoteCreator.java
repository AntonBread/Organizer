package com.app.organizer.note.factory.method;

import com.app.organizer.note.INote;
import com.app.organizer.note.TimeNote;

public class TimeNoteCreator extends NoteCreator {
    public INote createNote(String name) {
        TimeNote note = new TimeNote();
        note.setName(name);
        return note;
    }
}
