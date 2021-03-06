package com.example.jjobard.newmeteo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.ui.reusable.ActivityBase;

public class Main2Activity extends ActivityBase {
    public static final String MESSAGE_TO_NAV3 = "message_nav2_to_nav3";

    private Button go_nav_3;
    private View container;

    private String ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            ville = intent.getStringExtra(MainActivity.MAINACT_MESSAGE_TO_ACT2);
        }

        bindView();
        loadFragment();

    }

    private void bindView() {
        this.go_nav_3 = findViewById(R.id.go_nav_3);
        //this.container = findViewById(R.id.view_fragment);




        go_nav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Main2Activity.MESSAGE_TO_NAV3, ville);
                navigate(Main3Activity.class, bundle);
            }
        });
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Main2Fragment fragment = Main2Fragment.newInstance();
        fragmentTransaction.add(R.id.view_fragment, fragment);
        fragmentTransaction.commit();
    }


}
