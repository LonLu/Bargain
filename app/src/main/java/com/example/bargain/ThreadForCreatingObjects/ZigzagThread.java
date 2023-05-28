package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;
import com.example.bargain.Creating_Objects_From_Shops.Zigzag;
import com.example.bargain.ThreadForGettingURLs.ZigzagURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class ZigzagThread implements Runnable {
    ArrayList<String> zigzag_phone_url;
    Zigzag zigzag;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Phones");
    @Override
    public void run() {
        ZigzagURLsListThread zigzagURLsListThread = new ZigzagURLsListThread();
        Thread thread = new Thread(zigzagURLsListThread);
        thread.start();
        try {
            thread.join();
            zigzag_phone_url = zigzagURLsListThread.getURLZigzag();
        } catch (InterruptedException e) {
            Log.i("zigzag_phone", e.toString());
        }

        for (int i = 0; i < zigzag_phone_url.size(); i++){
            zigzag = new Zigzag(zigzag_phone_url.get(i));
            databaseReference.push().setValue(zigzag);
        }
    }
}
