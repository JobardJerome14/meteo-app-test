package com.example.jjobard.newmeteo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.model.Meteo;
import com.example.jjobard.newmeteo.ui.adapters.MeteoAdapter;
import com.example.jjobard.newmeteo.ui.reusable.ActivityBase;

import java.util.ArrayList;

public class Main3Activity extends ActivityBase {

    private String ville = "";

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            ville = intent.getStringExtra(Main2Activity.MESSAGE_TO_NAV3);
        }

        bindView();
    }


    private void bindView() {
        listview = findViewById(R.id.listV3);
        ArrayList<Meteo> meteos = new ArrayList<>();
        meteos.add(new Meteo("Paris"));
        meteos.add(new Meteo("Marseille"));
        meteos.add(new Meteo("Dijon"));
        meteos.add(new Meteo("Aix en Provence"));


        listview.setAdapter(new MeteoAdapter(this, meteos));
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }
}
