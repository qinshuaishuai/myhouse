package com.magic.house.utils;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

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

        String html1="<p class=\"loc-text\">" +
                "<a href=\"https://zhengzhou.anjuke.com/sale/erqic/\" target=\"_blank\" _soj=\"propview\">二七</a>－ " +
                "<a href=\"https://zhengzhou.anjuke.com/sale/guwancheng/\" target=\"_blank\" _soj=\"propview\">古玩城</a>" +
                "－ 兴华南街,近政通路</p> \n";

        String h1="123";
        System.out.println(getValue(html1,"a","innerHTML"));
    }

}
