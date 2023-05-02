package com.app.organizer.note.factory.method;

import android.util.Log;

import com.app.organizer.note.INote;

public abstract class NoteCreator {
    public abstract INote createNote(String name);
    
    public void doSomething(String noteName) {
        INote note = createNote(noteName);
        Log.d("TEST", note.toString());
    }
}
