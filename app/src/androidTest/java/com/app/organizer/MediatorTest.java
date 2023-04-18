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
import com.app.organizer.note.SubTimeNote;
import com.app.organizer.note.TimeNote;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


@RunWith(AndroidJUnit4.class)
public class MediatorTest {
    @Test
    public void time_note_database_mediator_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
    
        ArrayList<SubTimeNote> subNotes = new ArrayList<>();
        subNotes.add(new SubTimeNote("sub 1", "note 1", LocalTime.now().toString(), true));
        subNotes.add(new SubTimeNote("sub 2", "note 2", LocalTime.now().plusMinutes(15).toString(), true));
        subNotes.add(new SubTimeNote("sub 3", "note 3", LocalTime.now().plusMinutes(45).toString(), true));
        
        ArrayList<String> tags = new ArrayList<>();
        tags.add("tag 1");
        tags.add("tag 2");
        
        TimeNote note = new TimeNote("name", "desc", LocalDate.now(), LocalTime.now(), subNotes, tags, true);
    
        DatabaseMediator databaseMediator = new TimeNoteDatabaseEditor();
        databaseMediator.setNote(note);
        
        note.getDatabaseMediator().add(db);
    
        TimeNoteEntity entity = db.timeNoteDao().getById(1);
    
        Log.d("TEST", entity.getName());
        Log.d("TEST", entity.getDescription());
        assertEquals(entity.getName(), "name");
        assertEquals(entity.getDescription(), "desc");
        
        ArrayList<SubTimeNote> entitySubNotes = entity.getSubNotes();
        for (int i = 0; i < entitySubNotes.size(); i++) {
            Log.d("TEST", entitySubNotes.get(i).toString());
            assertEquals(entitySubNotes.get(i).toString(), subNotes.get(i).toString());
        }
        
        ArrayList<String> entityTags = entity.getTags();
        for (int i = 0; i < entityTags.size(); i++) {
            Log.d("TEST", entityTags.get(i));
            assertEquals(entityTags.get(i), tags.get(i));
        }
    }
}
