package com.app.organizer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.app.organizer.note.GoalNote;
import com.app.organizer.note.flyweight.GoalNoteCard;
import com.app.organizer.note.flyweight.GoalNoteCardTypeFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(AndroidJUnit4.class)
public class FlyweightTest {
    private final int CARD_COUNT = 100000;
    private final int CARD_TYPES = 2;
    private final String TYPE_NAME_DEFAULT = "default";
    private final String TYPE_NAME_FAVORITE = "favorite";
    
    ArrayList<GoalNoteCard> cards = new ArrayList<>(CARD_COUNT);
    
    
    @Test
    public void flyweight_test() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        
        final Drawable BACKGROUND_DEFAULT = context.getDrawable(R.drawable.flyweight_background_default);
        final Drawable BACKGROUND_FAVORITE = context.getDrawable(R.drawable.flyweight_background_favorite);
        final Drawable ICON_DEFAULT = context.getDrawable(R.drawable.flyweight_ic_default);
        final Drawable ICON_FAVORITE = context.getDrawable(R.drawable.flyweight_ic_favorite);
        final int COLOR_DEFAULT = context.getColor(R.color.gray);
        final int COLOR_FAVORITE = context.getColor(R.color.pink);
        
        for (int i = 0; i < CARD_COUNT / CARD_TYPES; i++) {
            cards.add(new GoalNoteCard(new GoalNote("Default name", "Sample description", null),
                                       GoalNoteCardTypeFactory.getCardType(TYPE_NAME_DEFAULT, BACKGROUND_DEFAULT,
                                                                           Color.valueOf(COLOR_DEFAULT),
                                                                           ICON_DEFAULT)));
            cards.add(new GoalNoteCard(new GoalNote("Favorite name", "Sample description", null),
                                       GoalNoteCardTypeFactory.getCardType(TYPE_NAME_FAVORITE, BACKGROUND_FAVORITE,
                                                                           Color.valueOf(COLOR_FAVORITE),
                                                                           ICON_FAVORITE)));
        }
        
        cards.get(0).display();
        cards.get(1).display();
    }
    
    
}
