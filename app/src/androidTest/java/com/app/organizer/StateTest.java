package com.app.organizer;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.app.organizer.note.TimeNote;
import com.app.organizer.note.state.TimeNoteCard;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(AndroidJUnit4.class)
public class StateTest {
    @Test
    public void state_test() {
        TimeNote note = new TimeNote("Go to the market",
                                     "Need to buy a loaf of bread",
                                     LocalDate.now(),
                                     LocalTime.now(),
                                     null, null, true);
    
        TimeNoteCard card = new TimeNoteCard(note);
        
        card.collapse();
    
        Log.d("CARD STATE", card.toString());
        
        card.expand();
        
        Log.d("CARD STATE", card.toString());
        
        card.hide();
        
        Log.d("CARD STATE", card.toString());
        
        card.hide();
    }
}
