package com.example.bargain.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.YerevanMobile;
import com.example.bargain.R;
import com.example.bargain.ThreadForCreatingObjects.MobileCentreThread;
import com.example.bargain.ThreadForCreatingObjects.VegaThread;
import com.example.bargain.ThreadForCreatingObjects.YerevanMobileThread;
import com.example.bargain.ThreadForCreatingObjects.ZigzagThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    ImageButton phone;
    ImageButton tablet;
    ImageButton notebook;

    Intent phone_intent;
    Intent tablet_intent;
    Intent notebook_intent;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_intent.putExtra(Constants.EXTRA, Constants.PHONE);
                startActivity(phone_intent);
            }
        });

        tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tablet_intent.putExtra(Constants.EXTRA, Constants.TABLET);
                startActivity(tablet_intent);
            }
        });

        notebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notebook_intent.putExtra(Constants.EXTRA, Constants.NOTEBOOK);
                startActivity(notebook_intent);
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
//
//        YerevanMobileThread yerevanMobileThread = new YerevanMobileThread(this);
//        Thread thread_yerevanMobile = new Thread(yerevanMobileThread);
//        thread_yerevanMobile.start();

    }


    public void init(){
        searchView = (SearchView) findViewById(R.id.search);

        phone = (ImageButton) findViewById(R.id.btnImg_phone);
        tablet = (ImageButton) findViewById(R.id.btnImg_tablet);
        notebook = (ImageButton) findViewById(R.id.btnImg_notebook);

        phone_intent = new Intent(this, RecyclerViewActivity.class);
        tablet_intent = new Intent(this, RecyclerViewActivity.class);
        notebook_intent = new Intent(this, RecyclerViewActivity.class);


    }

}


