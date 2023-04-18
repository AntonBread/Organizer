package com.app.organizer;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.app.organizer.database.AppDatabase;
import com.app.organizer.database.general.GeneralDatabaseManager;
import com.app.organizer.database.general.GeneralNoteEntity;
import com.app.organizer.database.goals.GoalNoteEntity;
import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.GoalNote;
import com.app.organizer.note.GoalStep;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void entity_string_convert_test() {
        GeneralNote note = new GeneralNote("Sample name", "Sample description", null, LocalDateTime.now());
        GeneralNoteEntity entity = note.toEntity();
        assertEquals(note.getName(), entity.getName());
        assertEquals(note.getDescription(), entity.getDescription());
        assertEquals(note.getCreationDateTime().toString(), entity.getCreationDateTime());
        
        GeneralNote note2 = new GeneralNote(entity);
        assertEquals(note2.getName(), entity.getName());
        assertEquals(note2.getDescription(), entity.getDescription());
        assertEquals(note2.getCreationDateTime().toString(), entity.getCreationDateTime());
    }
    
    @Test
    public void entity_list_convert_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        GeneralNote note = new GeneralNote("name", "description", new ArrayList<String>(), LocalDateTime.now());
        note.addTag("Tag 1");
        note.addTag("Tag 2");
        note.addTag("Tag 3000");
        
        GeneralNoteEntity entity = note.toEntity();
        db.generalNoteDao().insert(entity);
        
        GeneralNote note2 = new GeneralNote(db.generalNoteDao().getById(1));
        
        assertEquals(note.getTags().size(), note2.getTags().size());
        
        for (int i = 0; i < note.getTags().size(); i++) {
            assertEquals(note.getTags().get(i), note2.getTags().get(i));
        }
    }
    
    @Test
    public void create_isNameUnique_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        GeneralNoteEntity entity = new GeneralNoteEntity();
        entity.setName("Existing name");
        db.generalNoteDao().insert(entity);
        
        GeneralNote noteUnique = new GeneralNote("New name", null, null, null);
        GeneralNote noteNonUnique = new GeneralNote("Existing name", null, null, null);
        
        assertTrue(GeneralDatabaseManager.isNameUnique(db.generalNoteDao(), noteUnique));
        assertFalse(GeneralDatabaseManager.isNameUnique(db.generalNoteDao(), noteNonUnique));
    }
    
    @Test
    public void database_update_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        GeneralNoteEntity entity = new GeneralNoteEntity();
        entity.setName("Old name");
        entity.setId(db.generalNoteDao().insert(entity));
        
        entity.setName("Updated name");
        db.generalNoteDao().update(entity);
        
        assertEquals(entity.getName(), db.generalNoteDao().getById(1).getName());
    }
    
    @Test
    public void database_delete_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        GeneralNoteEntity entity = new GeneralNoteEntity();
        entity.setName("Sample name");
        entity.setId(db.generalNoteDao().insert(entity));
        
        db.generalNoteDao().delete(entity);
        
        assertNull(db.generalNoteDao().getByName("Sample name"));
    }
    
    @Test
    public void database_goal_note_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        
        ArrayList<GoalStep> steps = new ArrayList<>();
        steps.add(new GoalStep("Step 1", "Secure the keys", LocalDateTime.now().toString()));
        steps.add(new GoalStep("Step 2", "Ascend from darkness", LocalDateTime.now().plusMinutes(5).toString()));
        steps.add(new GoalStep("Step 3", "Rain fire", LocalDateTime.now().plusMinutes(30).toString()));
        
        GoalNote note = new GoalNote("name", "desc", steps);
        db.goalNoteDao().insert(note.toEntity());
        
        GoalNoteEntity entity = db.goalNoteDao().getById(1);
        
        Log.d("TEST", entity.getName());
        Log.d("TEST", entity.getDescription());
        assertEquals(entity.getName(), "name");
        assertEquals(entity.getDescription(), "desc");
        
        ArrayList<GoalStep> entitySteps = entity.getSteps();
        for (int i = 0; i < entitySteps.size(); i++) {
            Log.d("TEST", entitySteps.get(i).toString());
            assertEquals(entitySteps.get(i).toString(), steps.get(i).toString());
        }
    }
}