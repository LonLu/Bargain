package com.example.bargain.ThreadForGettingURLs;


import com.example.bargain.get_URL_Lists.GetURLsFromZigzag;
import java.util.ArrayList;

public class ZigzagURLsListThread implements Runnable {
    ArrayList<String> list;

    @Override
    public void run() {
        GetURLsFromZigzag getURLsFromZigzag = new GetURLsFromZigzag();
        list = getURLsFromZigzag.getUrlList_for_phone();
    }

    public ArrayList<String> getURLZigzag(){
        return list;
    }
}
