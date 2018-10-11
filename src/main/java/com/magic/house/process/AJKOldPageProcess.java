package com.magic.house.process;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by lenovo on 2018/10/11.
 * 描述：
 */
public class AJKOldPageProcess implements PageProcessor {

    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100);

    /**列表页*/
    private static String listPage="^https://zhengzhou.anjuke.com/sale/p\\d+/";
    /**详情页*/
    private static String detailPage="https://zhengzhou.anjuke.com/prop/view/A\\d+\\?([\\s\\S]*)";


    /*https://zhengzhou.anjuke.com/prop/view/A1413225968?from=filter&spread=commsearch_p&position=1&kwtype=filter&now_time=1539242800*/
    /*https://zhengzhou.anjuke.com/prop/view/A1397502338?from=filter&spread=commsearch_p&position=2&kwtype=filter&now_time=1539242800*/
    @Override
    public void process(Page page) {
        List<String> datalink = page.getHtml().css("div.house-details").css("div.house-title").css("a", "href").all();
        page.addTargetRequests(datalink);
        if(page.getUrl().regex(detailPage).match()){
//            String houseInfo=page.getHtml().
//            System.out.println(page.getHtml().$(""));
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

    public static void main(String[] args) {
        String ajkurl = "https://zhengzhou.anjuke.com/sale/";
        Spider.create(new AJKOldPageProcess()).addUrl(ajkurl).
                addPipeline(new ConsolePipeline()).thread(1).run();
    }
}
