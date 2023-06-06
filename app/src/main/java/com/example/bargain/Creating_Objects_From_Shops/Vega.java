package com.example.bargain.Creating_Objects_From_Shops;

import com.example.bargain.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class Vega extends Product {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory = "",
            memory_Type = "", ram, screen_Length, camera, url, sim;
    private boolean Availability;

    private int int_price;

    public Vega() {}

    public Vega(String URL) {
        Document document = getDocument(URL);
        Elements img = document.getElementsByClass("open-popup-image");
        image = img.attr("href");

        String name_ = document.select("h1").text();
        String[] name_array = name_.split(" ");
        StringBuilder nameBuild = new StringBuilder();
        for(int i = 0; i < name_array.length - 1; i++){
            nameBuild.append(name_array[i]).append(" ");
        }
        name = nameBuild.toString();
        cash_Price = document.getElementById("price-special").text();
        Availability = document.getElementById("blink7").text().equals("Առկա է");

        Elements characteristics = document.getElementsByClass("attribute");
        Elements td = characteristics.select("td");
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < td.size(); i++){
            arrayList.add(td.get(i).text());
            if(i >= 1){
                if(Objects.equals(arrayList.get(i - 1), "Էկրանի չափս")) screen_Length = arrayList.get(i) + " inch";
                else if(Objects.equals(arrayList.get(i - 1), "SIM")) sim = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Կենտր․ պրոցեսոր")) processor = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Ներ. հիշող/լրացուցիչ (ԳԲ)")){
                    if (arrayList.get(i).split(" ").length != 1) memory = arrayList.get(i).split(" ")[0] + " GB " + arrayList.get(i).split(" ")[1];
                    else memory = arrayList.get(i);
                }
                else if(Objects.equals(arrayList.get(i - 1), "Տեսախցիկ (MP)")) camera = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "ՕՀ")) os = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Օպերատիվ հիշ. (ԳԲ)")) ram = arrayList.get(i) + " GB";
                else if(Objects.equals(arrayList.get(i - 1), "Երաշխիքային Ժամկետ")) guarantee = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "SSD (ԳԲ)")){
                    if(!Objects.equals(memory_Type, "")){
                        memory_Type += ", SSD";
                        memory += ", " + arrayList.get(i);
                    }
                    else{
                        memory_Type += "SSD";
                        memory += arrayList.get(i);
                    }
                }
                else if(Objects.equals(arrayList.get(i - 1), "Կոշտ սկավառակ HDD (ԳԲ)") && !Objects.equals(arrayList.get(i), "Ոչ")){
                    if(!Objects.equals(memory_Type, "")){
                        memory_Type += ", HDD";
                        memory += ", " + arrayList.get(i);
                    }
                    else{
                        memory_Type += "HDD";
                        memory += arrayList.get(i);
                    }

                } arrayList.get(i);
            }
        }
        if(Objects.equals(memory_Type, "")) memory_Type = null;
        if(Objects.equals(memory, "")) memory = null;
        url = URL;


        try {
            String price_without_amd = cash_Price.split(" ֏")[0];
            String[] numbers = price_without_amd.split(" ");
            StringBuilder price = new StringBuilder();
            for (int i = 0; i < numbers.length; i++){
                price.append(numbers[i]);
            }
            int_price = Integer.parseInt(price.toString());
        }catch (Exception ign){}


    }



    public static Document getDocument(String URL) {
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (Exception ignored) {}
        return document;
    }


    public String getName() {
        return name;
    }

    public String getCash_Price() {
        return cash_Price;
    }

    public String getNot_Cash_Price(){
        return not_Cash_Price;
    }

    public String getImage() {
        return image;
    }

    public String getRelease_Date() {
        return release_Date;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public String getProcessor() {
        return processor;
    }

    public String getOs() {
        return os;
    }

    public String getMemory() {
        return memory;
    }

    public String getMemory_Type() {
        return memory_Type;
    }

    public String getRam() {
        return ram;
    }

    public String getScreen_Length() {
        return screen_Length;
    }

    public String getCamera() {
        return camera;
    }

    public String getUrl() {
        return url;
    }

    public String getSim() {
        return sim;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public int getInt_price() {
        return int_price;
    }
}

