package com.example.bargain.Creating_Objects_From_Shops;

import com.example.bargain.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Zigzag extends Product {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory,
            memory_Type, ram, screen_Length, camera, url, sim, type;
    private boolean availability;

    public Zigzag() {
    }

    public Zigzag(String URL){
        Document document = getDocument(URL);
        Elements image_element = document.getElementsByClass("big_images");
        image = image_element.select("a").first().attr("href");
        Elements price_element = document.getElementsByClass("price");
        cash_Price = price_element.first().text();

        Elements name_element = document.getElementsByClass("value");
        name = name_element.first().text();

        Elements availability_element = document.getElementsByClass("stock status_block in_stock");
        availability = availability_element.text().equals("Առկա է");

        Elements key = document.getElementsByClass("detail_name");
        ArrayList<String> key_array = new ArrayList<>(key.eachText());
        Elements value = document.getElementsByClass("detail_unit");
        ArrayList<String> value_array = new ArrayList<>(value.eachText());
        StringBuilder SIM_builder = new StringBuilder();
        StringBuilder processor_builder = new StringBuilder();

        for (int i = 0; i < key_array.size(); i++){
            if(Objects.equals(key_array.get(i), "Երաշխիք")) guarantee = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Օպերացիոն համակարգ")) os = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Անկյունագիծ")) screen_Length = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Տեսախցիկի կետայնություն")) camera = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Ներկառուցված հիշողություն (ROM)")) memory = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "SSD կուտակիչ")) {
                memory_Type = "SSD";
                memory = value_array.get(i);
            }
            else if(Objects.equals(key_array.get(i), "Օպերատիվ հիշողություն (RAM)")) ram = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "SIM քարտերի քանակ")) SIM_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "SIM քարտի տեսակ")) SIM_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Պրոցեսորի Արտադրող")) processor_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Պրոցեսորի տեսակ")) processor_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Հաճախականություն")) processor_builder.append(value_array.get(i)).append(" ");
        }
        if(!SIM_builder.toString().equals("")) sim = SIM_builder.toString();
        processor = processor_builder.toString();
        url = URL;


    }

    public Document getDocument(String URL){
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException ignored) {}
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

    public String getType() {
        return type;
    }

    public boolean isAvailability() {
        return availability;
    }
}
