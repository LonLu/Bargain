package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;
import com.example.bargain.Creating_Objects_From_Shops.Vega;
import com.example.bargain.ThreadForGettingURLs.VegaURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class VegaThread implements Runnable {
    ArrayList<String> vega_phone_url;
    Vega vega;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Phones");
    @Override
    public void run() {

        VegaURLsListThread vegaURLsListThread = new VegaURLsListThread();
        Thread thread = new Thread(vegaURLsListThread);
        thread.start();
        try {
            thread.join();
            vega_phone_url = vegaURLsListThread.getURLVega();
        } catch (InterruptedException e) {
            Log.i("vega_phone", e.toString());
        }

        for (int i = 0; i < vega_phone_url.size(); i++){
            vega = new Vega(vega_phone_url.get(i));
            databaseReference.push().setValue(vega);
        }
    }
}
