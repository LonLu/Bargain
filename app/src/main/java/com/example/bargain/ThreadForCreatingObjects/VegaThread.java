package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.Vega;
import com.example.bargain.ThreadForGettingURLs.VegaURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class VegaThread implements Runnable {
    ArrayList<String> vega_phone_url;
    ArrayList<String> vega_tablet_url;
    ArrayList<String> vega_notebook_url;
    Vega vega;
    DatabaseReference database_phone = FirebaseDatabase.getInstance().getReference(Constants.PHONE);
    DatabaseReference database_tablet = FirebaseDatabase.getInstance().getReference(Constants.TABLET);
    DatabaseReference database_notebook = FirebaseDatabase.getInstance().getReference(Constants.NOTEBOOK);
    @Override
    public void run() {

        VegaURLsListThread vegaURLsListThread = new VegaURLsListThread();
        Thread thread = new Thread(vegaURLsListThread);
        thread.start();
        try {
            thread.join();
            vega_phone_url = vegaURLsListThread.getURLVega(Constants.PHONE);
            vega_tablet_url = vegaURLsListThread.getURLVega(Constants.TABLET);
            vega_notebook_url = vegaURLsListThread.getURLVega(Constants.NOTEBOOK);
        } catch (InterruptedException e) {
            Log.i("vega_phone", e.toString());
        }

        for (int i = 0; i < vega_phone_url.size(); i++){
            try {
                vega = new Vega(vega_phone_url.get(i));
                database_phone.push().setValue(vega);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < vega_tablet_url.size(); i++){
            try {
                vega = new Vega(vega_tablet_url.get(i));
                database_tablet.push().setValue(vega);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < vega_notebook_url.size(); i++){
            try {
                vega = new Vega(vega_notebook_url.get(i));
                database_notebook.push().setValue(vega);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

    }
}
