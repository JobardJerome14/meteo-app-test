package com.example.jjobard.newmeteo.api;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedP {
    private Context context;

    public SharedP(Context ctx) {
        this.context = ctx;
    }

    /**
     * Fonction qui retourne les shared preferencies pour un dictionnaire
     * @param dictionnary : nom du dictionnaire
     * @return : shared preferencies
     */
    private SharedPreferences get_SHP(String dictionnary) {
        return this.context.getSharedPreferences(dictionnary, Context.MODE_PRIVATE);
    }


    private void clear_dico(String dico) {
        get_SHP(dico).edit().clear().apply();
    }

    public void clear_dico_city() {
        clear_dico(CityHelper.DICTIONNARY);
    }

    public void set_city(String ville) {
        get_SHP(CityHelper.DICTIONNARY).edit()
           .putString(CityHelper.CITY, ville)
           .apply();
    }

    public String get_city() {
        return get_SHP(CityHelper.DICTIONNARY).getString(CityHelper.CITY, "");
    }

    /**
     * classe pour noms des dictionnaires champs en static
     */
    private class CityHelper {
        final static String DICTIONNARY = "dico_ville";
        final static String CITY = "ville";
    }

}
