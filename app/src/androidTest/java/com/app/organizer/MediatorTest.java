package com.app.organizer;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.*;

import com.app.organizer.database.AppDatabase;
import com.app.organizer.database.DatabaseMediator;
import com.app.organizer.database.diary.TimeNoteDatabaseEditor;
import com.app.organizer.database.diary.TimeNoteEntity;
import com.app.organizer.note.TimeNote;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalTime;


@RunWith(AndroidJUnit4.class)
public class MediatorTest {
    @Test
    public void time_note_database_mediator_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        DatabaseMediator databaseMediator = new TimeNoteDatabaseEditor();
        TimeNote note = new TimeNote("name", "desc", LocalDate.now(), LocalTime.now(), null, null, true);
        
        databaseMediator.setNote(note);
        
        note.getDatabaseMediator().add(db);
    
        TimeNoteEntity entity = db.timeNoteDao().getById(1);
    
        Log.d("TEST", entity.getName());
        Log.d("TEST", entity.getDescription());
        
        assertEquals(entity.getName(), "name");
        assertEquals(entity.getDescription(), "desc");
    }
}
