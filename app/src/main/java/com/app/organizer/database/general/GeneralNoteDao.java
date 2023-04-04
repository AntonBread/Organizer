package com.app.organizer.database.general;

import androidx.room.*;

@Dao
public interface GeneralNoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(GeneralNoteEntity generalNoteEntity);
    
    @Update
    void update(GeneralNoteEntity generalNoteEntity);
    
    @Delete
    void delete(GeneralNoteEntity generalNoteEntity);
    
    @Query("SELECT * FROM GENERAL_NOTES WHERE name = :name")
    GeneralNoteEntity getByName(String name);
    
    @Query("SELECT * FROM GENERAL_NOTES WHERE id =:id")
    GeneralNoteEntity getById(long id);
}
