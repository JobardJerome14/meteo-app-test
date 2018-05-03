package com.example.jjobard.newmeteo.api;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedP {
    private Context context;

    public SharedP(Context ctx) {
        this.context = ctx;
    }

    private SharedPreferences get_meteo_SHP() {
        return this.context.getSharedPreferences(CityHelper.DICTIONNARY, Context.MODE_PRIVATE);

    }
    public void set_city(String ville) {
        get_meteo_SHP().edit()
           .putString(CityHelper.CITY, ville)
           .apply();
    }

    public String get_city() {
        return get_meteo_SHP().getString(CityHelper.CITY, "");
    }

    private class CityHelper {
        final static String DICTIONNARY = "dico_ville";
        final static String CITY = "ville";
    }

}
