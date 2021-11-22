package com.example.cholesterolcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFetchDay extends RecyclerView.Adapter<AdapterFetchDay.myViewHolder> {
    List<Day>day;
    public AdapterFetchDay(List<Day>day){
        this.day=day;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.day_card,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.date.setText("Date\n"+day.get(position).getDate());
        holder.count.setText("Fat Intake\n"+String.valueOf(day.get(position).getDayCount()));
    }

    @Override
    public int getItemCount() {
        return day.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView date,count;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.dateDay);
            count=itemView.findViewById(R.id.countDay);
        }
    }
}
