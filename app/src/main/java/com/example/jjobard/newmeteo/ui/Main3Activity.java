package com.example.jjobard.newmeteo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.ui.reusable.ActivityBase;

public class Main3Activity extends ActivityBase {

    private String ville = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            ville = intent.getStringExtra(Main2Activity.MESSAGE_TO_NAV3);
        }
    }
}
