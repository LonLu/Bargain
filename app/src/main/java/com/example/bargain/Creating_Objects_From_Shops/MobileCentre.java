package com.example.bargain.Creating_Objects_From_Shops;

import android.util.Log;

import com.example.bargain.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;

public class MobileCentre extends Product {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory,
            memory_Type, ram, screen_Length, camera, url, sim;
    private boolean availability;

    private int int_price;

    public MobileCentre() {
    }


    public MobileCentre(String URL) {

        StringBuilder processorBuilder = new StringBuilder();
        Document doc = getDocument(URL);
        Elements keys = doc.getElementsByClass("col-lg-3 col-md-3 col-sm-6 col-xs-6 rowname");
        Elements values = doc.getElementsByClass("col-lg-9 col-md-9 col-sm-6 col-xs-6");
        ArrayList<String> array_key = new ArrayList<>(keys.eachText());
        ArrayList<String> array_value = new ArrayList<>(values.eachText());
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        arr.add(array_key);
        arr.add(array_value);


        for(int j = 0; j < arr.get(0).size(); j++){
            if(Objects.equals(arr.get(0).get(j), "Հայտարարության տարին")) release_Date = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Երաշխիք")) guarantee = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "ՕՀ տեսակ") || Objects.equals(arr.get(0).get(j), "Օպերացիոն համակարգ")) os = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Կոշտ սկավառակի հիշողություն") || Objects.equals(arr.get(0).get(j), "Հիշողություն")) memory = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Կոշտ սկավառակի տեսակ")) memory_Type = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Օպերատիվ հիշողություն")) ram = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Էկրանի չափսը") || Objects.equals(arr.get(0).get(j), "Էկրան")) screen_Length = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Հիմնական տեսախցիկ")) camera = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "SIM քարտի քանակ")) sim = arr.get(1).get(j);
            else if(Objects.equals(arr.get(0).get(j), "Չիպսեթ")) processorBuilder.append(arr.get(1).get(j)).append(" ");
            else if(Objects.equals(arr.get(0).get(j), "Պրոցեսորի միջուկ") || Objects.equals(arr.get(0).get(j), "Պրոցեսորների միջուկների քանակը")) processorBuilder.append(arr.get(1).get(j)).append(" ");
            else if(Objects.equals(arr.get(0).get(j), "Պրոցեսոր")) processorBuilder.append(arr.get(1).get(j));
            url = URL;
        }

        if (!processorBuilder.equals(null)) processor = processorBuilder.toString();
        name = doc.select("h1").text();

        Elements img = doc.getElementsByClass("item active").select("img");
        image = img.attr("src");

        Elements availability_element = doc.getElementById("myCarousel").select("span");
        availability = !availability_element.text().equals("Առկա չէ");

        String amount = doc.getElementsByClass("regular").first().text();
        String[] array_amount = amount.split("");
        StringBuilder price_builder = new StringBuilder();
        for (int j = 0; j < array_amount.length - 3; j++) {
            price_builder.append(array_amount[j]);
        }
        cash_Price = price_builder.toString();


        try{
            String price_without_amd = cash_Price.split("դր.")[0];
            String[] numbers = price_without_amd.split(",");
            StringBuilder price = new StringBuilder();
            for (int i = 0; i < numbers.length; i++){
                price.append(numbers[i]);
            }
            int_price = Integer.parseInt(price.toString());
        }catch (Exception ign){}

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
        return availability;
    }

    public int getInt_price() {
        return int_price;
    }
}
