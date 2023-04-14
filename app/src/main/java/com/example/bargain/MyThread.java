package com.example.bargain;

public class MyThread implements Runnable {
    YerevanMobile yerevanMobile;
    @Override
    public void run() {
        yerevanMobile = new YerevanMobile("https://yerevanmobile.am/am/apple-macbook-pro-13-m1-8gb-ram-256gb-ssd-myd82-space-grey.html");
    }

    public YerevanMobile GetYerevanMobile(){
        return yerevanMobile;
    }
}
