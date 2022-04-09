package com.example.android_week7;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterTravel extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Travel> listTravels;

    public AdapterTravel(Context context, int layout, List<Travel> listTravels) {
        this.context = context;
        this.layout = layout;
        this.listTravels = listTravels;
    }

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

        EditText txtHeader = view.findViewById(R.id.txtName2);
        EditText editText = view.findViewById(R.id.editnameplace);

        ImageButton imgBtnEdit = view.findViewById(R.id.btnChange);
        ImageButton imgBtnRemove = view.findViewById(R.id.btnRemoveItem);

        Travel travel = listTravels.get(i);

        imgBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                travel.setName(editText.getText().toString());
                MainActivity2 instance = MainActivity2.getInstance();
                instance.getDb().updateLocation(travel);
                instance.update();
            }
        });

        imgBtnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity2.removeItem(i);
            }
        });

        txtHeader.setText(travel.getName());
        return view;
    }
}
