package com.example.bargain;

public class Product {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory,
            memory_Type, ram, screen_Length, camera, url, sim;
//    public boolean Availability;

    public Product(){}

    public Product(String name, String cash_Price){
        this.name = name;
        this.cash_Price = cash_Price;
    }


    public String getName() {
        return name;
    }

    public String getCash_Price() {
        return cash_Price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCash_Price(String cash_Price) {
        this.cash_Price = cash_Price;
    }
//    public String getNot_Cash_Price() {
//        return Not_Cash_Price;
//    }
//
//    public String getImage() {
//        return Image;
//    }
//
//    public String getRelease_Date() {
//        return Release_Date;
//    }
//
//    public String getGuarantee() {
//        return Guarantee;
//    }
//
//    public String getProcessor() {
//        return Processor;
//    }
//
//    public String getOS() {
//        return OS;
//    }
//
//    public String getMemory() {
//        return Memory;
//    }
//
//    public String getMemory_Type() {
//        return Memory_Type;
//    }
//
//    public String getRam() {
//        return Ram;
//    }
//
//    public String getScreen_Length() {
//        return Screen_Length;
//    }
//
//    public String getCamera() {
//        return Camera;
//    }
//
//    public String getURL() {
//        return URL;
//    }
//
//    public String getSIM() {
//        return SIM;
//    }

//    public boolean isAvailability() {
//        return Availability;
//    }
}
