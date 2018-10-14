package com.magic.house.Jobs;

import com.magic.house.pipeline.AjkOldSQLPipeline;
import com.magic.house.pipeline.AjkSQLPipeline;
import com.magic.house.process.AJKNewPageProcess;
import com.magic.house.process.AJKOldPageProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Spider;

/**
 * @author lenovo
 * @date 2018/10/11 描述：安居客定时任务
 */
@Component
public class AJKJob {

    private final static long ONE_MINUTE = 60 * 1000;
    private final static long ONE_HOUR = 60 * 1000 * 60;

    @Autowired
    private AjkSQLPipeline ajkSQLPipeline;
    @Autowired
    private AjkOldSQLPipeline ajkOldSQLPipeline;

    @Scheduled(fixedDelay = ONE_HOUR)
    public void fixedDelayJob1() {
        String ajkurl = "https://zhengzhou.anjuke.com/sale/p1/";
        Spider.create(new AJKOldPageProcess()).addUrl(ajkurl).
                addPipeline(ajkOldSQLPipeline).thread(1).run();
    }




    @Scheduled(cron = "0 0 12 * * ?")
    public void dayNewJob() {
        String ajkurl = "https://zz.fang.anjuke.com/loupan/all/p1/";
        Spider.create(new AJKNewPageProcess()).addUrl(ajkurl).
                addPipeline(ajkSQLPipeline).thread(1).run();
    }

    @Scheduled(cron = "0 0 11 * * ?")
    public void dayOldJob() {
        String ajkurl = "https://zhengzhou.anjuke.com/sale/p1/";
        Spider.create(new AJKOldPageProcess()).addUrl(ajkurl).
                addPipeline(ajkOldSQLPipeline).thread(1).run();
    }
}
