package com.example.cholesterolcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class FatConsumedActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_consumed);


        getData();
    }
    public void getData(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_col").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();

        recyclerView=findViewById(R.id.recyclerFetch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Day> day=userDao.getAllDay();
        AdapterFetchDay adapterFetchDay=new AdapterFetchDay(day);
        recyclerView.setAdapter(adapterFetchDay);
    }
}