package com.example.cholesterolcontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.myViewHolder> {
    List<Test> test;
    public AdapterTest(List<Test>test){
        this.test=test;
    }
    @NonNull
    @Override
    public AdapterTest.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.test_card,parent,false);

        return new AdapterTest.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTest.myViewHolder holder, int position) {
        holder.date.setText("Date\n\n"+test.get(position).getDateTest());
        holder.general.setText("General\n\n"+String.valueOf(test.get(position).getGeneral()));
        holder.hdl.setText("HDL\n\n"+String.valueOf(test.get(position).getHdl()));
        holder.ldl.setText("LDL\n\n"+String.valueOf(test.get(position).getLdl()));
        holder.triglycerides.setText("Triglycerides\n\n"+String.valueOf(test.get(position).getTriglycerides()));

    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView date,general,hdl,ldl,triglycerides;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.dateTest);
            general=itemView.findViewById(R.id.general);
            hdl=itemView.findViewById(R.id.hdl);
            ldl=itemView.findViewById(R.id.ldl);
            triglycerides=itemView.findViewById(R.id.triglycerides);
        }
    }
}
