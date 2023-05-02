package com.app.organizer;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.app.organizer.note.INote;
import com.app.organizer.note.factory.abstr.GeneralNoteFactory;
import com.app.organizer.note.factory.abstr.GoalNoteFactory;
import com.app.organizer.note.factory.abstr.NoteFactory;
import com.app.organizer.note.factory.abstr.TimeNoteFactory;
import com.app.organizer.note.factory.abstr.UIElement;
import com.app.organizer.ui.diary.DiaryFragment;
import com.app.organizer.ui.general.GeneralFragment;
import com.app.organizer.ui.goals.GoalsFragment;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AbstractFactoryTest {
    NoteFactory factory;
    
    @Test
    public void abstract_factory_test() {
        Class<?> uiClass = GoalsFragment.class;
        factoryInit(uiClass);
        
        INote note = factory.createNote();
        UIElement uiElement = factory.createUiElement();
        
        Log.d("TEST", note.getClass().getCanonicalName());
        uiElement.doSomething();
    }
    
    private void factoryInit(Class<?> uiClass) {
        if (uiClass == DiaryFragment.class) {
            factory = new TimeNoteFactory();
        }
        else if (uiClass == GeneralFragment.class) {
            factory = new GeneralNoteFactory();
        }
        else if (uiClass == GoalsFragment.class) {
            factory = new GoalNoteFactory();
        }
    }
}
