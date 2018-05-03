package com.example.jjobard.newmeteo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jjobard.newmeteo.api.API;
import com.example.jjobard.newmeteo.api.SharedP;
import com.example.jjobard.newmeteo.api.helpers.ResultatCallback;
import com.example.jjobard.newmeteo.model.Meteo;

public class MainActivity extends AppCompatActivity {

    private EditText saisie;
    private ImageButton imagesearch;
    private TextView sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        fillDisplay();

    }

    private void fillDisplay() {
        this.saisie.setText(new SharedP(this).get_city());

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

    private void set_shp_city(String ville) {
        new SharedP(this).set_city(ville);
    }


    private void getMeteoFromInput(String ville) {

        API my_api = new API();

        my_api.get_meteo_by_city(ville, new ResultatCallback() {
            @Override
            public void onWaitingResultat(Meteo my_meteo) {
                sortie.setText(my_meteo.toString());
                set_shp_city(my_meteo.getVille());

            }
        });
    }

}
