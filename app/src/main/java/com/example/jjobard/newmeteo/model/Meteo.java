package com.example.jjobard.newmeteo.model;

import com.google.gson.annotations.SerializedName;

public class Meteo {

    @SerializedName("name")
    private String ville;

    @SerializedName("cod")
    private String return_code;


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
}
