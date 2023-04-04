package com.app.organizer.database.general;

import com.app.organizer.note.GeneralNote;

public class GeneralDatabaseManager {
    
    public static boolean isNameUnique(GeneralNoteDao noteDao, GeneralNote note) {
        GeneralNoteEntity entity = noteDao.getByName(note.getName());
        return (entity == null);
    }
}
