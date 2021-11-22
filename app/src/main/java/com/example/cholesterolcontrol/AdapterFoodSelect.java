package com.example.cholesterolcontrol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterFoodSelect extends RecyclerView.Adapter<AdapterFoodSelect.myViewHolder> {
    Context context;
    ArrayList<String>arrayList;
    FoodQuantityListener foodQuantityListener;

    int totalCount=0;
    int count=0;

    public AdapterFoodSelect(Context context, ArrayList<String> arrayList, FoodQuantityListener foodQuantityListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.foodQuantityListener = foodQuantityListener;
    }




    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_check_box,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.checkBox.setText(arrayList.get(position));
        holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                count=progress;
               holder.countText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

         holder.checkBox.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (holder.checkBox.isChecked()&&holder.countText.getText().toString().equals("0 gram"))
                 {
                     Toast.makeText(context,"Select Quantity first...",Toast.LENGTH_LONG).show();
                     holder.checkBox.setChecked(false);
                 } else {
                     totalCount = totalCount + count;
                 }

                 foodQuantityListener.onFoodQuantityChange(totalCount);


             }
         });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        SeekBar seekBar;
        TextView countText;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.checkBtn);
            seekBar=itemView.findViewById(R.id.seekBar);
            countText=itemView.findViewById(R.id.count);
        }
    }
}

