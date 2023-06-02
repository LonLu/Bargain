package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.MobileCentre;
import com.example.bargain.ThreadForGettingURLs.MobileCentreURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class MobileCentreThread implements Runnable {
    ArrayList<String> mobileCentre_phone_url;
    ArrayList<String> mobileCentre_tablet_url;
    ArrayList<String> mobileCentre_notebook_url;
    MobileCentre mobileCentre;
    DatabaseReference database_phone = FirebaseDatabase.getInstance().getReference(Constants.PHONE);
    DatabaseReference database_tablet = FirebaseDatabase.getInstance().getReference(Constants.TABLET);
    DatabaseReference database_notebook = FirebaseDatabase.getInstance().getReference(Constants.NOTEBOOK);
    @Override
    public void run() {

        MobileCentreURLsListThread mobileCentreURLsListThread = new MobileCentreURLsListThread();
        Thread thread = new Thread(mobileCentreURLsListThread);
        thread.start();
        try {
            thread.join();
            mobileCentre_phone_url = mobileCentreURLsListThread.getURLMobileCentre(Constants.PHONE);
            mobileCentre_tablet_url = mobileCentreURLsListThread.getURLMobileCentre(Constants.TABLET);
            mobileCentre_notebook_url = mobileCentreURLsListThread.getURLMobileCentre(Constants.NOTEBOOK);
        } catch (InterruptedException e) {
            Log.i("mobileCentre_phone", e.toString());
        }

        for (int i = 0; i < mobileCentre_phone_url.size(); i++){
            try{
                mobileCentre = new MobileCentre(mobileCentre_phone_url.get(i));
                database_phone.push().setValue(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < mobileCentre_tablet_url.size(); i++){
            try{
                mobileCentre = new MobileCentre(mobileCentre_tablet_url.get(i));
                database_tablet.push().setValue(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < mobileCentre_notebook_url.size(); i++){
            try{
                mobileCentre = new MobileCentre(mobileCentre_notebook_url.get(i));
                database_notebook.push().setValue(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }
    }
}
