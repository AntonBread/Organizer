package com.app.organizer.database;

import androidx.room.*;

import com.app.organizer.database.general.GeneralNoteDao;
import com.app.organizer.database.general.GeneralNoteEntity;

@Database(entities = {GeneralNoteEntity.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract GeneralNoteDao generalDao();
}