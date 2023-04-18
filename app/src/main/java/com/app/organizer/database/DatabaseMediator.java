package com.app.organizer.database;

import com.app.organizer.note.INote;

@Deprecated
public interface DatabaseMediator {
    void add(AppDatabase db);
    void setNote(INote note);
}
