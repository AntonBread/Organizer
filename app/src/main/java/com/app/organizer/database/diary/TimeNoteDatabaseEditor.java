package com.app.organizer.database.diary;

import com.app.organizer.database.AppDatabase;
import com.app.organizer.database.DatabaseMediator;
import com.app.organizer.note.INote;
import com.app.organizer.note.TimeNote;

@Deprecated
public class TimeNoteDatabaseEditor implements DatabaseMediator {
    TimeNote timeNote;
    
    public void setNote(INote timeNote) {
        this.timeNote = (TimeNote) timeNote;
        ((TimeNote) timeNote).setDatabaseMediator(this);
    }
    
    public void add(AppDatabase db) {
        if (timeNote == null) {
            return;
        }
        db.timeNoteDao().insert(timeNote.toEntity());
    }
}
