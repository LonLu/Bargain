package com.example.bargain.ThreadForGettingURLs;


import com.example.bargain.Constants;
import com.example.bargain.get_URL_Lists.GetURLsFromZigzag;
import java.util.ArrayList;

public class ZigzagURLsListThread implements Runnable {
    ArrayList<String> list_phone;
    ArrayList<String> list_tablet;
    ArrayList<String> list_notebook;

    @Override
    public void run() {
        GetURLsFromZigzag getURLsFromZigzag = new GetURLsFromZigzag();
        list_phone = getURLsFromZigzag.getUrlList_for_phone();
        list_tablet = getURLsFromZigzag.getUrlList_for_tablet();
        list_notebook = getURLsFromZigzag.getUrlList_for_notebook();
    }

    public ArrayList<String> getURLZigzag(String electronic_type){
        if (electronic_type.equals(Constants.PHONE)) return list_phone;
        if (electronic_type.equals(Constants.TABLET)) return list_tablet;
        if (electronic_type.equals(Constants.NOTEBOOK)) return list_notebook;
        return null;
    }
}
