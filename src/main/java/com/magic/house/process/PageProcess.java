package com.magic.house.process;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.List;

import jdk.internal.util.xml.impl.Input;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import javax.swing.text.html.HTML;


public class PageProcess implements PageProcessor {


    @Value("${process.html.save.path}")
    private String savePath;
    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100);

    /**列表页*/
    private static String listPage="^https://zz.fang.anjuke.com/loupan/all/p\\d+/";
    /**详情页*/
    private static String detailPage="\"https://zz.fang.anjuke.com/loupan/\\\\d+.html\"";


    @Override
    public void process(Page page) {
        List<String> datalink = page.getHtml().css("div.key-list").css("div.item-mod", "data-link").all(); //获取详情页面
        page.addTargetRequests(datalink);

        if(page.getUrl().regex(detailPage).match()){
            page.putField("name", page.getHtml().$("h1#j-triggerlayer", "text").get());
            String price = page.getHtml().$("em.sp-price", "text").get();
            if (StringUtils.isBlank(price)) {
                price = page.getHtml().$("dd.around-price span", "text").get();
            }
            page.putField("price", price);
            page.putField("address", page.getHtml().$("span.lpAddr-text", "text").get());
            String url=page.getUrl().get();
            page.putField("url",url);


        }
        /*匹配分页*/
        if (page.getUrl().regex(listPage).match()) {
            List<String> links = page.getHtml().$(".next-page").links().all();
            page.addTargetRequests(links);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

//    public static void main(String[] args) {
//        String filePath = "/Users/qinshuai/work/html/";
//
////        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/?from=navigation").
////                addPipeline(new ConsolePipeline()).thread(5).run();
//
//        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/loupan/all/p1/").
//                addPipeline(new ConsolePipeline()).thread(1).run();
//    }

}
