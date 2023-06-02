package com.example.bargain.Creating_Objects_From_Shops;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class YerevanMobile {
    private String name, cash_Price, not_Cash_Price, image, release_Date, guarantee, processor, os, memory,
            memory_Type, ram, screen_Length, camera, url, sim;
    private boolean availability;

    private YerevanMobile() {
    }

    public YerevanMobile(Context context, int objectListIndex, int oneObjectIndex, String electronic_type){
        ArrayList<ArrayList<ArrayList<String>>> objects_list = null;
        AssetManager assetManager = context.getAssets();
        try {
            // Открытие потока для чтения файла
            InputStream inputStream = assetManager.open(electronic_type);
            // Чтение данных из потока
            ObjectInputStream in = new ObjectInputStream(inputStream);
            objects_list = (ArrayList<ArrayList<ArrayList<String>>>) in.readObject();
            in.close();
            inputStream.close();
        }catch (Exception e){ Log.i("fileError", e.toString());}

        ArrayList<ArrayList<String>> one_type_object = objects_list.get(objectListIndex);
        ArrayList<String> one_object = one_type_object.get(oneObjectIndex);
        name = one_object.get(0);
        availability = Boolean.parseBoolean(one_object.get(1));
        image = one_object.get(2);
        cash_Price = one_object.get(3);
        not_Cash_Price = one_object.get(4);
        sim = one_object.get(5);
        memory_Type = one_object.get(6);
        memory = one_object.get(7);
        ram = one_object.get(8);
        guarantee = one_object.get(9);
        os = one_object.get(10);
        release_Date = one_object.get(11);
        screen_Length = one_object.get(12);
        camera = one_object.get(13);
        processor = one_object.get(14);
        url = one_object.get(15);
    }

    public String getName() {
        return name;
    }

    public String getCash_Price() {
        return cash_Price;
    }

    public String getNot_Cash_Price() {
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
}