package com.app.organizer.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
}
