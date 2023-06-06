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

    ArrayList<MobileCentre> mobileCentre_phones = new ArrayList<>();
    ArrayList<MobileCentre> mobileCentre_tablets = new ArrayList<>();
    ArrayList<MobileCentre> mobileCentre_notebooks = new ArrayList<>();
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
                mobileCentre_phones.add(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < mobileCentre_tablet_url.size(); i++){
            try{
                mobileCentre = new MobileCentre(mobileCentre_tablet_url.get(i));
                mobileCentre_tablets.add(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }

        for (int i = 0; i < mobileCentre_notebook_url.size(); i++){
            try{
                mobileCentre = new MobileCentre(mobileCentre_notebook_url.get(i));
                mobileCentre_notebooks.add(mobileCentre);
            }catch (Exception ignored){Log.i("tenanqQani", ignored.toString());}
        }
    }

    public ArrayList<MobileCentre> getMobileCentre_phones() {
        return mobileCentre_phones;
    }

    public ArrayList<MobileCentre> getMobileCentre_tablets() {
        return mobileCentre_tablets;
    }

    public ArrayList<MobileCentre> getMobileCentre_notebooks() {
        return mobileCentre_notebooks;
    }
}
