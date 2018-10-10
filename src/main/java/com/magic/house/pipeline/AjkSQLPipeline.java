package com.magic.house.pipeline;

import com.magic.house.dao.AJKDao;
import com.magic.house.model.AJKBaseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 *
 * @author lenovo
 * @date 2018/10/10
 * 描述：安居客数据处理
 */

@Component("PostInfoPipeline")
public class AjkSQLPipeline implements Pipeline {

    @Autowired
    private AJKDao ajkDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String no=resultItems.get("no");
        String area=resultItems.get("area");
        String address=resultItems.get("address");
        Float price=resultItems.get("price");
        String html=resultItems.get("html");

        AJKBaseData data=new AJKBaseData(no,area,address,price,html);

        ajkDao.insert(data);

    }
}
