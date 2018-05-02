package com.example.jjobard.newmeteo.api;

import android.util.Log;

import com.example.jjobard.newmeteo.model.Meteo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private IApi iApi;

    public API() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org").client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.iApi = retrofit.create(IApi.class);
    }

    public Call<Meteo> get_meteo_by_city ( String city ) {
        // Create a call instance for looking up Retrofit contributors.
        Call<Meteo> call = this.iApi.getMeteoByCity(city, "78d8e5c2d2ef26799bb66865d14dd594");
        return call;
//        // Fetch and print a list of the contributors to the library.
//        try {
//            Response<Meteo> response = call.execute();
//            Log.i("getmeteobycity", response.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
