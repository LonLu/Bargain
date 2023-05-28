package com.example.bargain.ThreadForCreatingObjects;

import android.util.Log;
import com.example.bargain.Creating_Objects_From_Shops.MobileCentre;
import com.example.bargain.ThreadForGettingURLs.MobileCentreURLsListThread;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class MobileCentreThread implements Runnable {
    ArrayList<String> mobileCentre_phone_url;
    MobileCentre mobileCentre;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Phones");
    @Override
    public void run() {

        MobileCentreURLsListThread mobileCentreURLsListThread = new MobileCentreURLsListThread();
        Thread thread = new Thread(mobileCentreURLsListThread);
        thread.start();
        try {
            thread.join();
            mobileCentre_phone_url = mobileCentreURLsListThread.getURLMobileCentre();
        } catch (InterruptedException e) {
            Log.i("mobileCentre_phone", e.toString());
        }

        for (int i = 0; i < mobileCentre_phone_url.size(); i++){
            mobileCentre = new MobileCentre(mobileCentre_phone_url.get(i));
            databaseReference.push().setValue(mobileCentre);
        }
    }
}
