package com.app.organizer.database;

import com.app.organizer.database.diary.TimeNoteDao;
import com.app.organizer.database.general.GeneralNoteDao;
import com.app.organizer.database.goals.GoalNoteDao;

public interface DatabaseInterface {
    GeneralNoteDao generalNoteDao();
    TimeNoteDao timeNoteDao();
    GoalNoteDao goalNoteDao();
}
