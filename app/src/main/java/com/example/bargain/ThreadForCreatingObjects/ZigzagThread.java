package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.Zigzag;
import com.example.bargain.ThreadForGettingURLs.ZigzagURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class ZigzagThread implements Runnable {
    ArrayList<String> zigzag_phone_url;
    ArrayList<String> zigzag_tablet_url;
    ArrayList<String> zigzag_notebook_url;
    Zigzag zigzag;
    DatabaseReference database_phone = FirebaseDatabase.getInstance().getReference(Constants.PHONE);
    DatabaseReference database_tablet = FirebaseDatabase.getInstance().getReference(Constants.TABLET);
    DatabaseReference database_notebook = FirebaseDatabase.getInstance().getReference(Constants.NOTEBOOK);
    @Override
    public void run() {
        ZigzagURLsListThread zigzagURLsListThread = new ZigzagURLsListThread();
        Thread thread = new Thread(zigzagURLsListThread);
        thread.start();
        try {
            thread.join();
            zigzag_phone_url = zigzagURLsListThread.getURLZigzag(Constants.PHONE);
            zigzag_tablet_url = zigzagURLsListThread.getURLZigzag(Constants.TABLET);
            zigzag_notebook_url = zigzagURLsListThread.getURLZigzag(Constants.NOTEBOOK);
        } catch (InterruptedException e) {
            Log.i("zigzag_phone", e.toString());
        }

        for (int i = 0; i < zigzag_phone_url.size(); i++){
            try {
                zigzag = new Zigzag(zigzag_phone_url.get(i));
                database_phone.push().setValue(zigzag);
            }catch (Exception ignored){
                Log.i("tenanqQani", ignored.toString());
            }
        }

        for (int i = 0; i < zigzag_tablet_url.size(); i++){
            try {
                zigzag = new Zigzag(zigzag_tablet_url.get(i));
                database_tablet.push().setValue(zigzag);
            }catch (Exception ignored){
                Log.i("tenanqQani", ignored.toString());
            }
        }

        for (int i = 0; i < zigzag_notebook_url.size(); i++){
            try {
                zigzag = new Zigzag(zigzag_notebook_url.get(i));
                database_notebook.push().setValue(zigzag);
            }catch (Exception ignored){
                Log.i("tenanqQani", ignored.toString());
            }
        }

    }
}
