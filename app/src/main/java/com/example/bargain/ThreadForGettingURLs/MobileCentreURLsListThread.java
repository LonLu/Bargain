package com.example.bargain.ThreadForGettingURLs;

import com.example.bargain.Constants;
import com.example.bargain.get_URL_Lists.GetURLsFromMobileCentre;

import java.util.ArrayList;

public class MobileCentreURLsListThread implements Runnable {
    ArrayList<String> list_phone;
    ArrayList<String> list_tablet;
    ArrayList<String> list_notebook;

    @Override
    public void run() {
        GetURLsFromMobileCentre getURLsFromMobileCentre = new GetURLsFromMobileCentre();
        list_phone = getURLsFromMobileCentre.getUrlList_for_phone();
        list_tablet = getURLsFromMobileCentre.getUrlList_for_tablet();
        list_notebook = getURLsFromMobileCentre.getUrlList_for_notebook();
    }

    public ArrayList<String> getURLMobileCentre(String electronic_type){
        if (electronic_type.equals(Constants.PHONE)) return list_phone;
        if (electronic_type.equals(Constants.TABLET)) return list_tablet;
        if (electronic_type.equals(Constants.NOTEBOOK)) return list_notebook;
        return null;
    }
}

