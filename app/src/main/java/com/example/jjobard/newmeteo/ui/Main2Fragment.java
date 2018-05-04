package com.example.jjobard.newmeteo.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jjobard.newmeteo.R;

public class Main2Fragment extends Fragment {

    public Main2Fragment() {
        // Required empty public constructor
    }


    public static Main2Fragment newInstance(String param1, String param2) {
        Main2Fragment fragment = new Main2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false);
    }

}
