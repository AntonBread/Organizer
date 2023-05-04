package com.app.organizer.note.strategy.click;

import android.util.Log;

import com.app.organizer.note.strategy.GeneralNoteCard;

public class IgnoreOnClickStrategy implements OnClickStrategy {
    @Override
    public void onClick(GeneralNoteCard card) {
        Log.d("CARD ON CLICK:", "IGNORED");
    }
}
