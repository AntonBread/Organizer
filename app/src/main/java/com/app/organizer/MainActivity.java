package com.app.organizer;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.app.organizer.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    
    private ActivityMainBinding binding;
    
    private SharedPreferencesManager settingsManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        SharedPreferencesManager.logInstance();
        
        settingsManager = SharedPreferencesManager.getInstance(getApplicationContext());
    
        SharedPreferencesManager.logInstance();
    
        Locale locale = settingsManager.getLocale();
        Log.d("DEBUG", locale.getLanguage());
        
        Log.d("DEBUG", Integer.toString(settingsManager.getNotificationsSettings()));
        
        settingsManager = SharedPreferencesManager.getInstance(getApplicationContext());
    
        SharedPreferencesManager.logInstance();
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    
}