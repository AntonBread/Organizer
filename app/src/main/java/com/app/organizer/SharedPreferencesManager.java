package com.app.organizer;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.Locale;

public class SharedPreferencesManager {
    
    private static SharedPreferencesManager instance = null;
    
    private static final int NOTIFICATIONS_DISABLED = 0;
    private static final int NOTIFICATIONS_SELECT_EACH = 1;
    private static final int NOTIFICATIONS_SHOW_ALL = 2;
    
    private final Context appContext;
    
    private SharedPreferencesManager(Context appContext) {
        this.appContext = appContext;
    }
    
    public static SharedPreferencesManager getInstance(Context appContext) {
        if (instance == null) {
            instance = new SharedPreferencesManager(appContext);
        }
        return instance;
    }
    
    private SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }
    
    public Locale getLocale() {
        String localeString = getSharedPreferences().getString("lang", "en");
        return new Locale(localeString);
    }
    
    public int getNotificationsSettings() {
        String notificationString = getSharedPreferences().getString("notification", "select_each_time");
        switch (notificationString) {
            case "off":
                return NOTIFICATIONS_DISABLED;
            case "on":
                return NOTIFICATIONS_SHOW_ALL;
            case "select_each_time":
            default:
                return NOTIFICATIONS_SELECT_EACH;
        }
    }
}
