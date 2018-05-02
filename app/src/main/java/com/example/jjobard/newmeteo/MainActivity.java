package com.example.jjobard.newmeteo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jjobard.newmeteo.api.API;
import com.example.jjobard.newmeteo.model.Meteo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText saisie;
    private ImageButton imagesearch;
    private TextView sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
    }

    private void bindView() {
        this.saisie = findViewById(R.id.saisie);
        this.imagesearch = findViewById(R.id.imagesearch);
        this.sortie = findViewById(R.id.sortie);


        this.imagesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMeteoFromInput(saisie.getText().toString());
                hideKeyboard();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(saisie.getWindowToken(), 0);
    }


    private void getMeteoFromInput(String ville) {
        API mon_api = new API();
        Call<Meteo> mon_call = mon_api.get_meteo_by_city(ville);

        mon_call.enqueue(new Callback<Meteo>() {
            @Override
            public void onResponse(Call<Meteo> call, Response<Meteo> response) {
                if(response.isSuccessful()) {
                    sortie.setText(response.body().getVille());
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
