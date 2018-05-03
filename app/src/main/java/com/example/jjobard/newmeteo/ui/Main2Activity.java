package com.example.jjobard.newmeteo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.ui.reusable.ActivityBase;

public class Main2Activity extends ActivityBase {
    public static final String MESSAGE_TO_NAV3 = "message_nav2_to_nav3";

    private Button go_nav_3;

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


    }

    private void bindView() {
        this.go_nav_3 = findViewById(R.id.go_nav_3);

        go_nav_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(Main2Activity.MESSAGE_TO_NAV3, ville);
                navigate(Main3Activity.class, bundle);
            }
        });
    }


}
