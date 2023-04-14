package com.example.bargain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class JsoupScan {
    public String Get(String URL, String name){
        return null;
    }
    public Document GetDocument(String URL){
        return null;
    }
    public String GetName(String URL){
        return null;
    }
    public boolean GetAvailability(String URL){
        return false;
    }
    public String GetPrice(String URL){
        return null;
    }
    public String GetReleaseDate(String URL){
        return null;
    }
    public String GetGuarantee(String URL){
        return null;
    }
    public String GetProcessor(String URL){
        return null;
    }
    public String GetOS(String URL){
        return null;
    }
    public String GetMemory(String URL){
        return null;
    }
    public String GetMemoryType(String URL){
        return null;
    }
    public String GetRam(String URL){
        return null;
    }
    public String GetScreenLength(String URL){
        return null;
    }
    public String GetURL(String URL){
        return URL;
    }
}
