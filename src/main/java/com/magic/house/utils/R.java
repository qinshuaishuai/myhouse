package com.magic.house.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/11/6.
 * 描述：
 */
public class R extends HashMap<String,Object>{
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 200);
        put("codeinfo","成功");
    }

    public static R error(int code,String msg) {
        R r = new R();
        r.put("code", code);
        r.put("codeinfo", msg);
        return r;
    }

    public static R error(int code) {
        R r = new R();
        r.put("code", code);
        r.put("codeinfo", "参数错误");
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }


    @Override
    public R put(String key, Object value) {
         super.put(key, value);
         return this;
    }
}
