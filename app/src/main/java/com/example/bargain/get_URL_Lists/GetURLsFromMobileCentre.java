package com.example.bargain.get_URL_Lists;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GetURLsFromMobileCentre {
    private ArrayList<String> urlList_for_phone = new ArrayList<>();
    private ArrayList<String> urlList_for_tablet = new ArrayList<>();
    private ArrayList<String> urlList_for_notebook = new ArrayList<>();

    public ArrayList<String> getUrlList_for_phone() {
        String url_for_phone = "https://www.mobilecentre.am/category/phones/138/0/";
        try {
            urlList_for_phone.clear();
            Document document = Jsoup.connect(url_for_phone).get();
            Elements all_elements = document.getElementsByClass("listitem");
            for (int i = 0; i < all_elements.size(); i++){
                Elements each_product = all_elements.get(i).child(0).select("a");
                String product = each_product.attr("href");
                urlList_for_phone.add(product);
            }
        }catch (Exception ignored){}

        return urlList_for_phone;
    }

    public ArrayList<String> getUrlList_for_tablet() {
        String url_for_tablet = "https://www.mobilecentre.am/category/tablets/139/0/";
        try {
            urlList_for_tablet.clear();
            Document document = Jsoup.connect(url_for_tablet).get();
            Elements all_elements = document.getElementsByClass("listitem");
            for (int i = 0; i < all_elements.size(); i++){
                Elements each_product = all_elements.get(i).child(0).select("a");
                String product = each_product.attr("href");
                urlList_for_tablet.add(product);
            }
        }catch (Exception ignored){}
        return urlList_for_tablet;
    }

    public ArrayList<String> getUrlList_for_notebook() {
        String url_for_notebook = "https://www.mobilecentre.am/category/computers/144/0/";
        try {
            urlList_for_notebook.clear();
            Document document = Jsoup.connect(url_for_notebook).get();
            Elements all_elements = document.getElementsByClass("listitem");
            for (int i = 0; i < all_elements.size(); i++){
                Elements each_product = all_elements.get(i).child(0).select("a");
                String product = each_product.attr("href");
                urlList_for_notebook.add(product);
            }
        }catch (Exception ignored){}
        return urlList_for_notebook;
    }

}
