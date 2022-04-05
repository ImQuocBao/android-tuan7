package com.example.android_week7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterStudent extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> listStudent;

    public AdapterStudent(Context context, int layout, List<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    @Override
    public int getCount() {
        return listStudent.size();
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

        TextView txtHeader = view.findViewById(R.id.txtName);

        Student student = listStudent.get(i);
        txtHeader.setText(student.getName());
        return view;
    }
}
