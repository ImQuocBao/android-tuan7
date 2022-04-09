package com.example.android_week7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ListView lvTravel;
    private static List<Travel> listTravel;
    private static AdapterTravel adapter;
    int position = -1;

    private static MainActivity2 instance;
    private static DatabaseHandler2 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new DatabaseHandler2(this);
        lvTravel = findViewById(R.id.lvTravel);

//         Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addLocation(new Travel("Đà Lạt"));
        db.addLocation(new Travel("Buôn Mê thuột"));
        db.addLocation(new Travel("Cần Thơ"));
        db.addLocation(new Travel("Phú Quốc "));
        db.addLocation(new Travel("Lý Sơn"));
        db.addLocation(new Travel("Cần Giờ"));
        db.addLocation(new Travel("Côn Đảo"));
        db.addLocation(new Travel("Vũng Tàu"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        listTravel = db.getAllLocation();

        adapter = new AdapterTravel(this, R.layout.row_item2, listTravel);
        lvTravel.setAdapter(adapter);

        lvTravel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }
        });

    }

    public static MainActivity2 getInstance(){
        return instance;
    }

    static public void removeItem(int index) {
        listTravel.remove(index);
        db.deleteLocation(listTravel.get(index));
        adapter.notifyDataSetChanged();
    }

    public DatabaseHandler2 getDb() {
        return db;
    }

    public void update() {
        listTravel.clear();
        List<Travel> temp = db.getAllLocation();
        for (Travel n : temp){
            listTravel.add(n);
        }
        adapter.notifyDataSetChanged();
    }
}