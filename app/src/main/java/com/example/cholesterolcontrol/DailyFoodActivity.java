package com.example.cholesterolcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DailyFoodActivity extends AppCompatActivity implements FoodQuantityListener {
    private RecyclerView recyclerView;
    AdapterFoodSelect adapterFoodSelect;
    Button submit;
    EditText date;
    int counter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_food);

        submit=findViewById(R.id.btnSubmit);
        recyclerView=findViewById(R.id.recycleFoodSelect);
        date=findViewById(R.id.date);

        setRecyclerView();

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(date.getText().toString().isEmpty()){
                  Toast.makeText(DailyFoodActivity.this,"Enter Date...",Toast.LENGTH_LONG).show();
             }else {
                        Intent intent = new Intent(getApplicationContext(), DayResultActivity.class);
                        intent.putExtra("result", counter);
                        intent.putExtra("date", date.getText().toString());
                        startActivity(intent);
                    }
                }
            });



    }
    private ArrayList<String>getFoodData(){
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Egg");
        arrayList.add("Cheese");
        arrayList.add("Full Fat Yogurt");
        arrayList.add("Fried Food");
        arrayList.add("Fast Food");
        arrayList.add("Desserts");
        return arrayList;
    }
    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterFoodSelect=new AdapterFoodSelect(this,getFoodData(),this);
        recyclerView.setAdapter(adapterFoodSelect);
    }

    @Override
    public void onFoodQuantityChange(int totalCount) {
        counter=totalCount;
    }
}