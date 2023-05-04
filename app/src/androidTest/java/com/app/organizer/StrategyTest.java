package com.app.organizer;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.app.organizer.note.GeneralNote;
import com.app.organizer.note.strategy.GeneralNoteCard;
import com.app.organizer.note.strategy.click.DefaultOnClickStrategy;
import com.app.organizer.note.strategy.click.IgnoreOnClickStrategy;
import com.app.organizer.note.strategy.click.OnClickStrategy;
import com.app.organizer.note.strategy.display.DefaultDisplayStrategy;
import com.app.organizer.note.strategy.display.DisplayStrategy;
import com.app.organizer.note.strategy.display.FavoriteDisplayStrategy;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class StrategyTest {
    @Test
    public void strategy_test() {
        ArrayList<String> tags = new ArrayList<>(Arrays.asList("Tag 1", "Tag 2", "Tag 3"));
        GeneralNote note = new GeneralNote("Very important link!", "https://www.youtube.com/watch?v=dQw4w9WgXcQ", tags, LocalDateTime.now());
    
        DisplayStrategy displayStrategy = new DefaultDisplayStrategy();
        OnClickStrategy onClickStrategy = new DefaultOnClickStrategy();
    
        GeneralNoteCard card = new GeneralNoteCard(note, displayStrategy, onClickStrategy);
        
        card.display();
        card.click();
        card.click();
        
        card.setDisplayStrategy(new FavoriteDisplayStrategy());
        card.setOnClickStrategy(new IgnoreOnClickStrategy());
        
        card.display();
        card.click();
    }
}
