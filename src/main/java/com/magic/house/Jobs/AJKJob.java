package com.magic.house.Jobs;

import com.magic.house.pipeline.AjkSQLPipeline;
import com.magic.house.process.PageProcess;
import com.magic.house.utils.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Date;

/**
 * @author lenovo
 * @date 2018/10/11
 * 描述：安居客定时任务
 */
@Component
public class AJKJob {

    private final static long ONE_MINUTE = 60 * 1000;
    private final static long ONE_HOUR = 60 * 1000 * 60;

    @Autowired
    private AjkSQLPipeline ajkSQLPipeline;

    @Scheduled(fixedDelay = ONE_HOUR)
    public void fixedDelayJob() {

    }

    @Scheduled(cron="0 0 12 * * ?")
    public void dayJob(){
        String ajkurl = "https://zz.fang.anjuke.com/loupan/all/p1/";
        Spider.create(new PageProcess()).addUrl(ajkurl).
                addPipeline(ajkSQLPipeline).thread(1).run();
    }
}
