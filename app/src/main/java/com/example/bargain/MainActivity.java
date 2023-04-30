package com.example.bargain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> YerevanMobileURL;
    DatabaseReference database;
    SearchedRecyclerView searchedRecyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        adapter = new SearchedRecyclerView(100);
//        recyclerView.setAdapter(adapter);

        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Log.i("miBan", e.toString());
        }

//        database.push().setValue(myThread.getVega());
//        database.push().setValue(myThread.getMobileCentre());
        database.push().setValue(myThread.getZigzag());


    }
    public void init(){
        database = FirebaseDatabase.getInstance().getReference();
    }


}


