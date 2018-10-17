package com.magic.house.process;


import com.magic.house.utils.Util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class AJKNewPageProcess implements PageProcessor {


    @Value("${process.html.save.path}")
    private String savePath;


    private Site site = Site.me().setCharset("utf8").setRetryTimes(3).setSleepTime(100)
            .addHeader("User-Agent","ozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.516.400 QQBrowser/9.4.8188.400")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            .addHeader("Accept-Encoding", "gzip, deflate, sdch").addHeader("Accept-Language", "zh-CN,zh;q=0.8");;

    /**列表页*/
    private static String listPage="^https://zz.fang.anjuke.com/loupan/all/p\\d+/";
    /**详情页*/
    private static String detailPage="https://zz.fang.anjuke.com/loupan/\\d+.html";


    @Override
    public void process(Page page) {
        List<String> datalink = page.getHtml().css("div.key-list").css("div.item-mod", "data-link").all();
        page.addTargetRequests(datalink);

        if(page.getUrl().regex(detailPage).match()){
            page.putField("area", page.getHtml().$("h1#j-triggerlayer", "text").get());
            String price = page.getHtml().$("em.sp-price", "text").get();
            if (StringUtils.isBlank(price)) {
                price = page.getHtml().$("dd.around-price span", "text").get();
            }
            if(StringUtils.isBlank(price) || StringUtils.isEmpty(Util.extractData(price,"\\d+"))){
                price="0";
            }
            page.putField("price", price);
            page.putField("address", page.getHtml().$("span.lpAddr-text", "text").get());
            String url=page.getUrl().get();
            page.putField("html",url);
            page.putField("no", Util.extractData(url,"\\d+"));
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

}
