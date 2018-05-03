package com.example.jjobard.newmeteo.api;

import com.example.jjobard.newmeteo.api.helpers.ResultatCallback;
import com.example.jjobard.newmeteo.model.Meteo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private IApi iApi;

    /**
     *
     */
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

    public void get_meteo_by_city (String city, final ResultatCallback res_callback) {
        // Create a call instance for looking up Retrofit contributors.
        Call<Meteo> call = this.iApi.getMeteoByCity(city, "78d8e5c2d2ef26799bb66865d14dd594");

        call.enqueue(new Callback<Meteo>() {
            @Override
            public void onResponse(Call<Meteo> call, Response<Meteo> response) {
                if(response.isSuccessful()) {
                    Meteo my_meteo = response.body();
                    res_callback.onWaitingResultat(my_meteo);
                } else {
                    //TODO
                }
            }

            @Override
            public void onFailure(Call<Meteo> call, Throwable t) {
                //TODO

            }
        });



    }

}
