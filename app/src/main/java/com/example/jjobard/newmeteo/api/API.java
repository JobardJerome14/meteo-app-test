package com.example.jjobard.newmeteo.api;

import android.util.Log;

import com.example.jjobard.newmeteo.model.Meteo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private IApi iApi;

    public API() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.iApi = retrofit.create(IApi.class);
    }

    public void get_meteo_by_city () {
        // Create a call instance for looking up Retrofit contributors.
        Call<Meteo> call = this.iApi.getMeteoByCity("Marseille", "78d8e5c2d2ef26799bb66865d14dd594");

        // Fetch and print a list of the contributors to the library.
        try {
            Meteo response = call.execute().body();
            Log.i("getmeteobycity", response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
