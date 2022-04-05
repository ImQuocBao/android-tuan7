package com.example.android_week7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView lvStudent;
    List<Travel> listTravel;
    AdapterStudent adapter;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DatabaseHandler db = new DatabaseHandler(this);
        lvStudent = findViewById(R.id.lvStudent);

//         Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addStudent(new Student("Đỗ Anh Bôn"));
//        db.addStudent(new Student("Hoàng Quốc Cường"));
//        db.addStudent(new Student("Phạm Minh Dũng"));
//        db.addStudent(new Student("Châu Hoàng Duy"));
//        db.addStudent(new Student("Nguyễn Đình Hảo"));

        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        listStudent = db.getAllStudents();
//
//        adapter = new AdapterStudent(this, R.layout.row_item, listStudent);
        lvStudent.setAdapter(adapter);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }
        });

    }
}