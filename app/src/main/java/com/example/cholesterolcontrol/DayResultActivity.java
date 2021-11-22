package com.example.cholesterolcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DayResultActivity extends AppCompatActivity {
    TextView dayFatCount,dateView;
    Button btnWorkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_result);
        dateView=findViewById(R.id.dateView);
        btnWorkout=findViewById(R.id.btnSuggestion);

        dayFatCount=findViewById(R.id.dayFatCount);
        int result=getIntent().getExtras().getInt("result");
        String date=getIntent().getExtras().getString("date");

        dayFatCount.setText(String.valueOf(result+" gram"));
        dateView.setText(date);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_col").allowMainThreadQueries().build();
        UserDao userDao = db.userDao();

        userDao.insert(new Day(result,date));

        if(result>77){
            dayFatCount.setTextColor(Color.RED);
            btnWorkout.setVisibility(View.VISIBLE);

        }else {
            dayFatCount.setTextColor(Color.BLACK);

        }

        btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WorkoutActivity.class));
            }
        });



    }
}