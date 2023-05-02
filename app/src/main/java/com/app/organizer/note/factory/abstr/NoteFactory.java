package com.app.organizer.note.factory.abstr;

import com.app.organizer.note.INote;

public interface NoteFactory {
    INote createNote();
    UIElement createUiElement();
}
