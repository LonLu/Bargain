package com.example.bargain;

public class MyThread implements Runnable {
    MobileCentre mobileCentre;
    @Override
    public void run() {
        MobileCentre mobileCentre = new MobileCentre("https://www.mobilecentre.am/product/samsung-galaxy-s23-128gb-_beige_/28568/");
        this.mobileCentre = mobileCentre;
    }

    public MobileCentre getMobileCentre(){
        return mobileCentre;
    }
}
