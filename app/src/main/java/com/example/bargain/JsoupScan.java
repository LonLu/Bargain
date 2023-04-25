package com.example.bargain;


import org.jsoup.nodes.Document;

public abstract class JsoupScan {

    public String get(String URL, String name){
        return null;
    }
    public Document getDocument(String URL){
        return null;
    }
    public String getName(String URL){
        return null;
    }
    public String getImage(String URL){
        return null;
    }
    public boolean getAvailability(String URL){
        return false;
    }
    public String getPrice(String URL){
        return null;
    }
    public String getReleaseDate(String URL){
        return null;
    }
    public String getGuarantee(String URL){
        return null;
    }
    public String getProcessor(String URL){
        return null;
    }
    public String getOS(String URL){
        return null;
    }
    public String getMemory(String URL){
        return null;
    }
    public String getMemoryType(String URL){
        return null;
    }
    public String getRam(String URL){
        return null;
    }
    public String getScreenLength(String URL){
        return null;
    }
    public String getCamera(String URL){
        return null;
    }
    public String getURL(String URL){
        return URL;
    }
}
