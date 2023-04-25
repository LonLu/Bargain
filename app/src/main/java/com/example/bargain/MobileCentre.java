package com.example.bargain;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class MobileCentre extends JsoupScan{
    public String Name, Price, Image, Release_Date, Guarantee, Processor, OS, Memory,
            Memory_Type, Ram, Screen_Length, Camera, URL;
    public boolean Availability;

    public MobileCentre(){}

    public MobileCentre(String URL){
        Name = getName(URL);
        Availability = getAvailability(URL);
        Price = getPrice(URL);
        Image = getImage(URL);
        Release_Date = getReleaseDate(URL);
        Guarantee = getGuarantee(URL);
        Processor = getProcessor(URL);
        OS = getOS(URL);
        Memory = getMemory(URL);
        Memory_Type = getMemoryType(URL);
        Ram = getRam(URL);
        Screen_Length = getScreenLength(URL);
        Camera = getCamera(URL);
        this.URL = getURL(URL);
    }
    @Override
    public String get(String URL, String name) {
        String result = null;
        ArrayList<String> array_key = new ArrayList<>();
        ArrayList<String> array_value = new ArrayList<>();
        Document doc = getDocument(URL);
        Elements keys = doc.getElementsByClass("col-lg-3 col-md-3 col-sm-6 col-xs-6 rowname");
        Elements values = doc.getElementsByClass("col-lg-9 col-md-9 col-sm-6 col-xs-6");
        int i = 0;
        try{
            while (true){
                array_key.add(keys.get(i).text());
                array_value.add(values.get(i).text());
                i++;
            }
        }catch (Exception ignored){}
        for (int j = 0; j < array_key.size(); j++) {
            if (Objects.equals(array_key.get(j), name)){
                result = array_value.get(j);
                array_key.clear();
                array_value.clear();
            }
        }
        return result;
    }

    @Override
    public Document getDocument(String URL) {
        Document document = null;
        try{
            document = Jsoup.connect(URL).get();
        }catch (Exception e){
            Log.i("DocumentError", e.toString());
        }
        return document;
    }

    @Override
    public String getName(String URL) {
        Document doc = getDocument(URL);
        return doc.select("h1").text();
    }

    @Override
    public String getImage(String URL){
        Document doc = getDocument(URL);
        Elements img = doc.getElementsByClass("item active").select("img");
        return img.attr("src");
    }

    @Override
    public boolean getAvailability(String URL) {
        Document doc = getDocument(URL);
        Elements availability = doc.getElementById("myCarousel").select("span");
        return !availability.text().equals("Առկա չէ");
    }

    @Override
    public String getPrice(String URL) {
        Document doc = getDocument(URL);
        String amount = doc.getElementsByClass("regular").first().text();
        String[] array_amount = amount.split("");
        StringBuilder price = new StringBuilder();
        for (int i = 0; i < array_amount.length - 3; i++){
            if(Objects.equals(array_amount[i], ",")) array_amount[i] = ".";
            price.append(array_amount[i]);
        }
    return price.toString();
    }

    @Override
    public String getReleaseDate(String URL) {
        return get(URL, "Հայտարարության տարին");
    }

    @Override
    public String getGuarantee(String URL) {
        return get(URL, "Երաշխիք");
    }

    @Override
    public String getProcessor(String URL) {
        StringBuilder x = new StringBuilder();
        if (get(URL, "Չիպսեթ") != null) x.append(get(URL, "Չիպսեթ")).append(" ");
        if(get(URL, "Պրոցեսորի միջուկ") != null) x.append(get(URL, "Պրոցեսորի միջուկ")).append(" ");
        return x.append(get(URL, "Պրոցեսոր")).toString();
    }

    @Override
    public String getOS(String URL) {
        return get(URL, "ՕՀ տեսակ");
    }

    @Override
    public String getMemory(String URL) {
        return get(URL, "Կոշտ սկավառակի հիշողություն");
    }

    @Override
    public String getMemoryType(String URL) {
        return get(URL, "Կոշտ սկավառակի տեսակ");
    }

    @Override
    public String getRam(String URL) {
        return get(URL, "Օպերատիվ հիշողություն");
    }

    @Override
    public String getScreenLength(String URL) {
        return get(URL, "Էկրանի չափսը");
    }

    @Override
    public String getCamera(String URL) {
        return get(URL, "Հիմնական տեսախցիկ");
    }

    @Override
    public String getURL(String URL) {
        return URL;
    }
}
