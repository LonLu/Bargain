package com.example.bargain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        if (product.isExpanded()) {
            holder.additional_info.setImageResource(R.drawable.baseline_arrow_drop_up_24);
            if (product.getName() != null){
                holder.name.setText(product.getName());
                holder.name.setVisibility(View.VISIBLE);
            }
            if (product.getCash_Price() != null){
                holder.cash_Price.setText(product.getCash_Price());
                holder.cash_Price.setVisibility(View.VISIBLE);
            }
            if (product.getNot_Cash_Price() != null){
                holder.not_Cash_Price.setText(product.getNot_Cash_Price());
                holder.not_Cash_Price.setVisibility(View.VISIBLE);
            }
            if (product.getRelease_Date() != null){
                holder.release_Date.setText(product.getRelease_Date());
                holder.release_Date.setVisibility(View.VISIBLE);
            }
            if (product.getGuarantee() != null){
                holder.guarantee.setText(product.getGuarantee());
                holder.guarantee.setVisibility(View.VISIBLE);
            }
            if (product.getProcessor() != null){
                holder.processor.setText(product.getProcessor());
                holder.processor.setVisibility(View.VISIBLE);
            }
            if (product.getOs() != null){
                holder.os.setText(product.getOs());
                holder.os.setVisibility(View.VISIBLE);
            }
            if (product.getMemory() != null){
                holder.memory.setText(product.getMemory());
                holder.memory.setVisibility(View.VISIBLE);
            }
            if (product.getMemory_Type() != null){
                holder.memory_Type.setText(product.getMemory_Type());
                holder.memory_Type.setVisibility(View.VISIBLE);
            }
            if (product.getRam() != null){
                holder.ram.setText(product.getRam());
                holder.ram.setVisibility(View.VISIBLE);
            }
            if (product.getScreen_Length() != null){
                holder.screen_Length.setText(product.getScreen_Length());
                holder.screen_Length.setVisibility(View.VISIBLE);
            }
            if (product.getCamera() != null){
                holder.camera.setText(product.getCamera());
                holder.camera.setVisibility(View.VISIBLE);
            }
            if (product.getSim() != null){
                holder.sim.setText(product.getSim());
                holder.sim.setVisibility(View.VISIBLE);
            }
            if (product.getUrl() != null){
                holder.url.setText(product.getUrl());
                holder.url.setVisibility(View.VISIBLE);
            }


        } else {
            holder.additional_info.setImageResource(R.drawable.baseline_arrow_drop_down_24);
            holder.name.setVisibility(View.GONE);
            holder.cash_Price.setVisibility(View.GONE);
            holder.not_Cash_Price.setVisibility(View.GONE);
            holder.release_Date.setVisibility(View.GONE);
            holder.guarantee.setVisibility(View.GONE);
            holder.processor.setVisibility(View.GONE);
            holder.os.setVisibility(View.GONE);
            holder.memory.setVisibility(View.GONE);
            holder.memory_Type.setVisibility(View.GONE);
            holder.ram.setVisibility(View.GONE);
            holder.screen_Length.setVisibility(View.GONE);
            holder.camera.setVisibility(View.GONE);
            holder.sim.setVisibility(View.GONE);
            holder.url.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return product_list.size();
    }

    public void filterList(List<Product> filteredList) {
        this.product_list = filteredList;
        notifyDataSetChanged();
    }


    public class RecyclerViewExemplar extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView sName;
        private TextView sPrice;
        private ImageView imageView;

        private ImageView additional_info;

        private TextView name, cash_Price, not_Cash_Price, release_Date, guarantee, processor, os, memory,
                memory_Type, ram, screen_Length, camera, url, sim;
        public RecyclerViewExemplar(@NonNull View itemView) {
            super(itemView);
            sName = itemView.findViewById(R.id.tv_setName);
            sPrice = itemView.findViewById(R.id.tv_setPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            additional_info = (ImageView) itemView.findViewById(R.id.btn_additional);
            itemView.setOnClickListener(this);
            additional_info.setOnClickListener(this);

            name = itemView.findViewById(R.id.product_name);
            cash_Price = itemView.findViewById(R.id.product_cash_price);
            not_Cash_Price = itemView.findViewById(R.id.product_not_cash_price);
            release_Date = itemView.findViewById(R.id.product_release_date);
            guarantee = itemView.findViewById(R.id.product_guarantee);
            processor = itemView.findViewById(R.id.product_processor);
            os = itemView.findViewById(R.id.product_os);
            memory = itemView.findViewById(R.id.product_memory);
            memory_Type = itemView.findViewById(R.id.product_memory_type);
            ram = itemView.findViewById(R.id.product_ram);
            screen_Length = itemView.findViewById(R.id.product_screen_length);
            camera = itemView.findViewById(R.id.product_camera);
            sim = itemView.findViewById(R.id.product_sim);
            url = itemView.findViewById(R.id.product_url);
        }


        @Override
        public void onClick(View view) {
            if (view == additional_info){
                int position = getAdapterPosition();
                Product product = product_list.get(position);
                product.setExpanded(!product.isExpanded());
                notifyDataSetChanged();
            }
        }
    }
}
