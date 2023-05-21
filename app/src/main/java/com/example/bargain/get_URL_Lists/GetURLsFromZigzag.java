package com.example.bargain.get_URL_Lists;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GetURLsFromZigzag {
    private ArrayList<String> urlList_for_phone = new ArrayList<>();
    private ArrayList<String> urlList_for_tablet = new ArrayList<>();
    private ArrayList<String> urlList_for_notebook = new ArrayList<>();

    public ArrayList<String> getUrlList_for_phone() {
        int index = 1;
        String url_for_phone = "https://www.zigzag.am/am/phones-and-communication/phones/smartphones.html?p=" +
                index + "&product_list_dir=asc&product_list_mode=grid&product_list_order=price";

        try{
            Document doc;
            urlList_for_phone.clear();
            while (true){
                doc = Jsoup.connect(url_for_phone).get();
                index++;
                url_for_phone = "https://www.zigzag.am/am/phones-and-communication/phones/smartphones.html?p=" +
                        index + "&product_list_dir=asc&product_list_mode=grid&product_list_order=price";
                Elements next_page = doc.getElementsByClass("next_page icon_right  inactive");
                Elements page_products = doc.getElementsByClass("image_block").select("a");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).attr("href");
                    urlList_for_phone.add(each_product);
                }
                if (!next_page.isEmpty()) break;
            }
        }catch (Exception ignored){}

        return urlList_for_phone;
    }

    public ArrayList<String> getUrlList_for_tablet(){
        int index = 1;
        String url_for_tablet = "https://www.zigzag.am/am/computers-notebooks-tablets/tablets-and-ebook-readers/tablets.html?p=" + index;

        try{
            Document doc;
            urlList_for_tablet.clear();
            while (true){
                doc = Jsoup.connect(url_for_tablet).get();
                index++;
                url_for_tablet = "https://www.zigzag.am/am/computers-notebooks-tablets/tablets-and-ebook-readers/tablets.html?p=" + index;
                Elements next_page = doc.getElementsByClass("next_page icon_right  inactive");
                Elements page_products = doc.getElementsByClass("image_block").select("a");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).attr("href");
                    urlList_for_tablet.add(each_product);
                }
                if (!next_page.isEmpty()) break;
            }
        }catch (Exception ignored){}

        return urlList_for_tablet;
    }

    public ArrayList<String> getUrlList_for_notebook(){
        int index = 1;
        String url_for_notebook = "https://www.zigzag.am/am/computers-notebooks-tablets/notebooks.html?p=" + index;

        try{
            Document doc;
            urlList_for_notebook.clear();
            while (true){
                doc = Jsoup.connect(url_for_notebook).get();
                index++;
                url_for_notebook = "https://www.zigzag.am/am/computers-notebooks-tablets/notebooks.html?p=" + index;
                Elements next_page = doc.getElementsByClass("next_page icon_right  inactive");
                Elements page_products = doc.getElementsByClass("image_block").select("a");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).attr("href");
                    urlList_for_notebook.add(each_product);
                }
                if (!next_page.isEmpty()) break;
            }
        }catch (Exception ignored){}

        return urlList_for_notebook;
    }

}
