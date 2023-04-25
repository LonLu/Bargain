package com.example.bargain;

import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class YerevanMobile extends JsoupScan{
    public String Name;
    public boolean Availability;
    public String Price;
    public String Release_Date;
    public String Guarantee;
    public String Processor;
    public String OS;
    public String Memory;
    public String Memory_Type;
    public String Ram;
    public String Screen_Length;
    public String URL;



    public YerevanMobile() {}

    public YerevanMobile(String URL) {
        Name = getName(URL);
        Availability = getAvailability(URL);
        Price = getPrice(URL);
        Release_Date = getReleaseDate(URL);
        Guarantee = getGuarantee(URL);
        Processor = getProcessor(URL);
        OS = getOS(URL);
        Memory = getMemory(URL);
        Memory_Type = getMemoryType(URL);
        Ram = getRam(URL);
        Screen_Length = getScreenLength(URL);
        this.URL = getURL(URL);
    }

    @Override
    public String get(String URL, String td_name) {
        Document doc = getDocument(URL);
        Elements DETAILS_BLOCK_LIST = doc.getElementsByClass("details_block");
        Elements elements = DETAILS_BLOCK_LIST.select("td");
        ArrayList<String> arrayList = new ArrayList<>();
        String returns = null;
        boolean x = true;
        int i = 0;
        while (x){
            try{
                arrayList.add(elements.get(i).text());
                i++;
            }catch (Exception e) {x = false;}
        }
        for (int j = 0; j < arrayList.size(); j++){
            if (Objects.equals(arrayList.get(j), td_name)) returns = arrayList.get(j+1);
        }
        return returns;
    }

    @Override
    public Document getDocument(String URL){
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            Log.i("DocumentError", e.toString());
        }
        return doc;
    }

    @Override
    public String getName(String URL){
        Document doc = getDocument(URL);
        Elements NAME_LIST = doc.getElementsByClass("base");
        String[] NAME_ARRAY = NAME_LIST.first().text().split("/");
        String NAME = NAME_ARRAY[0];
        return NAME;
    }

    @Override
    public boolean getAvailability(String URL){
        Document doc = getDocument(URL);
        Elements AVAILABILITY_LIST = doc.getElementsByClass("stock unavailable");
        Element AVAILABILITY = AVAILABILITY_LIST.first();
        if(AVAILABILITY == null) return true;
        else{
            String FINAL_AVAILABILITY = AVAILABILITY.text();
            if(!FINAL_AVAILABILITY.equals("Զանգահարել")) Log.i("Случилось ЧП", FINAL_AVAILABILITY);
        }
        return false;
    }

    @Override
    public String getPrice(String URL){
        Document doc = getDocument(URL);
        Elements PRICE_LIST = doc.getElementsByClass("price");
        Element PRICE_ELEMENT = PRICE_LIST.get(0);
        String PRICE = PRICE_ELEMENT.text();
        String[] array = PRICE.split(" ");
        StringBuilder FINAL_PRICE = new StringBuilder();
        for(int i = 1; i < array.length; i++) {
            FINAL_PRICE.append(array[i]);
        }
        return FINAL_PRICE.toString();
    }

    @Override
    public String getReleaseDate(String URL) {
        return get(URL, "Հայտարարության Տարին");
    }

    @Override
    public String getGuarantee(String URL) {
        return get(URL, "Երաշխիք");
    }

    @Override
    public String getProcessor(String URL) {
        return get(URL, "Պրոցեսորի տեսակ");
    }

    @Override
    public String getOS(String URL) {
        return get(URL, "ՕՀ Տեսակ");
    }

    @Override
    public String getMemory(String URL){
        return get(URL, "Կոշտ սկավառակի հիշողություն");
    }

    @Override
    public String getMemoryType(String URL){
        String type = get(URL, "Կոշտ սկավառակի տեսակ");
        if(type == null) return "SSD";
        return type;
    }

    @Override
    public String getRam(String URL){
        return null;
    }

    @Override
    public String getScreenLength(String URL) {
        return get(URL, "Էկրանի չափը");
    }

    @Override
    public String getURL(String URL){
        return super.getURL(URL);
    }
}
