package com.magic.house.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author lenovo
 * @date 2018/11/6
 * 描述：
 */

@Data
@ToString
public class OldResponseData {

    private String [] names;

    private String [] times;

    private List<OldData> oldDataList;

}

