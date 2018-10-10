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

@Component
public class AjkSQLPipeline implements Pipeline {

    @Autowired
    private AJKDao ajkDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println(resultItems.getAll());
        String no=resultItems.getAll().get("no").toString();
        String area=resultItems.getAll().get("area").toString();
        String address=resultItems.getAll().get("address").toString();
        Float price=Float.parseFloat(resultItems.getAll().get("price").toString());
        String html=resultItems.getAll().get("html").toString();

        AJKBaseData data=new AJKBaseData(no,area,address,price,html);
        System.out.println(data);

        ajkDao.insert(data);

    }
}
