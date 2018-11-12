package com.magic.house.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParse {


    public static String getValue(String html,String tag){
        Document document=Jsoup.parse(html);
        String value=document.getElementsByTag(tag).html();
        return value;
    }

    public static String getValue(String html,String tag,String attribute){
        Document document=Jsoup.parse(html);

        String value=document.getElementsByTag(tag).attr(attribute);
        return value;
    }


}
