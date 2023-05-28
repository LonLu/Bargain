package com.example.bargain.ThreadForGettingURLs;

import com.example.bargain.get_URL_Lists.GetURLsFromVega;
import java.util.ArrayList;

public class VegaURLsListThread implements Runnable {
    ArrayList<String> list;

    @Override
    public void run() {
        GetURLsFromVega getURLsFromVega = new GetURLsFromVega();
        list = getURLsFromVega.getUrlList_for_phone();
    }

    public ArrayList<String> getURLVega(){
        return list;
    }
}
