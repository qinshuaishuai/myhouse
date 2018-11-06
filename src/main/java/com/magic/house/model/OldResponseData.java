package com.magic.house.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lenovo
 * @date 2018/11/6
 * 描述：
 */
public class OldResponseData {

    private String [] names;

    private String [] times;

    private List<OldData> oldDataList;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }

    public List<OldData> getOldDataList() {
        return oldDataList;
    }

    public void setOldDataList(List<OldData> oldDataList) {
        this.oldDataList = oldDataList;
    }
}

