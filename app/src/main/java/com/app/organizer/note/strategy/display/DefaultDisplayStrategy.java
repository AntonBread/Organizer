package com.app.organizer.note.strategy.display;

import android.graphics.Color;
import android.util.Log;

import com.app.organizer.note.strategy.GeneralNoteCard;

public class DefaultDisplayStrategy implements DisplayStrategy {
    @Override
    public void display(GeneralNoteCard card) {
        card.setBackgroundColor(Color.valueOf(Color.GRAY));
        card.setText(String.format("%s, %s", card.getNote().getName(), card.getNote().getDescription()));
        
        Log.d("CARD DISPLAY", card.toString());
    }
}
