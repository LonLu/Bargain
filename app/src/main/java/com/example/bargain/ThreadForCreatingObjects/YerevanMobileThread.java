package com.example.bargain.ThreadForCreatingObjects;

import android.content.Context;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.YerevanMobile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class YerevanMobileThread implements Runnable{
    Context context;
    ArrayList<YerevanMobile> yerevanMobile_phones = new ArrayList<>();
    ArrayList<YerevanMobile> yerevanMobile_tablets = new ArrayList<>();
    ArrayList<YerevanMobile> yerevanMobile_notebooks = new ArrayList<>();


    public YerevanMobileThread(Context context){
        this.context = context;
    }
    @Override
    public void run() {
        get_phone_from_YerevanMobile();
        get_tablet_from_YerevanMobile();
        get_notebook_from_YerevanMobile();
    }

    public void get_phone_from_YerevanMobile(){
        int firstIndex = 0;
        int secondIndex = 0;
        boolean firstBool = true;
        int exceptionCounter = 0;
        while (firstBool){
            try {
                YerevanMobile yerevanMobile = new YerevanMobile(context, firstIndex, secondIndex, Constants.YM_PHONE);
                yerevanMobile_phones.add(yerevanMobile);
                secondIndex++;
                exceptionCounter = 0;
            }catch (Exception e){
                firstIndex++;
                secondIndex = 0;
                exceptionCounter++;
                if(exceptionCounter == 2) firstBool = false;
            }
        }
    }


    public void get_tablet_from_YerevanMobile(){
        int firstIndex = 0;
        int secondIndex = 0;
        boolean firstBool = true;
        int exceptionCounter = 0;
        while (firstBool){
            try {
                YerevanMobile yerevanMobile = new YerevanMobile(context, firstIndex, secondIndex, Constants.YM_TABLET);
                yerevanMobile_tablets.add(yerevanMobile);
                secondIndex++;
                exceptionCounter = 0;
            }catch (Exception e){
                firstIndex++;
                secondIndex = 0;
                exceptionCounter++;
                if(exceptionCounter == 2) firstBool = false;
            }
        }
    }

    public void get_notebook_from_YerevanMobile(){
        int firstIndex = 0;
        int secondIndex = 0;
        boolean firstBool = true;
        int exceptionCounter = 0;
        while (firstBool){
            try {
                YerevanMobile yerevanMobile = new YerevanMobile(context, firstIndex, secondIndex, Constants.YM_NOTEBOOK);
                yerevanMobile_notebooks.add(yerevanMobile);
                secondIndex++;
                exceptionCounter = 0;
            }catch (Exception e){
                firstIndex++;
                secondIndex = 0;
                exceptionCounter++;
                if(exceptionCounter == 2) firstBool = false;
            }
        }
    }

    public ArrayList<YerevanMobile> getYerevanMobile_phones() {
        return yerevanMobile_phones;
    }

    public ArrayList<YerevanMobile> getYerevanMobile_tablets() {
        return yerevanMobile_tablets;
    }

    public ArrayList<YerevanMobile> getYerevanMobile_notebooks() {
        return yerevanMobile_notebooks;
    }
}
