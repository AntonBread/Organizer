package com.app.organizer.note.factory.abstr;

import com.app.organizer.note.INote;
import com.app.organizer.note.TimeNote;

public class TimeNoteFactory implements NoteFactory {
    @Override
    public INote createNote() {
        return new TimeNote();
    }
    
    @Override
    public UIElement createUiElement() {
        return new DiaryUIElement();
    }
}
