package com.example.bargain;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class MyThread implements Runnable {
    Vega vega;
    MobileCentre mobileCentre;
    Zigzag zigzag;
    YerevanMobile yerevanMobile;
    @Override
    public void run() {
//        vega = new Vega("https://vega.am/am/smart-herhakhos-realme-c25y-4gb-128gb-rmx3269-bl.html");
//        mobileCentre = new MobileCentre("https://www.mobilecentre.am/product/samsung-galaxy-a23-64gb-_peach_/27120/");
//        zigzag = new Zigzag("https://www.zigzag.am/am/xiaomi-redmi-9a-2gb-32gb-midnight-black.html");
    }

    public Vega getVega(){
        return vega;
    }
    public MobileCentre getMobileCentre(){
        return mobileCentre;
    }
    public Zigzag getZigzag(){
        return zigzag;
    }
}
