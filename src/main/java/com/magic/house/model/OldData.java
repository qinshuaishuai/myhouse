package com.magic.house.model;

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
public class OldData {
    private String name;
    private Float[] prices;

    public OldData(){}

    public OldData(String name,Float[] prices){
        this.name=name;
        this.prices=prices;
    }

}
