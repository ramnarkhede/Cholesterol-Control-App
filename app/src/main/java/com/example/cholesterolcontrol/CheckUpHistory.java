package com.example.cholesterolcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class CheckUpHistory extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addTest;
    List<Test> tests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up_history);
        addTest=findViewById(R.id.addTest);


            addTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),AddTestActivity.class));
                }
            });


        getData();


    }
    public void getData(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_col").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();

        recyclerView=findViewById(R.id.recycleTest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tests=userDao.getAllTest();
        AdapterTest adapterTest=new AdapterTest(tests);
        recyclerView.setAdapter(adapterTest);
    }
}