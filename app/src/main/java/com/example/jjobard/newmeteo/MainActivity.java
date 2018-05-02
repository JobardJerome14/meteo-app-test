package com.example.jjobard.newmeteo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jjobard.newmeteo.api.API;
import com.example.jjobard.newmeteo.model.Meteo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMeteoFromInput();
    }


    private void getMeteoFromInput() {
        API mon_api = new API();
        Call<Meteo> mon_call = mon_api.get_meteo_by_city("Marseille");

        mon_call.enqueue(new Callback<Meteo>() {
            @Override
            public void onResponse(Call<Meteo> call, Response<Meteo> response) {
                if(response.isSuccessful()) {
                    Log.i("onResponseSuccess", response.body().getVille());
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
