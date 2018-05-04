package com.example.jjobard.newmeteo.model;

import com.google.gson.annotations.SerializedName;

public class Meteo {

    public Meteo () {


    }

    public Meteo (String ville) {
        this.setVille(ville);
    }

    @SerializedName("name")
    private String ville;

    @SerializedName("cod")
    private String return_code;

    @SerializedName("clouds")
    private Nuages nuages;


    @SerializedName("main")
    private Tout tout;

    public Tout getTout() {
        return tout;
    }

    public void setTout(Tout tout) {
        this.tout = tout;
    }

    public class Nuages {
        @SerializedName("all") private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }

    @Override
    public String toString() {
        return this.getTout().getTemp() + "\n" + this.getVille();
    }

    public class Tout {
        @SerializedName("temp") private float temp;
        @SerializedName("pressure") private float pressure;

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }
    }


    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public Nuages getNuages() {
        return nuages;
    }

    public void setNuages(Nuages nuages) {
        this.nuages = nuages;
    }
}
