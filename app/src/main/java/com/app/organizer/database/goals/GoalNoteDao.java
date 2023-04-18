package com.app.organizer.database.goals;

import androidx.room.*;

@Dao
public interface GoalNoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(GoalNoteEntity goalNoteEntity);
    
    @Update
    void update(GoalNoteEntity goalNoteEntity);
    
    @Delete
    void delete(GoalNoteEntity goalNoteEntity);
    
    @Query("SELECT * FROM GOAL_NOTES WHERE name = :name")
    GoalNoteEntity getByName(String name);
    
    @Query("SELECT * FROM GOAL_NOTES WHERE id = :id")
    GoalNoteEntity getById(long id);
}
