package com.example.bargain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShowView extends RecyclerView.Adapter<ShowView.RecyclerViewExemplar> {
    List<Product> product_list;

    public ShowView(List<Product> product_list){
        this.product_list = product_list;
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
        Product product = product_list.get(position);
        holder.sName.setText(product.getName());
        holder.sPrice.setText(product.getCash_Price());
    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public static class RecyclerViewExemplar extends RecyclerView.ViewHolder{
        TextView sName;
        TextView sPrice;
        public RecyclerViewExemplar(@NonNull View itemView) {
            super(itemView);
            sName = itemView.findViewById(R.id.tv_setName);
            sPrice = itemView.findViewById(R.id.tv_setPrice);
        }
    }
}
