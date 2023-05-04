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
        createDBInstance();
        return db.generalNoteDao();
    }
    
    public TimeNoteDao timeNoteDao() {
        createDBInstance();
        return db.timeNoteDao();
    }
    
    public GoalNoteDao goalNoteDao() {
        createDBInstance();
        return db.goalNoteDao();
    }
    
    private void createDBInstance() {
        if (db == null) {
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        }
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
