package com.app.organizer.note.strategy.click;

import com.app.organizer.note.strategy.GeneralNoteCard;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultOnClickStrategy implements OnClickStrategy {
    @Override
    public void onClick(GeneralNoteCard card) {
        if (card.isTagsVisible()) {
            card.setTagsVisible(false);
            card.setSubText("");
        }
        else {
            card.setTagsVisible(true);
            ArrayList<String> tags = card.getNote().getTags();
            card.setSubText(Arrays.toString(tags.toArray()));
        }
        card.display();
    }
}
