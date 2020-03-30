package com.jerry.km3practical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class PreliminaryRecyclerAdapter extends RecyclerView.Adapter<PreliminaryRecyclerAdapter.MyViewHolder> {

    private ArrayList<PreliminaryTest> preliminaryTest;
    public PreliminaryRecyclerAdapter(ArrayList<PreliminaryTest> preliminaryTest){
        this.preliminaryTest = preliminaryTest;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView inferenceText, observationText;
        View view;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.cardView = itemView.findViewById(R.id.preCardView);
            this.inferenceText = itemView.findViewById(R.id.inferenceText);
            this.observationText = itemView.findViewById(R.id.observationText);

        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.preliminary_layout,parent,false);

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull PreliminaryRecyclerAdapter.MyViewHolder holder, int position) {

        PreliminaryTest preTest =  preliminaryTest.get(position);
        holder.inferenceText.setText(preTest.getInference());
        holder.observationText.setText(preTest.getObservation());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {

            return preliminaryTest.size();
    }
}
