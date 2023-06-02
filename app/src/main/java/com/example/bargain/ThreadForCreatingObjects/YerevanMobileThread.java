package com.example.bargain.ThreadForCreatingObjects;

import android.content.Context;

import com.example.bargain.Constants;
import com.example.bargain.Creating_Objects_From_Shops.YerevanMobile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class YerevanMobileThread implements Runnable{
    DatabaseReference database_phone;
    DatabaseReference database_tablet;
    DatabaseReference database_notebook;
    Context context;

    public YerevanMobileThread(Context context){
        this.context = context;
    }
    @Override
    public void run() {
        database_phone = FirebaseDatabase.getInstance().getReference(Constants.PHONE);
        database_tablet = FirebaseDatabase.getInstance().getReference(Constants.TABLET);
        database_notebook = FirebaseDatabase.getInstance().getReference(Constants.NOTEBOOK);
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
                database_phone.push().setValue(yerevanMobile);
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
                database_tablet.push().setValue(yerevanMobile);
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
                database_notebook.push().setValue(yerevanMobile);
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
}
