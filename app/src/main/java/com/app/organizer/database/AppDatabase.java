package com.app.organizer.database;

import androidx.room.*;

import com.app.organizer.database.diary.TimeNoteDao;
import com.app.organizer.database.diary.TimeNoteEntity;
import com.app.organizer.database.general.GeneralNoteDao;
import com.app.organizer.database.general.GeneralNoteEntity;
import com.app.organizer.database.goals.GoalNoteDao;
import com.app.organizer.database.goals.GoalNoteEntity;

@Database(entities = {GeneralNoteEntity.class,
                               TimeNoteEntity.class,
                               GoalNoteEntity.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase implements DatabaseInterface {
    public abstract GeneralNoteDao generalNoteDao();
    public abstract TimeNoteDao timeNoteDao();
    public abstract GoalNoteDao goalNoteDao();
}
