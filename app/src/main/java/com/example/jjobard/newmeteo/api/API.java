package com.example.jjobard.newmeteo.api;

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

}
