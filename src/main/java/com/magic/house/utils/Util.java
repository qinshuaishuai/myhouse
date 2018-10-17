package com.magic.house.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lenovo
 * @date 2018/10/10
 * 描述：常用的工具类
 */
public class Util {

    public static void buildHtml(byte[] bytes,String filePath,String suffix) {
        Long time = System.currentTimeMillis();
        File file = new File(filePath + time + suffix);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**抽取匹配的字符*/
    public static String extractData(String url, String pattern){
        Pattern p=Pattern.compile(pattern);
        Matcher matcher = p.matcher(url);
        String str="";
        while (matcher.find()) {
            str+= matcher.group(0);
        }
        return str;
    }

    public static void main(String[] args) {
        //System.out.println(extractData("17952 元/m²","\\d+"));
        String html1="<p class=\"loc-text\">" +
                "<a href=\"https://zhengzhou.anjuke.com/sale/erqic/\" target=\"_blank\" _soj=\"propview\">二七</a>－ " +
                "<a href=\"https://zhengzhou.anjuke.com/sale/guwancheng/\" target=\"_blank\" _soj=\"propview\">古玩城</a>" +
                "－ 兴华南街,近政通路</p> \n";
        String data=extractData(html1,"([\\u4e00-\\u9fa5]+)");
        System.out.println(extractData("asdas","\\d+"));
        System.out.println(data);

        String h1="https://zhengzhou.anjuke.com/prop/view/A1452369995?from=filter&spread=commsearch_p&position=1&kwtype=filter&now_time=1539786590";
        System.out.println(extractData(h1,"A\\d+"));

    }
}
