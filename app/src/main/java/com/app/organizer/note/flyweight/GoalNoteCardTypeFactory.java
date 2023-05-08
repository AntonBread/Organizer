package com.app.organizer.note.flyweight;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

public class GoalNoteCardTypeFactory {
    static Map<String, GoalNoteCardType> cardTypes = new HashMap<>();
    
    public static GoalNoteCardType getCardType(String name, Drawable backgroundDrawable, Color backgroundColor, Drawable icon) {
        GoalNoteCardType cardType = cardTypes.get(name);
        if (cardType == null) {
            cardType = new GoalNoteCardType(name, backgroundDrawable, backgroundColor, icon);
            cardTypes.put(name, cardType);
        }
        return cardType;
    }
}
