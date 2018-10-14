package com.magic.house.pipeline;

import com.magic.house.dao.AJKOldHouseDataMapper;
import com.magic.house.model.AJKOldHouseData;
import com.magic.house.utils.HtmlParse;
import com.magic.house.utils.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author qinshuai
 */
@Component
public class AjkOldSQLPipeline implements Pipeline {

    @Autowired
    private AJKOldHouseDataMapper ajkOldHouseDataMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {


        if(resultItems.getAll().containsKey("infos")){
            List<String> infos= (List<String>) resultItems.getAll().get("infos");

            /*小区名称*/
            String area= HtmlParse.getValue(infos.get(0),"a");

            String html=HtmlParse.getValue(infos.get(0),"a","href");

            String no= Util.extractData(html,"\\d+");

            String houseType=infos.get(1);

            Float price=Float.parseFloat(Util.extractData(infos.get(2),"\\d+"));

            String address=Util.extractData(infos.get(3),"([\\u4e00-\\u9fa5]+)");

            String houseAreas=infos.get(4);

            String housePay=infos.get(5);

            String houseAge=infos.get(6);

            String houseOrien=infos.get(7);

            String houseFloor=infos.get(10);

            String houseSpruce=infos.get(11);

            AJKOldHouseData ajkOldHouseData=new AJKOldHouseData(no,area,address,price,html,houseAge,houseType,houseAreas,houseOrien,houseFloor,housePay,houseSpruce);

            ajkOldHouseDataMapper.insert(ajkOldHouseData);

        }
    }
}
