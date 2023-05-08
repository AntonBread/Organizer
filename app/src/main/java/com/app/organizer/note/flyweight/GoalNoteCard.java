package com.app.organizer.note.flyweight;

import com.app.organizer.note.GoalNote;

public class GoalNoteCard {
    private GoalNote note;
    private GoalNoteCardType cardType;
    
    public GoalNoteCard(GoalNote note, GoalNoteCardType cardType) {
        this.note = note;
        this.cardType = cardType;
    }
    
    public void display() {
        cardType.display(note);
    }
}
