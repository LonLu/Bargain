package com.example.bargain;

public class MyThread implements Runnable {
    Vega vega;
    @Override
    public void run() {
        vega = new Vega("https://vega.am/am/smart-herhakhos-samsung-galaxy-a04s-sm-a047fds-3gb-32gb-bk.html");
    }

    public Vega getVega(){
        return vega;
    }
}
