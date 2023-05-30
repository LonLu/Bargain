package com.example.bargain;

public class Product {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory,
            memory_Type, ram, screen_Length, camera, url, sim;
    private boolean availability;
    private boolean isExpanded;

    public Product(){}

    public Product(String name, String cash_Price, String not_Cash_Price, String image, String release_Date, String guarantee, String processor, String os, String memory, String memory_Type, String ram, String screen_Length, String camera, String url, String sim, boolean availability) {
        this.name = name;
        this.cash_Price = cash_Price;
        this.not_Cash_Price = not_Cash_Price;
        this.image = image;
        this.release_Date = release_Date;
        this.guarantee = guarantee;
        this.processor = processor;
        this.os = os;
        this.memory = memory;
        this.memory_Type = memory_Type;
        this.ram = ram;
        this.screen_Length = screen_Length;
        this.camera = camera;
        this.url = url;
        this.sim = sim;
        this.availability = availability;

        this.isExpanded = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCash_Price() {
        return cash_Price;
    }

    public void setCash_Price(String cash_Price) {
        this.cash_Price = cash_Price;
    }

    public String getNot_Cash_Price() {
        return not_Cash_Price;
    }

    public void setNot_Cash_Price(String not_Cash_Price) {
        this.not_Cash_Price = not_Cash_Price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRelease_Date() {
        return release_Date;
    }

    public void setRelease_Date(String release_Date) {
        this.release_Date = release_Date;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemory_Type() {
        return memory_Type;
    }

    public void setMemory_Type(String memory_Type) {
        this.memory_Type = memory_Type;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreen_Length() {
        return screen_Length;
    }

    public void setScreen_Length(String screen_Length) {
        this.screen_Length = screen_Length;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }




    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
