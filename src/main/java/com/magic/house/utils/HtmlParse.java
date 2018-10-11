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

    public static void main(String[] args) {
        String html="<a href=\"https://zhengzhou.anjuke.com/community/view/764032\" target=\"_blank\" _soj=\"propview\">正商新蓝钻E区</a>";

        String h1="123";
        System.out.println(getValue(html,"a","href"));
    }

}
