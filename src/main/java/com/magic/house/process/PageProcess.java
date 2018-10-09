package com.magic.house.process;

import java.io.*;
import java.util.List;

import jdk.internal.util.xml.impl.Input;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.swing.text.html.HTML;


public class PageProcess implements PageProcessor {

    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {

//        System.out.println(page.getHtml());

//        List<String> imgs = page.getHtml().css("div.key-list").css("div.item-mod").css("img","src").all();
//        List<String> names= page.getHtml().css("div.key-list").xpath("//span[@class='items-name']").css("span","text").all();
//        List<String> houseType= page.getHtml().css("div.key-list").css("a.huxing").all();
//        List<String> prices= page.getHtml().css("div.key-list").xpath("//a[@class='favor-pos']").xpath("//p[@class='price]").all();

        List<String> datalink=page.getHtml().css("div.key-list").css("div.item-mod","data-link").all();
        page.addTargetRequests(datalink);

        buildHtml(page.getBytes());
        System.out.println(page.getHtml());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void buildHtml(byte[] bytes){
        Long time=System.currentTimeMillis();
        File file=new File("d:/h/"+time+".html");
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
        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/?from=navigation").thread(5).run();
    }

}
