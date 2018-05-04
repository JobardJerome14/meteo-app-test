package com.example.jjobard.newmeteo.ui.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jjobard.newmeteo.R;
import com.example.jjobard.newmeteo.model.Meteo;

import java.util.ArrayList;

public class MeteoAdapter extends BaseAdapter{

    private Context contexte;
    private ArrayList<Meteo> meteos = new ArrayList<Meteo>();

    public MeteoAdapter(Context contexte, ArrayList<Meteo> meteos) {
        this.contexte = contexte;
        this.meteos = meteos;


    }

    @Override
    public int getCount() {
        return meteos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.meteo_item, parent, false);
        }

        Meteo cur_meteo = this.meteos.get(position);
        final TextView tv_meteo = convertView.findViewById(R.id.tv_meteo);
        tv_meteo.setText(cur_meteo.getVille());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_meteo.setBackgroundColor(contexte.getResources().getColor(R.color.flashy2));
            }
        });


        return convertView;
        //return null;
    }


}
