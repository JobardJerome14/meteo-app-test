package com.example.jjobard.newmeteo.api;

import com.example.jjobard.newmeteo.model.Meteo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {
    //http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22


    @GET("/data/2.5/weather")
    Call<Meteo> getMeteoByCity(
            @Query("q") String city,
            @Query("appid") String app_id
            );
}
