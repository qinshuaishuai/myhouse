package com.magic.house.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 *
 * @author lenovo
 * @date 2018/10/10
 * 描述：
 */

@Component("PostInfoPipeline")
public class AjkSQLPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {

        System.out.println(resultItems.getAll());

//        String no=resultItems.get("no");
//        String area=resultItems.get("area");
//        String address=resultItems.get("address");
//        Float price=resultItems.get("price");
//        String html=resultItems.get("html");


    }
}
