package com.example.bargain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class ShowView extends RecyclerView.Adapter<ShowView.RecyclerViewExemplar> {
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
        return 17;
    }

    static class RecyclerViewExemplar extends RecyclerView.ViewHolder{

        TextView setName, setPrice;
        DatabaseReference database;
        ArrayList<String> price_list = new ArrayList<>();
        ArrayList<String> name_list = new ArrayList<>();

        public RecyclerViewExemplar(@NonNull View itemView) {
            super(itemView);
            setName = itemView.findViewById(R.id.tv_setName);
            setPrice = itemView.findViewById(R.id.tv_setPrice);
            database = FirebaseDatabase.getInstance().getReference();
        }

        public void bind(int listIndex) {
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (price_list.size() > 0) price_list.clear();
                    if(name_list.size() > 0) name_list.clear();
                    for (DataSnapshot ds: snapshot.getChildren()){
                        Product product = ds.getValue(Product.class);
                        assert product != null;
                        price_list.add(product.Cash_Price);
                        name_list.add(product.Name);
                    }
                    setPrice.setText(price_list.get(listIndex));
                    setName.setText(name_list.get(listIndex));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

        }
    }
}
