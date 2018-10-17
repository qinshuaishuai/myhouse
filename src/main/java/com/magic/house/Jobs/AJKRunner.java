package com.magic.house.Jobs;

import com.magic.house.pipeline.AjkOldSQLPipeline;
import com.magic.house.pipeline.AjkSQLPipeline;
import com.magic.house.process.AJKNewPageProcess;
import com.magic.house.process.AJKOldPageProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import static com.magic.house.utils.Config.AJK_OLD_URL;

@Component
public class AJKRunner implements ApplicationRunner {

    @Autowired
    private AjkSQLPipeline ajkSQLPipeline;
    @Autowired
    private AjkOldSQLPipeline ajkOldSQLPipeline;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Spider.create(new AJKOldPageProcess()).addUrl(AJK_OLD_URL).
//                addPipeline(ajkOldSQLPipeline).thread(5).run();
    }
}
