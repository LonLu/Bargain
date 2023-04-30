package com.example.bargain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Zigzag {
    public String Name, Price, Image, Release_Date, Guarantee, Processor, OS, Memory,
            Memory_Type, Ram, Screen_Length, Camera, URL, SIM;
    public boolean Availability;

    public Zigzag() {
    }

    public Zigzag(String URL){
        Document document = getDocument(URL);
        Elements image_element = document.getElementsByClass("big_images");
        Image = image_element.select("a").first().attr("href");
        Elements price_element = document.getElementsByClass("price");
        Price = price_element.first().text();

        Elements name_element = document.getElementsByClass("value");
        Name = name_element.first().text();

        Elements availability_element = document.getElementsByClass("stock status_block in_stock");
        Availability = availability_element.text().equals("Առկա է");

        Elements key = document.getElementsByClass("detail_name");
        ArrayList<String> key_array = new ArrayList<>(key.eachText());
        Elements value = document.getElementsByClass("detail_unit");
        ArrayList<String> value_array = new ArrayList<>(value.eachText());
        StringBuilder SIM_builder = new StringBuilder();
        StringBuilder processor_builder = new StringBuilder();

        for (int i = 0; i < key_array.size(); i++){
            if(Objects.equals(key_array.get(i), "Երաշխիք")) Guarantee = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Օպերացիոն համակարգ")) OS = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Անկյունագիծ")) Screen_Length = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Տեսախցիկի կետայնություն")) Camera = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "Ներկառուցված հիշողություն (ROM)")) Memory = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "SSD կուտակիչ")) {
                Memory_Type = "SSD";
                Memory = value_array.get(i);
            }
            else if(Objects.equals(key_array.get(i), "Օպերատիվ հիշողություն (RAM)")) Ram = value_array.get(i);
            else if(Objects.equals(key_array.get(i), "SIM քարտերի քանակ")) SIM_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "SIM քարտի տեսակ")) SIM_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Պրոցեսորի Արտադրող")) processor_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Պրոցեսորի տեսակ")) processor_builder.append(value_array.get(i)).append(" ");
            else if(Objects.equals(key_array.get(i), "Հաճախականություն")) processor_builder.append(value_array.get(i)).append(" ");
        }
        if(!SIM_builder.toString().equals("")) SIM = SIM_builder.toString();
        Processor = processor_builder.toString();
        this.URL = URL;
    }

    public Document getDocument(String URL){
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException ignored) {}
        return document;
    }
}
