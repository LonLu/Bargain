package com.example.bargain;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class MobileCentre{
    public String Name, Price, Image, Release_Date, Guarantee, Processor, OS, Memory,
            Memory_Type, Ram, Screen_Length, Camera, URL, SIM;
    public boolean Availability;

    public MobileCentre() {
    }


    public MobileCentre(String URL) {
        ArrayList<String> array_key = new ArrayList<>();
        ArrayList<String> array_value = new ArrayList<>();
        StringBuilder processorBuilder = new StringBuilder();
        Document doc = getDocument(URL);
        Elements keys = doc.getElementsByClass("col-lg-3 col-md-3 col-sm-6 col-xs-6 rowname");
        Elements values = doc.getElementsByClass("col-lg-9 col-md-9 col-sm-6 col-xs-6");
        int i = 0;
        try {
            while (true) {
                array_key.add(keys.get(i).text());
                array_value.add(values.get(i).text());
                i++;
            }
        } catch (Exception ignored) {}
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        arr.add(array_key);
        arr.add(array_value);


        for(int j = 0; j < arr.get(0).size(); j++){
            if(Objects.equals(arr.get(0).get(j), "Հայտարարության տարին")) Release_Date = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Երաշխիք")) Guarantee = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "ՕՀ տեսակ") || Objects.equals(arr.get(0).get(j), "Օպերացիոն համակարգ")) OS = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Կոշտ սկավառակի հիշողություն") || Objects.equals(arr.get(0).get(j), "Հիշողություն")) Memory = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Կոշտ սկավառակի տեսակ")) Memory_Type = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Օպերատիվ հիշողություն")) Ram = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Էկրանի չափսը") || Objects.equals(arr.get(0).get(j), "Էկրան")) Screen_Length = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Հիմնական տեսախցիկ")) Camera = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "SIM քարտի քանակ")) SIM = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Չիպսեթ")) processorBuilder.append(arr.get(1).get(j)).append(" ");
            else if(Objects.equals(arr.get(0).get(j), "Պրոցեսորի միջուկ") || Objects.equals(arr.get(0).get(j), "Պրոցեսորների միջուկների քանակը")) processorBuilder.append(arr.get(1).get(j)).append(" ");
            else if(Objects.equals(arr.get(0).get(j), "Պրոցեսոր")) processorBuilder.append(arr.get(1).get(j));
            this.URL = URL;
        }

        Processor = processorBuilder.toString();
        Name = doc.select("h1").text();

        Elements img = doc.getElementsByClass("item active").select("img");
        Image = img.attr("src");

        Elements availability = doc.getElementById("myCarousel").select("span");
        Availability = !availability.text().equals("Առկա չէ");

        String amount = doc.getElementsByClass("regular").first().text();
        String[] array_amount = amount.split("");
        StringBuilder price = new StringBuilder();
        for (int j = 0; j < array_amount.length - 3; j++) {
            if (Objects.equals(array_amount[j], ",")) array_amount[j] = ".";
            price.append(array_amount[j]);
        }
        Price = price.toString();
    }

    public Document getDocument(String URL) {
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (Exception e) {
            Log.i("DocumentError", e.toString());
        }
        return document;
    }



}
