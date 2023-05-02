package com.app.organizer.note.factory.abstr;

import com.app.organizer.note.GoalNote;
import com.app.organizer.note.INote;

public class GoalNoteFactory implements NoteFactory {
    @Override
    public INote createNote() {
        return new GoalNote();
    }
    
    @Override
    public UIElement createUiElement() {
        return new GoalsUIElement();
    }
}
