package com.app.organizer.note.state;

public interface CardState {
    void onExpand(TimeNoteCard card);
    void onCollapse(TimeNoteCard card);
    void onHide(TimeNoteCard card);
}
