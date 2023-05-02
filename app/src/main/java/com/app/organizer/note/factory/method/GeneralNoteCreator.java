package com.app.organizer.note.factory.method;

import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.INote;

public class GeneralNoteCreator extends NoteCreator {
    public INote createNote(String name) {
        GeneralNote note = new GeneralNote();
        note.setName(name);
        return note;
    }
}
