package com.example.jjobard.newmeteo.ui.reusable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jjobard.newmeteo.ui.Main2Activity;
import com.example.jjobard.newmeteo.ui.MainActivity;

public class ActivityBase extends AppCompatActivity{

    public void navigate(Class activity, Bundle bundle) {
        Intent i = new Intent(getApplicationContext(), activity);
        if(bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }

    public void navigateAndClose( Class activity, Bundle bundle){
        navigate(activity, bundle);
        finish();
    }
}
