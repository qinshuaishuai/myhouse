package com.magic.house.web;

import com.magic.house.model.OldData;
import com.magic.house.model.OldResponseData;
import com.magic.house.utils.R;
import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.Surrogate;

import java.util.*;

/**
 * Created by lenovo on 2018/10/23.
 * 描述：
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/Ajk")
public class AjkController {

    @RequestMapping(value = "getList")
    public Map<String,Object> getList(){
        return Collections.EMPTY_MAP;
    }

    @RequestMapping(value = "old")
    public R getOldList(){
        OldResponseData data=new OldResponseData();
        data.setNames(Arrays.array("a1","a2","a3"));
        data.setTimes(Arrays.array("2018-11-04","2018-11-05","2018-11-06"));

        List<OldData> oldData=new ArrayList<>();
        oldData.add(new OldData("a1",Arrays.array(13.25f,16.37f,96.36f)));
        oldData.add(new OldData("a2",Arrays.array(15.25f,19.37f,99.36f)));
        oldData.add(new OldData("a3",Arrays.array(16.25f,10.37f,93.36f)));

        data.setOldDataList(oldData);
        return R.ok().put("data",data);
    }


}
