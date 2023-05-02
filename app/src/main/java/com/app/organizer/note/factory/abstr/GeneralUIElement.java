package com.app.organizer.note.factory.abstr;

import android.util.Log;

public class GeneralUIElement implements UIElement {
    @Override
    public void doSomething() {
        Log.d("TEST", "This is message from General UI Element");
    }
}
