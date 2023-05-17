package com.example.bargain;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class YerevanMobile {
    public String Name, Cash_Price, Not_Cash_Price, Image, Release_Date, Guarantee, Processor, OS, Memory,
            Memory_Type, Ram, Screen_Length, Camera, URL, SIM;
    public boolean Availability;

    public YerevanMobile() {
    }

    public YerevanMobile(Context context, int objectListIndex, int oneObjectIndex){
        ArrayList<ArrayList<ArrayList<String>>> objects_list = null;
        AssetManager assetManager = context.getAssets();
        try {
            // Открытие потока для чтения файла
            InputStream inputStream = assetManager.open("YMArray.ser");
            // Чтение данных из потока
            ObjectInputStream in = new ObjectInputStream(inputStream);
            objects_list = (ArrayList<ArrayList<ArrayList<String>>>) in.readObject();
            in.close();
            inputStream.close();
        }catch (Exception e){ Log.i("fileError", e.toString());}

        ArrayList<ArrayList<String>> one_type_object = objects_list.get(objectListIndex);
        ArrayList<String> one_object = one_type_object.get(oneObjectIndex);
        Name = one_object.get(0);
        Availability = Boolean.parseBoolean(one_object.get(1));
        Image = one_object.get(2);
        Cash_Price = one_object.get(3);
        Not_Cash_Price = one_object.get(4);
        SIM = one_object.get(5);
        Memory_Type = one_object.get(6);
        Memory = one_object.get(7);
        Ram = one_object.get(8);
        Guarantee = one_object.get(9);
        OS = one_object.get(10);
        Release_Date = one_object.get(11);
        Screen_Length = one_object.get(12);
        Camera = one_object.get(13);
        Processor = one_object.get(14);
        URL = one_object.get(15);
    }
}