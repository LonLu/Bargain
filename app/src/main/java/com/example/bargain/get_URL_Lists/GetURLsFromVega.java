package com.example.bargain.get_URL_Lists;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GetURLsFromVega {
    private ArrayList<String> urlList_for_phone = new ArrayList<>();
    private ArrayList<String> urlList_for_tablet = new ArrayList<>();
    private ArrayList<String> urlList_for_notebook = new ArrayList<>();

    public ArrayList<String> getUrlList_for_phone() {
        int index = 1;
        String url_for_phone = "https://vega.am/am/herhakhosner-ev-aksesowarner/smart-herhakhosner/page-" + index;
        try{
            Document doc = Jsoup.connect(url_for_phone).get();
            Elements count_element = doc.getElementsByClass("col-md-6 text-right");
            String[] count_arr = count_element.text().split(" ");
            int count = Integer.parseInt(count_arr[count_arr.length - 2]);
            for(int j = index; j <= count; j++){
                if (j >= 2) url_for_phone = "https://vega.am/am/herhakhosner-ev-aksesowarner/smart-herhakhosner/page-" + j;
                doc = Jsoup.connect(url_for_phone).get();
                Elements page_products = doc.getElementsByClass("col-12 col-md-4 col-lg-3");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).getElementsByClass("right").select("a").attr("href");
                    if (!each_product.isEmpty()) urlList_for_phone.add(each_product);
                }
            }
        }catch (Exception ignored){}

        return urlList_for_phone;
    }

    public ArrayList<String> getUrlList_for_tablet(){
        int index = 1;
        String url_for_tablet = "https://vega.am/am/herhakhosner-ev-aksesowarner/planshetner/page-" + index;
        try{
            Document doc = Jsoup.connect(url_for_tablet).get();
            Elements count_element = doc.getElementsByClass("col-md-6 text-right");
            String[] count_arr = count_element.text().split(" ");
            int count = Integer.parseInt(count_arr[count_arr.length - 2]);
            for(int j = index; j <= count; j++){
                if (j >= 2) url_for_tablet = "https://vega.am/am/herhakhosner-ev-aksesowarner/planshetner/page-" + j;
                doc = Jsoup.connect(url_for_tablet).get();
                Elements page_products = doc.getElementsByClass("col-12 col-md-4 col-lg-3");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).getElementsByClass("right").select("a").attr("href");
                    if (!each_product.isEmpty()) urlList_for_tablet.add(each_product);
                }
            }
        }catch (Exception ignored){}

        return urlList_for_tablet;
    }

    public ArrayList<String> getUrlList_for_notebook(){
        int index = 1;
        String url_for_notebook = "https://vega.am/am/hamakargichner-ew-noowtbowker/dyowrakir-hamakargichner/page-" + index;
        try{
            Document doc = Jsoup.connect(url_for_notebook).get();
            Elements count_element = doc.getElementsByClass("col-md-6 text-right");
            String[] count_arr = count_element.text().split(" ");
            int count = Integer.parseInt(count_arr[count_arr.length - 2]);
            for(int j = index; j <= count; j++){
                if (j >= 2) url_for_notebook = "https://vega.am/am/hamakargichner-ew-noowtbowker/dyowrakir-hamakargichner/page-" + j;
                doc = Jsoup.connect(url_for_notebook).get();
                Elements page_products = doc.getElementsByClass("col-12 col-md-4 col-lg-3");
                for (int i = 0; i < page_products.size(); i++){
                    String each_product = page_products.get(i).getElementsByClass("right").select("a").attr("href");
                    if (!each_product.isEmpty()) urlList_for_notebook.add(each_product);
                }
            }
        }catch (Exception ignored){}

        return urlList_for_notebook;
    }

}
