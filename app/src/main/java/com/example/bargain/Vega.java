package com.example.bargain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class Vega {
    public String Name, Price, Image, Release_Date, Guarantee, Processor, OS, Memory = "",
            Memory_Type = "", Ram, Screen_Length, Camera, URL, SIM;
    public boolean Availability;

    public Vega() {}

    public Vega(String URL) {
        Document document = getDocument(URL);
        Elements image = document.getElementsByClass("open-popup-image");
        Image = image.attr("href");

        String name = document.select("h1").text();
        String[] name_array = name.split(" ");
        StringBuilder nameBuild = new StringBuilder();
        for(int i = 0; i < name_array.length - 1; i++){
            nameBuild.append(name_array[i]).append(" ");
        }
        Name = nameBuild.toString();
        Price = document.getElementById("price-special").text();
        Availability = document.getElementById("blink7").text().equals("Առկա է");

        Elements characteristics = document.getElementsByClass("attribute");
        Elements td = characteristics.select("td");
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < td.size(); i++){
            arrayList.add(td.get(i).text());
            if(i >= 1){
                if(Objects.equals(arrayList.get(i - 1), "Էկրանի չափս")) Screen_Length = arrayList.get(i) + " inch";
                else if(Objects.equals(arrayList.get(i - 1), "SIM")) SIM = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Կենտր․ պրոցեսոր")) Processor = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Ներ. հիշող/լրացուցիչ (ԳԲ)")){
                    if (arrayList.get(i).split(" ").length != 1) Memory = arrayList.get(i).split(" ")[0] + " GB " + arrayList.get(i).split(" ")[1];
                    else Memory = arrayList.get(i);
                }
                else if(Objects.equals(arrayList.get(i - 1), "Տեսախցիկ (MP)")) Camera = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "ՕՀ")) OS = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "Օպերատիվ հիշ. (ԳԲ)")) Ram = arrayList.get(i) + " GB";
                else if(Objects.equals(arrayList.get(i - 1), "Երաշխիքային Ժամկետ")) Guarantee = arrayList.get(i);
                else if(Objects.equals(arrayList.get(i - 1), "SSD (ԳԲ)")){
                    if(!Objects.equals(Memory_Type, "")){
                        Memory_Type += ", SSD";
                        Memory += ", " + arrayList.get(i);
                    }
                    else{
                        Memory_Type += "SSD";
                        Memory += arrayList.get(i);
                    }
                }
                else if(Objects.equals(arrayList.get(i - 1), "Կոշտ սկավառակ HDD (ԳԲ)") && !Objects.equals(arrayList.get(i), "Ոչ")){
                    if(!Objects.equals(Memory_Type, "")){
                        Memory_Type += ", HDD";
                        Memory += ", " + arrayList.get(i);
                    }
                    else{
                        Memory_Type += "HDD";
                        Memory += arrayList.get(i);
                    }

                } arrayList.get(i);
            }
        }
        if(Objects.equals(Memory_Type, "")) Memory_Type = null;
        if(Objects.equals(Memory, "")) Memory = null;
        this.URL = URL;
    }



    public static Document getDocument(String URL) {
        Document document = null;
        try {
            document = Jsoup.connect(URL).get();
        } catch (Exception ignored) {}
        return document;
    }
}

