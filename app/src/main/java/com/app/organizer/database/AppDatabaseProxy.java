package com.app.organizer.database;

import android.content.Context;

import androidx.room.Room;

import com.app.organizer.database.diary.TimeNoteDao;
import com.app.organizer.database.general.GeneralNoteDao;
import com.app.organizer.database.goals.GoalNoteDao;

public class AppDatabaseProxy implements DatabaseInterface {
    private AppDatabase db = null;
    private final Context context;
    
    public AppDatabaseProxy(Context context) {
        this.context = context;
    }
    
    public GeneralNoteDao generalNoteDao() {
        if (db == null) {
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        }
        return db.generalNoteDao();
    }
    
    public TimeNoteDao timeNoteDao() {
        if (db == null) {
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        }
        return db.timeNoteDao();
    }
    
    public GoalNoteDao goalNoteDao() {
        if (db == null) {
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        }
        return db.goalNoteDao();
    }
    
    @Override
    public String toString() {
        if (db == null) {
            return "NULL";
        }
        else {
            return db.toString();
        }
    }
    
}
