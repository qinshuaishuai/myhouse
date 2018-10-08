package com.magic.house.process;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class PageProcess implements PageProcessor {

    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {
        List<String> imgs = page.getHtml().css("div.key-list").css("div.item-mod").css("img","src").all();
        List<String> names= page.getHtml().css("div.key-list").xpath("//span[@class='items-name']").css("span","text").all();
        List<String> houseType= page.getHtml().css("div.key-list").css("a.huxing").all();
        List<String> prices= page.getHtml().css("div.key-list").xpath("//a[@class='favor-pos']").xpath("//p[@class='price]").all();


    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/?from=navigation").thread(5).run();

    }
}
