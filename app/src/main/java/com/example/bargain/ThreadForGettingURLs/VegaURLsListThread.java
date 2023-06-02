package com.example.bargain.ThreadForGettingURLs;

import com.example.bargain.Constants;
import com.example.bargain.get_URL_Lists.GetURLsFromVega;
import java.util.ArrayList;

public class VegaURLsListThread implements Runnable {
    ArrayList<String> list_phone;
    ArrayList<String> list_tablet;
    ArrayList<String> list_notebook;

    @Override
    public void run() {
        GetURLsFromVega getURLsFromVega = new GetURLsFromVega();
        list_phone = getURLsFromVega.getUrlList_for_phone();
        list_tablet = getURLsFromVega.getUrlList_for_tablet();
        list_notebook = getURLsFromVega.getUrlList_for_notebook();
    }

    public ArrayList<String> getURLVega(String electronic_type){
        if (electronic_type.equals(Constants.PHONE)) return list_phone;
        if (electronic_type.equals(Constants.TABLET)) return list_tablet;
        if (electronic_type.equals(Constants.NOTEBOOK)) return list_notebook;
        return null;
    }
}
