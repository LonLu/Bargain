package com.example.bargain;

public class MyThread implements Runnable {
    Vega vega;
    MobileCentre mobileCentre;
    Zigzag zigzag;
    @Override
    public void run() {
//        vega = new Vega("https://vega.am/am/smart-herhakhos-samsung-galaxy-a23-sm-a235fdsn-4gb-64gb-peach.html");
//        mobileCentre = new MobileCentre("https://www.mobilecentre.am/product/samsung-galaxy-a23-64gb-_peach_/27120/");
        zigzag = new Zigzag("https://www.zigzag.am/am/xiaomi-redmi-9a-2gb-32gb-midnight-black.html");
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
