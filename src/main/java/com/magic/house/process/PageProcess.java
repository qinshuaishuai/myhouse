package com.magic.house.process;


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

import javax.swing.text.html.HTML;


public class PageProcess implements PageProcessor {


    @Value("${process.html.save.path}")
    private String savePath;

    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {

        System.out.println("------------------------------------------------------------");
//        System.out.println(page.getHtml());

//        List<String> imgs = page.getHtml().css("div.key-list").css("div.item-mod").css("img","src").all();
//        List<String> names= page.getHtml().css("div.key-list").xpath("//span[@class='items-name']").css("span","text").all();
//        List<String> houseType= page.getHtml().css("div.key-list").css("a.huxing").all();
//        List<String> prices= page.getHtml().css("div.key-list").xpath("//a[@class='favor-pos']").xpath("//p[@class='price]").all();

        List<String> datalink=page.getHtml().css("div.key-list").css("div.item-mod","data-link").all();
        page.addTargetRequests(datalink);

        //buildHtml(page.getBytes());

        page.putField("name",page.getHtml().$("h1#j-triggerlayer","text").get());

        page.putField("price",page.getHtml().$("em.sp-price","text").get());

        page.putField("address",page.getHtml().$("span.lpAddr-text","text").get());

        if(page.getResultItems().get("name")==null){
            page.setSkip(true);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void buildHtml(byte[] bytes){
        Long time=System.currentTimeMillis();


        String filePath="/Users/qinshuai/work/html/";

        File file=new File(filePath+time+".html");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String filePath="/Users/qinshuai/work/html/";

        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/?from=navigation").
                addPipeline(new ConsolePipeline()).thread(5).run();
    }

}
