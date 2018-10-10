package com.magic.house;


import com.magic.house.pipeline.AjkSQLPipeline;
import com.magic.house.process.PageProcess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Spider;


/**
 *
 * @author lenovo
 * @date 2018/10/8
 * 描述：启动类
 */
@SpringBootApplication
@MapperScan("com.magic.house.dao")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String ajkurl="https://zz.fang.anjuke.com/loupan/all/p1/";
        Spider.create(new PageProcess()).addUrl(ajkurl).
                addPipeline(new AjkSQLPipeline()).thread(1).run();
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        String ajkurl="https://zz.fang.anjuke.com/loupan/all/p1/";
//        return args -> {
//            Spider.create(new PageProcess()).addUrl(ajkurl).
//                    addPipeline(new AjkSQLPipeline()).thread(1).run();
//        };
//
//
//    }



}
