package com.example.bargain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DatabaseReference database;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread myThread = new MyThread();
                Thread thread = new Thread(myThread);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {}
                YerevanMobile yerevanMobile = myThread.GetYerevanMobile();
                database.push().setValue(yerevanMobile);

            }
        });


    }
    public void init(){
        database = FirebaseDatabase.getInstance().getReference();
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }


}


