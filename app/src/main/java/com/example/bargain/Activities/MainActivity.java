package com.example.bargain.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bargain.Creating_Objects_From_Shops.YerevanMobile;
import com.example.bargain.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    ImageButton phone;
    ImageButton tablet;
    ImageButton notebook;
    ImageButton accessories;
    Intent phone_intent;
    Intent tablet_intent;
    Intent notebook_intent;
    Intent accessories_intent;


    DatabaseReference database;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(phone_intent);
            }
        });

//        VegaThread vegaThread = new VegaThread();
//        Thread thread_vega = new Thread(vegaThread);
//        thread_vega.start();
//
//        MobileCentreThread mobileCentreThread = new MobileCentreThread();
//        Thread thread_mobileCentre = new Thread(mobileCentreThread);
//        thread_mobileCentre.start();
//
//        ZigzagThread zigzagThread = new ZigzagThread();
//        Thread thread_zigzag = new Thread(zigzagThread);
//        thread_zigzag.start();

    }


    public void init(){
        database = FirebaseDatabase.getInstance().getReference();

        searchView = (SearchView) findViewById(R.id.search);

        phone = (ImageButton) findViewById(R.id.btnImg_phone);
        tablet = (ImageButton) findViewById(R.id.btnImg_tablet);
        notebook = (ImageButton) findViewById(R.id.btnImg_notebook);
        accessories = (ImageButton) findViewById(R.id.btnImg_accessory) ;

        phone_intent = new Intent(this, RecyclerViewActivity.class);
        tablet_intent = new Intent(this, RecyclerViewActivity.class);
        notebook_intent = new Intent(this, RecyclerViewActivity.class);
        accessories_intent = new Intent(this, RecyclerViewActivity.class);


//        getFromYerevanMobile();

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // Размеры доступны здесь
            int width = phone.getWidth();
            int height = phone.getHeight();
            Log.i("parameterss", width + " " + height);
        }
    }



    public void getFromYerevanMobile(){

        int firstIndex = 0;
        int secondIndex = 0;
        boolean firstBool = true;
        int exceptionCounter = 0;
        while (firstBool){
            try {
                YerevanMobile yerevanMobile = new YerevanMobile(this, firstIndex, secondIndex);
                database.push().setValue(yerevanMobile);
                secondIndex++;
                exceptionCounter = 0;
            }catch (Exception e){
                firstIndex++;
                secondIndex = 0;
                exceptionCounter++;
                if(exceptionCounter == 2) firstBool = false;
            }
        }
    }

}


