package com.app.organizer.note.factory.abstr;

import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.INote;

public class GeneralNoteFactory implements NoteFactory {
    @Override
    public INote createNote() {
        return new GeneralNote();
    }
    
    @Override
    public UIElement createUiElement() {
        return new GeneralUIElement();
    }
}
