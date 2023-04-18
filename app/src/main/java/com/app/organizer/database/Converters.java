package com.app.organizer.database;

import android.util.Log;

import androidx.room.TypeConverter;

import com.app.organizer.note.GoalStep;
import com.app.organizer.note.SubTimeNote;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Converters {
    @TypeConverter
    public static ArrayList<String> listFromString(String json) {
        Gson gson = new Gson();
        TypeToken<List<String>> listType = new TypeToken<List<String>>(){};
        return gson.fromJson(json, listType.getType());
    }
    
    @TypeConverter
    public static String listToString(ArrayList<String> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
    
    
    
    @TypeConverter
    public static LocalDate dateFromString(String dateString) {
        return LocalDate.parse(dateString);
    }
    
    @TypeConverter
    public static String dateToString(LocalDate date) {
        return date.toString();
    }
    
    
    
    @TypeConverter
    public static LocalTime timeFromString(String timeString) {
        return LocalTime.parse(timeString);
    }
    
    @TypeConverter
    public static String timeToString(LocalTime time) {
        return time.toString();
    }
    
    
    
    @TypeConverter
    public static ArrayList<SubTimeNote> subTimeNotesFromJson(String json) {
        Gson gson = new Gson();
        Type subTimeNoteClassType = new TypeToken<ArrayList<SubTimeNote>>(){}.getType();
        return gson.fromJson(json, subTimeNoteClassType);
    }
    
    @TypeConverter
    public static String subTimeNotesToJson(ArrayList<SubTimeNote> subNotes) {
        Gson gson = new Gson();
        return gson.toJson(subNotes);
    }
    
    
    
    @TypeConverter
    public static LocalDateTime dateTimeFromString(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString);
    }
    
    @TypeConverter
    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.toString();
    }
    
    
    
    @TypeConverter
    public static ArrayList<GoalStep> goalStepsFromJson(String json) {
        Gson gson = new Gson();
        Type goalStepsClassType = new TypeToken<ArrayList<GoalStep>>(){}.getType();
        return gson.fromJson(json, goalStepsClassType);
    }
    
    @TypeConverter
    public static String goalStepsToJson(ArrayList<GoalStep> goalSteps) {
        Gson gson = new Gson();
        return gson.toJson(goalSteps);
    }
}
