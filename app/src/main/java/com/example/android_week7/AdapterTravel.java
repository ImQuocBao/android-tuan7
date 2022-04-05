package com.example.android_week7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterTravel extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Travel> listTravels;

    @Override
    public int getCount() {
        return listTravels.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtHeader = view.findViewById(R.id.txtName2);

        Travel travel = listTravels.get(i);
        txtHeader.setText(travel.getName());
        return view;
    }
}
