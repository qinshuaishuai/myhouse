package com.magic.house.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/10/11.
 * 描述：
 */
public class Dates {

    private static SimpleDateFormat sdf=null;

    public static String format_yyyyMMddHHmmss(Date date){
        sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }
}
