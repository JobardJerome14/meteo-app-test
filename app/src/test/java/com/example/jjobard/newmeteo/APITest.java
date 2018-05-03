package com.example.jjobard.newmeteo;

import com.example.jjobard.newmeteo.api.IApi;
import com.example.jjobard.newmeteo.api.helpers.ResultatCallback;
import com.example.jjobard.newmeteo.model.Meteo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APITest {

    private IApi iApi;

    public APITest() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org").client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.iApi = retrofit.create(IApi.class);
    }

    public Call<Meteo> get_meteo_by_city (String city) {
        // Create a call instance for looking up Retrofit contributors.
        return this.iApi.getMeteoByCity(city, "78d8e5c2d2ef26799bb66865d14dd594");

    }

}
