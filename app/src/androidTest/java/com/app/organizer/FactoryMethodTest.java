package com.app.organizer;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.GoalNote;
import com.app.organizer.note.TimeNote;
import com.app.organizer.note.factory.GeneralNoteCreator;
import com.app.organizer.note.factory.GoalNoteCreator;
import com.app.organizer.note.factory.NoteCreator;
import com.app.organizer.note.factory.TimeNoteCreator;

@RunWith(AndroidJUnit4.class)
public class FactoryMethodTest {
    NoteCreator creator;
    
    @Test
    public void factory_method_test() {
        Class<?> noteClass = GeneralNote.class;
        init(noteClass);
        creator.doSomething("Sample name");
    }
    
    void init(Class<?> noteClass) {
        if (noteClass == GeneralNote.class) {
            creator = new GeneralNoteCreator();
        }
        else if (noteClass == TimeNote.class) {
            creator = new TimeNoteCreator();
        }
        else if (noteClass == GoalNote.class) {
            creator = new GoalNoteCreator();
        }
    }
}
