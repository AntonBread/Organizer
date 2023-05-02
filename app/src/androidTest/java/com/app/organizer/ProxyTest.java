package com.app.organizer;

import android.content.Context;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.app.organizer.database.AppDatabaseProxy;
import com.app.organizer.database.diary.TimeNoteEntity;
import com.app.organizer.note.TimeNote;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(AndroidJUnit4.class)
public class ProxyTest {
    @Test
    public void proxy_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabaseProxy db = new AppDatabaseProxy(context);
        Log.d("DATABASE OBJECT", db.toString());
    
        TimeNote note = new TimeNote("name", "description", LocalDate.now(), LocalTime.now(), null, null, true);
        db.timeNoteDao().insert(note.toEntity());
        
        Log.d("DATABASE OBJECT", db.toString());
        
        TimeNoteEntity entity = db.timeNoteDao().getById(1);
        Log.d("TEST", entity.getName());
    }
}
