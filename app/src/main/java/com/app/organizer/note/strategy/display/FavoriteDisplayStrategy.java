package com.app.organizer.note.strategy.display;

import android.graphics.Color;
import android.util.Log;

import com.app.organizer.note.strategy.GeneralNoteCard;

public class FavoriteDisplayStrategy implements DisplayStrategy {
    @Override
    public void display(GeneralNoteCard card) {
        card.setBackgroundColor(Color.valueOf(Color.RED));
        card.setText(card.getNote().getName());
        
        Log.d("CARD DISPLAY", card.toString());
    }
}
