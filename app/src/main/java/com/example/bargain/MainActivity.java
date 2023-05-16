package com.example.bargain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.xmlpull.v1.sax2.Driver;


public class MainActivity extends AppCompatActivity {
    ImageButton phone;
    ImageButton tablet;
    ImageButton notebook;
    ImageButton accessories;
    ImageButton home;
    ImageButton wait;
    ImageButton settings;
    Intent phone_intent;
    Intent tablet_intent;
    Intent notebook_intent;
    Intent accessories_intent;
    Intent home_intent;
    Intent wait_intent;
    Intent settings_intent;


    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            Log.i("miBan", e.toString());
//        }

//        database.push().setValue(myThread.getVega());
//        database.push().setValue(myThread.getMobileCentre());
//        database.push().setValue(myThread.getZigzag());


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(phone_intent);
            }
        });



    }
    public void init(){
        database = FirebaseDatabase.getInstance().getReference();

        phone = (ImageButton) findViewById(R.id.btnImg_phone);
        tablet = (ImageButton) findViewById(R.id.btnImg_tablet);
        notebook = (ImageButton) findViewById(R.id.btnImg_notebook);
        accessories = (ImageButton) findViewById(R.id.btnImg_accessory) ;
        home = (ImageButton) findViewById(R.id.btnImg_home);
        wait = (ImageButton) findViewById(R.id.btnImg_wait);
        settings = (ImageButton) findViewById(R.id.btnImg_settings);

        phone_intent = new Intent(this, RecyclerViewActivity.class);
        tablet_intent = new Intent(this, RecyclerViewActivity.class);
        notebook_intent = new Intent(this, RecyclerViewActivity.class);
        accessories_intent = new Intent(this, RecyclerViewActivity.class);

        home_intent = new Intent(this, MainActivity.class);

    }


}


