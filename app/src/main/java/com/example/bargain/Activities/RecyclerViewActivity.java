package com.example.bargain.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargain.Adapter;
import com.example.bargain.Constants;
import com.example.bargain.Product;
import com.example.bargain.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    Adapter adapter;
    RecyclerView recyclerView;
    ValueEventListener valueEventListener;
    DatabaseReference database;
    List<Product> products;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        searchView = (SearchView) findViewById(R.id.search);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        products = new ArrayList<>();
        adapter = new Adapter(products, getApplicationContext());
        recyclerView.setAdapter(adapter);

        String extra_from_intent = getIntent().getStringExtra(Constants.EXTRA);
        database = FirebaseDatabase.getInstance().getReference(extra_from_intent);

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.onActionViewExpanded();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterItems(newText);
                return true;
            }
        });
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                products.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Product product = dataSnapshot.getValue(Product.class);
                    products.add(product);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        database.addValueEventListener(valueEventListener);
    }

    private void filterItems(String searchText) {
        List<Product> filteredList = new ArrayList<>();
        for (Product item : products) {
            if (item.getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(item);
            }
        }

//        filteredList = sort(filteredList);
        adapter.filterList(filteredList);
    }

//    public List<Product> sort(List<Product> product_list){
//        for (int i = 0; i < product_list.size() - 1; i++){
//            for (int j = 0; j < product_list.size() - i - 1; j++){
//                if (product_list.get(j).getCash_Price() != null && product_list.get(j+1).getCash_Price() != null && product_list.get(j).getUrl() != null && product_list.get(j+1).getUrl() != null){
//                    if (product_list.get(j).get_int_price(product_list.get(j).getUrl(), product_list.get(j).getCash_Price())
//                            > product_list.get(j+1).get_int_price(product_list.get(j+1).getUrl(), product_list.get(j+1).getCash_Price())){
//                        Product product = product_list.get(j);
//                        product_list.set(j, product_list.get(j+1));
//                        product_list.set(j+1, product);
//                    }
//                }
//            }
//        }
//        return product_list;
//    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.removeEventListener(valueEventListener);
    }
}

