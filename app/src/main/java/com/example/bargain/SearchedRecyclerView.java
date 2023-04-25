package com.example.bargain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchedRecyclerView extends RecyclerView.Adapter<SearchedRecyclerView.RecyclerViewExemplar> {
    int amount;

    public SearchedRecyclerView(int number){
        amount = number;
    }
    @NonNull
    @Override
    public RecyclerViewExemplar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int exemplarLayoutID = R.layout.recycler_view_exemplar;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(exemplarLayoutID, parent, false);
        RecyclerViewExemplar exemplar = new RecyclerViewExemplar(view);
        return exemplar;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewExemplar holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return amount;
    }

    static class RecyclerViewExemplar extends RecyclerView.ViewHolder{
        TextView textViewNumber;

        public RecyclerViewExemplar(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.textView);
        }

        public void bind(int listindex){
            textViewNumber.setText(String.valueOf(listindex));
        }
    }
}
