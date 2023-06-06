package com.example.bargain.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.YerevanMobile;
import com.example.bargain.Product;
import com.example.bargain.R;
import com.example.bargain.ThreadForCreatingObjects.MobileCentreThread;
import com.example.bargain.ThreadForCreatingObjects.VegaThread;
import com.example.bargain.ThreadForCreatingObjects.YerevanMobileThread;
import com.example.bargain.ThreadForCreatingObjects.ZigzagThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {
    ImageButton phone;
    ImageButton tablet;
    ImageButton notebook;

    Intent phone_intent;
    Intent tablet_intent;
    Intent notebook_intent;
    SearchView searchView;

    DatabaseReference database_phone = FirebaseDatabase.getInstance().getReference(Constants.PHONE);
    DatabaseReference database_tablet = FirebaseDatabase.getInstance().getReference(Constants.TABLET);
    DatabaseReference database_notebook = FirebaseDatabase.getInstance().getReference(Constants.NOTEBOOK);


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
//
//
//        Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                if (!thread_vega.isAlive() && !thread_zigzag.isAlive() && !thread_mobileCentre.isAlive() && !thread_yerevanMobile.isAlive()){
//                    ArrayList<Product> all_phones = new ArrayList<>();
//                    all_phones.addAll(yerevanMobileThread.getYerevanMobile_phones());
//                    all_phones.addAll(mobileCentreThread.getMobileCentre_phones());
//                    all_phones.addAll(zigzagThread.getZigzag_phones());
//                    all_phones.addAll(vegaThread.getVega_phones());
//                    all_phones = getAvailable(all_phones);
//                    all_phones.sort(Comparator.comparingInt(Product::getInt_price));
//                    for(int i = 0; i < all_phones.size(); i++){
//                        database_phone.push().setValue(all_phones.get(i));
//                    }
//
//                    ArrayList<Product> all_tablets = new ArrayList<>();
//                    all_tablets.addAll(yerevanMobileThread.getYerevanMobile_tablets());
//                    all_tablets.addAll(mobileCentreThread.getMobileCentre_tablets());
//                    all_tablets.addAll(zigzagThread.getZigzag_tablets());
//                    all_tablets.addAll(vegaThread.getVega_tablets());
//                    all_tablets = getAvailable(all_tablets);
//                    all_tablets.sort(Comparator.comparingInt(Product::getInt_price));
//                    for (int i = 0; i < all_tablets.size(); i++){
//                        database_tablet.push().setValue(all_tablets.get(i));
//                    }
//
//                    ArrayList<Product> all_notebooks = new ArrayList<>();
//                    all_notebooks.addAll(yerevanMobileThread.getYerevanMobile_notebooks());
//                    all_notebooks.addAll(mobileCentreThread.getMobileCentre_notebooks());
//                    all_notebooks.addAll(zigzagThread.getZigzag_notebooks());
//                    all_notebooks.addAll(vegaThread.getVega_notebooks());
//                    all_notebooks = getAvailable(all_notebooks);
//                    all_notebooks.sort(Comparator.comparingInt(Product::getInt_price));
//                    for (int i = 0; i < all_notebooks.size(); i++){
//                        database_notebook.push().setValue(all_notebooks.get(i));
//                    }
//
//                    handler.removeCallbacks(this);
//                    Log.i("thread_finished", "thread finished");
//                }
//                else{
//                    Log.i("thread_finished", "thread_alive");
//                    handler.postDelayed(this, 10000);
//                }
//
//            }
//        };
//
//        handler.postDelayed(runnable, 2000);

    }

    public ArrayList<Product> getAvailable(ArrayList<Product> product_list){
        ArrayList<Product> available_product = new ArrayList<>();
        for (int i = 0; i < product_list.size(); i++){
            if (product_list.get(i).isAvailability()) available_product.add(product_list.get(i));
        }
        return available_product;
    }


    public void init(){
        searchView = (SearchView) findViewById(R.id.search);

        phone = (ImageButton) findViewById(R.id.btnImg_phone);
        tablet = (ImageButton) findViewById(R.id.btnImg_tablet);
        notebook = (ImageButton) findViewById(R.id.btnImg_notebook);

        phone_intent = new Intent(this, RecyclerViewActivity.class);
        tablet_intent = new Intent(this, RecyclerViewActivity.class);
        notebook_intent = new Intent(this, RecyclerViewActivity.class);

        Glide.with(this).load(R.drawable.phone_assortment).fitCenter()
                .skipMemoryCache(true).into(phone);
        Glide.with(this).load(R.drawable.big_tablet).fitCenter()
                .skipMemoryCache(true).into(tablet);
        Glide.with(this).load(R.drawable.notebook_assortment).fitCenter()
                .skipMemoryCache(true).into(notebook);
    }

}


