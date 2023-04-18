package com.app.organizer.database.diary;

import androidx.room.*;

@Dao
public interface TimeNoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(TimeNoteEntity timeNoteEntity);
    
    @Update
    void update(TimeNoteEntity timeNoteEntity);
    
    @Delete
    void delete(TimeNoteEntity timeNoteEntity);
    
    @Query("SELECT * FROM DIARY_NOTES WHERE name =:name")
    TimeNoteEntity getByName(String name);
    
    @Query("Select * FROM DIARY_NOTES WHERE id =:id")
    TimeNoteEntity getById(long id);
}
