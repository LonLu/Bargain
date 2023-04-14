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
    public String Scree_Length;
    public String URL;



    public YerevanMobile() {}

    public YerevanMobile(String URL) {
        Name = GetName(URL);
        Availability = GetAvailability(URL);
        Price = GetPrice(URL);
        Release_Date = GetReleaseDate(URL);
        Guarantee = GetGuarantee(URL);
        Processor = GetProcessor(URL);
        OS = GetOS(URL);
        Memory = GetMemory(URL);
        Memory_Type = GetMemoryType(URL);
        Ram = GetRam(URL);
        Scree_Length = GetScreenLength(URL);
        this.URL = GetURL(URL);
    }

    @Override
    public String Get(String URL, String td_name) {
        Document doc = GetDocument(URL);
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
    public Document GetDocument(String URL){
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            Log.i("DocumentError", e.toString());
        }
        return doc;
    }

    @Override
    public String GetName(String URL){
        return super.GetName(URL);
    }

    @Override
    public boolean GetAvailability(String URL){
        Document doc = GetDocument(URL);
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
    public String GetPrice(String URL){
        Document doc = GetDocument(URL);
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
    public String GetReleaseDate(String URL) {
        return Get(URL, "Հայտարարության Տարին");
    }

    @Override
    public String GetGuarantee(String URL) {
        return Get(URL, "Երաշխիք");
    }

    @Override
    public String GetProcessor(String URL) {
        return Get(URL, "Պրոցեսորի տեսակ");
    }

    @Override
    public String GetOS(String URL) {
        return Get(URL, "ՕՀ Տեսակ");
    }

    @Override
    public String GetMemory(String URL){
        return Get(URL, "Կոշտ սկավառակի հիշողություն");
    }

    @Override
    public String GetMemoryType(String URL){
        return Get(URL, "Կոշտ սկավառակի տեսակ");
    }

    @Override
    public String GetRam(String URL){
        return null;
    }

    @Override
    public String GetScreenLength(String URL) {
        return Get(URL, "Էկրանի չափը");
    }

    @Override
    public String GetURL(String URL){
        return super.GetURL(URL);
    }
}
