package dev.m13d.weatherapp;

import android.app.Activity;
import android.content.SharedPreferences;

public final class AppCache {

    private static final String CITY_KEY = "city";
    private static final String DEFAULT_TOWN = "Moscow";
    private SharedPreferences userPreferences;

    public AppCache(Activity activity) {
        userPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getSavedCity() {
        return userPreferences.getString(CITY_KEY, DEFAULT_TOWN);
    }

    public void saveCity(String city) {
        userPreferences.edit().putString(CITY_KEY, city).apply();
    }
}
