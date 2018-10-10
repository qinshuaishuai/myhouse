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
public class util {

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
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

}
