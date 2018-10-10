package com.magic.house;


import com.magic.house.process.PageProcess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 *
 * @author lenovo
 * @date 2018/10/8
 * 描述：启动类
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Spider.create(new PageProcess()).addUrl("https://zz.fang.anjuke.com/loupan/all/p1/").
                addPipeline(new ConsolePipeline()).thread(1).run();

    }
}
