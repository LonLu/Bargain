package com.example.bargain.ThreadForGettingURLs;

import com.example.bargain.get_URL_Lists.GetURLsFromMobileCentre;
import com.example.bargain.get_URL_Lists.GetURLsFromVega;
import java.util.ArrayList;

public class MobileCentreURLsListThread implements Runnable {
    ArrayList<String> list;

    @Override
    public void run() {
        GetURLsFromMobileCentre getURLsFromMobileCentre = new GetURLsFromMobileCentre();
        list = getURLsFromMobileCentre.getUrlList_for_phone();
    }

    public ArrayList<String> getURLMobileCentre(){
        return list;
    }
}

