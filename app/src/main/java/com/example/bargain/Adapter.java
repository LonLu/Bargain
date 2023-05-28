package com.example.bargain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bargain.Activities.MainActivity;
import com.example.bargain.Activities.RecyclerViewActivity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewExemplar> {
    List<Product> product_list;


    public Adapter(List<Product> product_list){
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
        String img_url = product.getImage();
        Glide.with(holder.itemView.getContext()).load(img_url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public void filterList(List<Product> filteredList) {
        this.product_list = filteredList;
        notifyDataSetChanged();
    }


    public static class RecyclerViewExemplar extends RecyclerView.ViewHolder{
        TextView sName;
        TextView sPrice;
        ImageView imageView;
        public RecyclerViewExemplar(@NonNull View itemView) {
            super(itemView);
            sName = itemView.findViewById(R.id.tv_setName);
            sPrice = itemView.findViewById(R.id.tv_setPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
