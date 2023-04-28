package com.example.bargain;

public class MyThread implements Runnable {
    MobileCentre mobileCentre;
    @Override
    public void run() {
        mobileCentre = new MobileCentre("https://www.mobilecentre.am/product/apple-ipad-pro-11-wi-fi-256gb-_2022_-silver/28211/");
    }

    public MobileCentre getMobileCentre(){
        return mobileCentre;
    }
}
