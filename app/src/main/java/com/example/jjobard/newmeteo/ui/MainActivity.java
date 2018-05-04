package com.example.jjobard.newmeteo.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.api.API;
import com.example.jjobard.newmeteo.api.SharedP;
import com.example.jjobard.newmeteo.api.helpers.ResultatCallback;
import com.example.jjobard.newmeteo.model.Meteo;
import com.example.jjobard.newmeteo.ui.reusable.ActivityBase;

public class MainActivity extends ActivityBase {
    public static final String MAINACT_MESSAGE_TO_ACT2 = "city_to_activity_2";
    private EditText saisie;
    private ImageButton imagesearch;
    private TextView sortie;
    private Button clear_memory;
    private Button go_nav2;
    private Button photo_btn;
    private ImageView imageView;

    private SharedP sharedP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedP = new SharedP(this);

        bindView();
        fillDisplay();

    }

    /**
     * rempli les champs avec les SharedPreferencies
     */
    private void fillDisplay() {
        this.saisie.setText(new SharedP(this).get_city());

    }

    private void bindView() {
        this.saisie = findViewById(R.id.saisie);
        this.imagesearch = findViewById(R.id.imagesearch);
        this.sortie = findViewById(R.id.sortie);
        this.clear_memory = findViewById(R.id.clr);
        this.go_nav2 = findViewById(R.id.goAct2);
        this.photo_btn = findViewById(R.id.photo_btn);
        this.imageView = findViewById(R.id.image_view);

        this.saisie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        go_nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navigate();
            }
        });

        this.imagesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMeteoFromInput(saisie.getText().toString());
                hideKeyboard();
            }
        });

        this.clear_memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedP.clear_dico_city();
            }
        });

        this.photo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_photo();
            }
        });

    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(saisie.getWindowToken(), 0);
    }

    /**
     * déclarer ici pour utiliser le ctx $
     * pour l'appler depuis callback
     */
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


    private void navigate() {
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.MAINACT_MESSAGE_TO_ACT2, saisie.getText().toString());

        navigateAndClose(Main2Activity.class, bundle);


    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private void take_photo() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}
