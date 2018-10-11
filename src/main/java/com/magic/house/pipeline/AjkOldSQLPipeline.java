package com.magic.house.pipeline;

import com.magic.house.utils.HtmlParse;
import com.magic.house.utils.Util;

import java.util.List;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class AjkOldSQLPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {

        System.out.println(resultItems.getAll());

        /*
        [<a href="https://zhengzhou.anjuke.com/community/view/764032" target="_blank" _soj="propview">正商新蓝钻E区</a>,
        2室 2厅 1卫, 17952 元/m²,
        <p class="loc-text"><a href="https://zhengzhou.anjuke.com/sale/guanchenga/" target="_blank" _soj="propview">管城</a>－ <a href="https://zhengzhou.anjuke.com/sale/anxuzhuang/" target="_blank" _soj="propview">安徐庄</a>－ 果园路</p>
<i class="iconfont i-location"></i>, 83平方米, 44.70万, 2009年, 南, <span id="reference_monthpay"></span>, 普通住宅, 高层(共28层), 简单装修, 70年, 有, 满五年, 商品房, 是]
        * */
        if(resultItems.getAll().containsKey("infos")){
            List<String> infos= (List<String>) resultItems.getAll().get("infos");
            System.out.println(infos);

            /*小区名称*/
            String area= HtmlParse.getValue(infos.get(0),"a");

            String html=HtmlParse.getValue(infos.get(0),"a","href");

            String no= Util.extractData(html,"\\d+");

            String houseType=infos.get(1);

            Float price=Float.parseFloat(Util.extractData(infos.get(2),"\\d+"));


        }
    }
}
